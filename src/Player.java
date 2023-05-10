import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player{
    private String name;
    private ArrayList<Card> playerHand;
    private Card[] cardsAtPlay;
    private boolean isPlayer1;
    private static ArrayList<Card> leftPile = new ArrayList<>();
    private static ArrayList<Card> rightPile = new ArrayList<>();
    private static byte numPlayers = 0;
    public Player(String name) throws IOException {
        numPlayers++;
        this.name = name;
        playerHand = new ArrayList<>();
        if(numPlayers == 1) {
            isPlayer1 = true;
            for(int i = 0; i < 26; i++) playerHand.add(Deck.deck.get(i));
        }
        else if(numPlayers == 2){
            isPlayer1 = false;
            for(int i = 26; i < Deck.deck.size();i++) {
                playerHand.add(Deck.deck.get(i));
            }
        }
        cardsAtPlay = new Card[15];
                /*{
            {null},
            {null,null},
            {null,null,null},
            {null,null,null,null},
            {null,null,null,null,null}
        };

                 */
        grabcardsAtPlay();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Card> getplayerHand() {
        return playerHand;
    }

    public void addCard(Card card) {
        playerHand.add(card);
    }
    public Card[] getCardsAtPlay(){
        return cardsAtPlay;
    }
    public void grabcardsAtPlay(){
        if(playerHand.size() < 15){
            for (int i = 0; i < playerHand.size(); i++) {
                cardsAtPlay[i] = playerHand.get(i);
            }
        }else {
            for (int i = 0; i < 15; i++) {
                cardsAtPlay[i] = playerHand.get(i);
            }
        }
        playerHand.removeAll(List.of(cardsAtPlay));
    }
    public void spit(){
        if(isPlayer1) leftPile.add(playerHand.get(0));
        else rightPile.add(playerHand.get(0));
    }
    public String toString(){
        return getName()+"\n"+playerHand.toString()+"\n"+playerHand.size()+"\n"+ Arrays.toString(cardsAtPlay)+"\n"+cardsAtPlay.length+"\n";
    }
}
