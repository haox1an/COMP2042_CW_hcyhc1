package Model;

import Controller.Actor;
import javafx.scene.image.Image;

public class FrogLife extends Actor {
   private final int size = 60;


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
