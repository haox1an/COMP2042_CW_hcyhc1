package Model;

import Controller.Actor;
import javafx.scene.image.Image;

public class Obstacle extends Actor {
	private int speed;
	@Override
	public void act(long now) {
		move(speed , 0);
		reposition(-200, 600, speed);
	}
	
	public Obstacle(String imageLink, int xpos, int ypos, int s, int size) {
		setImage(new Image(imageLink, size, size, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
	}

}
