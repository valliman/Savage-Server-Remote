package model;

import at.valli.savage.connection.ConnectionException;
import at.valli.savage.connection.StatefulConnector;

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
    StatefulConnector connector;

    public ConnectionManager(String ip, String port, String password) {
        connector=new StatefulConnector(ip,Integer.parseInt(port),password);
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

    public String execute(String cmd) {
        String msg="";
        try {
            msg=connector.execute(cmd);
        } catch (ConnectionException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return msg;
    }
}
