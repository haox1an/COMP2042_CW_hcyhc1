package View;

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

    public DisplayWin() {
        winPane = new MyStage();
        winStage = new Stage();
        winScene = new Scene(winPane, 600,800);
        winStage.setScene(winScene);
        winStage.setTitle("You Won!");
        createBackground();
        Text("Press SpaceBar to return to Menu", 50, 160);
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


    public void Text(String text, int Xpos, int Ypos){
        Text winText = new Text();
        Font font = Font.loadFont("file:src/main/resources/Font/Minecraft.ttf", 30);
        winText.setText(text);
        winText.setFill(Color.GREY);
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


}