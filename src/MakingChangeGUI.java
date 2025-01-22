import javax.swing.*
import java.awt.*;


public class MakingChangeGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Making Change");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);


        RegisterPanel registerPanel = new RegisterPanel();
        frame.add(registerPanel);
        frame.setVisible(true);
    }
}
