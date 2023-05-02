import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player extends Cards{
    private String name;
    private ArrayList<Card> playerDeck;
    private Card[] hand;
    public static byte numPlayers = 0;

    public Player(String name) throws IOException {
        super();
        numPlayers++;
        System.out.println("numplayers: "+ numPlayers);
        this.name = name;
        playerDeck = new ArrayList<>();
        if(numPlayers == 1) {
            for(int i = 0; i < 26; i++) playerDeck.add(deck.get(i));
        }
        else if(numPlayers == 2){
            System.out.println("tried");
            for(int i = 26; i < deck.size();i++) {
                System.out.println("loop");
                playerDeck.add(deck.get(i));
            }
        }
        hand = new Card[15];
        grabHand();
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
        for(int i = 0; i < 15; i ++){
            hand[i] = playerDeck.get(i);
        }
        playerDeck.removeAll(List.of(hand));
    }
    public String toString(){
        return getName()+"\n"+playerDeck.toString()+"\n"+playerDeck.size()+"\n"+ Arrays.toString(hand)+"\n"+hand.length+"\n";
    }
}
