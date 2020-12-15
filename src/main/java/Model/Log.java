package Model;

import Controller.Actor;
import javafx.scene.image.Image;

/**
 * Class to display the 'Log' obstacle
 */
public class Log extends Actor {

	private double speed;
	private final int size = 150;
	@Override
	/**
	 * To move the sprite and reposition
	 * @param now current time frame
	 */
	public void act(long now) {
		move(speed , 0);
		reposition(-180,700,speed);
	}

	/**
	 * To display the image of the sprite
	 * @param xpos Position X to be placed
	 * @param ypos Position Y to be placed
	 * @param s Speed of the sprite
	 */
	public Log(int xpos, int ypos, double s) {
		setImage(new Image("file:src/main/resources/Img/log3.png", size,size, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
		
	}


}



