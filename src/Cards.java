import java.io.File;
import java.util.ArrayList;

public class Cards {
    public static ArrayList<Card> deck;
    public Cards(){
        File[] listOfFiles = new File("src/card images").listFiles();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                String[] temp = file.getName().split("_");
                deck.add(new Card(Byte.parseByte(temp[2].substring(1))));
            }
        }
    }
    public void shuffle(Card)
}