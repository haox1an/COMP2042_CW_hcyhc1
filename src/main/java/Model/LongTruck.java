package Model;

import Controller.Actor;
import javafx.scene.image.Image;
/**
 * Class to display the 'Long Truck' obstacle
 */
public class LongTruck extends Actor {
	private double speed;
	private int size = 200;
	/**
	 * To move the sprite and reposition
	 * @param now current time frame
	 */
	@Override
	public void act(long now) {
		move(speed , 0);
		reposition(-200, 600, speed);
	}
	/**
	 * To display the image of the sprite
	 * @param xpos Position X to be placed
	 * @param ypos Position Y to be placed
	 * @param s Speed of the sprite
	 */
	public LongTruck(int xpos, int ypos, double s) {
		if (s < 0) {
		setImage(new Image("file:src/main/resources/Img/truck2Left.png", size, size,true, true));
		}
		if (s > 0 ) {
			setImage(new Image("file:src/main/resources/Img/truck2Right.png", size, size,true, true));
		}
		setX(xpos);
		setY(ypos);
		speed = s;
	}

}
