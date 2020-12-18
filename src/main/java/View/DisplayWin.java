package View;

import Controller.FrogScore;
import Controller.World;
import Model.BackgroundImage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

    /**
     * This class create a Stage, will be displayed if player wins the game
     * Allows player to return to menu scene
     * Display score and leaderboard
     * @author Chung Hao Xian
     */
public class DisplayWin {
    Stage winStage;
    Scene winScene;
    World winPane;
    FrogScore frogScore;

        /**
         * DisplayWin() initializes the stage, display background image, display text, display score and pop out alert window
         * @param score Player's score to be displayed
         */
    public DisplayWin(int score) {
        initializeStage();
        createBackground();
        createText("Press SpaceBar to return to Menu", 46, 160);
        createText("Your Score is\n\n\t\t" + score, 200, 350);
        keyListener();
        setAlert(score);

    }

        /**
         * initiializeStage() initialize pane, scene, stage, set scene and title
         */
    public void initializeStage(){
        winPane = new World();
        winStage = new Stage();
        winScene = new Scene(winPane, 600,800);
        winStage.setScene(winScene);
        winStage.setTitle("You Won!");

    }

        /**
         * createBackground() create background image for the scene
         */
    public void createBackground(){
        BackgroundImage winBackground = new BackgroundImage("file:src/main/resources/Img/WinScene.jpg");
        winPane.add(winBackground);
    }

        /**
         * getStage() For other class to obtain
         * @return winStage This is current stage
         */
    public Stage getStage(){
        return winStage;
    }

        /**
         * createStage() show the this stage
         */
    public void createStage(){
        winStage.show();

    }

        /**
         * cretaeText() create text to be displayed on the scene
         * @param text Text to be displayed
         * @param Xpos Position X
         * @param Ypos Position Y
         */
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


        /**
         * keyListener() when SPACE is pressed, it will return to menu stage
         */
    public void keyListener(){
        winScene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.SPACE){
                winStage.hide();
                MenuDisplay menu = new MenuDisplay();
                menu.createMenuStage();

            }
        });
    }

        /**
         * recordScore() when game is over, score will be recorded into the file
         * @param score player's score to be recorded
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
         * @param score Takes in score to display on the alert window
         */
    public void setAlert(int score){
        recordScore(score);
        Alert winAlert = new Alert(Alert.AlertType.INFORMATION);
        winAlert.setTitle("You Won");
        winAlert.setHeaderText("Your Score: " + score);
        winAlert.setContentText("Scoreboard: " + frogScore.displayScore());
        winAlert.show();


    }

}
