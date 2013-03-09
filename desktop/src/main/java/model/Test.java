package model;

/**
 * Created with IntelliJ IDEA.
 * User: Bernhard
 * Date: 07.03.13
 * Time: 20:49
 * To change this template use File | Settings | File Templates.
 */
public class Test {

    public static void main(String[] args) {
        ConnectionManager cman=new ConnectionManager("127.0.0.1","11235","Lee7Dub5");
        String s=cman.execute("python \"import sv_srcp; sv_srcp.advancedClientList()\"");
        System.out.println(s);
        System.out.println(s.contains("�"));
    }
}
