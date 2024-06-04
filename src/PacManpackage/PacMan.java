package PacManpackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.Button;
import java.awt.Label;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;
import javax.swing.JEditorPane;
import javax.swing.ImageIcon;
import java.awt.Canvas;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.SwingConstants;

public class PacMan extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	int score=0;
	int temps=0;
	JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PacMan frame = new PacMan();
					frame.setVisible(true);
					frame.augmenterleScore();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	public void augmenterleScore() {
		score+=1;
		lblNewLabel.setText("   Score : " + score);
	}

	
	/**
	 * Create the frame.
	 */
	public PacMan() {
		
//		int score=0;
//		int temps=0;
		
		

		setTitle("PacMan");
		setOpacity(0.5f);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 790, 441);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		RCanvas R = new RCanvas();
		R.setBounds(0, 0, 0, 0);
		R.setBackground(Color.WHITE);
		R.setForeground(new Color(255, 0, 0));
		//add(R);
		

		setContentPane(contentPane);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setForeground(new Color(192, 192, 192));
		contentPane_1.setBackground(new Color(0, 0, 0));
		contentPane_1.setToolTipText("");
		contentPane_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		
		JLabel lblNewLabel_1 = new JLabel("PACMAN");
		lblNewLabel_1.setBounds(184, -2, 101, 33);
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 23));
		lblNewLabel_1.setForeground(new Color(255, 255, 0));
		
		JLabel lblNewLabel_2 = new JLabel("New label De La Carte");
		lblNewLabel_2.setBounds(13, 42, 565, 450);
		lblNewLabel_2.setIcon(new ImageIcon(PacMan.class.getResource("/PacManpackage/MapV3.jpg")));
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(841, 3, 146, 14);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(584, 260, 49, 14);
		
		JPanel contentPane_1_1 = new JPanel();
		contentPane_1_1.setForeground(new Color(192, 192, 192));
		contentPane_1_1.setBackground(new Color(0, 0, 0));
		contentPane_1_1.setToolTipText("");
		contentPane_1_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		
		

		
		// Les Bouttons  (JButton) : 
		
		JButton btnNewButton_Q = new JButton("<");
		btnNewButton_Q.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getExtendedKeyCode()==KeyEvent.VK_LEFT || e.getExtendedKeyCode()==KeyEvent.VK_Q) {
					//TODO (Raykesh nous dit que le bouton Gauche est appuier) Clavier !
					//TODO
					augmenterleScore();
				}
			}
		});
		btnNewButton_Q.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println("Button clicked!");
				//TODO (Raykesh nous dit que le bouton Gauche est appuier)
				augmenterleScore();
			}
		});
		
		JButton btnNewButton_S = new JButton("V");
		btnNewButton_S.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getExtendedKeyCode()==KeyEvent.VK_DOWN || e.getExtendedKeyCode()==KeyEvent.VK_S) {
					//TODO (Raykesh nous dit que le bouton Bas est appuier) Clavier !
					//TODO
					augmenterleScore();
				}
			}
		});
		btnNewButton_S.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO (Raykesh nous dit que le bouton Bas est appuier)
				augmenterleScore();
			}
		});
		
		JButton btnNewButton_D = new JButton(">");
		btnNewButton_D.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getExtendedKeyCode()==KeyEvent.VK_RIGHT || e.getExtendedKeyCode()==KeyEvent.VK_D) {
					//TODO (Raykesh nous dit que le bouton Droite est appuier) Clavier !
					//TODO
					augmenterleScore();
				}
			}
		});
		btnNewButton_D.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO (Raykesh nous dit que le bouton Droite est appuier)
				augmenterleScore();
			}
		});
		
		JButton btnNewButton_Z = new JButton("^");
		btnNewButton_Z.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getExtendedKeyCode()==KeyEvent.VK_UP || e.getExtendedKeyCode()==KeyEvent.VK_Z) {
					//TODO (Raykesh nous dit que le bouton Haut est appuier) Clavier !
					//TODO
					augmenterleScore();
				}
			}
		});
		btnNewButton_Z.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO (Raykesh nous dit que le bouton Haut est appuier)
				augmenterleScore();
			}
		});
		
		ImageIcon icon = new ImageIcon(PacMan.class.getResource("/PacManpackage/rond-jaune.png"));
		Image image = icon.getImage();
		Image newImage = image.getScaledInstance(15, 15, java.awt.Image.SCALE_SMOOTH); // Recadrer l'image 
		icon = new ImageIcon(newImage);
		//new ImageIcon(PacMan.class.getResource("/PacManpackage/rond-jaune.png"))
		
		JLabel lblNewLabel_4 = new JLabel("pacman");
		lblNewLabel_4.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_4.setIcon(icon );
		lblNewLabel_4.setBounds(233, 278, 15, 15);
		contentPane_1.add(lblNewLabel_4);
		
		ImageIcon originalIcon = new ImageIcon(PacMan.class.getResource("/PacManpackage/fantome1.png"));//new ImageIcon("/PacManPackage/rond-jaune.png");  // Charge l'image
		Image oimage = originalIcon.getImage();  // Transforme l'ImageIcon en Image
		Image resizedImage = oimage.getScaledInstance(15, 15,  Image.SCALE_SMOOTH);  // Redimensionne l'image
		//ImageIcon resizedIcon = new ImageIcon(resizedImage);  // Retransforme en ImageIcon
		originalIcon = new ImageIcon(resizedImage);
		//jLabel.setIcon(resizedIcon);  // Affecte l'icône redimensionnée au JLabel
		
		JLabel lblNewLabel_4_1 = new JLabel("fantom");
		//Fantome Clyde  = new Fantome(lblNewLabel_4_1); // Clyde Fantome orange. 
		Fantome Clyde  = new Fantome(lblNewLabel_4_1,215, 249,14,12); // Clyde Fantome orange. 		
		Clyde.setTaille(15);
		//System.out.println("test");
		lblNewLabel_4_1.setIcon(originalIcon);
		lblNewLabel_4_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_4_1.setBounds(215, 249, 15, 15);
		//lblNewLabel_4_1.setBounds(Clyde.getX(), Clyde.getY(), Clyde.getTaille(), Clyde.getTaille());
		lblNewLabel_4_1.setBounds(Clyde.getX(), Clyde.getY(), 15, 15);
		contentPane_1.add(lblNewLabel_4_1) ; 
		contentPane_1.add(lblNewLabel_4_1) ; 
		
		
		contentPane_1.add(R);
		

		
		JLabel lblNewLabelR = new JLabel("   Score : "+score);
		this.lblNewLabel = lblNewLabelR; // Add this line
		lblNewLabel.setText("   Score : " + score);
		lblNewLabel.setForeground(new Color(192, 192, 192));
		
		JLabel lblTemps = new JLabel("   Temps : "+temps);
		lblTemps.setForeground(Color.LIGHT_GRAY);
		GroupLayout gl_contentPane_1_1 = new GroupLayout(contentPane_1_1);
		gl_contentPane_1_1.setHorizontalGroup(
			gl_contentPane_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane_1_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton_Q)
					.addGap(18)
					.addGroup(gl_contentPane_1_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane_1_1.createSequentialGroup()
							.addComponent(btnNewButton_S, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnNewButton_D, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnNewButton_Z, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(93, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane_1_1.createSequentialGroup()
					.addContainerGap(73, Short.MAX_VALUE)
					.addGroup(gl_contentPane_1_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTemps, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
					.addGap(104))
		);
		gl_contentPane_1_1.setVerticalGroup(
			gl_contentPane_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane_1_1.createSequentialGroup()
					.addGap(19)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblTemps, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addGap(102)
					.addComponent(btnNewButton_Z)
					.addGap(18)
					.addGroup(gl_contentPane_1_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_Q)
						.addComponent(btnNewButton_S)
						.addComponent(btnNewButton_D))
					.addContainerGap(269, Short.MAX_VALUE))
		);
		contentPane_1_1.setLayout(gl_contentPane_1_1);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(contentPane_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(contentPane_1_1, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(contentPane_1, GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(contentPane_1_1, GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
					.addContainerGap())
		);
		contentPane_1.setLayout(null);
		contentPane_1.add(R);
		contentPane_1.add(lblNewLabel_2);
		contentPane_1.add(lblNewLabel_3);
		contentPane_1.add(lblNewLabel_1);
		contentPane_1.add(progressBar);
		contentPane.setLayout(gl_contentPane);
	}
}