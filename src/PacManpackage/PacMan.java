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
    private Timer timerUpdate;

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
        if(pacman.getX()==fantom.getX2() && pacman.getY()==fantom.getY2()) {System.exit(0);}
        
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

        actionMap.put("moveUp", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(  pacman.getY() > 0 && pacman.getElementMatrix(pacman.getY()-1,pacman.getX()) == 0) {
            		pacman.setDirection("UP");
                }
                fantom.setDirection("UP");
            }
        });

        actionMap.put("moveDown", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(  pacman.getY() < pacman.getMatrixLenghtMoinsUn() && pacman.getElementMatrix(pacman.getY()+1,pacman.getX()) == 0) {
            		pacman.setDirection("DOWN");
            	}
                fantom.setDirection("DOWN");
            }
        });

        actionMap.put("moveLeft", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(  pacman.getX() > 0 && pacman.getElementMatrix(pacman.getY(),pacman.getX()-1) == 0) {
            		pacman.setDirection("LEFT");
                }
                fantom.setDirection("LEFT");
            }
        });

        actionMap.put("moveRight", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(  pacman.getX() < pacman.getMatrix0LenghtMoinsUn() && pacman.getElementMatrix(pacman.getY(),pacman.getX()+1) == 0) {
            		pacman.setDirection("RIGHT");
                }
                fantom.setDirection("RIGHT");
            }
        });


        JLabel lblScore = new JLabel("Score: 0");
        lblScore.setForeground(Color.WHITE);
        lblScore.setFont(new Font("Tahoma", Font.BOLD, 14));

        
        JLabel lblTime = new JLabel("Time: "+timer);
        lblTime.setForeground(Color.WHITE);
        lblTime.setFont(new Font("Tahoma", Font.BOLD, 14));

        
        
        timerUpdate = new Timer();
        timerUpdate.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                timer += 0.1; // Update timer value every 0.1 seconds
                lblTime.setText("Time: " + String.format("%.1f", timer));
                if(pacman.getX()==fantom.getX2() && pacman.getY()==fantom.getY2()) {
                	System.exit(0);
                }
            }
        }, 100, 100); // Update every 100 milliseconds
        

        
        JPanel statusPanel = new JPanel(new GridLayout(2, 1)); // Status labels below buttons
        statusPanel.setBackground(Color.BLACK);
        statusPanel.add(lblScore);
        statusPanel.add(lblTime);
        controlPanel.add(statusPanel, BorderLayout.SOUTH);
    }
}
