package njpo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class Snake extends JPanel implements Runnable{

	
	private boolean moveLeft = false;
	private boolean moveRight = true;
	private boolean moveUp = false;
	private boolean moveDown = false;
	private int speedSnake = 200;
	private int sizeSnake = 40;
	private int lenSnake = 1;
	private int points = 0;
	private List<Integer> snakeX = new ArrayList<Integer>();
	private List<Integer> snakeY = new ArrayList<Integer>();
	
	private boolean petla = true;
	
	private final Snack snack;
	private final Snake snake;
	private final Board game;
	public Snake(int racX, int racY, Snack s, Board gam) {
		this.snake = this;
		updateList(racX, racY);
		snack = s;
		game = gam;
	}
	private void updateList(int i, int j) {
		snakeX.add(i);
		snakeY.add(j);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			
			move();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void move() throws InterruptedException {
		int tempX = 0; //holder for value from array
		int temp1X = 0;
		int tempY = 0;
		int temp1Y = 0;
		int check = 0;
		while(petla) {
			Thread.sleep(speedSnake);
			//System.out.println(snakeX[0]);
			synchronized(this){
				isEdge();
				
				//sprawdzenie czy pozycja snake jest taka jak snack
				if(eat()) {
					updateList(snakeX.get(snakeX.size()-1), snakeY.get(snakeY.size()-1));
					//zrestartowanie pozycji snack oraz uzycie notifyall
					snack.restetSnack();
					setLenSnake(getLenSnake()+1);
					updateSpeedSnake(getSpeedSnake());
					updatePoints();
				}
				
			if(moveLeft) {
				
				//1element modyfikuje nastepne przenosze na i+1 miejsce. Gdy modyfikuje tak X to z Y poprostu przenosze i+1
				for(int i = 0; i < snakeX.size(); i ++) {
					if( i == 0) {
						tempX = snakeX.get(i);
						snakeX.set(i, tempX-sizeSnake);
						tempY = snakeY.get(i);
						
					} else {
						temp1X = snakeX.get(i);
						snakeX.set(i, tempX);
						tempX = temp1X;
						
						temp1Y = snakeY.get(i);
						snakeY.set(i, tempY);
						tempY = temp1Y;
					}
				}
				
			} else if(moveRight) {
				
				for(int i = 0; i < snakeX.size(); i ++) {
					if( i == 0) {
						tempX = snakeX.get(i);
						snakeX.set(i, tempX+sizeSnake);
						tempY = snakeY.get(i);
					} else {
						temp1X = snakeX.get(i);
						snakeX.set(i, tempX);
						tempX = temp1X;
						
						temp1Y = snakeY.get(i);
						snakeY.set(i, tempY);
						tempY = temp1Y;
					}
				}
				
			} else if(moveUp) {
				
				for(int i = 0; i < snakeY.size(); i ++) {

					if( i == 0) {
						tempY = snakeY.get(i);
						snakeY.set(i, tempY-sizeSnake);
						tempX = snakeX.get(i);
					} else {
						temp1Y = snakeY.get(i);
						snakeY.set(i, tempY);
						tempY = temp1Y;
						
						temp1X = snakeX.get(i);
						snakeX.set(i, tempX);
						tempX = temp1X;
					}
				}
				
			} else if(moveDown) {
				
				for(int i = 0; i < snakeY.size(); i ++) {
					if( i == 0) {
						tempY = snakeY.get(i);
						snakeY.set(i, tempY+sizeSnake);
						tempX = snakeX.get(i);
					} else {
						temp1Y = snakeY.get(i);
						snakeY.set(i, tempY);
						tempY = temp1Y;
						
						temp1X = snakeX.get(i);
						snakeX.set(i, tempX);
						tempX = temp1X;
					}
				}
			}
			System.out.println("pozy x: " + snakeX.get(0));
			System.out.println("pozy y: " + snakeY.get(0));
			repaint();
			}
		}
	}
	
	private void isEdge() {
				
		if(snakeX.get(0) == 0 || snakeX.get(0) == 1160)
			endGame();
		if(snakeY.get(0) == 0 || snakeY.get(0) == 640)
			endGame();
		if(snakeY.get(0) == snack.getPositionSkullY() && snakeX.get(0) == snack.getPositionSkullX())
			endGame();
		isBody (snakeX.get(0),snakeY.get(0));
	}

	private void isBody (int x, int y) {
		for (int i = 1; i < snakeX.size(); i++) {
			if(x == snakeX.get(i) && y == snakeY.get(i)) {
				endGame();
			}
		}
	}
	private void endGame() {
		try {
			Thread.sleep(1000);
			setVisible(false);
			game.endGame();
			EndGame end = new EndGame(getPoints());
			end.setVisible(true);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void updatePoints() {
		// TODO Auto-generated method stub
		int curPoint = getPoints() + 10;
		setPoints(curPoint);
	}
	private void updateSpeedSnake(int currentSpeed) {

		int newSpeed = (currentSpeed > 50) ? currentSpeed-5 : 50;
		System.out.println(newSpeed);
		setSpeedSnake(newSpeed);

	}
	private boolean eat() {
		return true ? (snakeX.get(0) == snack.getPositionX() && snakeY.get(0) == snack.getPositionY()) : false;
	}
	



	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		snack.paintComponent(g);
		
		for(int i = 0; i < snakeX.size(); i ++) {
			g2d.setColor(Color.green);
			g2d.drawRect(snakeX.get(i)-2, snakeY.get(i)-2, sizeSnake-7, sizeSnake-7);
			g2d.setColor(Color.blue);
	        g2d.fillRect(snakeX.get(i),snakeY.get(i), sizeSnake-10, sizeSnake-10);
			
		}
		
        
	}
	
	public void setPetla(boolean petla) {
		this.petla = petla;
	}
	//setters and getters
	public boolean isMoveLeft() {
		return moveLeft;
	}

	public void setMoveLeft(boolean moveLeft) {
		this.moveLeft = moveLeft;
	}

	public boolean isMoveRight() {
		return moveRight;
	}

	public void setMoveRight(boolean moveRight) {
		this.moveRight = moveRight;
	}

	public boolean isMoveUp() {
		return moveUp;
	}

	public void setMoveUp(boolean moveUp) {
		this.moveUp = moveUp;
	}

	public boolean isMoveDown() {
		return moveDown;
	}

	public void setMoveDown(boolean moveDown) {
		this.moveDown = moveDown;
	}	
	public int getLenSnake() {
		return lenSnake;
	}
	public void setLenSnake(int lenSnake) {
		this.lenSnake = lenSnake;
	}
	public int getSpeedSnake() {
		return speedSnake;
	}
	public void setSpeedSnake(int speedSnake) {
		this.speedSnake = speedSnake;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
}