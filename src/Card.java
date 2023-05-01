import java.awt.image.BufferedImage;

public class Card {
    private final BufferedImage IMAGE;
    private final String CARD_VAL;
    private final String SUIT;
    public Card(String CARD_VAL, String SUIT, BufferedImage image) {
        IMAGE = image;
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

    public BufferedImage getIMAGE() {
        return IMAGE;
    }

    public String toString(){
        return CARD_VAL + " of " + SUIT;
    }
}