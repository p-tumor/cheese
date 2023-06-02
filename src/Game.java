import javax.swing.*;
import java.awt.*;

public class Game extends JPanel {
    Player p1, p2;
    Card [] p1Hand = new Card[15];
    public Game(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
        for(int i = 0; i < p1Hand.length; i++){
            System.out.println(p1.getPlayerHand().size());
            //p1Hand[i] = new ImageIcon(p1.getCardsAtPlay()[i].getCARD_FRONT()).getImage();
            p1Hand[i] = p1.getCardsAtPlay()[i];
        }

    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        for(int i = 0; i < 7; i++){
            switch (i){
                case 0 ->{
                    g2D.drawImage(p1Hand[i].getCARD_FRONT(),75,400,null);
                }
                case (1) ->{

                    g2D.drawImage(p1Hand[i].getCARD_FRONT(),150,400,null);
                }
                case (2)->{
                    g2D.drawImage(p1Hand[i].getCARD_FRONT(),152,400,null);
                }
                /*case(3)
                case(4)
                case(5)
                case(6)
                case(7)
                case(8)
                case(9)
                case(10)
                case(11)
                case(12)
                case(13)
                case(14)

                 */
            }
        }
    }

}
