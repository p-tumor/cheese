import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.security.Key;

public class Window extends JFrame{
    private Font BIGGER = new Font("Comic Sans MS Bold", Font.PLAIN, 33);
    private Font SMALLER = new Font("Comic Sans MS", Font.PLAIN, 30);
    private Action moveCard;
    private JLabel p2Cards;
    private Player p1;
    private Player p2;
    String name1, name2;
    boolean clicked1, clicked2;
    public Window() throws IOException {
        this.setTitle("Spit");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        clicked1 = clicked2 = false;
        p1 = new Player();
        p2 = new Player();

        CardPanel omniscient = new CardPanel();
        omniscient.setLayout(new CardLayout());
        CardLayout omniscientLayout = (CardLayout) omniscient.getLayout();

        JPanel helpPage = new JPanel(new BorderLayout(10,0));
        JLabel helpText = new JLabel("This is the help menu.", SwingConstants.LEFT);
        helpText.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        JButton helpDone = new JButton("Done!");

        //Getting player names-----------------------------------------------------
        JPanel playerCreation = new JPanel(new BorderLayout());
        JPanel playerCenter = new JPanel();
        playerCenter.setLayout(new BoxLayout(playerCenter,BoxLayout.X_AXIS));
        JPanel p1Creation = new JPanel();
        JTextField p1Name = new JTextField("Enter name: ");
        p1Name.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(!clicked1) {
                    p1Name.setText("");
                    clicked1 = true;
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                name1 = p1Name.getText();
            }
        });

        JPanel p2Creation = new JPanel();
        JTextField p2Name = new JTextField("Enter name: ");
        p2Name.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(!clicked2) {
                    p2Name.setText("");
                    clicked2 = true;
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                name2 = p2Name.getText();
            }
        });
        p1Creation.add(p1Name);
        p2Creation.add(p2Name);

        JPanel playPanel = new JPanel();
        JButton play = new JButton("Play!");
        play.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p1.setName(name1);
                p2.setName(name2);
                omniscientLayout.show(omniscient,"game");
            }
        });

        playPanel.add(play, BorderLayout.SOUTH);

        playerCenter.add(p1Creation);
        playerCenter.add(p2Creation);

        playerCreation.add(playerCenter, BorderLayout.CENTER);
        playerCreation.add(playPanel, BorderLayout.SOUTH);





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
        ImageIcon p2card = new ImageIcon(Deck.deck.get(1).getCARD_FRONT());

        moveCard = new MoveCard();

        p2Cards = new JLabel();
        p2Cards.setIcon(p2card);
        southBoard.add(p2Cards);
        System.out.println(p2Cards.getWidth());
        System.out.println(p2Cards.getHeight());
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

        CardPanel startMenu = new CardPanel();
        startMenu.setLayout(new BorderLayout());
        TransparentPanel centerStartMenu = new TransparentPanel();
        centerStartMenu.setLayout(new FlowLayout());


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
        start.setForeground(Color.WHITE);
        start.setFocusable(false);
        start.setOpaque(false);
        start.setContentAreaFilled(false);
        start.setBorderPainted(false);
        start.setFont(SMALLER);
        start.addActionListener(e -> {
            omniscientLayout.show(omniscient,"creation");
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
        help.setForeground(Color.WHITE);
        help.setFocusable(false);
        help.setAlignmentX(Component.CENTER_ALIGNMENT);
        help.setVisible(true);
        help.setOpaque(false);
        help.setContentAreaFilled(false);
        help.setBorderPainted(false);
        help.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        help.addActionListener(e -> {
            omniscientLayout.show(omniscient, "helpPage");
            System.out.println("ini w: "+ helpDone.getWidth());
            System.out.println("ini h: "+helpDone.getHeight());
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
        JPanel donePanel = new JPanel(new BorderLayout());
        donePanel.setBackground(Color.red);
        donePanel.setPreferredSize(new Dimension(150,150));
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
        donePanel.add(helpDone, BorderLayout.SOUTH);
        helpPage.add(donePanel,BorderLayout.WEST);

        //Building text in help menu--------------------------------------------------------------------------------------------------------
        JPanel omniHTP = new JPanel(new FlowLayout());//htp = help text panel
        helpText.setText(helpText(helpText));
        omniHTP.add(helpText,FlowLayout.LEFT);
        helpPage.add(omniHTP,BorderLayout.CENTER);


        //Title in MainMenu------------------------------------------------------------------------------------------------------------------------
        JLabel title = new JLabel("Welcome to Spit!");
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        title.setForeground(Color.WHITE);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        startMenu.add(title, BorderLayout.NORTH);
        startMenu.add(centerStartMenu, BorderLayout.CENTER);

        //Final additions----------------------------------------------------------------------------------------------------------------------
        omniscient.add(startMenu, "startMenu");
        omniscient.add(helpPage, "helpPage");
        omniscient.add(playerCreation, "creation");
        omniscient.add(omniscientBoard, "game");
        this.add(omniscient);

        this.setVisible(true);
    }
    private String helpText(JLabel thing){
        StringBuilder s = new StringBuilder();
        s.append("<html>");
        thing.setFont(BIGGER);
        s.append("How to Play?<br>");
        thing.setFont(SMALLER);
        s.append("<p style='text-align: left;'> Spit is simple. </p>");
        s.append("</html>");
        return s.toString();
    }
    private class MoveCard extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            p2Cards.setLocation(p2Cards.getX()-15,p2Cards.getY());
        }
    }
}
