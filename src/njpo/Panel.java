package njpo;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import java.awt.Dialog.ModalityType;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class Panel extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Panel dialog = new Panel();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Panel() {
		
		setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		setResizable(false);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setBackground(Color.BLACK);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\marti\\Desktop\\Projektry-spring_and_hibernate\\NJPOII\\src\\art-and-design.png"));
		setTitle("Snake game!");
		setBounds(100, 100, 450, 300);
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.BLACK);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.SOUTH);
		
		JButton btnNewGame = new JButton("Start Game!");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Board board = new Board();
				board.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		btnNewGame.setBackground(SystemColor.inactiveCaption);
		btnNewGame.setForeground(Color.BLACK);
		btnNewGame.setFont(new Font("Snap ITC", Font.PLAIN, 16));
		
		JLabel lblSnakeGame = new JLabel("Snake Game");
		lblSnakeGame.setForeground(Color.WHITE);
		lblSnakeGame.setFont(new Font("Snap ITC", Font.PLAIN, 50));
		
		JLabel lblMarcinPietras = new JLabel("Marcin Pietras");
		lblMarcinPietras.setFont(new Font("Snap ITC", Font.PLAIN, 11));
		lblMarcinPietras.setForeground(Color.WHITE);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(141)
					.addComponent(btnNewGame)
					.addContainerGap(50, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addContainerGap(51, Short.MAX_VALUE)
					.addComponent(lblSnakeGame)
					.addGap(43))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(167)
					.addComponent(lblMarcinPietras)
					.addContainerGap(171, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addContainerGap(107, Short.MAX_VALUE)
					.addComponent(lblSnakeGame)
					.addGap(31)
					.addComponent(lblMarcinPietras)
					.addGap(18)
					.addComponent(btnNewGame)
					.addGap(44))
		);
		contentPanel.setLayout(gl_contentPanel);
	}
}
