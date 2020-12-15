package View;

import Controller.*;
import Model.*;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * This class display menu stage
 * Allow change stage to DisplayGame()
 * Allow change stage to HelpDisplay()
 * Allow exit application
 * @author Chung Hao Xian
 */
public class MenuDisplay {
	World mainPane;
	Scene menuScene;
	Stage menuStage;
	Music music = new Music();
	
	StartButton startButton;
	HelpButton helpButton;
	QuitButton quitButton;

	/**
	 * This constructor initialize the stage, scene, and pane
	 * add background image, play, info, quit buttons and music
	 */
	public MenuDisplay() {
		initializeStage();
		createBackground();
		createStartButton();
		createHelpButton();
		createQuitButton();
		addMusic();
		
	}

	/**
	 * This method initialize stage, pane, scene, set scene and title
	 */
	private void initializeStage(){
		mainPane = new World();
		menuScene = new Scene(mainPane, 600, 800);
		menuStage = new Stage();
		menuStage.setScene(menuScene);
		menuStage.setTitle("Frogger");

	}

	/**
	 * This method show the stage
	 */
	public void createMenuStage() {
		menuStage.show();
		
	}

	/**
	 * This method return this stage
	 * @return menuStage Stage can be obtained using this method
	 */
	public Stage getStage() {
		return menuStage;
	}

	/**
	 * This method create background Image
	 */
	public void createBackground() {
		BackgroundImage menuBackground = new BackgroundImage("file:src/main/resources/Img/Menu.jpg");
		mainPane.add(menuBackground);
	}

	/**
	 * This method create Start button
	 * When button pressed change to stage DisplayGame()
	 */
	public void createStartButton() 
	{
		startButton = new StartButton( 65, 300);
		mainPane.add(startButton);
		
		startButton.setOnAction(event -> {
			menuStage.hide();
			DisplayGame game = new DisplayGame();
			game.createGame();
			music.stopMusic();
		});
		}

	/**
	 * This method create Help button
	 * When pressed, change to Stage HelpDisplay()
	 */
	public void createHelpButton() 
	{
		helpButton = new HelpButton( 500, 700);
		mainPane.add(helpButton);
		
		helpButton.setOnAction(event -> {
			menuStage.hide();
			HelpDisplay help = new HelpDisplay();
			help.createHelpStage();
			music.stopMusic();
		});
	}

	/**
	 * This method create Quit button
	 * When pressed, exit application
	 */
	public void createQuitButton()
	{
		quitButton = new QuitButton(5, 700);
		mainPane.add(quitButton);
		
		quitButton.setOnAction(event -> Platform.exit());
		
	}

	/**
	 * This method add music
	 */
	public void addMusic() {
		music.playMusic();
	}

	
	
	
}
