import java.util.ArrayList;

public class Player{
    private String name;
    private ArrayList<Card> playerDeck;

    public Player(String name, ArrayList<Card> playerDeck) {
        this.name = name;
        this.playerDeck = playerDeck;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Card> getPlayerDeck() {
        return playerDeck;
    }

    public void addCard(Card card) {
        playerDeck.add(card);
    }
}
