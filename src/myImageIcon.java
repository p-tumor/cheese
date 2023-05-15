import javax.swing.ImageIcon;
import java.awt.*;
import java.net.URL;

public class myImageIcon extends ImageIcon {
    private Card card;

    public myImageIcon(String filename, String description, Card card) {
        super(filename, description);
        this.card = card;
    }

    public myImageIcon(String filename, Card card) {
        super(filename);
        this.card = card;
    }

    public myImageIcon(URL location, String description, Card card) {
        super(location, description);
        this.card = card;
    }

    public myImageIcon(URL location, Card card) {
        super(location);
        this.card = card;
    }

    public myImageIcon(Image image, String description, Card card) {
        super(image, description);
        this.card = card;
    }

    public myImageIcon(Image image, Card card) {
        super(image);
        this.card = card;
    }

    public myImageIcon(byte[] imageData, String description, Card card) {
        super(imageData, description);
        this.card = card;
    }

    public myImageIcon(byte[] imageData, Card card) {
        super(imageData);
        this.card = card;
    }

    public myImageIcon(Card card) {
        this.card = card;
    }
    public void setCard(Card c){
        card = c;
    }

    public Card getCard() {
        return card;
    }
}
