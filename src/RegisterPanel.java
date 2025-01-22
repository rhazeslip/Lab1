import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RegisterPanel extends JPanel {
    private Register register = new Register();
    private JTextField input;
    private PursePanel changePanel1;

    public RegisterPanel() {
        setLayout(new BorderLayout());

        //Input Panel
        input = new JTextField(10);
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Enter Amount:"));
        inputPanel.add(input);
        add(inputPanel, BorderLayout.NORTH);

        //Change Panel
        changePanel1 = new PursePanel();
        add(changePanel1, BorderLayout.CENTER);

        //Input Listener
        InputListener listener = new InputListener();
        input.addActionListener(listener);
    }

    private class InputListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try{
                double amt = Double.parseDouble(input.getText());
                Purse purse = register.makeChange(amt);
                changePanel1.setPurse(purse);
                changePanel1.repaint();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(RegisterPanel.this,
                        "Invalid Amount", "Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
