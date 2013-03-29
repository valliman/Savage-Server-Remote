package view;

import controller.Tool;

/**
 * Created with IntelliJ IDEA.
 * User: Bernhard
 * Date: 09.07.12
 * Time: 14:34
 * To change this template use File | Settings | File Templates.
 */
public class Launcher {

    public static void main(String[] args) {

        if(!Tool.checkVersion()) {
            QuestionDialog qd=new QuestionDialog("New version available!","A new version of the Savage Remote Controller is available! Download the new version now?");
            if(qd.getAnswer()) {

                Tool.goToDownloadPage();
                System.exit(0);
            }
        }
        new LoginForm();
    }
}
