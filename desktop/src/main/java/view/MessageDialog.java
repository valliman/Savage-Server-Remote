package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MessageDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JLabel errorMessage;

    public MessageDialog(String title, String text) {
        setTitle(title);
        errorMessage.setText(text);
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });
        setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void onOK() {
// add your code here
        dispose();
    }

}
