import javax.swing.JPanel;
import java.awt.*;

public class TransparentPanel extends JPanel {
    public TransparentPanel(){
        setOpaque(true);

    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Set the panel's background color with an alpha value to make it transparent
        g.setColor(new Color(0, 0, 0, 0)); // Change the alpha value (0-255) to adjust the transparency
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}
