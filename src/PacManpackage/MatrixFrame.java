package PacManpackage;

import javax.swing.JFrame; 
import javax.swing.SwingUtilities; 

public class MatrixFrame { 
    public static void main(String[] args) { 
        SwingUtilities.invokeLater(() -> { 
            JFrame frame = new JFrame("Matrix Display"); 
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

            // Nous creons une instance de plateau 
            Plateau plateau = new Plateau(); 

            // Nous utilisons  l'instance creer  au dessus pour creer le panel
            MatrixPanel panel = new MatrixPanel(plateau); 
            frame.add(panel); 
            frame.pack(); 
            frame.setLocationRelativeTo(null); 
            frame.setVisible(true); 
        }); 
    } 
} 
