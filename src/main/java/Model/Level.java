package Model;

import Controller.Actor;
import javafx.scene.image.Image;

/**
 * class to display the number of current level
 */
public class Level extends Actor {
    final int size = 80;
    Image lvWord;
    Image lvNum;
    Image lvFinal;

    /**
     * Display image of number of current level
     * @param level type image to be displayed
     */
    public Level(int level){
        if(level == 0)
        {
            lvWord = new Image("file:src/main/resources/Img/LevelFont.png", 250, 250, true, true);
            setImage(lvWord);
            setX(170);
            setY(20);
        }
        else if(level == 10)
        {
            lvFinal = new Image("file:src/main/resources/Img/LevelFinal.png", 300, 270, true, true);
            setImage(lvFinal);
            setX(170);
            setY(11);

        }
        else {
            lvNum = new Image("file:src/main/resources/Img/Level" + level + ".png", size, size, true, true);
            setImage(lvNum);
            setX(400);
            setY(20);
        }
    }


    @Override
    public void act(long now) {

    }
}
