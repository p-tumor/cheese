import javax.swing.JPanel;
import java.awt.*;

public class TransparentPanel extends JPanel {
    public TransparentPanel(){
        setOpaque(false);

    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(0, 0, 0, 0));
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}