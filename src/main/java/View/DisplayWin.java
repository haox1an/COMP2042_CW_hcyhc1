package View;

import Controller.Animal;
import Controller.MyStage;
import Model.BackgroundImage;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.event.EventHandler;


public class DisplayWin {

    Stage winStage;
    Scene winScene;
    MyStage winPane;
    Animal frog;

    int points;
    public DisplayWin(int score) {
        winPane = new MyStage();
        winStage = new Stage();
        winScene = new Scene(winPane, 600,800);
        winStage.setScene(winScene);
        winStage.setTitle("You Won!");
        createBackground();
        createText("Press SpaceBar to return to Menu", 46, 160);
        createText("Your Score is\n\n\t\t" + score, 200, 350);
        keyListener();

    }

    public void createBackground(){
        BackgroundImage winBackground = new BackgroundImage("file:src/main/resources/Img/WinScene.jpg");
        winPane.add(winBackground);
    }

    public Stage getStage(){
        return winStage;
    }

    public void createStage(){
        winStage.show();

    }


    public void createText(String text, int Xpos, int Ypos){
        Text winText = new Text();
        Font font = Font.loadFont("file:src/main/resources/Font/ARCADECLASSIC.ttf", 33);
        winText.setText(text);
        winText.setFill(Color.LIGHTGREY);
        winText.setX(Xpos);
        winText.setY(Ypos);
        winText.setFont(font);
        winPane.add(winText);
    }



    public void keyListener(){
        winScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.SPACE){
                    winStage.hide();
                    MenuDisplay menu = new MenuDisplay();
                    menu.createMenuStage();

                }
            }
        });
    }

    public int setScore(int point)
    {
        this.points = point;
        return this.points;
    }

    public int getScore()
    {
        return this.points;
    }


}
