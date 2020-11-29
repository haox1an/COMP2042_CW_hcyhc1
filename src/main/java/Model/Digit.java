package Model;

import Controller.Actor;
import javafx.scene.image.Image;

public class Digit extends Actor{
	int dim;
	Image digit;
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
	public Digit(int n, int size, int xPos, int yPos) {
		digit = new Image("file:src/main/resources/Img/"+n+".png", size, size, true, true);
		setImage(digit);
		setX(xPos);
		setY(yPos);
	}
}
