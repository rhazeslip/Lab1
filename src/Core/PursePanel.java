package Core;

import javax.swing.*;
import java.awt.*;
import java.util.Map;


public class PursePanel extends JPanel{
    private Purse purse = new Purse();

    public void setPurse(Purse purse){
        this.purse = purse;
    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Map<Denomination, Integer> contents = purse.getCash();
        int yPos = 15;
        int xPos = 20;
        for (Map.Entry<Denomination, Integer> entry : contents.entrySet()){
            Denomination denomination = entry.getKey();
            int count = entry.getValue();

            g.drawString(denomination.name() + ": " + count, 20, yPos);
            yPos += 5;

            //ImageIcon img = new ImageIcon(imagePath);
            //JLabel imgLabel = new JLabel(img);
            //this.add(imgLabel);
            for (int i = 0; i < count; i++) {
                try {
                    Image img = new ImageIcon(denomination.img()).getImage();
                    g.drawImage(img, xPos + 100 * i, yPos, 50, 50, this);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            yPos += 60;
        }
    }

    public void updatePurse(Purse newPurse){
        this.purse = newPurse;
        this.removeAll();
        revalidate();
        repaint();
    }
}
