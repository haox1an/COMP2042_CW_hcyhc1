package Model;

import Controller.Actor;
import javafx.scene.image.Image;

public class End extends Actor{
	boolean isEnd = false;
	@Override
	public void act(long now) {
		// TODO Auto-generated method st
	}
	
	public End(int x) {
		setX(x);
		setY(108);
		setImage(new Image("file:src/View/End.png", 60, 50, true, true));
	}
	
	public void setEnd() {
		setImage(new Image("file:src/View/FrogEnd.png", 60, 50, true, true));
		isEnd = true;
	}
	
	public boolean isEnd() {
		return isEnd;
	}
}
