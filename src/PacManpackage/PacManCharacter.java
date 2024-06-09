package PacManpackage;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PacManCharacter {
    private JLabel label;
    private int x, y,dx,dy;
    private int[][] matrix;
    private final int SIZE = 10; // La taille de chaque case dans la matrice
    private final int offsetX = 110;
    private final int offsetY = 105;
    private String direction = ""; // Direction actuelle
    private String previousDirection = "" ;
    private Timer timer; // Timer pour le déplacement continu
    

    public PacManCharacter(JLayeredPane pane, int[][] matrix) {
        this.matrix = matrix;
        ImageIcon icon = new ImageIcon(this.getClass().getResource("/PacManpackage/rond-jaune.png"));
        icon = resizeImageIcon(icon, 10, 10); // Redimensionner à 50x50 pixels, ajustez selon vos besoins
        label = new JLabel(icon);
        // Position initiale de Pac-Man dans la matrice
        x = 14; // colonne
        y = 17; // ligne
        label.setBounds(x * SIZE + offsetX, y * SIZE + offsetY, icon.getIconWidth(), icon.getIconHeight());
        pane.add(label, Integer.valueOf(3));  // Ajouter Pac-Man au pane
        
        timer = new Timer(200, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                move();
            }
        });
        timer.start(); // Démarrer le timer
    }

    private ImageIcon resizeImageIcon(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }
    
    public void setDirection(String direction) {
        this.direction = direction;
    }
    
    private void move() {
    	dx = 0;
    	dy = 0;
        switch (direction) {
            case "LEFT":
            	dx=-1;
                moveLeft();
                break;
            case "RIGHT":
            	dx=1;
                moveRight();
                break;
            case "UP":
            	dy=-1;
                moveUp();
                break;
            case "DOWN":
            	dy=1;
                moveDown();
                break;
        }
    }

    public void moveLeft() {
        if (x > 0 && matrix[y][x - 1] == 0) {
            x--;
        } else if (x == 0) {
            x = matrix[0].length - 1; // Réapparaître à droite
        }
        updatePosition();
    }

    public void moveRight() {
        if (x < matrix[0].length - 1 && matrix[y][x + 1] == 0) {
            x++;
        } else if (x == matrix[0].length - 1) {
            x = 0; // Réapparaître à gauche
        }
        updatePosition();
    }

    public void moveUp() {
        if (y > 0 && matrix[y - 1][x] == 0) {
            y--;
            updatePosition();
        }
    }

    public void moveDown() {
        if (y < matrix.length - 1 && matrix[y + 1][x] == 0) {
            y++;
            updatePosition();
        }
    }

    private void updatePosition() {
//        label.setBounds((x-dx) * SIZE + offsetX, (y-dy) * SIZE + offsetY, label.getWidth(), label.getHeight());
//        for(int i=0;i<SIZE;i++) {
//        	label.setBounds((x-dx) * SIZE + offsetX + dx*i, (y-dy) * SIZE + offsetY + dy*i, label.getWidth(), label.getHeight());
//        }
    	if( x >= matrix[0].length - 1 || x <= 0 || (matrix[y][x + 1] != 0 || matrix[y][x - 1] != 0) && dx!=0) {
    		label.setBounds((x) * SIZE + offsetX, (y) * SIZE + offsetY, label.getWidth(), label.getHeight());
    	}
    	else {
	    	int newX = (x-dx) * SIZE + offsetX;
	        int newY = (y-dy) * SIZE + offsetY;
	
	        // Create a timer to update the position with a delay
	        Timer updateTimer = new Timer(10, new ActionListener() {
	            int i = 0;
	            public void actionPerformed(ActionEvent e) {
	                label.setBounds(newX + dx * i, newY + dy * i, label.getWidth(), label.getHeight());
	                i++;
	
	                // Stop the timer when the animation is complete
	                if (i >= SIZE) {
	                    ((Timer) e.getSource()).stop();
	                }
	            }
	        });
	        updateTimer.start();
        }
    }
}
