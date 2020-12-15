package Model;

import Controller.Actor;
import javafx.scene.image.Image;

/**
 * This class is used to display 'End' actor
 */
public class End extends Actor{
	boolean isEnd = false;
	@Override
	public void act(long now) {
		// TODO Auto-generated method st
	}

	/**
	 * To display image of 'End'
	 * @param x  Position X of the image
	 */
	public End(int x) {
		setX(x);
		setY(108);
		setImage(new Image("file:src/main/resources/Img/End.png", 60, 50, true, true));
	}

	/**
	 * To display image after Player has intersect with 'End'
	 */
	public void setEnd() {
		setImage(new Image("file:src/main/resources/Img/FrogEnd.png", 60, 50, true, true));
		isEnd = true;
	}

	/**
	 * To inform that the place is occupied
	 * @return boolean when place is intersected
	 */
	public boolean isEnd() {
		return isEnd;
	}

}
