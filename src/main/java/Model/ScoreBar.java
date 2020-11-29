package Model;

import Controller.Actor;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ScoreBar extends Text {

    Font font;

   public ScoreBar(int point){
        font = Font.loadFont("file:src/main/resources/Font/Minecraft.ttf", 30);
        setText("Points  " + point);
        setFont(font);
        setFill(Color.WHITE);
        setX(5);
        setY(780);


   }

}
