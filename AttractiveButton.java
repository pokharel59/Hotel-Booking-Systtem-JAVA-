package CustomerGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AttractiveButton extends JButton {

    private static final Color BUTTON_COLOR = new Color(37, 165, 0);
    private static final Color BUTTON_HOVER_COLOR = new Color(174, 222, 155);
    private static final int ARC_RADIUS = 15;

    public AttractiveButton(String text) {
        super(text);

        setOpaque(false);
        setContentAreaFilled(false);
        setForeground(Color.WHITE);
        setFont(new Font("Arial", Font.BOLD, 16));
        setFocusPainted(false);
        setPreferredSize(new Dimension(150, 50));
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setBorder(null);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(BUTTON_HOVER_COLOR);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(BUTTON_COLOR);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (getModel().isPressed()) {
            g2.setColor(BUTTON_HOVER_COLOR);
        } else if (getModel().isRollover()) {
            g2.setColor(BUTTON_HOVER_COLOR);
        } else {
            g2.setColor(BUTTON_COLOR);
        }

        g2.fillRoundRect(0, 0, getWidth(), getHeight(), ARC_RADIUS, ARC_RADIUS);

        super.paintComponent(g);

        g2.dispose();
    }
}
