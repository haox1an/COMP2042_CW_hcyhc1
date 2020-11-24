package Model;

import Controller.Actor;
import javafx.scene.image.Image;

public class LongLog extends Actor{
	
	private double speed;
	private final int  size = 300;
	@Override
	public void act(long now) {
		move(speed , 0);
		reposition(-180,700,speed);
	}
	
	public LongLog(int xpos, int ypos, double s) {
		setImage(new Image("file:src/View/logs.png", size, size, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
	}
	
	public boolean isMoving() {
		return speed < 0;
	}

}
