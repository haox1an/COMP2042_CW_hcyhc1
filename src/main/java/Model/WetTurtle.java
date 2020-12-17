package Model;

import Controller.Actor;
import javafx.scene.image.Image;
/**
 * Class to create 'Wet Turtle' Actor, and this turtle will sink into water
 */
public class WetTurtle extends Actor{
	Image[] Turtle;
	private double speed;
	final int size = 130;
	boolean sunk = false;
	/**
	 * Display image of turtle in different state using different image
	 * @param now
	 */
	@Override
	public void act(long now) {

				if (now/900000000  % 4 ==0) {
					setImage(Turtle[1]);
					sunk = false;

				}
				else if (now/900000000 % 4 == 1) {
					setImage(Turtle[0]);
					sunk = false;
				}
				else if (now/900000000 %4 == 2) {
					setImage(Turtle[2]);
					sunk = false;

				} else if (now/900000000 %4 == 3) {
					setImage(Turtle[3]);
					sunk = true;
				}
		move(speed , 0);
		reposition(-200,600,speed);
	}

	/**
	 * To display the image of the sprite
	 * @param xpos Position X to be placed
	 * @param ypos Position Y to be placed
	 * @param s Speed of the sprite
	 */
	public WetTurtle(int xpos, int ypos, double s) {
		Turtle = new Image[4];
		Turtle[0] = new Image("file:src/main/resources/Img/TurtleAnimation1.png", size, size, true, true);
		Turtle[1] = new Image("file:src/main/resources/Img/TurtleAnimation2Wet.png", size, size, true, true);
		Turtle[2] = new Image("file:src/main/resources/Img/TurtleAnimation3Wet.png", size, size, true, true);
		Turtle[3] = new Image("file:src/main/resources/Img/TurtleAnimation4Wet.png", size, size, true, true);
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(Turtle[1]);
	}

	/**
	 * Boolean of whether turtle has sunk into water
	 * @return true if turtle has sunk, else false
	 */
	public boolean isSunk() {
		return sunk;
	}
}
