package njpo;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player1 implements KeyListener {
	Snake snake;
	Snack snack;
	Player1(Snake s, Snack ss){
		snake = s;
		snack = ss;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
			switch(e.getKeyCode()) {
			case KeyEvent.VK_UP:{
				
				if( (snake.getLenSnake() < 2) || (snake.isMoveDown() != true))
				setDirection(false,false,true,false);
				
				break;
			}
			case KeyEvent.VK_DOWN:{
				if( (snake.getLenSnake() < 2) || (snake.isMoveUp() != true))
				setDirection(false,false,false,true);
				
				break;
			}
			case KeyEvent.VK_LEFT:{
				if((snake.getLenSnake() < 2 ) || (snake.isMoveRight() != true))
				setDirection(true,false,false,false);
				
				break;
			}
			case KeyEvent.VK_RIGHT:{
				if( (snake.getLenSnake() < 2) || (snake.isMoveLeft() != true))
				setDirection(false,true,false,false);
				
				break;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	private void setDirection(boolean left, boolean right, boolean up, boolean down) {
		
		snake.setMoveLeft(left);
		snake.setMoveRight(right);
		snake.setMoveDown(down);
		snake.setMoveUp(up);
	}

}
