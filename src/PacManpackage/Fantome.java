package PacManpackage;

import javax.swing.JLabel;

public class Fantome {

	JLabel label;
	Sens S;
	//position : en coordonné 
	double x,y;
	// Position dans le Plateau (Matrice)
	double Px,Py;
	public Fantome(JLabel LeLabelDuFantome) {
		this.label = LeLabelDuFantome;
	}
	
	public Fantome(JLabel LeLabelDuFantome ,double x,double y,double Px,double Py) {
		this.label = LeLabelDuFantome;
		this.x=x;this.y=y;
		this.Px=Px;this.Py=Py;
	}
	
	void Goto(double x,double y) {
		// TODO ...
		//label
	}
	
	
	
	
}
