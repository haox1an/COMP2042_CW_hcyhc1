package View;

import Controller.FrogScore;
import Controller.World;
import Model.BackgroundImage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.text.Font;

/**
 * This class display 'Game Over' scene after player has lost the game
 * it allows player to restart the game
 * it displays player's score
 * @author Chung Hao Xian
 */
public class DisplayGameOver {

    Scene gameoverScene;
    Stage gameoverStage;
    World gameoverPane;
    FrogScore frogScore;

    Font font;
    BackgroundImage gameoverBackground;

    /**
     * DisplayGameOver() shows background, information text, score, and leaderboard
     * @param scores passed from DisplayGame(), which is player's score
     */
    public DisplayGameOver(int scores){

        initializeStage();
        createBackground();
        createText("PRESS SPACEBAR TO PLAY AGAIN", 25, 750);
        createText("Your Score is\n\n\t\t  " + scores, 170, 350);
        keyListener();
        setAlert(scores);
        }

    /**
     * initiializeStage() initialize pane, scene, stage, set scene and title
     */
    public void initializeStage(){
        gameoverPane  = new World();
        gameoverScene = new Scene(gameoverPane, 600, 800);
        gameoverStage = new Stage();
        gameoverStage.setScene(gameoverScene);
        gameoverStage.setTitle("Game Over");


    }

    /**
     * createBackground() display background image of the scene
     */
    public void createBackground(){
        gameoverBackground = new BackgroundImage("file:src/main/resources/Img/gameoverScene.jpg");
        gameoverPane.add(gameoverBackground);
    }

    /**
     * createStage() shows the stage
     */
    public void createStage(){
        gameoverStage.show();
    }

    /**
     * createText display text on the scene
     * @param text text to be displayed
     * @param Xpos Position X
     * @param Ypos Position Y
     */
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

    /**
     * keyListener() change scene to DisplayGame() when space is pressed
     */
    public void keyListener(){
        gameoverScene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.SPACE){
                gameoverStage.hide();
                DisplayGame game = new DisplayGame();
                game.createGame();

            }
        });
    }

    /**
     * getStage() For other class to obtain the stage
     * @return Stage This return this Stage
     */
    public Stage getStage(){
        return gameoverStage;
    }

    /**
     * recordScore() write the score into the file
     * @param score player's score to be recoreded
     */
    public void recordScore(int score){
        frogScore = new FrogScore();
        try
        {
            frogScore.createFile();
            frogScore.addScore(score);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("File not created");
        }
    }

    /**
     * setAlert() display alert window when the game is over, it will display the leaderboard
     * @param score Takes in score to display
     */

    public void setAlert(int score){
        recordScore(score);
        Alert loseAlert = new Alert(Alert.AlertType.INFORMATION);
        loseAlert.setTitle("Game Over");
        loseAlert.setHeaderText("Your Score: " + score);
        loseAlert.setContentText("Scoreboard: " + frogScore.displayScore());
        loseAlert.show();
    }


}
