package controller;

import view.MessageDialog;
import view.MyTableModel;
import view.PlayerListTableModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: Bernhard
 * Date: 09.07.12
 * Time: 13:44
 * To change this template use File | Settings | File Templates.
 */
public class Tool {
    public final static String build="30032013";
    public final static String buildurl ="http://pastebin.com/raw.php?i=RzpAHJyc";
    public final static String defaultobjecturl="http://pastebin.com/raw.php?i=exw5MPWp";
    public final static String defaultstateurl="http://pastebin.com/raw.php?i=6wPpFnws";
    public final static String dl="https://www.dropbox.com/sh/jzry2jz730bkbvd/P-gO94aAha";
    public static HashMap<String,String> defaultobject=getDefaultObject();
    public static HashMap<String,String> defaultstate=getDefaultState();

    public static void main(String[] args) {
        System.out.println(Tool.validHost("192.168.0.1"));
        System.out.println(Tool.validHost("www.google.at"));
        System.out.println(Tool.validHost("192.168.0.300"));
        System.out.println(Tool.validHost("192.168.0.1.1"));
        System.out.println(Tool.validHost("asd.asd.a.s"));
        System.out.println(Tool.validHost("300.2.3.1"));
        System.out.println(Tool.validHost("200.2.3"));
        System.out.println(Tool.validHost("asd.asd.a"));
        System.out.println(Tool.validPort("11235"));
        System.out.println(Tool.validPort("100000"));
        System.out.println(Tool.validPort("asdf"));
        System.out.println(Tool.validPassword("asdf"));
        System.out.println(Tool.validPassword(""));
    }

    public static boolean validHost(String host) {
        /*String[] parts=ip.split("\\.");

        if(parts.length!=4) {
            return false;
        }

        for(String s:parts) {
            int i=-1;

            try {
                i = Integer.parseInt( s );
            } catch(NumberFormatException e) {
                return false;
            }

            if((i<0)||(i>255)) {
                return false;
            }
        }*/
        String ValidIpAddressRegex = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
        String ValidHostnameRegex = "^(?=.{1,255}$)[0-9A-Za-z](?:(?:[0-9A-Za-z]|-){0,61}[0-9A-Za-z])?(?:\\.[0-9A-Za-z](?:(?:[0-9A-Za-z]|-){0,61}[0-9A-Za-z])?)*\\.?$";
        String containsLetters = "^[a-zA-Z]{1,25}$";
        Pattern ippattern=Pattern.compile(ValidIpAddressRegex);
        Pattern hostpattern=Pattern.compile(ValidHostnameRegex);
        Pattern letterpattern=Pattern.compile(containsLetters);
        Matcher ipmatcher=ippattern.matcher(host);
        Matcher hostmatcher=hostpattern.matcher(host);
        Matcher lettermatcher=letterpattern.matcher(host);
        if(containsLetters(host)) {
            if(hostmatcher.matches()) {
                return true;
            }
        }
        else {
            if(ipmatcher.matches()) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsLetters(String s) {
        for(int i=0; i<s.length(); i++) {
            char c=s.charAt(i);
            int j=c;
            if((j>=65&&j<=90)||(j>=97&&j<=122)) {
                return true;
            }
        }
        return false;
    }

    public static boolean validPort(String port) {
        int i=-1;

        try {
            i = Integer.parseInt(port);
        } catch(NumberFormatException e) {
            return false;
        }

        if((i<0)||(i>65535)) {
            return false;
        }

        return true;
    }

    public static boolean validPassword(String password) {
        if(password.length()==0) {
            return false;
        }
        return true;
    }

    public static boolean isValid(String ip, String port, String password) {
        String errorMsg="";
        int counter=0;
        if(!validHost(ip)) {
            counter++;
            errorMsg+=" IP";
        }
        if(!validPort(port)) {
            counter++;
            if(counter>1) errorMsg+=", Port";
            else errorMsg+=" Port";
        }
        if(!validPassword(password)) {
            counter++;
            if(counter>1) errorMsg+=", Password";
            else errorMsg+=" Password";
        }
        if(counter==0) {
            return true;
        }
        else {
            String errorPrefix=counter+" Errors:";
            String errorSuffix=" invalid!";
            new MessageDialog("Error",errorPrefix+errorMsg+errorSuffix);
            return false;
        }
    }

    public static ImageIcon getMapImage(String mapname,int width, int height) {
        ImageIcon icon=new ImageIcon();
        BufferedImage img=null;
        try {
            img=ImageIO.read(new URL("http://www.newerth.com/maps/sav1/"+mapname+"_overhead.jpg"));
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        img=resize(img,width,height);
        icon.setImage(img);
        return icon;
    }

    public static ImageIcon getMapImage(String mapname) {
        ImageIcon icon=new ImageIcon();
        try {
            icon.setImage(ImageIO.read(new URL("http://www.newerth.com/maps/sav1/" + mapname + "_overhead.jpg")));
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return icon;
    }

    public static BufferedImage resize(BufferedImage img, int newW, int newH) {
        int w = img.getWidth();
        int h = img.getHeight();
        BufferedImage dimg = dimg = new BufferedImage(newW, newH, img.getType());
        Graphics2D g = dimg.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(img, 0, 0, newW, newH, 0, 0, w, h, null);
        g.dispose();
        return dimg;
    }

    public static TableModel HashMap2TableModel(HashMap<String, String> map) {
        DefaultTableModel model = new MyTableModel (
                new Object[] { "Name", "Value" }, 0
        );
        for (Iterator it = map.entrySet().iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry)it.next();
            model.addRow(new Object[] { entry.getKey(), entry.getValue() });
        }
        return model;
    }

    public static TableModel ArrayHashMap2TableModel(ArrayList<HashMap<String,String>> clientlist) {
        DefaultTableModel model = new PlayerListTableModel(
                new Object[] { "id", "nickname", "uid", "ip", "cstate", "maxp" }, 0
        );
        for (HashMap<String,String> client:clientlist) {
            model.addRow(new Object[] { client.get("id"), client.get("nickname"), client.get("uid"), client.get("ip"), client.get("cstate"), client.get("maxp") });
        }
        return model;
    }

    public static HashMap<String,String> TableModel2HashMap(TableModel model) {
        HashMap<String,String> ret = new HashMap<String, String>();
        for(int i=0; i<model.getRowCount(); i++) {
            ret.put(model.getValueAt(i, 0).toString(), model.getValueAt(i, 1).toString());
        }
        return ret;
    }

    public static HashMap<String,String> getChange(HashMap<String,String> normal,HashMap<String,String> changed) {
        HashMap<String,String> difference = new HashMap<String, String>();
        for(Map.Entry<String,String> entry:changed.entrySet()) {
            if(!entry.getValue().equals(normal.get(entry.getKey()))) {
                difference.put(entry.getKey(),entry.getValue());
            }
        }
        return difference;
    }

    public static boolean isDifferent(HashMap<String,String> normal,HashMap<String,String> changed) {
        return !getChange(normal,changed).isEmpty();
    }

    public static HashMap<String,String> getDefaultObject() {
        String str="";
        if(fileExists(defaultobjecturl)) {
            str=readFile("default.object");
        }
        else {
            saveOnlineFile("default.object",defaultobjecturl);
            str=readFile("default.object");
        }
        System.out.println(str);
        str=str.replace(" \"","\"");
        HashMap<String,String> defaultobject=new HashMap<String, String>();
        Pattern pattern = Pattern.compile("(.*?)\"(.*?)\"");
        while(!str.isEmpty()) {
            Matcher matcher = pattern.matcher(str);
            String key="";
            String value="";
            if (matcher.find()) {
                key=matcher.group(1);
                value=matcher.group(2);
                str=str.replace(key+"\""+value+"\"","");
            }
            defaultobject.put(key,value);
        }
        return defaultobject;
    }

    public static HashMap<String,String> extendObject(HashMap<String,String> object) {
        HashMap<String,String> mydefaultobject=defaultobject;
        for(Map.Entry<String,String> entry:object.entrySet()) {
            mydefaultobject.put(entry.getKey(),entry.getValue());
        }
        return mydefaultobject;
    }

    public static HashMap<String,String> getDefaultState() {
        String str="";
        if(fileExists(defaultstateurl)) {
            str=readFile("default.state");
        }
        else {
            saveOnlineFile("default.state",defaultstateurl);
            str=readFile("default.state");
        }
        str=str.replace(" \"","\"");
        HashMap<String,String> defaultstate=new HashMap<String, String>();
        Pattern pattern = Pattern.compile("(.*?)\"(.*?)\"");
        while(!str.isEmpty()) {
            Matcher matcher = pattern.matcher(str);
            String key="";
            String value="";
            if (matcher.find()) {
                key=matcher.group(1);
                value=matcher.group(2);
                str=str.replace(key+"\""+value+"\"","");
            }
            defaultstate.put(key,value);
        }
        return defaultstate;
    }

    public static HashMap<String,String> extendState(HashMap<String,String> state) {
        HashMap<String,String> mydefaultstate=defaultstate;
        for(Map.Entry<String,String> entry:state.entrySet()) {
            mydefaultstate.put(entry.getKey(),entry.getValue());
        }
        return mydefaultstate;
    }

    public static void write(String path, String[] str)
    {
        try {
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
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static String[] read(String path)
    {
        try {
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
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean fileExists(String path) {
        try {
            File file=new File(path);
            return file.exists();
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String readFile(String path)
    {
        try {
            File file = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(file));

            String line;
            String str="";

            while ((line = br.readLine()) != null) {
                str+=line;
            }

            br.close();
            return str;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean checkVersion() {
        boolean same=false;
        try
        {
            URL url = new URL(buildurl);
            Scanner s = new Scanner(url.openStream());
            while (s.hasNext())
            {
                String line=s.nextLine();
                System.out.println("BUILD: "+line);
                if(line.equals(build)) {
                    same=true;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return same;
    }

    public static String readOnlineFile(String surl) {
        String text="";
        try
        {
            URL url = new URL(surl);
            Scanner s = new Scanner(url.openStream());
            while (s.hasNext())
            {
                String line=s.nextLine();
                text+=line+"\n";
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }

    public static void saveOnlineFile(String filename, String urlString) {
            BufferedInputStream in = null;
            FileOutputStream fout = null;
            try
            {
                in = new BufferedInputStream(new URL(urlString).openStream());
                fout = new FileOutputStream(filename);

                byte data[] = new byte[1024];
                int count;
                while ((count = in.read(data, 0, 1024)) != -1)
                {
                    fout.write(data, 0, count);
                }
            }
            catch(Exception e) {
                e.printStackTrace();
            }
            finally
            {
                try {
                    if (in != null)
                        in.close();
                    if (fout != null)
                        fout.close();
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
            }
    }

    public static void openWebpage(URI uri) {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(uri);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void openWebpage(URL url) {
        try {
            openWebpage(url.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static void goToDownloadPage() {
        try {
            URL url=new URL(dl);
            openWebpage(url);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<HashMap<String,String>> getDataFromClientList(String clientlist) {
        ArrayList<HashMap<String,String>> data=new ArrayList<HashMap<String,String>>();
        clientlist=clientlist.replace("\n","");
        clientlist=clientlist.replace("Client ","�id=");
        clientlist=clientlist.replace(":  addr = ",";ip=");
        clientlist=clientlist.replace(" (id ",";uid=");
        clientlist=clientlist.replace("), reqname = ",";nickname=");
        clientlist=clientlist.replace(", cstate = ",";cstate=");
        clientlist=clientlist.replace(", maxp = ",";maxp=");
        String[] lines=clientlist.split("�");
        for(String line:lines) {
            if(line==null || line.equals("")) continue;
            HashMap<String,String> client=new HashMap<String, String>();
            String[] keyvalue=line.split(";");
            client.put(keyvalue[0].split("=")[0], keyvalue[0].split("=")[1]);
            client.put(keyvalue[1].split("=")[0],keyvalue[1].split("=")[1]);
            client.put(keyvalue[2].split("=")[0],keyvalue[2].split("=")[1]);
            client.put(keyvalue[3].split("=")[0],keyvalue[3].split("=")[1]);
            client.put(keyvalue[4].split("=")[0],keyvalue[4].split("=")[1]);
            client.put(keyvalue[5].split("=")[0],keyvalue[5].split("=")[1]);
            data.add(client);
        }
        return data;
    }
}
