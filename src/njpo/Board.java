package njpo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Board extends JFrame{
	public Board game;
	Snack snack ;
	Snake snake ;

	public Board() {
		
		super("Snake game! ssss");
		game = this;
		setPreferredSize(new Dimension(1217, 720)); //42 24 / 1217, 738 / 1277, 730 / 1217, 720
		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\marti\\Desktop\\Projektry-spring_and_hibernate\\NJPOII\\src\\art-and-design.png"));
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		snack = new Snack(160,160);
		snake = new Snake(120,120,snack,game);
		
		
		Thread[] r = new Thread[4];
		r[0] = new Thread(snake);
		r[1] = new Thread(snack);

		r[0].start(); 
		r[1].start();
		
		JPanel panel = snake;
		add(panel);
		addKeyListener(new Player1(snake, snack));
		
		JLabel label = new JLabel("Pietras Marcin");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Source Sans Pro Light", Font.PLAIN, 15));
	      Dimension size = label.getPreferredSize();
	      label.setBounds(1070, 651, size.width, size.height);
	      panel.setLayout(null);
	      panel.add(label);
		
	}
	public void endGame() {
		setVisible(false);
		dispose();
		snake.setPetla(false);
		snack.setPetla(false);
	}
	
}
