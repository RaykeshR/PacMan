package PacManpackage;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class RCanvas extends JComponent {
	public RCanvas() {
		
	}
	
	protected void dessinerLesComposant(Graphics g) {
		Graphics2D r2d = (Graphics2D) g;
		Rectangle2D.Double r = new Rectangle2D.Double(0,0,500,500);
		r2d.setColor(new Color(255,0,0));
		r2d.fill(r);
	}
}
