package PacManpackage;

import javax.swing.JLabel;

public class Fantome {

	JLabel label;
	Sens S;
	//position : en coordonné 
	int x,y;
	// Position dans le Plateau (Matrice)
	double Px,Py;
	//taille Optionnel : 
	private int taille;
	public Fantome(JLabel LeLabelDuFantome) {
		this.label = LeLabelDuFantome;
	}
	
	public Fantome(JLabel LeLabelDuFantome ,int x,int y,double Px,double Py) {
		this.label = LeLabelDuFantome;
		this.x=x;this.y=y;
		this.Px=Px;this.Py=Py;
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
		//int[][] P = Plateau.P_original; // On récupère le plateau
		//...
		return L;
	}
	
	/**
	 * @Fonctionnement : Définie le mouvement aléatoire des fantômes 
	 */
	void MouvementAuto() {
		int Decision = getRandomNumber(1,100); // [ 1 , 100 ] 
		int[][] M=mur();
		if( M[1+S.getDx()][1+S.getDy()]==0 && Decision >= 95 ) {
			//Si il n'y a pas de mur dans le sens courant on continue (95% du temps)
			int n =1; // déplacement d'une Case
			Goto(x+S.getDx()*n,y+S.getDy()*n);
		}else {
			// Choisi une direction parmi celle disponible.
			int SensPossible = (1-M[0][1]) + (1-M[1][0]) + (1-M[2][1]) + (1-M[1][2]);
			Sens[] NouveauSens = new Sens[SensPossible];
			if (SensPossible!=0) {
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
			    S = NouveauSens[DecisionNouveauSens];
			    
			    MouvementAuto(); 
			    // Case disponible donc mouvement
			    // Boucle infinie en cas de bug ou d'erreur ! ! !
			    
			}else{
				// Bloquer pas de sens possible
			}
			
		}
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
	public double getPx() {
		return Px;
	}

	/**
	 * @return the py
	 */
	public double getPy() {
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
	public void setPx(double px) {
		Px = px;
	}

	/**
	 * @param py the py to set
	 */
	public void setPy(double py) {
		Py = py;
	}

	/**
	 * @param taille the taille to set
	 */
	public void setTaille(int taille) {
		this.taille = taille;
	}
	
	
	
	
}
