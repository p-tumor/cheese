import java.io.IOException;

public class Play {
    private static Player p1,p2;
    public static void play() throws IOException {
        p1 = new Player();
        p2 = new Player();
        System.out.println(p1.getCardsAtPlay());
        System.out.println(p2.getCardsAtPlay());
    }
}
