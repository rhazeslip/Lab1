package Core;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RegisterPanel extends JPanel implements RegisterObserver {
    private final Register register;
    private final JTextField input;
    private final PursePanel changePanel;

    public RegisterPanel() {
        register = new Register();
        register.addObserver(this);

        setLayout(new BorderLayout());

        //Input Panel
        input = new JTextField(15);
        JButton calculateButton = new JButton("Calculate Change");

        //Change Panel
        changePanel = new PursePanel();

        calculateButton.addActionListener(new InputListener());
        input.addActionListener(new InputListener());

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Enter Amount:"));
        inputPanel.add(input);
        inputPanel.add(calculateButton);

        add(inputPanel, BorderLayout.NORTH);
        add(changePanel, BorderLayout.CENTER);

    }

    @Override
    public void update(Purse purse){
        changePanel.setPurse(purse);
        changePanel.repaint();
    }

    private class InputListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try{
                double amt = Double.parseDouble(input.getText());
                register.makeChange(amt);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(RegisterPanel.this,
                        "Invalid Amount", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
