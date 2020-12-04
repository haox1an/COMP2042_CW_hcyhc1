package Model;

import Controller.Actor;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.beans.property.IntegerProperty;

import javax.swing.*;

public class ScoreBar extends Actor {

    Font font;
    Text score;
   public ScoreBar(int point){
        score = new Text();
        font = Font.loadFont("file:src/main/resources/Font/Minecraft.ttf", 30);
        score.setText("Points  " + point);
        score.setFont(font);
        score.setFill(Color.WHITE);
        score.setTranslateX(5);
        score.setTranslateY(780);
   }

   public Text getText(){
       return score;

   }
    @Override
    public void act(long now) {

    }
}
