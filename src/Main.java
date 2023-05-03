import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //new Window();
        Deck.genDeck();
        Player p1 = new Player("J");
        System.out.println(p1);
        Player p2 = new Player("B");
        System.out.println(p2);
    }
}
