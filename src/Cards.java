import java.io.File;
import java.util.ArrayList;

public class Cards {
    public static ArrayList<Card> deck;
    public Cards(){
        File[] listOfFiles = new File("src/card images").listFiles();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                String[] temp = file.getName().split("_");
                deck.add(new Card(Byte.parseByte(temp[2].substring(1)),temp[1]));
            }
        }
    }
    public ArrayList<Card> shuffle(ArrayList<Card> deck){
        ArrayList<Card> temp = new ArrayList<>(deck);
        deck.clear();
        for(int i = (int)(Math.random()*temp.size()); temp.size() != 0; temp.remove(i)){
            deck.add(temp.get(i));
        }
        deck = temp;
        return deck;
    }

    public static ArrayList<Card> getDeck() {
        String output = "";
        for(Card c: deck){

        }
        return output;
    }
}