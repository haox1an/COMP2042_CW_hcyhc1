package Model;

import Controller.Actor;
import javafx.scene.image.Image;

public class Turtle extends Actor{
	Image[] turtle;
	private double speed;
	private final int animationTime = 450000000;
	boolean turtleSunk = false;
	private final int size = 130;
	
	@Override
	public void act(long now) {
				if (now/animationTime  % 6 ==0) {
					setImage(turtle[1]);
					turtleSunk = false;
				}
				else if (now/animationTime % 6 == 1) {
					setImage(turtle[0]);
					turtleSunk = false;
				}
				else if (now/animationTime % 6 == 2) {
					setImage(turtle[2]);
					turtleSunk = false;
				}
				
				else if (now/animationTime % 6 == 3) {	
					setImage(turtle[3]);
					turtleSunk = false;
				}
				
				else if(now/animationTime % 6 == 4) {
					setImage(turtle[4]);
					turtleSunk = false;
				}
				
				else if(now/animationTime % 6 == 5) {
					setImage(turtle[5]);
					turtleSunk = true;
				}
				
		move(speed , 0);
		reposition(-200,600,speed);
	}
	
	
	public Turtle(int xpos, int ypos, double s) {
		turtle = new Image[6];
		turtle[0] = new Image("file:src/View/TurtleAnimation1.png",size, size, true, true);
		turtle[1] = new Image("file:src/View/TurtleAnimation2.png", size, size, true, true);
		turtle[2] = new Image("file:src/View/TurtleAnimation3.png", size, size, true, true);
		turtle[3] = new Image("file:src/View/TurtleAnimation2Wet.png", size, size, true, true);
		turtle[4] = new Image("file:src/View/TurtleAnimation3Wet.png", size, size, true, true);
		turtle[5] = new Image("file:src/View/TurtleAnimation4Wet.png", size, size, true, true);
		
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(turtle[1]);
	}
	
	public boolean isSunk() {
		return turtleSunk;
		
		
	}
	
	
}
