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
    private GridBagConstraints grille_1;
    private double timer = 0;
    private int score = 0;
    private Timer timerUpdate;
    private boolean flag = false;

	//le main qui instancie l'objet PacMan qui est le jeu
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                PacMan frame = new PacMan();
                frame.setVisible(true);
            } 
	    catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

	//méthode gameOver() gère quand le pacman rentre en collision avec le fantome
    private void gameOver() {
	    //éteint le timer
        timerUpdate.cancel();
	    //nouvelle frame
        JFrame gameOverFrame = new JFrame("Game Over");
        gameOverFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    //nouveau label text
        JLabel gameOverLabel = new JLabel("Game Over!", SwingConstants.CENTER);
        gameOverLabel.setFont(new Font("Arial", Font.BOLD, 36));
        gameOverFrame.getContentPane().setLayout(new GridBagLayout());

	    //grille pour alligner les informations
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.gridheight = GridBagConstraints.REMAINDER;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;
        gameOverFrame.getContentPane().add(gameOverLabel, constraints);

	    //affichage du timer
        JLabel timeLabel = new JLabel("Temps : ", SwingConstants.CENTER);
        gameOverFrame.getContentPane().add(timeLabel);

	    //affichage de la valeur du timer
        JLabel timeValue = new JLabel(String.format("%.2fs", timer), SwingConstants.CENTER);
        gameOverFrame.getContentPane().add(timeValue);

	    //affichage d'un espace
        JLabel spaceLabel = new JLabel(" ", SwingConstants.CENTER);
        gameOverFrame.getContentPane().add(spaceLabel);

	    //affichage du mot score
        JLabel scoreLabel = new JLabel("Score : ", SwingConstants.CENTER);
        gameOverFrame.getContentPane().add(scoreLabel);

	    //affichage de la valeur de score
        JLabel scoreValue = new JLabel(score * 10 + " points", SwingConstants.CENTER);
        gameOverFrame.getContentPane().add(scoreValue);

        gameOverFrame.setSize(300, 200);
        gameOverFrame.setVisible(true);
        this.dispose();
    }

    private void Victoire() {
        timerUpdate.cancel();
        JFrame victoryFrame = new JFrame("Victoire");
        victoryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel victoryLabel = new JLabel("Victoire\nCONGRATULATIONS!", SwingConstants.CENTER);
        victoryLabel.setFont(new Font("Arial", Font.BOLD, 10));
        victoryFrame.getContentPane().setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.gridheight = GridBagConstraints.REMAINDER;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;
        victoryFrame.getContentPane().add(victoryLabel, constraints);

	    //mêmes objectif que dans gameOver()
        JLabel timeLabel = new JLabel("Temps : ", SwingConstants.CENTER);
        victoryFrame.getContentPane().add(timeLabel);

        JLabel timeValue = new JLabel(String.format("%.2fs", timer), SwingConstants.CENTER);
        victoryFrame.getContentPane().add(timeValue);

        JLabel spaceLabel = new JLabel(" ", SwingConstants.CENTER);
        victoryFrame.getContentPane().add(spaceLabel);

        JLabel scoreLabel = new JLabel("Score : ", SwingConstants.CENTER);
        victoryFrame.getContentPane().add(scoreLabel);

        JLabel scoreValue = new JLabel(score * 10 + " points", SwingConstants.CENTER);
        victoryFrame.getContentPane().add(scoreValue);

        victoryFrame.setSize(300, 200);
        victoryFrame.setVisible(true);
        this.dispose();
    }

	//getteur timer
    public double getTimer() {
        return timer;
    }

    
    public PacMan() {
        setTitle("PacMan");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 750, 550);

	    //nouveau panel pour la fenetre
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(Color.BLACK);
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JLayeredPane layeredPane = new JLayeredPane();
        contentPane.add(layeredPane, BorderLayout.CENTER);

        JLabel lblBackground = new JLabel(new ImageIcon(PacMan.class.getResource("/PacManpackage/MapV3.jpg")));
        lblBackground.setBounds(0, 0, 500, 500);
        layeredPane.add(lblBackground, Integer.valueOf(1));

	    //on affiche le plateau avec matrixpanel
        Plateau plateau = new Plateau();
        MatrixPanel matrixPanel = new MatrixPanel(plateau);
        matrixPanel.setBounds(109, 106, 500, 500);
        matrixPanel.setOpaque(false);
        layeredPane.add(matrixPanel, Integer.valueOf(2));
        
        int[][] matrix = plateau.getPlateauBinaire();

	    //on instancie le pacman et le fantom
        pacman = new PacManCharacter(layeredPane, matrix);  
        fantom = new Fantome(layeredPane, matrix);  
        if (pacman.getX() == fantom.getX2() && pacman.getY() == fantom.getY2()) {
            System.exit(0);
        }

	    //fenetre de controle avec les boutons
        JPanel fenetreDeControle = new JPanel();
        fenetreDeControle.setBackground(Color.BLACK);
        fenetreDeControle.setPreferredSize(new Dimension(250, 500));
        contentPane.add(fenetreDeControle, BorderLayout.EAST);

        JPanel fenetreDeBoutons = new JPanel(new GridBagLayout());
        fenetreDeBoutons.setBackground(Color.BLACK);
        fenetreDeControle.add(fenetreDeBoutons);

	    //la grille pour aligner les boutons
        GridBagConstraints grille = new GridBagConstraints();
        grille.insets = new Insets(5, 5, 5, 5);

	    //le bouton du haut
        JButton boutonUP = new JButton("^");
        boutonUP.addActionListener(e -> {
            if (pacman.getY() > 0 && pacman.getElementMatrix(pacman.getY() - 1, pacman.getX()) != 1) {
                pacman.setDirection("UP");
            }
            fantom.setDirection("UP");
        });
        grille.gridx = 1;
        grille.gridy = 0;
        fenetreDeBoutons.add(boutonUP, grille);

	    //le bouton du bas
        grille = new GridBagConstraints();
        grille.insets = new Insets(5, 5, 5, 5);
        JButton boutonDOWN = new JButton("V");
        boutonDOWN.addActionListener(e -> {
            if (pacman.getY() < pacman.getMatrixLenghtMoinsUn() && pacman.getElementMatrix(pacman.getY() + 1, pacman.getX()) != 1) {
                pacman.setDirection("DOWN");
            }
            fantom.setDirection("DOWN");
        });
        grille.gridx = 1;
        grille.gridy = 2;
        fenetreDeBoutons.add(boutonDOWN, grille);

	    //le bouton de gauche
        grille = new GridBagConstraints();
        grille.insets = new Insets(5, 5, 5, 5);
        JButton boutonLEFT = new JButton("<");
        boutonLEFT.addActionListener(e -> {
            if (pacman.getX() > 0 && pacman.getElementMatrix(pacman.getY(), pacman.getX() - 1) != 1) {
                pacman.setDirection("LEFT");
            }
            fantom.setDirection("LEFT");
        });
        grille.gridx = 0;
        grille.gridy = 1;
        fenetreDeBoutons.add(boutonLEFT, grille);

	    //le bouton de droite
        grille_1 = new GridBagConstraints();
        grille_1.anchor = GridBagConstraints.EAST;
        grille_1.insets = new Insets(5, 5, 5, 5);
        JButton boutonRIGHT = new JButton(">");
        boutonRIGHT.addActionListener(e -> {
            if (pacman.getX() < pacman.getMatrix0LenghtMoinsUn() && pacman.getElementMatrix(pacman.getY(), pacman.getX() + 1) != 1) {
                pacman.setDirection("RIGHT");
            }
            fantom.setDirection("RIGHT");
        });
        grille_1.gridx = 2;
        grille_1.gridy = 1;
        fenetreDeBoutons.add(boutonRIGHT, grille_1);

	    //objets pour keybind
        InputMap inputMap = contentPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = contentPane.getActionMap();

	    //on récupère les str pour les boutons du clavier
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "moveUp");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "moveDown");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "moveLeft");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "moveRight");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_Z, 0), "moveUp");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0), "moveDown");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0), "moveLeft");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0), "moveRight");

	    //meme manière que les boutons du haut
        actionMap.put("moveUp", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pacman.getY() > 0 && pacman.getElementMatrix(pacman.getY() - 1, pacman.getX()) != 1) {
                    pacman.setDirection("UP");
                }
                fantom.setDirection("UP");
            }
        });

        actionMap.put("moveDown", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pacman.getY() < pacman.getMatrixLenghtMoinsUn() && pacman.getElementMatrix(pacman.getY() + 1, pacman.getX()) != 1) {
                    pacman.setDirection("DOWN");
                }
                fantom.setDirection("DOWN");
            }
        });

        actionMap.put("moveLeft", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pacman.getX() > 0 && pacman.getElementMatrix(pacman.getY(), pacman.getX() - 1) != 1) {
                    pacman.setDirection("LEFT");
                }
                fantom.setDirection("LEFT");
            }
        });

        actionMap.put("moveRight", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pacman.getX() < pacman.getMatrix0LenghtMoinsUn() && pacman.getElementMatrix(pacman.getY(), pacman.getX() + 1) != 1) {
                    pacman.setDirection("RIGHT");
                }
                fantom.setDirection("RIGHT");
            }
        });

        JLabel labelScore = new JLabel("Score: " + score);
        labelScore.setForeground(Color.WHITE);
        labelScore.setFont(new Font("Tahoma", Font.BOLD, 14));

        JLabel labelTemps = new JLabel("Time: " + timer);
        labelTemps.setForeground(Color.WHITE);
        labelTemps.setFont(new Font("Tahoma", Font.BOLD, 14));

        timerUpdate = new Timer();
        timerUpdate.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                timer += 0.1;
                labelTemps.setText("Time: " + String.format("%.1f", timer));
                labelScore.setText("Score: " + String.format("%d", score * 10));
                int pacmanX = pacman.getX();
                int pacmanY = pacman.getY();

                if (pacman.getX() == fantom.getX2() && pacman.getY() == fantom.getY2()) {
                    gameOver();
                } 
		else if (!flag && matrix[pacmanY][pacmanX] == 2) {
                    flag = true;
                    matrix[pacmanY][pacmanX] = 0;
                    Point p = matrixPanel.getPoint(pacmanX, pacmanY);
                    matrixPanel.removePoint(p);
                    score++;
                    flag = false;
                }
                if (score >= 100) {
                    Victoire();
                }
            }
        }, 100, 100);

        JPanel statusPanel = new JPanel(new GridLayout(2, 1)); // Status labels below buttons
        statusPanel.setBackground(Color.BLACK);
        statusPanel.add(labelScore);
        statusPanel.add(labelTemps);
        fenetreDeControle.add(statusPanel, BorderLayout.SOUTH);
    }

}
