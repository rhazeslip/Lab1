import javax.swing.*;
import java.awt.*;
import java.util.Map;


public class PursePanel extends JPanel{
    private Purse purse;

    public PursePanel(){
        this.purse = new Purse();
    }

    public void setPurse(Purse purse){
        this.purse = purse;
    }


    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        if(purse != null){
            int y = 10;
            for (Map.Entry<Denomination, Integer> entry :  purse.cash.entrySet()){
                String text = entry.getKey().name() + ": " + entry.getValue();
                g.drawString(text, 10, y);
                y += 20;
            }
        }
    }
}
