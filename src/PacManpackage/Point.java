package PacManpackage;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Point {
    private JLabel label;
    int x;
	int y;
    private final int SIZE = 5;
    private final int offsetX = 110;
    private final int offsetY = 105;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        ImageIcon icon = new ImageIcon(this.getClass().getResource("/PacManpackage/rond-jaune.png"));
        icon = resizeImageIcon(icon, 3, 3);
        label = new JLabel(icon);
        label.setBounds(x * SIZE, y * SIZE, icon.getIconWidth(), icon.getIconHeight());
    }

    private ImageIcon resizeImageIcon(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

    public JLabel getLabel() {
        return label;
    }

    public void addToPane(JLayeredPane pane) {
        pane.add(label, JLayeredPane.DEFAULT_LAYER);
        pane.repaint();
    }

    public void removeFromPane(JLayeredPane pane) {
        pane.remove(label);
        pane.repaint();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
