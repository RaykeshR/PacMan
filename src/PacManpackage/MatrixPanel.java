package PacManpackage;

//importations

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.util.List;
import java.util.ArrayList;

public class MatrixPanel extends JPanel {
	//attributes
    private int[][] matrix;	//tableau 2D représentant la matrice
    private final int size = 10;  // taille de chaque carré par 10px
    private List<Point> points;	//création d'un liste de point
//    private int score ;

	//constructeur permettant de créer le plateau
    public MatrixPanel(Plateau plateau) {
        this.matrix = plateau.getPlateauBinaire();
//        this.score = 0 ;
        int width = matrix[0].length * size;
        int height = matrix.length * size;
        setPreferredSize(new Dimension(width, height));
        points = new ArrayList<>();

        // Initialize points based on matrix values
        for (int index = 0; index < matrix.length; index++) {
            for (int jindex = 0; jindex < matrix[index].length; jindex++) {
                if (matrix[index][jindex] == 2) {
                    points.add(new Point(jindex, index));
                }
            }
        }
    }

	//methods
	//cette methodes permet de dessiner le plateau en parcourant la matrice
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int index = 0; index < matrix.length; index++) {
            for (int jindex = 0; jindex < matrix[index].length; jindex++) {
                if (matrix[index][jindex] == 1) {
                    g.setColor(Color.BLUE);
                    // la map (the maze) avec des carré bleu
                } else if (matrix[index][jindex] == 2) {
                    g.setColor(Color.BLACK);
                    g.fillRect( jindex * size, index * size, size, size ) ;
                } else {
                    g.setColor(Color.BLACK);
                }
                g.fillRect( jindex * size, index * size, size, size ) ;
            }
        }

        // Draw points for cells with value 2
        List<Point> points3 = new ArrayList<>(points); // copie de la liste pour enlever des bugs
        for (Point point : points3) {
//        	if (point.getX()!=0 || point.getY()!=0) {
	            JLabel label = point.getLabel();
	            label.setLocation(point.getX() * size+3, point.getY() * size+3);
	            this.add(label);
//            }
        }
    }

	//cette méthode permet d'ajouter des points sur le plateau
    public void addPoint(Point point) {
        points.add(point);
        repaint();
    }

	//cette méthode permet d'enlever des points du plateau
    public void removePoint(Point point) {
        points.remove(point);
        remove(point.getLabel()); // Ligne Magique qui enlève les labels qui apparaisse en haut à gauche
        repaint();
    }
    

//    public int getScore() {
//        return score;
//    }
    
    /**
     *  Getter utilisé pour avoir un point connaissant ces coordonnées x et y
     */
    public Point getPoint( int x, int y ) {
    	List<Point> points2 = new ArrayList<>(points); // copie de la liste pour enlever des bugs du à une écriture et lecture en simultanée.
        for (Point point : points2) {
            if (point.getX() == x && point.getY() == y) {
                return point;
            }
        }
        return null; // return null if no point is found at the given coordinates
    }
}
