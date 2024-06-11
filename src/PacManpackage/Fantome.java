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

	//attributs
	Sens S = Sens.UP;
	int x,y; //position 
	int Px,Py; 
	private int taille; //variable pour gerer la taille optionnel	
	private JLabel label;
	private int x2, y2,dx,dy; 
	private int[][] matrix;
	private final int SIZE = 10; // La taille de chaque case dans la matrice
	private final int offsetX = 110;
	private final int offsetY = 105;
	private String direction = "UP"; // correspond à la direction actuelle
	private String previousDirection = "" ; //correspond à la direction  precedente
	private Timer timer; //pour gerer le déplacement continu
	private List<Integer> casesAccessibles;
	
	//constructeurs
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
        icon = resizeImageIcon(icon, 10, 10); // On redimensionne à 10x10 pixels l'image
        label = new JLabel(icon);
       
		// position initiale de Paman dans la matrice
        x2 = 13; // colonne
        y2 = 14; // ligne
        Px=x2;Py=y2;
        x=x2 * SIZE;
        y=y2 * SIZE;
        label.setBounds(x2 * SIZE + offsetX, y2 * SIZE + offsetY, icon.getIconWidth(), icon.getIconHeight());
        pane.add(label, Integer.valueOf(3));  // pour ajouter Pacman au pane
        
        timer = new Timer(200, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                move();//appel de la methode move() qui correspond au changement de direction
            }
        });
        timer.start(); // cela permet de démarrer le timer
    }
//methodes
	//reecriture de la methode resizeImageIcon qui redimensionne une image et est presente dans la classe point
	private ImageIcon resizeImageIcon(ImageIcon icon, int width, int height) {
	        Image img = icon.getImage(); //nouvel icon
	        Image resizedImage = img.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
	        return new ImageIcon(resizedImage);
	}
    public void setDirection(String direction) {
        this.direction = direction;
    }
	
	// switch case pour gerer le deplacement
	private void move() {
		direction = MouvementAuto();
		dx = 0;
    	dy = 0;
        switch (direction) {
            case "LEFT":
            	dx=-1; //change la valeur de dx
                moveLeft();// et appel la methode moveLeft
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

//methodes pour gerer la direction    
    public void moveLeft() {
	    //verifie si la case à gauche correspond à un 0 ou un 2
        if (x2 > 0 && casesAccessibles.contains(matrix[y2][x2 - 1])) {
            x2--;
		//verifie si la case correspond a un portail et si oui teleporte à un autre partail
        } else if (x2 == 0) {
            x2 = matrix[0].length - 1; // teleporte le plateau à droite
        }
        updatePosition();
    }

    public void moveRight() {
	    //verifie si la case à droite correspond à un 0 ou un 2
        if (x2 < matrix[0].length - 1 && casesAccessibles.contains(matrix[y2][x2 + 1])) {
            x2++;
        } else if (x2 == matrix[0].length - 1) {
            x2 = 0; // teleporte le plateau à droite
        }
        updatePosition();
    }

    public void moveUp() {
	    //verifie si la case en haut correspond à un 0 ou un 2
        if (y2 > 0 && casesAccessibles.contains(matrix[y2 - 1][x2])) {
            y2--;
            updatePosition();
        }
    }

    public void moveDown() {
	    //verifie si la case en bas correspond à un 0 ou un 2
        if (y2 < matrix.length - 1 && casesAccessibles.contains( matrix[y2 + 1][x2])) {
            y2++;
            updatePosition();
        }
    }
	//methode pour mettre à jour la direction precedente par la direction actuelle
	private void updatePosition() {
	    label.setBounds(x2 * SIZE + offsetX, y2 * SIZE + offsetY, label.getWidth(), label.getHeight());
//	    if( x2 >= matrix[0].length - 1 || x2 <= 0 || (matrix[y2][x2 + 1] == 1 || matrix[y2][x2 - 1] == 1) && dx!=0) {
//    		label.setBounds((x2) * SIZE + offsetX, (y2) * SIZE + offsetY, label.getWidth(), label.getHeight());

	}
	
	void AllerA(int x,int y) {
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
		        // pas de déplacement, on ne fait rien
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

	int[][] mur() {
		int[][] L = new int[][] {
			{0,0,0},
			{0,0,0},
			{0,0,0},
		};
		Plateau get = new Plateau(); 
		//int[][] P = Plateau.P_original; // On récupère le plateau
		int[][] G = get.getMat3(Px,Py); 
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
	
	String MouvementAuto() {
		int Decision = getRandomNumber(1,100); 
		int[][] M=mur(); 
		if( M[1+S.getDx()][1+S.getDy()]==0 && Decision >= 95 ) {
			//Si il n'y a pas de mur dans le sens courant on continue 
			//int n =10; // déplacement de 10 Case
			int n =SIZE; // déplacement de 10 Case
			AllerA(x+S.getDx()*n,y+S.getDy()*n); 
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
			    // Case disponible donc il y'aura mouvement
			    // Boucle infinie en cas de bug ou d'erreur juste une prevention
			    
			}else{
				// si c'est Bloquer pas de sens possible
				return "UP";
			}
			
		}
	}
	
	
	
	Sens NouveauSensChoisiAuHasard(int SensPossible,int[][] M) {
		Sens[] NouveauSens = new Sens[SensPossible]; // Contiendra les différents sens possible dans un futur proche mdrr
		int DecisionNouveauSens = getRandomNumber(0,SensPossible-1); 
		// Remplie NouveauSens
		int index=0; 
		if (M[0][1]==0) {
			// pour verifier si la case du haut est dispo
			NouveauSens[index] = Sens.UP; 
			index++; 
		}
		if (M[1][0]==0) {
	        // pour verifier si la case du bas est dispo
	        NouveauSens[index] = Sens.LEFT; 
	        index++; 
	    }
	    if (M[2][1]==0) {
	      // pour verifier si la case du haut est dispo
	        NouveauSens[index] = Sens.DOWN; 
	        index++; 
	    }
	    if (M[1][2]==0) {
	        // pour verifier si la case du haut est dispo
	        NouveauSens[index] = Sens.RIGHT; 
	        index++; 
	    }
	    // retourne la nouvelle direction choisi
	    return NouveauSens[DecisionNouveauSens];
	}
	

	public int getRandomNumber(int min, int max) {
	    return (int) ((Math.random() * (max+1 - min)) + min);
	  
	}
	
	public Sens getS() {
		return S;
	}
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getPx() {
		return Px;
	}

	public int getPy() {
		return Py;
	}

	public int getTaille() {
		return this.taille;
	}

	public void setS(Sens s) {
		S = s;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	public void setPx(int px) {
		Px = px;
	}

	public void setPy(int py) {
		Py = py;
	}
	public void setTaille(int taille) {
		this.taille = taille;
	}
	public int getX2() {
		return x2;
	}

	public int getY2() {
		return y2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}
	
	
	
	
}
