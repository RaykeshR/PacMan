/**
 * 
 */
package PacManpackage;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 */
class PacManTest {

	PacManCharacter pacman;
	Fantome fantom;
	MatrixPanel matrixPanel;
	JLayeredPane layeredPane;
	Plateau plateau;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		layeredPane = new JLayeredPane();
		plateau = new Plateau();
        
        matrixPanel = new MatrixPanel(plateau);
        matrixPanel.setBounds(109, 106, 500, 500); // Adaptez ces dimensions pour utiliser au maximum l'espace
        matrixPanel.setOpaque(false);
        
        int[][] matrix = plateau.getPlateauBinaire(); 
        
        pacman = new PacManCharacter(layeredPane, matrix);  
        fantom  = new Fantome(layeredPane, matrix);  
	}

	@Test
	void test() {
		int x=14;
		Assertions.assertEquals(x, pacman.getX(),"error in pacman : x");
		int y=17;
		Assertions.assertEquals(y, pacman.getY(),"error in pacman : y");
		x=13;
		Assertions.assertEquals(x, fantom.getX2(),"error in fantom : x");
		y=14;
		Assertions.assertEquals(y, fantom.getY2(),"error in fantom : y");        
		PacMan p = new PacMan();
		p.setVisible(true);
		Assertions.assertNotEquals(0.0, p.getTimer());
	}
	@Test
	void test2() {
		for(int i =0;i<50;i++) {
			int A = fantom.getRandomNumber(5,10);
			Assertions.assertTrue(A>=5 , "getRandomNumber");
			Assertions.assertTrue(A<=10, "getRandomNumber");
			Assertions.assertFalse(A<5 , "getRandomNumber");
			Assertions.assertFalse(A>10, "getRandomNumber");
		}
	}
	@Test
	void test3() {
		PacMan p = new PacMan();
		p.setVisible(true);
		p.main(null);
		//TODO
	}
	
	
	
}
