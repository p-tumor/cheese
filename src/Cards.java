import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Cards {
    protected static ArrayList<Card> deck;
    protected ArrayList<Card> pOneDeck;
    protected ArrayList<Card> pTwoDeck;
    protected ArrayList<Cards> leftPile;
    protected ArrayList<Cards> rightPile;
    public void genCards() throws IOException {
        deck = new ArrayList<>();
        File[] listOfFiles = new File("src/card images").listFiles();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                String[] temp = file.getName().split("_");
                if(temp.length == 3){
                    String value = temp[2].substring(0,temp[2].indexOf("."));
                    if(value.substring(0).equals("0")) value = value.substring(1);
                    if (!temp[2].contains("black") && !temp[2].contains("red")){
                        BufferedImage image = ImageIO.read(file);
                        deck.add(new Card(value,temp[1],image));
                    }
                }
            }
        }
        shuffle(deck);
        pOneDeck = new ArrayList<>();
        pTwoDeck = new ArrayList<>();
        for( int i = 0; i < deck.size(); i++){
            if(i < 26)pOneDeck.add(deck.get(i));
            else pTwoDeck.add(deck.get(i));
        }

        System.out.println(pOneDeck.size() + "pOne");
        System.out.println(pTwoDeck.size() + "pTwo");
        System.out.println(pOneDeck == null);
        System.out.println(pTwoDeck == null);
        leftPile = new ArrayList<>();
        rightPile = new ArrayList<>();
    }
    protected void shuffle(ArrayList<Card> deck){
        ArrayList<Card> temp = new ArrayList<>(deck);
        deck.clear();
        for(int i = (int)(Math.random()*temp.size()); temp.size() != 0; i = (int)(Math.random()*temp.size())){
            deck.add(temp.get(i));
            temp.remove(i);
        }
    }
    public void toLeft(Player p, Card c){
        Card[] temp = p.getHand();

    }

    protected String getDeck() {
        StringBuilder output = new StringBuilder();
        for(Card c: deck) output.append(c.getSUIT()).append(c.getCARD_VAL());
        return output.toString();
    }

    public ArrayList<Card> getpOneDeck() {
        return pOneDeck;
    }

    public ArrayList<Card> getpTwoDeck() {
        return pTwoDeck;
    }
}