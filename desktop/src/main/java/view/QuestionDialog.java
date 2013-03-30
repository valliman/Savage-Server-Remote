package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuestionDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonYes;
    private JButton buttonNo;
    private JLabel questionDialogLabel;
    private boolean answer;

    public QuestionDialog(String title, String text) {
        answer=false;
        setTitle(title);
        questionDialogLabel.setText(text);
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonNo);
        buttonYes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onYes();
            }
        });
        buttonNo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onNo();
            }
        });
        setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void onYes() {
        answer=true;
        dispose();
    }
    private void onNo() {
        answer=false;
        dispose();
    }
    public boolean getAnswer() {
        return answer;
    }
}
