package View;

import Controller.MyStage;
import Model.BackgroundImage;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.text.Font;

public class DisplayGameOver {

    Scene gameoverScene;
    Stage gameoverStage;
    MyStage gameoverPane;

    Font font;
    BackgroundImage gameoverBackground;

    public DisplayGameOver(int scores){
        System.out.println(scores);
        gameoverPane  = new MyStage();
        gameoverScene = new Scene(gameoverPane, 600, 800);
        gameoverStage = new Stage();
        gameoverStage.setScene(gameoverScene);
        gameoverStage.setTitle("Game Over");
        createBackground();
        createText("PRESS SPACEBAR TO PLAY AGAIN", 25, 750);
        createText("Your Score is\n\n\t\t\t" + scores, 170, 350);
        keyListener();
        }

    public void createBackground(){
        gameoverBackground = new BackgroundImage("file:src/main/resources/Img/gameoverScene.jpg");
        gameoverPane.add(gameoverBackground);
    }

    public void createStage(){
        gameoverStage.show();
    }

    public void createText (String text, int Xpos, int Ypos){
        Text gameoverText = new Text();
        font = Font.loadFont("file:src/main/resources/Font/ARCADECLASSIC.ttf", 40);
        gameoverText.setText(text);
        gameoverText.setFont(font);
        gameoverText.setFill(Color.WHITE);
        gameoverText.setX(Xpos);
        gameoverText.setY(Ypos);
        gameoverPane.add(gameoverText);


    }

    public void keyListener(){
        gameoverScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override

            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.SPACE){
                    gameoverStage.hide();
                    DisplayGame game = new DisplayGame();
                    game.createGame();

                }
            }
        });
    }

    public Stage getStage(){
        return gameoverStage;
    }





}
