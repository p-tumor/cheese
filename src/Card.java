import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Card {
    private final BufferedImage CARD_FRONT;
    private final BufferedImage CARD_BACK = ImageIO.read(new File("src/card images/card_back.png"));
    private final String CARD_VAL;
    private final String SUIT;
    public Card(String CARD_VAL, String SUIT, BufferedImage image) throws IOException {
        CARD_FRONT = image;
        if(CARD_VAL.indexOf("0") == 0){
            this.CARD_VAL = CARD_VAL.substring(1,2);
        }else this.CARD_VAL = CARD_VAL;
        this.SUIT = SUIT;
    }
    public String getCARD_VAL() {
        return CARD_VAL;
    }
    public String getSUIT() {
        return SUIT;
    }

    public BufferedImage getCARD_FRONT() {
        return CARD_FRONT;
    }

    public String toString(){
        return CARD_VAL + " of " + SUIT;
    }
}