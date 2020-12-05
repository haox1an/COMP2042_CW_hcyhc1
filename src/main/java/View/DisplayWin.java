package View;

import Controller.Animal;
import Controller.FrogScore;
import Controller.World;
import Model.BackgroundImage;
import com.sun.prism.impl.Disposer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;


public class DisplayWin {

    Stage winStage;
    Scene winScene;
    World winPane;
    Animal frog;
    FrogScore frogScore;

    int points;
    public DisplayWin(int score) {
        winPane = new World();
        winStage = new Stage();
        winScene = new Scene(winPane, 600,800);
        winStage.setScene(winScene);
        winStage.setTitle("You Won!");
        createBackground();
        createText("Press SpaceBar to return to Menu", 46, 160);
        createText("Your Score is\n\n\t\t" + score, 200, 350);
        keyListener();
        setAlert(score);

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

    public void RecordScore(int score){
        frogScore = new FrogScore();
        try
        {
            frogScore.createFile();
            if(frogScore.isHigher(score))
                frogScore.addScore(score);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("File not created");
        }
    }

    public void setAlert(int score){
        RecordScore(score);
        Alert winAlert = new Alert(Alert.AlertType.INFORMATION);
        winAlert.setTitle("Scoreboard");
        winAlert.setHeaderText("Your Score: " + score);
        winAlert.setContentText("Scoreboard: " + frogScore.getList());
        winAlert.show();


    }

}
