import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class Window extends JFrame{
    private Font BIGGER = new Font("Comic Sans MS Bold", Font.PLAIN, 33);
    private Font SMALLER = new Font("Comic Sans MS", Font.PLAIN, 30);
    public Window() throws IOException {
        super("Spit");
        //gen Jframe
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(750, 750);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        //this.setLayout(null);
        /*JLabel back = new JLabel(new ImageIcon("src/backFrame.png"));
        back.setBounds(0,0,getWidth(),getHeight());
        this.add(back);

         */


        JPanel omniscient = new JPanel();
        omniscient.setLayout(new CardLayout());
        CardLayout omniscientLayout = (CardLayout) omniscient.getLayout();

        JPanel helpPage = new JPanel(new BorderLayout());
        JLabel helpText = new JLabel("This is the help menu");
        helpPage.add(helpText);
        JButton helpDone = new JButton("Done!");

        // Building game board----------------------------------------------------------------------------------------------------------------------
        JPanel omniscientBoard = new JPanel(new BorderLayout());

        JPanel northBoard
        JLabel p1Cards = new JLabel();
        omniscientBoard.add(p1Cards,BorderLayout.NORTH);

        JLabel p2Cards = new JLabel();
        p2Cards.setBackground(Color.green);
        omniscientBoard.add(p2Cards,BorderLayout.SOUTH);

        EmptyBorder leftBoardBorder = BorderFactory.createEmptyBorder();
        leftBoardBorder.setBackground(Color.red);
        omniscientBoard.add(leftBoardBorder,BorderLayout.WEST);

        JPanel rightBoardBorder = new JPanel();
        rightBoardBorder.setBackground(Color.blue);
        omniscientBoard.add(rightBoardBorder,BorderLayout.EAST);


        Deck.genDeck();
        JPanel forAllCards = new JPanel();
        for(Card c: Deck.deck){
            forAllCards.add(new JLabel(new myImageIcon(c.getCARD_FRONT(),c)));
        }

        JPanel startMenu = new JPanel(new BorderLayout());
        JPanel centerStartMenu = new JPanel(new FlowLayout());


        JPanel test = new JPanel();
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
        start.setFont(SMALLER);
        start.addActionListener(e -> {
            omniscientLayout.show(omniscient,"game");
        });
        start.addMouseListener((new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                start.setFont(BIGGER);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                start.setFont(SMALLER);
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
        help.addActionListener(e -> {
            omniscientLayout.show(omniscient, "helpPage");
            System.out.println(helpDone.getWidth());
            System.out.println(helpDone.getHeight());
        });
        help.addMouseListener((new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                help.setFont(BIGGER);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                help.setFont(SMALLER);
            }
        }));
        centerStartMenu.add(help, BorderLayout.CENTER);

        //Building the "Done!" button in the helpPage-----------------------------------------------------------------------------------
        helpDone.setVerticalAlignment(SwingConstants.BOTTOM);
        helpDone.setFocusable(false);
        helpDone.setOpaque(false);
        helpDone.setContentAreaFilled(false);
        helpDone.setBorderPainted(false);
        helpDone.addActionListener(e ->{
            omniscientLayout.show(omniscient,"startMenu");
        });
        helpDone.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        helpDone.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                helpDone.setFont(BIGGER);
            }
            @Override
            public void mouseExited(MouseEvent e){
                helpDone.setFont(SMALLER);
            }
        });

        helpPage.add(helpDone, BorderLayout.WEST);



        //Title in MainMenu------------------------------------------------------------------------------------------------------------------------
        JLabel title = new JLabel("Welcome to Spit!");
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        startMenu.add(title, BorderLayout.NORTH);
        startMenu.add(centerStartMenu, BorderLayout.CENTER);

        //Final additions----------------------------------------------------------------------------------------------------------------------
        omniscient.add(startMenu, "startMenu");
        omniscient.add(helpPage, "helpPage");
        omniscient.add(omniscientBoard, "game");
        this.add(omniscient);

        this.setVisible(true);
    }
}
