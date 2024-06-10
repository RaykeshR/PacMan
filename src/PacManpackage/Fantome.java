package PacManpackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.Timer;

//import javax.swing.JLabel;
//import javax.swing.JLayeredPane;
//import javax.swing.ImageIcon;
import java.awt.Image;
//import javax.swing.Timer;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

public class Fantome {

	//JLabel label;
	Sens S = Sens.UP;
	//position : en coordonné 
	int x,y;
	// Position dans le Plateau (Matrice)
	int Px,Py;
	//taille Optionnel : 
	private int taille;
	
	
	private JLabel label;
    private int x2, y2,dx,dy;
    private int[][] matrix;
    private final int SIZE = 10; // La taille de chaque case dans la matrice
    private final int offsetX = 110;
    private final int offsetY = 105;
    private String direction = "UP"; // Direction actuelle
    private String previousDirection = "" ;
    private Timer timer; // Timer pour le déplacement continu
    private List<Integer> casesAccessibles;
	
	
	public Fantome(JLabel LeLabelDuFantome) {
		this.label = LeLabelDuFantome;
	}
	
	public Fantome(JLabel LeLabelDuFantome ,int x,int y,int Px,int Py) {
		this.label = LeLabelDuFantome;
		this.x=x;this.y=y;
		this.Px=Px;this.Py=Py;
	}
	
	public Fantome(JLayeredPane pane, int[][] matrix) {
        this.matrix = matrix;
        casesAccessibles = Arrays.asList(0, 2);
        ImageIcon icon = new ImageIcon(this.getClass().getResource("/PacManpackage/fantome1.png"));
        icon = resizeImageIcon(icon, 10, 10); // Redimensionner à 50x50 pixels, ajustez selon vos besoins
        label = new JLabel(icon);
        // Position initiale de Pac-Man dans la matrice
        x2 = 13; // colonne
        y2 = 14; // ligne
        Px=x2;Py=y2;
        x=x2 * SIZE;
        y=y2 * SIZE;
        label.setBounds(x2 * SIZE + offsetX, y2 * SIZE + offsetY, icon.getIconWidth(), icon.getIconHeight());
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
		direction = MouvementAuto();
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
		updatePosition();
		
	}
//    public void moveLeft() {
//        if (x2 > 0 && matrix[y2][x2 - 1] == 0) {
//            x2--;
//        } else if (x2 == 0) {
//            x2 = matrix[0].length - 1; // Réapparaître à droite
//        }
//        updatePosition();
//    }
//
//    public void moveRight() {
//        if (x2 < matrix[0].length - 1 && matrix[y2][x2 + 1] == 0) {
//            x2++;
//        } else if (x2 == matrix[0].length - 1) {
//            x2 = 0; // Réapparaître à gauche
//        }
//        updatePosition();
//    }
//
//    public void moveUp() {
//        if (y2 > 0 && matrix[y2 - 1][x2] == 0) {
//            y2--;
//            updatePosition();
//        }
//    }
//
//    public void moveDown() {
//        if (y2 < matrix.length - 1 && matrix[y2 + 1][x2] == 0) {
//            y2++;
//            updatePosition();
//        }
//    }
    
    public void moveLeft() {
        if (x2 > 0 && casesAccessibles.contains(matrix[y2][x2 - 1])) {
            x2--;
        } else if (x2 == 0) {
            x2 = matrix[0].length - 1; // Réapparaître à droite
        }
        updatePosition();
    }

    public void moveRight() {
        if (x2 < matrix[0].length - 1 && casesAccessibles.contains(matrix[y2][x2 + 1])) {
            x2++;
        } else if (x2 == matrix[0].length - 1) {
            x2 = 0; // Réapparaître à gauche
        }
        updatePosition();
    }

    public void moveUp() {
        if (y2 > 0 && casesAccessibles.contains(matrix[y2 - 1][x2])) {
            y2--;
            updatePosition();
        }
    }

    public void moveDown() {
        if (y2 < matrix.length - 1 && casesAccessibles.contains( matrix[y2 + 1][x2])) {
            y2++;
            updatePosition();
        }
    }
	private void updatePosition() {
	    label.setBounds(x2 * SIZE + offsetX, y2 * SIZE + offsetY, label.getWidth(), label.getHeight());
//	    if( x2 >= matrix[0].length - 1 || x2 <= 0 || (matrix[y2][x2 + 1] == 1 || matrix[y2][x2 - 1] == 1) && dx!=0) {
//    		label.setBounds((x2) * SIZE + offsetX, (y2) * SIZE + offsetY, label.getWidth(), label.getHeight());
//    	}
//    	else {
//	    	int newX = (x2-dx) * SIZE + offsetX;
//	        int newY = (y2-dy) * SIZE + offsetY;
//	
//	        // Create a timer to update the position with a delay
//	        Timer updateTimer = new Timer(10, new ActionListener() {
//	            int i = 0;
//	            public void actionPerformed(ActionEvent e) {
//	                label.setBounds(newX + dx * i, newY + dy * i, label.getWidth(), label.getHeight());
//	                i++;
//	
//	                // Stop the timer when the animation is complete
//	                if (i >= SIZE) {
//	                    ((Timer) e.getSource()).stop();
//	                }
//	            }
//	        });
//	        updateTimer.start();
//        }
	}
	
	
	
	/**
	 * @Fonctionnement : va à une position x,y 
	 * Avec le label
	 * @param x
	 * @param y
	 */
	void Goto(int x,int y) {
		// TODO ...
		//label
		int dx=(this.x-x);
		int dy=(this.y-y);
//		if((dx)%10!=0 || (dy)%10!=0) {
//			System.out.println("erreur");
//		}else {
//			if(((dx)!=10 && (dx)!=-10) || ((dy)!=10 && (dy)!=-10)) {
//				System.out.println("erreur 2");
//			}// else : dx==10 ou -10 et dy=10 ou -10
//			this.x=x;this.y=y;
//			this.Px+=dx/10; // (this.x-x)=dx
//			this.Py+=dy/10;
//			x2=Px;
//			y2=Py;
//			updatePosition();
//		}
		if ((dx) % 10 != 0 || (dy) % 10 != 0) {
		    System.out.println("erreur");
		} else {
		    if (dx == 0 && dy == 0) {
		        // Pas de déplacement, on ne fait rien
		    	 System.out.println("erreur3");
		    } else if (((dx) != 10 && (dx) != -10) || ((dy) != 10 && (dy) != -10)) {
		        //System.out.println("erreur 2");
		    } else {
		        this.x = x;
		        this.y = y;
		        this.Px += dx / 10; // (this.x-x)=dx
		        this.Py += dy / 10;
		        x2 = Px;
		        y2 = Py;
		        updatePosition();
		    }
		}
		
	}

	/**
	 * @Fonctionnement : Verifie la présence de mur dans le Plateau 
	 * @return Une matrice de 3 par 3 indiquant la position des mur alentoure du labyrinte
	 * 1 indique la présence d'un mur et 0 l'absence d'un mur . 
	 * Finalement c'est dans Plateau
	 */ 
	int[][] mur() {
		int[][] L = new int[][] {
			{0,0,0},
			{0,0,0},
			{0,0,0},
		};
		Plateau get = new Plateau(); // TODO changé aux plateaux Réél ! ! !
		//int[][] P = Plateau.P_original; // On récupère le plateau
		int[][] G = get.getMat3(Px,Py); // TODO changé aux plateaux Réél ! ! !
		//On récupère la matrice 3x3 des case alentoure
		// Petit Rappel : 
		// 1 les mur | 9 | 8 | 10 | 7 un fantome | 
		// O les Vides | 3 les points |  4 les Gros Bonus | 5 Fruit (Cerises : 100 point|fraise : 300 point|? : 500 point|Pomme : 700 point|Fruit du Dragon : 1000 point|? : 2000 point|? : 3000 point|Clés : 5000 point|)
		// 2 les Portail
		// 6 PacMan
		//...
		
	    // On parcourt la matrice 3x3
	    for (int i = 0; i < 3; i++) {
	        for (int j = 0; j < 3; j++) {
	            if (G[i][j] == 1 || G[i][j] == 7 || G[i][j] == 8 || G[i][j] == 9 || G[i][j] == 10) { // Si c'est un mur
	                L[i][j] = 1; // On met 1 dans la matrice de retour
	            } else {
	                L[i][j] = 0; // Sinon on met 0
	            }
	        }
	    }

		
		return L;
	}
	
	/**
	 * @Fonctionnement : Définie le mouvement aléatoire des fantômes 
	 */
	String MouvementAuto() {
		int Decision = getRandomNumber(1,100); // [ 1 , 100 ] 
		int[][] M=mur(); 
		if( M[1+S.getDx()][1+S.getDy()]==0 && Decision >= 95 ) {
			//Si il n'y a pas de mur dans le sens courant on continue (95% du temps)
			//int n =10; // déplacement de 10 Case
			int n =SIZE; // déplacement de 10 Case
			Goto(x+S.getDx()*n,y+S.getDy()*n); 
//			x+=S.getDx();
//			y+=S.getDy();
			switch (S) {
	            case UP:
	                return "UP";
	            case DOWN:
	                return "DOWN";
	            case LEFT:
	                return "LEFT";
	            case RIGHT:
	                return "RIGHT";
			default:
				return "UP";
	        }
		}else {
			// Choisi une direction parmi celle disponible.
			int SensPossible = (1-M[0][1]) + (1-M[1][0]) + (1-M[2][1]) + (1-M[1][2]); // Le nombre de sens possible
			if (SensPossible!=0) {
			    S = NouveauSensChoisiAuHasard(SensPossible,M); 
			    
			    return MouvementAuto(); 
			    // Case disponible donc mouvement
			    // Boucle infinie en cas de bug ou d'erreur ! ! !
			    
			}else{
				// Bloquer pas de sens possible
				return "UP";
			}
			
		}
	}
	
	
	
	Sens NouveauSensChoisiAuHasard(int SensPossible,int[][] M) {
		Sens[] NouveauSens = new Sens[SensPossible]; // Contiendra les différents sens possible
		int DecisionNouveauSens = getRandomNumber(0,SensPossible-1); // [ 0 , SensPossible [ 
		// Remplir NouveauSens
		int index=0; 
		if (M[0][1]==0) {
			// Case du haut disponible
			NouveauSens[index] = Sens.UP; 
			index++; 
		}
		if (M[1][0]==0) {
	        // Case de la gauche disponible
	        NouveauSens[index] = Sens.LEFT; 
	        index++; 
	    }
	    if (M[2][1]==0) {
	        // Case du bas disponible
	        NouveauSens[index] = Sens.DOWN; 
	        index++; 
	    }
	    if (M[1][2]==0) {
	        // Case de la droite disponible
	        NouveauSens[index] = Sens.RIGHT; 
	        index++; 
	    }
	    // Nouvelle direction choisi
	    return NouveauSens[DecisionNouveauSens];
	}
	
	/**
	 * @Fonctionnement : Définie un randint aléatoire entre  [min,max] <===
	 * @param min
	 * @param max
	 * @return random int between [ min , max ]
	 */
	public int getRandomNumber(int min, int max) {
	    return (int) ((Math.random() * (max+1 - min)) + min);
	    /*
	     * random  											[0,1[
	     * random * (max+1 - min)  							[0,max+1-min[
	     * ((Math.random() * (max - min)) + min)  			[min,max+1[
	     * (int) ((Math.random() * (max+1 - min)) + min)  	[min,max]
	     */
	}
	
	
	
	
	
	
	/*
	 *       ----------------------------------------------------     GETTER et SETTER  :           -------------------------------------------------------------------          
	 */
	
	
	
	
	/**
	 * @return the s
	 */
	public Sens getS() {
		return S;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @return the px
	 */
	public int getPx() {
		return Px;
	}

	/**
	 * @return the py
	 */
	public int getPy() {
		return Py;
	}

	/**
	 * @return the taille
	 */
	public int getTaille() {
		return this.taille;
	}

	/**
	 * @param s the s to set
	 */
	public void setS(Sens s) {
		S = s;
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

	/**
	 * @param px the px to set
	 */
	public void setPx(int px) {
		Px = px;
	}

	/**
	 * @param py the py to set
	 */
	public void setPy(int py) {
		Py = py;
	}

	/**
	 * @param taille the taille to set
	 */
	public void setTaille(int taille) {
		this.taille = taille;
	}

	/**
	 * @return the x2
	 */
	public int getX2() {
		return x2;
	}

	/**
	 * @return the y2
	 */
	public int getY2() {
		return y2;
	}

	/**
	 * @param x2 the x2 to set
	 */
	public void setX2(int x2) {
		this.x2 = x2;
	}

	/**
	 * @param y2 the y2 to set
	 */
	public void setY2(int y2) {
		this.y2 = y2;
	}
	
	
	
	
}
