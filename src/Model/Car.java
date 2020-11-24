package Model;

import Controller.Actor;
import javafx.scene.image.Image;

public class Car extends Actor {
	private double speed;
	private int size = 50; 
	@Override
	public void act(long now) {
		move(speed , 0);
		reposition(-200, 600, speed);
	}
	
	public Car(int xpos, int ypos, double s) {
		if (s < 0) {
		setImage(new Image("file:src/View/car1Left.png", size, size,true, true));
		}
		if (s > 0 ) {
			setImage(new Image("file:src/View/car1Right.png", size, size,true, true));
		}
		setX(xpos);
		setY(ypos);
		speed = s;
	}

}
