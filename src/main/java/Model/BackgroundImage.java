package Model;

import Controller.Actor;

import javafx.scene.image.Image;

/**
 * This class create Background Image
 */
public class BackgroundImage extends Actor{

	private final int width = 600;
	private final int height = 900;
	@Override
	public void act(long now) {
		
		
	}

	/**
	 * Set the Image as background image
	 * @param imageLink Image to be set as background Image
	 */
	public BackgroundImage(String imageLink) {
		setImage(new Image(imageLink,width, height, true, true));
	}

}
