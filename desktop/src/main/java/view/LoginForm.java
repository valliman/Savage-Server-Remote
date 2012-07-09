package view;

import model.ConnectionManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static controller.Tool.*;

/**
 * Created with IntelliJ IDEA.
 * User: Bernhard
 * Date: 07.07.12
 * Time: 13:00
 * To change this template use File | Settings | File Templates.
 */
public class LoginForm extends JFrame{
    private JTextField ipTextField;
    private JTextField portTextField;
    private JPasswordField passwordTextField;
    private JList list1;
    private JButton connectButton;
    private JButton addToFavoritesButton;
    private JButton removeFromFavoritesButton;
    private JButton button1;
    private JButton button2;
    private JPanel contentPane;

    public LoginForm() {
        setTitle("Login");
        setContentPane(contentPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        connectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onConnect();
            }
        });
        pack();
        setVisible(true);
    }

    public void onConnect() {
        String errorMsg="";
        int counter=0;
        if(!validIP(ipTextField.getText())) {
            counter++;
            errorMsg+=" IP";
        }
        if(!validPort(portTextField.getText())) {
            counter++;
            if(counter>1) errorMsg+=", Port";
            else errorMsg+=" Port";
        }
        if(!validPassword(passwordTextField.getText())) {
            counter++;
            if(counter>1) errorMsg+=", Password";
            else errorMsg+=" Password";
        }
        if(counter==0) {
            ConnectionManager cman=new ConnectionManager(ipTextField.getText(), portTextField.getText(), passwordTextField.getText());
            dispose();
            new MainForm(cman);
        }
        else {
            String errorPrefix=counter+" Errors:";
            String errorSuffix=" invalid!";
            new ErrorDialog(errorPrefix+errorMsg+errorSuffix);
        }

    }

}
