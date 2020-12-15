package Model;

import Controller.Actor;
import javafx.scene.image.Image;

/**
 * This class is use to display the number of lives that the player has
 */
public class FrogLife extends Actor {
   private final int size = 60;

    /**
     * Method to create the image of the number
     * @param n number of life
     */
    public FrogLife(int n) {
        Image im1 = new Image("file:src/main/resources/Img/life" + n + ".png", size, size, true, true);
        setImage(im1);
        setX(110);
        setY(18);
    }

    @Override
    public void act(long now) {

    }


}
