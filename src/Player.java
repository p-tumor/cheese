import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player{
    private String name;
    private ArrayList<Card> playerHand;
    private Card[] cardsAtPlay;
    private boolean isPlayer1;
    private String playerName;
    private static ArrayList<Card> leftPile = new ArrayList<>();
    private static ArrayList<Card> rightPile = new ArrayList<>();
    private static byte numPlayers = 0;
    public Player() throws IOException {
        numPlayers++;
        playerName = null;
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
    public Card[] getCardsAtPlay(){
        return cardsAtPlay;
    }
    public void grabCardsAtPlay(){
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
        String cardVal = leftPile.get(leftPile.size()-1).getCARD_VAL();
        Card card = cardsAtPlay[cardsAtPlayIndex];
        if(isLeftPile){
            switch (cardVal) {
                case "2" ->{
                    if(card.getCARD_VAL().equals("A") || card.getCARD_VAL().equals("3")){
                        leftPile.add(cardsAtPlay[cardsAtPlayIndex]);
                        cardsAtPlay[cardsAtPlayIndex] = null;
                    }
                }
                case "3" ->{
                    if(card.getCARD_VAL().equals("2") || card.getCARD_VAL().equals("3")){
                        leftPile.add(cardsAtPlay[cardsAtPlayIndex]);
                        cardsAtPlay[cardsAtPlayIndex] = null;
                    }
                }
                case "4" ->{
                    if(card.getCARD_VAL().equals("3") || card.getCARD_VAL().equals("5")){
                        leftPile.add(cardsAtPlay[cardsAtPlayIndex]);
                        cardsAtPlay[cardsAtPlayIndex] = null;
                    }
                }
                case "5" ->{
                    if(card.getCARD_VAL().equals("4") || card.getCARD_VAL().equals("6")){
                        leftPile.add(cardsAtPlay[cardsAtPlayIndex]);
                        cardsAtPlay[cardsAtPlayIndex] = null;
                    }
                }
                case "6" ->{
                    if(card.getCARD_VAL().equals("5") || card.getCARD_VAL().equals("7")){
                        leftPile.add(cardsAtPlay[cardsAtPlayIndex]);
                        cardsAtPlay[cardsAtPlayIndex] = null;
                    }
                }
                case "7" ->{
                    if(card.getCARD_VAL().equals("6") || card.getCARD_VAL().equals("8")){
                        leftPile.add(cardsAtPlay[cardsAtPlayIndex]);
                        cardsAtPlay[cardsAtPlayIndex] = null;
                    }
                }
                case "8" ->{
                    if(card.getCARD_VAL().equals("7") || card.getCARD_VAL().equals("9")){
                        leftPile.add(cardsAtPlay[cardsAtPlayIndex]);
                        cardsAtPlay[cardsAtPlayIndex] = null;
                    }
                }
                case "9" ->{
                    if(card.getCARD_VAL().equals("8") || card.getCARD_VAL().equals("10")){
                        leftPile.add(cardsAtPlay[cardsAtPlayIndex]);
                        cardsAtPlay[cardsAtPlayIndex] = null;
                    }
                }
                case "10" ->{
                    if(card.getCARD_VAL().equals("9") || card.getCARD_VAL().equals("J")){
                        leftPile.add(cardsAtPlay[cardsAtPlayIndex]);
                        cardsAtPlay[cardsAtPlayIndex] = null;
                    }
                }
                case "J" ->{
                    if(card.getCARD_VAL().equals("10") || card.getCARD_VAL().equals("Q")){
                        leftPile.add(cardsAtPlay[cardsAtPlayIndex]);
                        cardsAtPlay[cardsAtPlayIndex] = null;
                    }
                }
                case "Q" ->{
                    if(card.getCARD_VAL().equals("J") || card.getCARD_VAL().equals("K")){
                        leftPile.add(cardsAtPlay[cardsAtPlayIndex]);
                        cardsAtPlay[cardsAtPlayIndex] = null;
                    }
                }
                case "K" ->{
                    if(card.getCARD_VAL().equals("Q") || card.getCARD_VAL().equals("A")){
                        leftPile.add(cardsAtPlay[cardsAtPlayIndex]);
                        cardsAtPlay[cardsAtPlayIndex] = null;
                    }
                }
                case "A" ->{
                    if(card.getCARD_VAL().equals("K") || card.getCARD_VAL().equals("2")){
                        leftPile.add(cardsAtPlay[cardsAtPlayIndex]);
                        cardsAtPlay[cardsAtPlayIndex] = null;
                    }
                }
            }
        }else {
            switch (cardVal) {
                case "2" -> {
                    if (card.getCARD_VAL().equals("A") || card.getCARD_VAL().equals("3")) {
                        rightPile.add(cardsAtPlay[cardsAtPlayIndex]);
                        cardsAtPlay[cardsAtPlayIndex] = null;
                    }
                }
                case "3" -> {
                    if (card.getCARD_VAL().equals("2") || card.getCARD_VAL().equals("3")) {
                        rightPile.add(cardsAtPlay[cardsAtPlayIndex]);
                        cardsAtPlay[cardsAtPlayIndex] = null;
                    }
                }
                case "4" -> {
                    if (card.getCARD_VAL().equals("3") || card.getCARD_VAL().equals("5")) {
                        rightPile.add(cardsAtPlay[cardsAtPlayIndex]);
                        cardsAtPlay[cardsAtPlayIndex] = null;
                    }
                }
                case "5" -> {
                    if (card.getCARD_VAL().equals("4") || card.getCARD_VAL().equals("6")) {
                        rightPile.add(cardsAtPlay[cardsAtPlayIndex]);
                        cardsAtPlay[cardsAtPlayIndex] = null;
                    }
                }
                case "6" -> {
                    if (card.getCARD_VAL().equals("5") || card.getCARD_VAL().equals("7")) {
                        rightPile.add(cardsAtPlay[cardsAtPlayIndex]);
                        cardsAtPlay[cardsAtPlayIndex] = null;
                    }
                }
                case "7" -> {
                    if (card.getCARD_VAL().equals("6") || card.getCARD_VAL().equals("8")) {
                        rightPile.add(cardsAtPlay[cardsAtPlayIndex]);
                        cardsAtPlay[cardsAtPlayIndex] = null;
                    }
                }
                case "8" -> {
                    if (card.getCARD_VAL().equals("7") || card.getCARD_VAL().equals("9")) {
                        rightPile.add(cardsAtPlay[cardsAtPlayIndex]);
                        cardsAtPlay[cardsAtPlayIndex] = null;
                    }
                }
                case "9" -> {
                    if (card.getCARD_VAL().equals("8") || card.getCARD_VAL().equals("10")) {
                        rightPile.add(cardsAtPlay[cardsAtPlayIndex]);
                        cardsAtPlay[cardsAtPlayIndex] = null;
                    }
                }
                case "10" -> {
                    if (card.getCARD_VAL().equals("9") || card.getCARD_VAL().equals("J")) {
                        rightPile.add(cardsAtPlay[cardsAtPlayIndex]);
                        cardsAtPlay[cardsAtPlayIndex] = null;
                    }
                }
                case "J" -> {
                    if (card.getCARD_VAL().equals("10") || card.getCARD_VAL().equals("Q")) {
                        rightPile.add(cardsAtPlay[cardsAtPlayIndex]);
                        cardsAtPlay[cardsAtPlayIndex] = null;
                    }
                }
                case "Q" -> {
                    if (card.getCARD_VAL().equals("J") || card.getCARD_VAL().equals("K")) {
                        rightPile.add(cardsAtPlay[cardsAtPlayIndex]);
                        cardsAtPlay[cardsAtPlayIndex] = null;
                    }
                }
                case "K" -> {
                    if (card.getCARD_VAL().equals("Q") || card.getCARD_VAL().equals("A")) {
                        rightPile.add(cardsAtPlay[cardsAtPlayIndex]);
                        cardsAtPlay[cardsAtPlayIndex] = null;
                    }
                }
                case "A" -> {
                    if (card.getCARD_VAL().equals("K") || card.getCARD_VAL().equals("2")) {
                        rightPile.add(cardsAtPlay[cardsAtPlayIndex]);
                        cardsAtPlay[cardsAtPlayIndex] = null;
                    }
                }
            }
        }
    }
    public void spit(){
        if(isPlayer1) leftPile.add(playerHand.get(0));
        else rightPile.add(playerHand.get(0));
    }
    public void setName(String s){
        playerName = s;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String toString(){
        return getName()+"\n"+playerHand.toString()+"\n"+playerHand.size()+"\n"+ Arrays.toString(cardsAtPlay)+"\n"+cardsAtPlay.length+"\n";
    }
}
