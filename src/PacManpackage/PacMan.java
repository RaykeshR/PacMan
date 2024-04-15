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

public class PacMan extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PacMan frame = new PacMan();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PacMan() {
		
		int score=0;
		int temps=0;
		
		
		setTitle("PacMan");
		setOpacity(0.5f);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 790, 441);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));

		setContentPane(contentPane);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setForeground(new Color(192, 192, 192));
		contentPane_1.setBackground(new Color(0, 0, 0));
		contentPane_1.setToolTipText("");
		contentPane_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JLabel lblNewLabel_1 = new JLabel("PACMAN");
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 23));
		lblNewLabel_1.setForeground(new Color(255, 255, 0));
		
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(PacMan.class.getResource("/PacManpackage/MapV3.jpg")));
		GroupLayout gl_contentPane_1 = new GroupLayout(contentPane_1);
		gl_contentPane_1.setHorizontalGroup(
			gl_contentPane_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane_1.createSequentialGroup()
					.addGap(362)
					.addComponent(lblNewLabel_1)
					.addContainerGap(326, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane_1.createSequentialGroup()
					.addContainerGap(160, Short.MAX_VALUE)
					.addComponent(lblNewLabel_2)
					.addGap(127))
		);
		gl_contentPane_1.setVerticalGroup(
			gl_contentPane_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane_1.createSequentialGroup()
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_2)
					.addContainerGap(35, Short.MAX_VALUE))
		);
		contentPane_1.setLayout(gl_contentPane_1);
		
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
					//TODO (Raykesh nous dit que le bouton Gauche est appuier)
				}
			}
		});
		btnNewButton_Q.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnNewButton_S = new JButton("V");
		btnNewButton_S.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnNewButton_D = new JButton(">");
		
		JButton btnNewButton_Z = new JButton("^");
		btnNewButton_Z.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		// Les labels  (JLabel) : 
		
		JLabel lblNewLabel = new JLabel("   Score : "+score);
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
					.addComponent(contentPane_1, GroupLayout.DEFAULT_SIZE, 793, Short.MAX_VALUE)
					.addGap(28)
					.addComponent(contentPane_1_1, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(contentPane_1, GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
				.addComponent(contentPane_1_1, GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
	}
}
