import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //new Window();
        new Cards().genCards();
        System.out.println(Player.numPlayers);
        Player p1 = new Player("J");
        System.out.println(Player.numPlayers);
        Player p2 = new Player("B");
        System.out.println(Player.numPlayers);
        System.out.println(p1);
        System.out.println(p2);
    }
}
