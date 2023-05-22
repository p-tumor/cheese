import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class Window extends JFrame{
    public Window() throws IOException {
        super("Spit");
        //gen Jframe
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(750, 750);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        //this.setLayout(null);
        JLabel back = new JLabel(new ImageIcon("src/backFrame.png"));
        back.setBounds(0,0,getWidth(),getHeight());
        this.add(back);


        TransparentPanel omniscient = new TransparentPanel();
        omniscient.setLayout(new CardLayout());
        CardLayout omniscientLayout = (CardLayout) omniscient.getLayout();

        Deck.genDeck();
        TransparentPanel forAllCards = new TransparentPanel();
        for(Card c: Deck.deck){
            forAllCards.add(new JLabel(new myImageIcon(c.getCARD_FRONT(),c)));
        }

        TransparentPanel startMenu = new TransparentPanel();
        startMenu.setLayout(new BorderLayout());
        TransparentPanel centerStartMenu = new TransparentPanel();
        centerStartMenu.setLayout(new FlowLayout());


        TransparentPanel test = new TransparentPanel();
        myImageIcon testimage = new myImageIcon(Deck.deck.get(0).getCARD_FRONT(),Deck.deck.get(0));


        JLabel test2 = new JLabel(testimage);
        test2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(testimage.getCard());
                int ran = (int)(Math.random()*Deck.deck.size());
                testimage.setImage(Deck.deck.get(ran).getCARD_FRONT());
                testimage.setCard(Deck.deck.get(ran));
                repaint();
            }

        });
        test.add(test2);

        //Start button in main menu--------------------------------------------------------------------------------------------
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
        centerStartMenu.add(start, BorderLayout.CENTER);

        //Help button on Main Menu---------------------------------------------------------------------------------------------
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
        centerStartMenu.add(help, BorderLayout.CENTER);



        //Title in MainMenu-------------------------------------------------------------------------------------------------
        JLabel title = new JLabel("Welcome to Spit!");
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        startMenu.add(title, BorderLayout.NORTH);
        startMenu.add(centerStartMenu, BorderLayout.CENTER);
        //startMenu.set
        /*this.add(startMenu, BorderLayout.NORTH);
        this.add(centerStartMenu, BorderLayout.CENTER);
        this.add(test,BorderLayout.SOUTH);

         */
        omniscient.add(startMenu);
        this.add(omniscient);

        this.setVisible(true);
    }
}
