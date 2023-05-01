import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player extends Cards{
    private String name;
    private ArrayList<Card> playerDeck;
    private Card[] hand;
    public static byte numPlayers = 0;

    public Player(String name) {
        numPlayers++;
        this.name = name;
        if(numPlayers == 1){
            System.out.println("ran 1");
            playerDeck = pOneDeck;
            if(playerDeck == null) System.out.println("fuck me");
        }
        else if(numPlayers == 2) {
            System.out.println("ran 2");
            playerDeck = pTwoDeck;
        }
        hand = new Card[15];
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
    public Card[] getHand(){
        return hand;
    }
    public void grabHand(){
        System.out.println(playerDeck);
        for(int i = 0; i < 15; i ++){
            hand[i] = playerDeck.get(i);
        }
        playerDeck.removeAll(List.of(hand));
    }
    public String toString(){
        return getName()+"\n"+playerDeck.toString()+"\n"+ Arrays.toString(hand)+"\n";
    }
}
