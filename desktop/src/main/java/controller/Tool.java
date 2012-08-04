package controller;

import view.MessageDialog;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

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

}
