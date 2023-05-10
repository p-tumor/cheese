import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class Window extends JFrame{
    public Window() throws IOException {
        Deck.genDeck();
        JPanel startMenu = new JPanel();
        JPanel centerPanel = new JPanel(new FlowLayout());

        JPanel test = new JPanel();
        myImageIcon testimage = new myImageIcon(Deck.deck.get(0).getCARD_FRONT(),Deck.deck.get(0));
        JLabel test2 = new JLabel(testimage);
        test2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(testimage.getCard());
            }

        });
        test.add(test2);

        JButton start = new JButton("Start Game");
        start.setFocusable(false);
        start.setOpaque(false);
        start.setContentAreaFilled(false);
        start.setBorderPainted(false);
        start.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        start.addActionListener(e -> {
            System.out.println("start button pressed");
        });
        start.addMouseListener((new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                start.setFont(new Font("Comic Sans MS Bold", Font.PLAIN, 30));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                start.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
            }
        }));
        start.setAlignmentX(Component.CENTER_ALIGNMENT);
        start.setVisible(true);
        centerPanel.add(start);

        JButton help = new JButton("Help");
        help.setFocusable(false);
        help.setAlignmentX(Component.CENTER_ALIGNMENT);
        help.setVisible(true);
        help.setOpaque(false);
        help.setContentAreaFilled(false);
        help.setBorderPainted(false);
        help.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        help.addMouseListener((new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                help.setFont(new Font("Comic Sans MS Bold", Font.PLAIN, 33));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                help.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
            }
        }));
        centerPanel.add(help);

        this.setTitle("Spit");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel title = new JLabel("Welcome to Spit!");
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        startMenu.add(title);

        //startMenu.set
        this.add(startMenu, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(test,BorderLayout.SOUTH);

        this.setSize(500, 500);
        this.setVisible(true);
    }
}
