package Model;

import Controller.Actor;
import javafx.scene.image.Image;

public class Truck extends Actor {
	private double speed;
	private int size = 120; 
	@Override
	public void act(long now) {
		move(speed , 0);
		reposition(-200, 600, speed);
	}
	
	public Truck(int xpos, int ypos, double s) {
		if (s < 0) {
		setImage(new Image("file:src/View/truck1Left.png", size, size,true, true));
		}
		if (s > 0 ) {
			setImage(new Image("file:src/View/truck1Right.png", size, size,true, true));
		}
		setX(xpos);
		setY(ypos);
		speed = s;
	}

}
