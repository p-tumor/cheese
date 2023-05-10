import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player{
    private String name;
    private ArrayList<Card> playerHand;
    private Card[][] cardsAtPlay;
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
        cardsAtPlay = new Card[][]{
            {null},
            {null,null},
            {null,null,null},
            {null,null,null,null},
            {null,null,null,null,null}
        };
        grabCardsAtPlay();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Card> getPlayerHand() {
        return playerHand;
    }

    public void addCard(Card card) {
        playerHand.add(card);
    }
    public Card[][] getCardsAtPlay(){
        return cardsAtPlay;
    }
    public void grabCardsAtPlay(){
        if(playerHand.size() < 15){
            for(Card[] playPile: cardsAtPlay) {
                for (int i = 0; i < playerHand.size(); i++) {
                    playPile[i] = playerHand.get(i);
                }
            }
        }else {
            for(Card[] playPile: cardsAtPlay) {
                for (int i = 0; i < playerHand.size(); i++) {
                    playPile[i] = playerHand.get(i);
                }
            }
        }
        for(Card[] cards: cardsAtPlay) {
            playerHand.removeAll(List.of(cards));
        }
    }
    public void takePile(boolean choice){
        if(choice) {
            playerHand.addAll(leftPile);
            leftPile.clear();
            Deck.shuffle(playerHand);
        }else{
            playerHand.addAll(rightPile);
            rightPile.clear();
            Deck.shuffle(playerHand);
        }
    }
    public void playCard(int cardsAtPlayIndex, boolean isLeftPile){
        if(isLeftPile){
            String cardVal = leftPile.get(leftPile.size()-1).getCARD_VAL();
            Card card = Deck.deck.get(0);
            switch (cardVal) {
                case "2" ->{
                    if(card.getCARD_VAL().equals("A") || card.getCARD_VAL().equals("3")){

                    }
                }
            }
        }else{

        }
    }
    public void spit(){
        if(isPlayer1) leftPile.add(playerHand.get(0));
        else rightPile.add(playerHand.get(0));
    }
    public String toString(){
        return getName()+"\n"+playerHand.toString()+"\n"+playerHand.size()+"\n"+ Arrays.toString(cardsAtPlay)+"\n"+cardsAtPlay.length+"\n";
    }
}
