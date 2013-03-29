package view;

import model.ConnectionManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created with IntelliJ IDEA.
 * User: Bernhard
 * Date: 04.08.12
 * Time: 20:19
 * To change this template use File | Settings | File Templates.
 */
public class UploadMapForm extends JFrame{
    private JTextField uploadMapTextField;
    private JPanel contentPane;
    private JButton uploadButton;
    private ConnectionManager cman;

    public UploadMapForm(ConnectionManager cman) {
        setTitle("Upload Map...");
        setContentPane(contentPane);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.cman=cman;
        uploadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onUpload();
            }
        });
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        uploadMapTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode()==KeyEvent.VK_ENTER) {
                    onUpload();
                }
            }
        });
    }

    private void onUpload() {
        cman.execute("mapcheckversion "+uploadMapTextField.getText());
        new MessageDialog("Success!",uploadMapTextField.getText()+" got uploaded successfully!");
        uploadMapTextField.setText("");
    }
}
