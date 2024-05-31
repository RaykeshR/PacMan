package PacManpackage;

import javax.swing.JPanel; 
import java.awt.Dimension; 
import java.awt.Graphics; 
import java.awt.Color; 

public class MatrixPanel extends JPanel { 
    private int[][] matrix; 
    private final int size = 10;  // taille de chaque carré 

    public MatrixPanel(Plateau plateau) {
        this.matrix = plateau.getPlateauBinaire(); 
        int width = matrix[0].length * size; 
        int height = matrix.length * size; 
        setPreferredSize(new Dimension(width, height)); 
    } 

    @Override 
    protected void paintComponent(Graphics g) { 
        super.paintComponent(g); 
        for (int i = 0; i < matrix.length; i++) { 
            for (int j = 0; j < matrix[i].length; j++) { 
                if (matrix[i][j] == 0) { 
                    g.setColor(Color.BLACK); 
                } else if (matrix[i][j] == 1) { 
                    g.setColor(Color.BLUE); 
                } 
                g.fillRect(j * size, i * size, size, size); 
            } 
        } 
    }  
}
