import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Deck {
    public static ArrayList<Card> deck = new ArrayList<>();
    public static void shuffle(ArrayList<Card> deck){
        ArrayList<Card> temp = new ArrayList<>(deck);
        deck.clear();
        for(int i = (int)(Math.random()*temp.size()); temp.size() != 0; i = (int)(Math.random()*temp.size())){
            deck.add(temp.get(i));
            temp.remove(i);
        }
    }
    public static void genDeck() throws IOException {
        File[] listOfFiles = new File("src/card images").listFiles();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                String[] temp = file.getName().split("_");
                if(temp.length == 3){
                    String value = temp[2].substring(0,temp[2].indexOf("."));
                    if(value.indexOf("0") == 0) value = value.substring(1);
                    if (!temp[2].contains("black") && !temp[2].contains("red")){
                        BufferedImage image = ImageIO.read(file);
                        deck.add(new Card(value,temp[1],image));
                    }
                }
            }
        }
        shuffle(deck);
    }
    public String getDeck() {
        StringBuilder output = new StringBuilder();
        for(Card c: deck) output.append(c.getSUIT()).append(c.getCARD_VAL());
        return output.toString();
    }
}