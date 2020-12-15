package Model;

import Controller.Actor;
import javafx.scene.image.Image;
/**
 * Class to display the 'Long Log' obstacle
 */
public class LongLog extends Actor{
	
	private double speed;
	private final int  size = 300;
	/**
	 * To move the sprite and reposition
	 * @param now current time frame
	 */
	@Override
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
	public LongLog(int xpos, int ypos, double s) {
		setImage(new Image("file:src/main/resources/Img/logs.png", size, size, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
	}
	
	public boolean isMoving() {
		return speed < 0;
	}

}
