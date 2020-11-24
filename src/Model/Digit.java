package Model;

import Controller.Actor;
import javafx.scene.image.Image;

public class Digit extends Actor{
	int dim;
	Image im1;
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
	public Digit(int n, int size, int xPos, int yPos) {
		im1 = new Image("file:src/View/"+n+".png", size, size, true, true);
		setImage(im1);
		setX(xPos);
		setY(yPos);
	}
}
