package model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: Bernhard
 * Date: 07.03.13
 * Time: 20:49
 * To change this template use File | Settings | File Templates.
 */
public class Test {

    public static void main(String[] args) {
        /*ConnectionManager cman=new ConnectionManager("188.22.136.217","11235","Lee7Dub5");
        System.out.println(cman.execute("cvarlist 0 9999"));*/
        String s="00 ^w[ ^rR   ^mT^mV ^w]  svr_allowCheats \"0\"\n" +
                "01 ^w[        ^w]  cmd_showScriptDebugInfo \"0\"\n" +
                "02 ^w[        ^w]  cmd_useScriptCache \"1\"\n" +
                "03 ^w[        ^w]  cmd_traceScripts \"0\"\n" +
                "04 ^w[ ^rR      ^w]  numGameErrors \"0\"\n" +
                "05 ^w[        ^w]  homedir \"(null)/.savage/\"\n" +
                "06 ^w[ ^rR  ^yC   ^w]  archive_precedence \"1\"\n" +
                "07 ^w[        ^w]  sys_forcefocus \"0\"\n" +
                "08 ^w[        ^w]  mod \"/game\"\n" +
                "09 ^w[^cS ^wU     ^w]  sound_sfxVolume \"1.0\"\n" +
                "10 ^w[^cS ^wU     ^w]  sound_masterVolume \"1.0\"\n" +
                "11 ^w[^cS ^wU     ^w]  cl_cameraDistLerp \"8\"\n" +
                "12 ^w[^cS ^wU     ^w]  con_cursorspeed \"4\"\n" +
                "13 ^w[^cS ^wU     ^w]  terrain_minslope \"0.7\"\n" +
                "14 ^w[^cS ^wU     ^w]  cl_shadowType \"2\"\n" +
                "15 ^w[^cS ^wU     ^w]  cl_drawPlayerName \"1\"\n" +
                "16 ^w[^cS ^wU     ^w]  cl_cmdr_scrollaccel \"800\"\n" +
                "17 ^w[^cS ^wU     ^w]  vid_mode \"-1\"\n" +
                "18 ^w[^cS ^wU     ^w]  cl_ignoreBadPackets \"0\"\n" +
                "19 ^w[^cS ^wU     ^w]  gfx_soundSpace \"100\"\n" +
                "20 ^w[^cS ^wU     ^w]  cl_cameraAngleLerp \"9999\"\n" +
                "\n" +
                "1630 matching variables found, 1630 displayed\n" +
                "\n" +
                "Flags:\" +\n" +
                "^cS        ^wSaved to startup.cfg\n" +
                "^rR        ^wRead only\n" +
                "^wU        ^wUser defined\n" +
                "^gW        ^wWorld config setting\n" +
                "^yC        ^wCheat protected - enable with \"devworld\" command\n" +
                "^mT        ^wServer dictated setting\n" +
                "^mV        ^wServer info\n" +
                "^bN        ^wLocal client network setting";
        String[] parts=s.replaceAll("\"","").split("\n");
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
    }
}
