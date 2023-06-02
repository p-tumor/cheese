import javax.swing.*;
import java.awt.*;

public class Game extends JPanel {
    Player p1, p2;
    JLabel[] p1Hand = new JLabel[15];
    public Game(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
        for(int i = 0; i < p1Hand.length; i++){
            p1Hand[i] = new JLabel(new ImageIcon(p1.getPlayerHand().get(i).getCARD_FRONT()));
        }
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        for(int i = 0; i < p1Hand.length; i++){
            switch (i){
                case 0 ->{
                    g2D.drawImage((Image) p1Hand[i].getIcon(),100,400,null);
                }
            }
        }
    }
}
