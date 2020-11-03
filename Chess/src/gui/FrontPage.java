package gui;

import javax.swing.*;
import java.awt.*;

public class FrontPage extends JComponent {
    private final int SIZE = 60;
    public FrontPage() {

    }
    public Dimension getPreferredSize() {
        return new Dimension(8 * SIZE, (8 * SIZE));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        final Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLUE);
        g2d.drawRect(100,100,100,100);
    }
}
