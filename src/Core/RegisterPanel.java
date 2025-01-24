package Core;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RegisterPanel extends JPanel {
    private Register register = new Register();
    private JTextField input;
    private PursePanel changePanel;

    public RegisterPanel() {
        setLayout(new BorderLayout());

        //Input Panel
        input = new JTextField(15);
        JButton calculateButton = new JButton("Calculate Change");

        //Change Panel
        changePanel = new PursePanel();

        input.addActionListener(new InputListener());

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Enter Amount:"));
        inputPanel.add(input);
        inputPanel.add(calculateButton);

        add(inputPanel, BorderLayout.NORTH);
        add(changePanel, BorderLayout.CENTER);

    }

    private class InputListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try{
                double amt = Double.parseDouble(input.getText());
                Purse purse = register.makeChange(amt);
                changePanel.setPurse(purse);
                changePanel.repaint();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(RegisterPanel.this,
                        "Invalid Amount");
            }
        }
    }
}
