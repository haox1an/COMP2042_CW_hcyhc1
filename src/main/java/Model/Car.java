package Model;

import Controller.Actor;
import javafx.scene.image.Image;

/**
 * Class to create 'car' obstacle
 */
public class Car extends Actor {
	private double speed;
	private int size = 50;

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
	 * To create the 'car' obstacle
	 * @param xpos Position X of the sprite
	 * @param ypos Position Y of the sprite
	 * @param s	Speed of the sprite
	 */
	public Car(int xpos, int ypos, double s) {
		if (s < 0) {
		setImage(new Image("file:src/main/resources/Img/car1Left.png", size, size,true, true));
		}
		if (s > 0 ) {
			setImage(new Image("file:src/main/resources/Img/car1Right.png", size, size,true, true));
		}
		setX(xpos);
		setY(ypos);
		speed = s;
	}

}
