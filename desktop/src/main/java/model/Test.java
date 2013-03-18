package model;

import controller.Tool;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: Bernhard
 * Date: 07.03.13
 * Time: 20:49
 * To change this template use File | Settings | File Templates.
 */
public class Test {

    public static void main(String[] args) throws Exception {
        //ConnectionManager cman=new ConnectionManager("127.0.0.1","11235","Lee7Dub5");
        /*String s=cman.execute("python \"import sv_srcp; sv_srcp.advancedClientList()\"");
        System.out.println(s);
        System.out.println(s.contains("�"));*/
        /*cman.execute("createobject default; objload default;");
        HashMap<String,String> defaultobject=cman.getObjectSettings("default", read("C:\\default.object"));
        //System.out.println(defaultobject.toString());
        String defaultobjectfilestring="";
        int i=0;
        String[] defaultobjectfilestrings=new String[defaultobject.size()];
        for(Map.Entry<String,String> entry:defaultobject.entrySet()) {
            defaultobjectfilestrings[i]=entry.getKey()+" \""+entry.getValue()+"\"";
            i++;
        }
        write("C:\\mydefault.object",defaultobjectfilestrings);*/
        /*cman.execute("createstate default; stateload default;");
        HashMap<String,String> defaultstate=cman.getStateSettings("default", read("C:\\default.state"));
        //System.out.println(defaultobject.toString());
        String defaultstatefilestring="";
        int i=0;
        String[] defaultstatefilestrings=new String[defaultstate.size()];
        for(Map.Entry<String,String> entry:defaultstate.entrySet()) {
            defaultstatefilestrings[i]=entry.getKey()+" \""+entry.getValue()+"\"";
            i++;
        }
        write("C:\\mydefault.state",defaultstatefilestrings);*/
        /*File f=new File("default.state");
        System.out.println(f.getAbsolutePath());*/
        //System.out.println(Tool.getDefaultObject().toString());
        System.out.println(Tool.getDefaultObject());

    }

    public static void write(String path, String[] str) throws IOException
    {
        File file = new File(path);
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));

        for (int i = 0; i < str.length; i++) {
            if(str[i]!=null)
            {
                bw.write(str[i]);
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
    }

    public static String[] read(String path) throws IOException
    {
        File file = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;

        int i=0;
        while ((line = br.readLine()) != null) {
            i++;
        }
        String[] str=new String[i];
        br = new BufferedReader(new FileReader(file));
        i=0;
        while ((line = br.readLine()) != null) {
            str[i]=line;
            i++;
        }

        br.close();
        return str;

    }
}
