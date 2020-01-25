package njpo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Snack extends JPanel implements Runnable{
	private int positionX = 500;
	private int positionY = 500;
	private int positionSkullX = 440;
	private int positionSkullY = 440;
	private int positionSkullX1 = 480;
	private int positionSkullY1 = 360;
	
	private boolean petla = true;


	private BufferedImage image;
	private BufferedImage image1;
	
	Snack(int posX, int posY) {

		positionX = posX;
		positionY = posY;
		File imageFile = new File("C:\\Users\\marti\\Desktop\\Projektry-spring_and_hibernate\\NJPOII\\src\\apple.png");
		File imageFile1 = new File("C:\\Users\\marti\\Desktop\\Projektry-spring_and_hibernate\\NJPOII\\src\\icons8-skull-30.png");
		try {
			image = ImageIO.read(imageFile);
			image1 = ImageIO.read(imageFile1);
		} catch (IOException e) {
			System.err.println("Blad odczytu obrazka");
			e.printStackTrace();
		}

		Dimension dimension = new Dimension(image.getWidth(), image.getHeight());
		setPreferredSize(dimension);
	}
	
	@Override
	public void run() {

		
		doaSnack();
	}
	
	synchronized void doaSnack() {
		try {
			while(petla) {
			wait(10000);
			positionX = getRandomNumberInRange(1, 28); //1120 40
			positionY = getRandomNumberInRange(1, 15); // 600 40
			positionSkullX = getRandomNumberInRange(1, 28);
			positionSkullY = getRandomNumberInRange(1, 15);
			positionSkullX1 = getRandomNumberInRange(1, 28);
			positionSkullY1 = getRandomNumberInRange(1, 15);
			if(positionSkullY == positionY) {
				positionSkullY = getRandomNumberInRange(1, 28);
			}
			if(positionSkullY1 == positionY) {
				positionSkullY = getRandomNumberInRange(1, 28);
			}
//			System.out.println("test pozycja przekaski X: " + positionX);
//			System.out.println("test pozycja przekaski Y: " + positionX);	
			repaint();
			}
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	//reset positions
	synchronized void restetSnack() {
		 notifyAll();
	}


		
	
	
	//painting a snack
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, 1201,681);
		g2d.setColor(Color.GRAY);
		g2d.fillRect(40, 40, 1121,601);
		
		g2d.drawImage(image, positionX, positionY, this);
		g2d.drawImage(image1, positionSkullX, positionSkullY, this);
		g2d.drawImage(image1, positionSkullX1, positionSkullY1, this);
	}
	
	//get random position for our snack
	private int getRandomNumberInRange(int min, int max) {

		Random r = new Random();
		return ((r.nextInt(max - min) + 1) + min)*40;
	}
	
	//getters and setters
	public void setPetla(boolean petla) {
		this.petla = petla;
	}
	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
	public int getPositionSkullX() {
		return positionSkullX;
	}

	public void setPositionSkullX(int positionSkullX) {
		this.positionSkullX = positionSkullX;
	}

	public int getPositionSkullY() {
		return positionSkullY;
	}

	public void setPositionSkullY(int positionSkullY) {
		this.positionSkullY = positionSkullY;
	}
}
