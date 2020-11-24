package Model;

import Controller.Actor;
import javafx.scene.image.Image;

public class BackgroundImage extends Actor{

	private final int width = 600;
	private final int height = 900;
	@Override
	public void act(long now) {
		
		
	}
	
	public BackgroundImage(String imageLink) {
		setImage(new Image(imageLink,width, height, true, true));
	}

}
