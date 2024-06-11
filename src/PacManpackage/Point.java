//librairie
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
//    private boolean EnCoursDeDigestion;
//    // Position dans le Plateau (Matrice)
	int Px,Py;

//constructeur
    public Point(int x, int y) {
        this.x = x;Px=x;
        this.y = y;Py=y;
        ImageIcon icon = new ImageIcon(this.getClass().getResource("/PacManpackage/rond-jaune.png"));// pour recuperer l'information (l'image rond-jaune)
        icon = resizeImageIcon(icon, 3, 3); // pour redimensionner l'image
        label = new JLabel(icon); //nouveau label associé à icon
        label.setBounds(x * SIZE, y * SIZE, icon.getIconWidth(), icon.getIconHeight());//Définit la position et la taille du label pour afficher le point
    }
//methodes
	//methodes pour redimensionner la taille d'un icon
    private ImageIcon resizeImageIcon(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

    public JLabel getLabel() {
        return label;
    }

   
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    


//    public Point(int x, int y) {
//        this.x = x;
//        this.y = y;
//        this.EnCoursDeDigestion = false;
//    }
//
//    public int getX() {
//        return x;
//    }
//
//    public int getY() {
//        return y;
//    }
//
//    public boolean isEaten() {
//        return EnCoursDeDigestion;
//    }
//
//    public void eat() {
//        EnCoursDeDigestion = true;
//    }
//
//	/**
//	 * @return the px
//	 */
//	public int getPx() {
//		return Px;
//	}
//
//	/**
//	 * @return the py
//	 */
//	public int getPy() {
//		return Py;
//	}
//
//	
//	/**
//	 * Dans la matrice, c'est repésentée par des 3
//	 * renvoie les objets de la classe point correspondont aux point sur le plateau.
//	 */
//	public Point[] LesPointstandard(int n) {
//		Plateau get = new Plateau();
//	    int[][] P = get.getPlateau();
//	    int nombreELements = count(P, 3);
//	    Point[] points = new Point[nombreELements];
//	    int index = 0;
//	    for (int i = 0; i < P.length; i++) {
//	        for (int j = 0; j < P[i].length; j++) {
//	            if (P[i][j] == 3) {
//	                points[index] = new Point(i * n, j * n);
//	                points[index].Px = i;
//	                points[index].Py = j;
//	                index++;
//	            }
//	        }
//	    }
//	    return points;
//	}
//methode pour compter dans la matrice le nombre de fois qu'il y'a valeur
	private int count(int[][] matrix, int valeur) {
	    int count = 0;
	    for (int i = 0; i < matrix.length; i++) {
	        for (int j = 0; j < matrix[i].length; j++) {
	            if (matrix[i][j] == valeur) {
	                count++;
	            }
	        }
	    }
	    return count;
	}
	
	
	//renvoie les objets de la classe point correspondont aux Gros point sur le plateau.
	
	 //
	public Point[] LesBonus(int n) {
		Plateau get = new Plateau();
	    int[][] P = get.getPlateau();
	    int nombreELements = count(P, 4);
	    Point[] points = new Point[nombreELements];
	    int index = 0;
	    for (int i = 0; i < P.length; i++) {
	        for (int j = 0; j < P[i].length; j++) {
	            if (P[i][j] == 4) {
	                points[index] = new Point(i * n, j * n);
	                points[index].Px = i;
	                points[index].Py = j;
	                index++;
	            }
	        }
	    }
	    return points;
	}



}
