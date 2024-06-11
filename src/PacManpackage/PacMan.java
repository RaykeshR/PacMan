package PacManpackage;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import java.util.Timer;
import java.util.TimerTask;



public class PacMan extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private PacManCharacter pacman;
    private Fantome fantom;
    private GridBagConstraints gbc_1;
    private double timer=0;
    private int score=0;
    private Timer timerUpdate;
    private boolean flag=false;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                PacMan frame = new PacMan();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

	private void gameOver() {
        // Stop the timer / la c'est pour arreter le timer
    	// Nous c'est notre main (la loop en fond)
        timerUpdate.cancel();

        // Create a new JFrame / on refait une nouvelle fenetre
        JFrame gameOverFrame = new JFrame("Game Over");
        gameOverFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JLabel to display "Game Over"  / on refait une nouvelle fenetre avec le texte
        JLabel gameOverLabel = new JLabel("Game Over!", SwingConstants.CENTER);
        gameOverLabel.setFont(new Font("Arial", Font.BOLD, 36));

        gameOverFrame.getContentPane().setLayout(new GridBagLayout());

        // Add the gameOverLabel to the frame / ajout du label
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.gridheight = GridBagConstraints.REMAINDER;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;
        gameOverFrame.getContentPane().add(gameOverLabel, constraints);

        JLabel Temps0 = new JLabel("Temps : ", SwingConstants.CENTER);
        gameOverFrame.getContentPane().add( Temps0 );
        
        JLabel Temps = new JLabel(""+(  (double)Math.round(timer*100)/100   )+"s", SwingConstants.CENTER);
        gameOverFrame.getContentPane().add( Temps );
        
//        JLabel Temps2 = new JLabel("temps"+timer+"s", SwingConstants.CENTER);
//        gameOverFrame.getContentPane().add(Temps2);


        JLabel espace = new JLabel(" ", SwingConstants.CENTER);
        gameOverFrame.getContentPane().add( espace );
        
        JLabel Score0 = new JLabel("Score : ", SwingConstants.CENTER);
        gameOverFrame.getContentPane().add( Score0 );
        
        JLabel Score = new JLabel(""+score*10+"points", SwingConstants.CENTER);
        gameOverFrame.getContentPane().add( Score );
        
        // Set the window size and make it visible / ajout du label
        gameOverFrame.setSize(300, 200);
        gameOverFrame.setVisible(true);
        
        // Close the main game window / Fin
        this.dispose();
    }

    private void Victoire() {
    	//...
        // Stop the timer / la c'est pour arreter le timer
    	// Nous c'est notre main (la loop en fond)
        timerUpdate.cancel();

        // Create a new JFrame for the game over window / on refait une nouvelle fenetre
        JFrame gameOverFrame = new JFrame("Victoire");
        gameOverFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JLabel to display "Game Over"  / on refait une nouvelle fenetre avec le texte
        JLabel gameOverLabel = new JLabel("Victoire \nCONGRATULATIONS!", SwingConstants.CENTER);
        gameOverLabel.setFont(new Font("Arial", Font.BOLD, 10));

        gameOverFrame.getContentPane().setLayout(new GridBagLayout());

        // Add the gameOverLabel to the frame / ajout du label
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.gridheight = GridBagConstraints.REMAINDER;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;
        gameOverFrame.getContentPane().add(gameOverLabel, constraints);
        
        JLabel Temps0 = new JLabel("Temps : ", SwingConstants.CENTER);
        gameOverFrame.getContentPane().add( Temps0 );
        JLabel Temps = new JLabel(""+(  (double)Math.round(timer*100)/100   )+"s", SwingConstants.CENTER);
        gameOverFrame.getContentPane().add( Temps );
        JLabel espace = new JLabel(" ", SwingConstants.CENTER);
        gameOverFrame.getContentPane().add( espace );
        JLabel Score0 = new JLabel("Score : ", SwingConstants.CENTER);
        gameOverFrame.getContentPane().add( Score0 );
        JLabel Score = new JLabel(""+score*10+"points", SwingConstants.CENTER);
        gameOverFrame.getContentPane().add( Score );
        // Set the window size and make it visible / ajout du label
        gameOverFrame.setSize(300, 200);
        gameOverFrame.setVisible(true);
        
        // Close the main game window / Fin
        this.dispose();
    }public double getTimer() {return timer;}
    
    public PacMan() {
    	setTitle("PacMan");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Réduire la taille de la fenêtre en ajustant ces valeurs
        setBounds(100, 100, 750, 550); // Ajustez ces valeurs selon vos besoins

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(Color.BLACK);
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JLayeredPane layeredPane = new JLayeredPane();
        contentPane.add(layeredPane, BorderLayout.CENTER);

        // Ajustez les dimensions ici pour correspondre à la nouvelle taille de la fenêtre
        JLabel lblBackground = new JLabel(new ImageIcon(PacMan.class.getResource("/PacManpackage/MapV3.jpg")));
        lblBackground.setBounds(0, 0, 500, 500); // Adaptez ces dimensions
        layeredPane.add(lblBackground, Integer.valueOf(1));

        Plateau plateau = new Plateau();
        
        MatrixPanel matrixPanel = new MatrixPanel(plateau);
        matrixPanel.setBounds(109, 106, 500, 500); // Adaptez ces dimensions pour utiliser au maximum l'espace
        matrixPanel.setOpaque(false);
        layeredPane.add(matrixPanel, Integer.valueOf(2));
        
        int[][] matrix = plateau.getPlateauBinaire(); 
        
        pacman = new PacManCharacter(layeredPane, matrix);  
        fantom  = new Fantome(layeredPane, matrix);  
        //if(pacman.getX()==fantom.getX2() && pacman.getY()==fantom.getY2()) {System.exit(0);}
        
        JPanel controlPanel = new JPanel();
        controlPanel.setBackground(Color.BLACK);
        controlPanel.setPreferredSize(new Dimension(250, 500));
        contentPane.add(controlPanel, BorderLayout.EAST);

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setBackground(Color.BLACK);
        controlPanel.add(buttonPanel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JButton btnUp = new JButton("^");
        btnUp.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(  pacman.getY() > 0 && pacman.getElementMatrix(pacman.getY()-1,pacman.getX()) != 1) 
        		pacman.setDirection("UP");
        		fantom.setDirection("UP");
        	}
        });
        gbc.gridx = 1;
        gbc.gridy = 0;
        buttonPanel.add(btnUp, gbc);

        gbc = new GridBagConstraints(); // Reset or create new GridBagConstraints
        gbc.insets = new Insets(5, 5, 5, 5);
        JButton btnDown = new JButton("V");
        btnDown.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(  pacman.getY() < pacman.getMatrixLenghtMoinsUn() && pacman.getElementMatrix(pacman.getY()+1,pacman.getX()) != 1)
        		pacman.setDirection("DOWN");
        		fantom.setDirection("DOWN");
        	}
        });
        gbc.gridx = 1;
        gbc.gridy = 2;
        buttonPanel.add(btnDown, gbc);

        gbc = new GridBagConstraints(); // Reset or create new GridBagConstraints
        gbc.insets = new Insets(5, 5, 5, 5);
        JButton btnLeft = new JButton("<");
        btnLeft.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(  pacman.getX() > 0 && pacman.getElementMatrix(pacman.getY(),pacman.getX()-1) != 1) 
        		pacman.setDirection("LEFT");
        		fantom.setDirection("LEFT");
        	}
        });
        gbc.gridx = 0;
        gbc.gridy = 1;
        buttonPanel.add(btnLeft, gbc);

        gbc_1 = new GridBagConstraints(); // Reset or create new GridBagConstraints
        gbc_1.anchor = GridBagConstraints.EAST;
        gbc_1.insets = new Insets(5, 5, 5, 5);
        JButton btnRight = new JButton(">");
        btnRight.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(  pacman.getX() < pacman.getMatrix0LenghtMoinsUn() && pacman.getElementMatrix(pacman.getY(),pacman.getX()+1) != 1)
        		pacman.setDirection("RIGHT");
        		fantom.setDirection("RIGHT");
        	}
        });
        
        gbc_1.gridx = 2;
        gbc_1.gridy = 1;
        buttonPanel.add(btnRight, gbc_1);
        
     // Ajout des mappages de touches du clavier
        InputMap inputMap = contentPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = contentPane.getActionMap();

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "moveUp");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "moveDown");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "moveLeft");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "moveRight");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_Z, 0), "moveUp");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0), "moveDown");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0), "moveLeft");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0), "moveRight");
        //On a mis le ZQSD mais aussi les touche directionnel et les boutons.

        actionMap.put("moveUp", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(  pacman.getY() > 0 && pacman.getElementMatrix(pacman.getY()-1,pacman.getX()) != 1) {
            		pacman.setDirection("UP");
                }
                fantom.setDirection("UP");
            }
        });

        actionMap.put("moveDown", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(  pacman.getY() < pacman.getMatrixLenghtMoinsUn() && pacman.getElementMatrix(pacman.getY()+1,pacman.getX()) != 1) {
            		pacman.setDirection("DOWN");
            	}
                fantom.setDirection("DOWN");
            }
        });

        actionMap.put("moveLeft", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(  pacman.getX() > 0 && pacman.getElementMatrix(pacman.getY(),pacman.getX()-1) != 1) {
            		pacman.setDirection("LEFT");
                }
                fantom.setDirection("LEFT");
            }
        });

        actionMap.put("moveRight", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(  pacman.getX() < pacman.getMatrix0LenghtMoinsUn() && pacman.getElementMatrix(pacman.getY(),pacman.getX()+1) != 1) {
            		pacman.setDirection("RIGHT");
                }
                fantom.setDirection("RIGHT");
            }
        });


        JLabel lblScore = new JLabel("Score: "+score);
        lblScore.setForeground(Color.WHITE);
        lblScore.setFont(new Font("Tahoma", Font.BOLD, 14));

        
        JLabel lblTime = new JLabel("Time: "+timer);
        lblTime.setForeground(Color.WHITE);
        lblTime.setFont(new Font("Tahoma", Font.BOLD, 14));

        
        
        timerUpdate = new Timer();
        timerUpdate.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                timer += 0.1; // Update timer value every 0.1 seconds / pour notre compteur de temps 
                lblTime.setText("Time: " + String.format("%.1f", timer));
                int pacmanX=pacman.getX();
                int pacmanY=pacman.getY();
//                lblScore.setText("Score: " + String.format("%d", score) + " | " + pacmanX + ", " + pacmanY +"|"+matrix[0].length+"|"+matrix.length);
                lblScore.setText("Score: " + String.format("%d", score*10));
                if(pacman.getX()==fantom.getX2() && pacman.getY()==fantom.getY2()) {
//                	System.exit(0);
                	// Game over!
                    gameOver();
                    
                }
                
                else if (!flag && matrix[pacmanY][pacmanX] == 2) {
                	flag=true;
                	matrix[pacmanY][pacmanX] = 0 ;
                	Point p = matrixPanel.getPoint(pacmanX, pacmanY);
                	matrixPanel.removePoint(p);
                	score++;
                	flag=false;
                	
                }
                if(score>=100) {
                	// Le Score vaut 100*10 Donc 1OOO point Donc victoire.
                	Victoire();
                }
            }
        }, 100, 100); // Update every 100 milliseconds / la boucle de fond de notre code
        

        
        JPanel statusPanel = new JPanel(new GridLayout(2, 1)); // Status labels below buttons
        statusPanel.setBackground(Color.BLACK);
        statusPanel.add(lblScore);
        statusPanel.add(lblTime);
        controlPanel.add(statusPanel, BorderLayout.SOUTH);
        
        
        
    }
}
