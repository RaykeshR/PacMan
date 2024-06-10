package PacManpackage;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.util.List;
import java.util.ArrayList;

public class MatrixPanel extends JPanel {
    private int[][] matrix;
    private final int size = 10;  // taille de chaque carré
    private List<Point> points;
    private int score ;

    public MatrixPanel(Plateau plateau) {
        this.matrix = plateau.getPlateauBinaire();
        this.score = 0 ;
        int width = matrix[0].length * size;
        int height = matrix.length * size;
        setPreferredSize(new Dimension(width, height));
        points = new ArrayList<>();

        // Initialize points based on matrix values
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 2) {
                    points.add(new Point(j, i));
                }
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    g.setColor(Color.BLUE);
                } else if (matrix[i][j] == 2) {
                    g.setColor(Color.BLACK);
                    g.fillRect(j * size, i * size, size, size);
                } else {
                    g.setColor(Color.BLACK);
                }
                g.fillRect(j * size, i * size, size, size);
            }
        }

        // Draw points for cells with value 2
        for (Point point : points) {
            JLabel label = point.getLabel();
            label.setLocation(point.getX() * size+3, point.getY() * size+3);
            this.add(label);
        }
    }

    public void addPoint(Point point) {
        points.add(point);
        repaint();
    }
 
    public void removePoint(Point point) {
        points.remove(point);
        repaint();
    }
    

    public int getScore() {
        return score;
    }
    
    public Point getPoint(int x, int y) {
        for (Point point : points) {
            if (point.getX() == x && point.getY() == y) {
                return point;
            }
        }
        return null; // return null if no point is found at the given coordinates
    }
    
}
