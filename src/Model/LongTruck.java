package Model;

import Controller.Actor;
import javafx.scene.image.Image;

public class LongTruck extends Actor {
	private double speed;
	private int size = 200; 
	@Override
	public void act(long now) {
		move(speed , 0);
		reposition(-200, 600, speed);
	}
	
	public LongTruck(int xpos, int ypos, double s) {
		if (s < 0) {
		setImage(new Image("file:src/View/truck2Left.png", size, size,true, true));
		}
		if (s > 0 ) {
			setImage(new Image("file:src/View/truck2Right.png", size, size,true, true));
		}
		setX(xpos);
		setY(ypos);
		speed = s;
	}

}
