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
	
	void Goto(double x,double y) {
		// TODO ...
		//label
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
