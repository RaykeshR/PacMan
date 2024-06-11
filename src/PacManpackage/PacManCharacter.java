package PacManpackage;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

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
    private List<Integer> casesAccessibles;
    

    public PacManCharacter(JLayeredPane pane, int[][] matrix) {
        this.matrix = matrix;
	casesAccessibles = Arrays.asList(0, 2);
        ImageIcon icon = new ImageIcon(this.getClass().getResource("/PacManpackage/rond-jaune.png"));
        icon = resizeImageIcon(icon, 10, 10); // Redimensionner à 50x50 pixels, ajustez selon vos besoins
        label = new JLabel(icon);
        // Position initiale de Pacman dans la matrice
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
            	dx=-1;// lissage des déplacement
                moveLeft();
                break;
            case "RIGHT":
            	dx=1;// lissage des déplacement
                moveRight();
                break;
            case "UP":
            	dy=-1;// lissage des déplacement
                moveUp();
                break;
            case "DOWN":
            	dy=1;// lissage des déplacement
                moveDown();
                break;
        }
    }

   public void moveLeft() {
        if (x > 0 && casesAccessibles.contains(matrix[y][x - 1])) {
            x--;
        } else if (x == 0) {
            x = matrix[0].length - 1; // Réapparaître à droite
        }
        updatePosition();
    }

    public void moveRight() {
        if (x < matrix[0].length - 1 && casesAccessibles.contains(matrix[y][x + 1])) {
            x++;
        } else if (x == matrix[0].length - 1) {
            x = 0; // Réapparaître à gauche
        }
        updatePosition();
    }

    public void moveUp() {
        if (y > 0 && casesAccessibles.contains(matrix[y - 1][x])) {
            y--;
            updatePosition();
        }
    }

    public void moveDown() {
        if (y < matrix.length - 1 && casesAccessibles.contains( matrix[y + 1][x])) {
            y++;
            updatePosition();
        }
    }


    private void updatePosition() {
//        label.setBounds((x-dx) * SIZE + offsetX, (y-dy) * SIZE + offsetY, label.getWidth(), label.getHeight());
//        for(int i=0;i<SIZE;i++) {
//        	label.setBounds((x-dx) * SIZE + offsetX + dx*i, (y-dy) * SIZE + offsetY + dy*i, label.getWidth(), label.getHeight());
//        }
    	if( x >= matrix[0].length - 1 || x <= 0 || (matrix[y][x + 1] == 1 || matrix[y][x - 1] == 1) && dx!=0) {
    		// Gestion des bug
    		label.setBounds((x) * SIZE + offsetX, (y) * SIZE + offsetY, label.getWidth(), label.getHeight());
    	}
    	else {
	    	int newX = (x-dx) * SIZE + offsetX;
	        int newY = (y-dy) * SIZE + offsetY;
	
	        // Create a timer to update the position with a delay
	        // ici on avance de 10% chanque itération.
	        Timer updateTimer = new Timer(10, new ActionListener() {
	            int i = 0;
	            public void actionPerformed(ActionEvent e) {
	                label.setBounds(newX + dx * i, newY + dy * i, label.getWidth(), label.getHeight());
	                i++;
	
	                // Stop the timer when the animation is complete
	                // on a avancer à la nouvelle coordoner
	                if (i >= SIZE) {
	                    ((Timer) e.getSource()).stop();
	                }
	            }
	        });
	        updateTimer.start();
        }
    }

	/**
	 * @return the x
	 */
	public int getX() {
		//return (x + matrix.length) % matrix.length; 
		
		return x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
//		return (y + matrix[0].length) % matrix[0].length; 
//		if(y%28==0) {return y-1;}
//		if(y%28==1) {return y-2;}
		return y;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	public int getElementMatrix(int x,int y) {
		//...
		return matrix[x][y];
	}
	
	public int getMatrixLenghtMoinsUn() {
		//...
		return matrix.length - 1;
	}
	public int getMatrix0LenghtMoinsUn() {
		//...
		return matrix[0].length - 1;
	}
	
	
	
}
