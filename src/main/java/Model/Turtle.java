package Model;

import Controller.Actor;
import javafx.scene.image.Image;

/**
 * Class to create 'Turtle' Actor
 */
public class Turtle extends Actor{
	Image[] turtle;
	private double speed;
	private final int animationTime = 450000000;
	boolean turtleSunk = false;
	private final int size = 130;

	/**
	 * Display image of turtle in different state using different image
	 * @param now
	 */
	@Override
	public void act(long now) {
				if (now/animationTime  % 3 ==0) {
					setImage(turtle[1]);
				}
				else if (now/animationTime % 3 == 1) {
					setImage(turtle[0]);
				}
				else if (now/animationTime % 3 == 2) {
					setImage(turtle[2]);
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
	public Turtle(int xpos, int ypos, double s) {
		turtle = new Image[6];
		turtle[0] = new Image("file:src/main/resources/Img/TurtleAnimation1.png",size, size, true, true);
		turtle[1] = new Image("file:src/main/resources/Img/TurtleAnimation2.png", size, size, true, true);
		turtle[2] = new Image("file:src/main/resources/Img/TurtleAnimation3.png", size, size, true, true);
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(turtle[1]);
	}
	

	
	
}
