package njpo;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EndGame extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private int points  = 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			EndGame dialog = new EndGame(0);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public EndGame(int po) {
		setTitle("Snake game!");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\marti\\Desktop\\Projektry-spring_and_hibernate\\NJPOII\\src\\art-and-design.png"));
		setResizable(false);
		points = po;
		setBounds(100, 100, 450, 300);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.BLACK);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Tw\u00F3j wynik: ");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Source Sans Pro Light", Font.PLAIN, 31));
		
		JLabel lblNewLabel_1 = new JLabel(points+" punktów");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Source Sans Pro Light", Font.PLAIN, 15));
		
		JButton btnJeszczeRaz = new JButton("Jeszcze raz");
		btnJeszczeRaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Board nextGame = new Board();
				setVisible(false);
				dispose();
			}
		});
		btnJeszczeRaz.setBackground(new Color(0, 204, 255));
		btnJeszczeRaz.setFont(new Font("Source Sans Pro Light", Font.PLAIN, 15));
		
		JButton btnKoniec = new JButton("Koniec");
		btnKoniec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(1);
			}
		});
		btnKoniec.setBackground(new Color(255, 51, 0));
		btnKoniec.setFont(new Font("Source Sans Pro Light", Font.PLAIN, 15));
		
		JLabel lblTheGameIs = new JLabel("The Game is over :(");
		lblTheGameIs.setForeground(Color.WHITE);
		lblTheGameIs.setFont(new Font("Source Sans Pro Light", Font.PLAIN, 40));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(54)
					.addComponent(btnJeszczeRaz)
					.addPreferredGap(ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
					.addComponent(btnKoniec, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addGap(75))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(178)
					.addComponent(lblNewLabel_1)
					.addContainerGap(189, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addContainerGap(72, Short.MAX_VALUE)
					.addComponent(lblTheGameIs)
					.addGap(59))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(135)
					.addComponent(lblNewLabel)
					.addContainerGap(147, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTheGameIs)
					.addPreferredGap(ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1)
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnJeszczeRaz)
						.addComponent(btnKoniec))
					.addGap(42))
		);
		contentPanel.setLayout(gl_contentPanel);
	}
}
