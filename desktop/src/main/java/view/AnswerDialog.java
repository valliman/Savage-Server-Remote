package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnswerDialog extends JDialog {
    private JPanel contentPane;
    private JLabel answerDialogLabel;
    private JButton answerDialogButtonOK;
    private JTextField answerDialogTextField;
    private String answer;

    public AnswerDialog(String title, String text) {
        answer="";
        setTitle(title);
        answerDialogLabel.setText(text);
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(answerDialogButtonOK);
        answerDialogButtonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onButtonOK();
            }
        });
        setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void onButtonOK() {
        answer=answerDialogTextField.getText();
        dispose();
    }

    public String getAnswer() {
        return answer;
    }
}
