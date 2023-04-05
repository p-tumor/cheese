public class Card {
    private final byte CARD_NUM;
    private final String SUIT;

    public Card(byte CARD_NUM, String SUIT) {
        this.CARD_NUM = CARD_NUM;
        this.SUIT = SUIT;
    }

    public byte getCARD_NUM() {
        return CARD_NUM;
    }

    public String getSUIT() {
        return SUIT;
    }
}
