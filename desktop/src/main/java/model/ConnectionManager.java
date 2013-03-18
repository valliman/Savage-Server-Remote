package model;

//import at.valli.savage.connection.ConnectionException;
//import at.valli.savage.connection.StatefulConnector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Bernhard
 * Date: 09.07.12
 * Time: 16:27
 * To change this template use File | Settings | File Templates.
 */
public class ConnectionManager {
    //StatefulConnector connector;
    MyConnector connector;

    public ConnectionManager(String ip, String port, String password) {
        connector=null;
        try {
            connector=new MyConnector(ip,Integer.parseInt(port),password);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public void set(String name, String value) {
        execute("set " + name + "\"" + value + "\"");
    }

    public void set(HashMap<String,String> config) {
        String cmd="";
        for(Map.Entry<String,String> entry:config.entrySet()) {
            cmd+="set "+entry.getKey()+" \""+entry.getValue()+"\";";
        }
        execute(cmd);
    }

    public String get(String name) {
        String msg="";
        msg=execute(name);
        msg=msg.replace(name+" is ","");
        msg=msg.replace("\"","");
        return msg;
    }

    public String getObjectSetting(String objectname, String settingname) {
        String cmd="objedit "+objectname+"; objset "+settingname;
        String msg;
        msg=execute(cmd);
        msg=msg.replace(settingname+": ","");
        msg=msg.replace("\"","");
        return msg;
    }

    public HashMap<String,String> getObjectSettings(String objectname, String settingnames[]) {
        HashMap<String,String> config=new HashMap<String, String>();
        for(int i=0; i<settingnames.length; i++) {
            config.put(settingnames[i],getObjectSetting(objectname,settingnames[i]));
        }
        return config;
    }

    public String getStateSetting(String statename, String settingname) {
        String cmd="stateedit "+statename+"; stateset "+settingname;
        String msg;
        msg=execute(cmd);
        msg=msg.replace(settingname+": ","");
        msg=msg.replace("\"","");
        return msg;
    }

    public HashMap<String,String> getStateSettings(String statename, String settingnames[]) {
        HashMap<String,String> config=new HashMap<String, String>();
        for(int i=0; i<settingnames.length; i++) {
            config.put(settingnames[i],getObjectSetting(statename,settingnames[i]));
        }
        return config;
    }

    public HashMap<String,String> get(String[] names) {
        String cmd="";
        for(String s:names) {
            cmd+=s+";";
        }
        String msg=execute(cmd);
        String[] values=msg.split("\n");
        HashMap<String,String> config=new HashMap<String, String>();
        for(int i=0; i<values.length; i++) {
            values[i]=values[i].replace(names[i]+" is ","");
            values[i]=values[i].replace("\"","");
            config.put(names[i],values[i]);
        }
        return config;
    }

    public HashMap<String,String> getObject(String name) {
        String cmd="objedit "+name+"; objlist";
        String msg=execute(cmd);
        msg=msg.replace("^r","");
        msg=msg.replace("=\n","");
        msg=msg.replace("=","");
        String[] temp=msg.split("\n");
        HashMap<String,String> object=new HashMap<String, String>();
        for(String s:temp) {
            if(s.contains("Data for object")) {
                continue;
            }
            else {
                String key=s.split(": ")[0];
                String value="";
                try {
                    value=s.split(": ")[1];
                } catch(Exception e) {
                    // do nothing
                }
                object.put(key,value);
            }
        }
        return object;
    }

    public HashMap<String,String> getState(String name) {
        String cmd="stateedit "+name+"; statelist";
        String msg=execute(cmd);
        msg=msg.replace("^r","");
        msg=msg.replace("=\n","");
        msg=msg.replace("=","");
        String[] temp=msg.split("\n");
        HashMap<String,String> state=new HashMap<String, String>();
        for(String s:temp) {
            if(s.contains("Data for state")) {
                continue;
            }
            else {
                String key=s.split(": ")[0];
                String value="";
                try {
                    value=s.split(": ")[1];
                } catch(Exception e) {
                    // do nothing
                }
                state.put(key,value);
            }
        }
        return state;
    }

    public HashMap<String,String> getAll() {
        String s=execute("cvarlist 0 9999");
        String[] parts=s.replace("\"", "").split("\n");
        ArrayList<String> nameandvalue=new ArrayList<String>();
        for(String part:parts) {
            try{
                nameandvalue.add(part.split("]  ")[1]);
            } catch(Exception e) {
                // do nothing
            }
        }
        HashMap<String,String> config=new HashMap<String,String>();
        for(String part:nameandvalue) {
            try {
                config.put(part.split(" ")[0],part.split(" ")[1]);
            } catch(Exception e) {
                // do nothing
            }
        }
        return config;
    }

    public String execute(String cmd) {
        String msg="";
        try {
            msg=connector.execute(cmd);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return msg;
    }

    public void applyObject(HashMap<String, String> object) {
        String cmd="objedit "+object.get("name")+";";
        for(Map.Entry<String,String> entry:object.entrySet()) {
            cmd+=" objset "+entry.getKey()+" \""+entry.getValue()+"\";";
        }
        execute(cmd);
    }

    public void saveObject(HashMap<String, String> object) {
        String cmd="objedit "+object.get("name")+";";
        for(Map.Entry<String,String> entry:object.entrySet()) {
            cmd+=" objset "+entry.getKey()+" \""+entry.getValue()+"\";";
        }
        cmd+=" objsave;";
        execute(cmd);
    }

    public void applyState(HashMap<String, String> state) {
        String cmd="stateedit "+state.get("name")+";";
        for(Map.Entry<String,String> entry:state.entrySet()) {
            cmd+=" stateset "+entry.getKey()+" \""+entry.getValue()+"\";";
        }
        execute(cmd);
    }

    public void saveState(HashMap<String, String> state) {
        String cmd="stateedit "+state.get("name")+";";
        for(Map.Entry<String,String> entry:state.entrySet()) {
            cmd+=" stateset "+entry.getKey()+" \""+entry.getValue()+"\";";
        }
        cmd+=" statesave;";
        execute(cmd);
    }

    public HashMap<String, String> getPlayerList() {
        String msg=execute("python \"import sv_srcp; sv_srcp.advancedClientList()\"");
        HashMap<String,String> playerlist=new HashMap<String, String>();
        for(String client:msg.split("\n")) {
            playerlist.put(client.split("�")[0],client.split("�")[1]);
        }
        return playerlist;
    }

    public void switchteam(int team,String name) {
        execute("switchteam "+team+" \""+name+"\"");
    }

    public void mute(String name) {
        execute("mute \""+name+"\"");
    }

    public void unmute(String name) {
        execute("unmute \""+name+"\"");
    }

    public void setcmdr(String name) {
        execute("setcmdr \""+name+"\"");
    }

    public void kick(String name, String reason) {
        String cmd="set kick_reason \""+reason+"\"; kick "+getIndexFromName(name)+" #kick_reason#";
        System.out.println(cmd);
        //execute("set kick_reason \""+reason+"\"; kick \""+getIndexFromName(name)+" #kick_reason#");
    }

    public void shuffleteams() {
        execute("shuffleteams");
    }

    public void nextmap() {
        execute("world "+get("sv_nextmap"));
    }

    public String getIndexFromName(String name) {
        return execute("python \"import core; import sv_utils; core.ConsolePrint(str(sv_utils.getIndexFromName('"+name+"')))\"").replace("\n","");
    }
}
