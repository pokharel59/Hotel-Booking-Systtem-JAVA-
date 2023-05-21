package CustomerGUI;

import javax.swing.JPanel;
import java.awt.Graphics;

public class RoundPanel extends JPanel {

    private static final int arcRadius = 20;

    public RoundPanel() {

        this.setOpaque(false);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth(), getHeight(), arcRadius, arcRadius);
    }

//    public void dispose() {
//        super.dispose();
//    }
}
