import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CardPanel extends JPanel implements ActionListener {
    Image card, backgroundImage;
    Timer timer;
    int x, y, xVelocity, yVelocity;

    public CardPanel() {
        card = new ImageIcon(Deck.deck.get((int)(Math.random()*Deck.deck.size())).getCARD_FRONT()).getImage();
        backgroundImage = new ImageIcon("src/backFrame.png").getImage();
        timer = new Timer(10,this);
        timer.start();
        x = -10;
        y = 0;
        xVelocity = 1;
        yVelocity = 1;
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(backgroundImage,0,0,null);
        g2D.drawImage(card,x,y,null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(x < -10 || x >= 500-card.getWidth(null)) xVelocity *= -1;
        x+=xVelocity;
        if(y < 0 || y >= 500-(card.getHeight(null)*1.5)) yVelocity *= -1;
        y+=yVelocity;
        repaint();
    }
}