package view;

import javax.swing.*;
import java.awt.event.*;

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
        pack();
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
