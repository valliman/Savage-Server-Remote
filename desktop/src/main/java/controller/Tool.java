package controller;

import view.MessageDialog;
import view.MyTableModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
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

    public static void main(String[] args) {
        System.out.println(Tool.validIP("192.168.0.1"));
        System.out.println(Tool.validIP("192.168.0.300"));
        System.out.println(Tool.validIP("192.168.0.1.1"));
        System.out.println(Tool.validIP("asd.asd.a.s"));
        System.out.println(Tool.validPort("11235"));
        System.out.println(Tool.validPort("100000"));
        System.out.println(Tool.validPort("asdf"));
        System.out.println(Tool.validPassword("asdf"));
        System.out.println(Tool.validPassword(""));
    }

    public static boolean validIP(String ip) {
        String[] parts=ip.split("\\.");

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
        }

        return true;
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
        if(!validIP(ip)) {
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
        String str=readFile("default.object");
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
        HashMap<String,String> defaultobject=getDefaultObject();
        for(Map.Entry<String,String> entry:object.entrySet()) {
            defaultobject.put(entry.getKey(),entry.getValue());
        }
        return defaultobject;
    }

    public static HashMap<String,String> getDefaultState() {
        String str=readFile("default.state");
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
        HashMap<String,String> defaultstate=getDefaultState();
        for(Map.Entry<String,String> entry:state.entrySet()) {
            defaultstate.put(entry.getKey(),entry.getValue());
        }
        return defaultstate;
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
        } catch (IOException e) {
            e.printStackTrace();
            return null;
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

}
