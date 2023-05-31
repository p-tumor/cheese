import javax.swing.*;

public class Game extends JPanel {
    Player p1, p2;
    JLabel[] p1Hand = new JLabel[15];
    public Game(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
        for(int i = 0; i < p1Hand.length; i++){
            p1Hand[i] = new JLabel(new ImageIcon(p1.getPlayerHand()[i]));
        }
    }
}
