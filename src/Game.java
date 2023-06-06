import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game extends JPanel implements ActionListener {
    Player p1, p2;
    Card [][] p1Hand;
    Action move;
    public Game(Player p1, Player p2) {
        p1Hand = new Card[][]{
                {null},
                {null,null},
                {null,null,null},
                {null,null,null,null},
                {null,null,null,null,null}
        };
        this.p1 = p1;
        this.p2 = p2;
        for(Card[] pile: p1Hand) {
            for (int i = 0; i < pile.length; i++) {
                System.out.println(p1.getPlayerHand().size());
                //p1Hand[i] = new ImageIcon(p1.getCardsAtPlay()[i].getCARD_FRONT()).getImage();
                pile[i] = p1.getCardsAtPlay()[i];
            }
        }
        move = new move();
        this.getInputMap().put(KeyStroke.getKeyStroke("SPACE"),"pressed");
        this.getActionMap().put("pressed", move);

    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        for (Card[] pile : p1Hand) {
            for (int i = 0; i < pile.length; i++) {
                switch (i) {
                    case 0 -> {
                        g2D.drawImage(pile[i].getCARD_FRONT(), 75, 400, null);
                    }
                    case (1) -> {

                        g2D.drawImage(pile[i].getCARD_FRONT(), 150, 400, null);
                    }
                    case (2) -> {
                        g2D.drawImage(pile[i].getCARD_FRONT(), 152, 400, null);

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

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public class move extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            Graphics2D graphics2D = (Graphics2D) getGraphics();
            graphics2D.drawImage(p1Hand[0][0].getCARD_FRONT(), 100, 100, null);
        }
    }
}
