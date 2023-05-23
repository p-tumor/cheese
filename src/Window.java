import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicOptionPaneUI;
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
        Deck.genDeck();
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

        JPanel northBoard = new JPanel();
        northBoard.setPreferredSize(new Dimension(100,75));
        northBoard.setBackground(Color.orange);
        JLabel p1Cards = new JLabel(new ImageIcon(Deck.deck.get(0).getCARD_FRONT()));
        northBoard.add(p1Cards);
        omniscientBoard.add(northBoard,BorderLayout.NORTH);

        JPanel southBoard = new JPanel();
        southBoard.setPreferredSize(new Dimension(100,75));
        southBoard.setBackground(Color.pink);
        JLabel p2Cards = new JLabel(new ImageIcon(Deck.deck.get(1).getCARD_FRONT()));
        southBoard.add(p2Cards);
        omniscientBoard.add(southBoard,BorderLayout.SOUTH);

        JPanel westBoard = new JPanel();
        westBoard.setPreferredSize(new Dimension(100,100));
        westBoard.setBackground(Color.red);
        omniscientBoard.add(westBoard, BorderLayout.WEST);

        JPanel eastBoard = new JPanel();
        eastBoard.setPreferredSize(new Dimension(100,100));
        eastBoard.setBackground(Color.blue);
        omniscientBoard.add(eastBoard,BorderLayout.EAST);

        JPanel centerBoard = new JPanel();
        centerBoard.setLayout(new BoxLayout(centerBoard,BoxLayout.X_AXIS));
        JPanel left = new JPanel(new BorderLayout());
        left.setBackground(Color.green);
        JPanel right = new JPanel(new BorderLayout());
        right.setBackground(Color.gray);

        JLabel leftPile = new JLabel(new ImageIcon(Deck.deck.get(3).getCARD_FRONT()));
        leftPile.setAlignmentX(Component.CENTER_ALIGNMENT);
        left.add(leftPile, BorderLayout.CENTER);
        centerBoard.add(left);

        JLabel rightPile = new JLabel(new ImageIcon(Deck.deck.get(6).getCARD_FRONT()));
        right.add(rightPile, BorderLayout.CENTER);
        centerBoard.add(right);

        omniscientBoard.add(centerBoard,BorderLayout.CENTER);


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
            System.out.println(helpDone.getX());
            System.out.println(helpDone.getY());
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
        JPanel donePanel = new JPanel(new GridBagLayout());
        donePanel.setBackground(Color.red);
        GridBagConstraints c = new GridBagConstraints();
        c.gridheight = 6;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 6;
        helpDone.setVerticalAlignment(SwingConstants.BOTTOM);
        /*helpDone.setFocusable(false);
        helpDone.setOpaque(false);
        helpDone.setContentAreaFilled(false);
        helpDone.setBorderPainted(false);

         */
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
        donePanel.add(helpDone, c);
        helpPage.add(donePanel, BorderLayout.WEST);



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
