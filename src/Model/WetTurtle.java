package Model;

import Controller.Actor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class WetTurtle extends Actor{
	Image[] Turtle;
	private int speed;
	int i = 1;
	boolean bool = true;
	boolean sunk = false;
	@Override
	public void act(long now) {

				if (now/900000000  % 4 ==0) {
					setImage(Turtle[1]);

					
				}
				else if (now/900000000 % 4 == 1) {
					setImage(Turtle[0]);

				}
				else if (now/900000000 %4 == 2) {
					setImage(Turtle[2]);

				} else if (now/900000000 %4 == 3) {
					setImage(Turtle[3]);
					sunk = true;
				}
		move(speed , 0);
		reposition(-200,600,speed);
	}
	
	
	public WetTurtle(int xpos, int ypos, int s, int size) {
		Turtle = new Image[4];
		Turtle[0] = new Image("file:src/View/TurtleAnimation1.png", size, size, true, true);
		Turtle[1] = new Image("file:src/View/TurtleAnimation2Wet.png", size, size, true, true);
		Turtle[2] = new Image("file:src/View/TurtleAnimation3Wet.png", size, size, true, true);
		Turtle[3] = new Image("file:src/View/TurtleAnimation4Wet.png", size, size, true, true);
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(Turtle[1]);
	}
	public boolean isSunk() {
		return sunk;
	}
}
