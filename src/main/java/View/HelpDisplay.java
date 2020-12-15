package View;

import Controller.World;
import Model.QuitButton;
import Model.BackgroundImage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * This class display Stage of 'How to Play' of the game
 * @author Chung Hao Xian
 */
public class HelpDisplay {
		World helpPane;
		Scene helpScene;
		ImageView instructions;
		Stage helpStage;

	/**
	 * This constructor initialize the stage, show background, button, and image
	 */
	public HelpDisplay() {
		initializeStage();
		createHelpStage();
		createBackground();
		createQuitButton();
		addInstructions();
	}

	/**
	 * This method initialize stage, pane, scene, set scene and title
	 */
	public void initializeStage(){
		helpStage = new Stage();
		helpPane = new World();
		helpScene = new Scene(helpPane, 600, 800);
		helpStage.setScene(helpScene);
		helpStage.setTitle("Frogger");
	}

	/**
	 * This method show the Stage
	 */
	public void createHelpStage() {
		helpStage.show();
		
	}

	/**
	 *This method create background image
	 */
	public void createBackground()
	{
		BackgroundImage helpBackground = new BackgroundImage("file:src/main/resources/Img/Menu.jpg");
		helpPane.add(helpBackground);
	}

	/**
	 * This method create quit button
	 * When pressed, return to menu
	 */
	public void createQuitButton()
	{
		QuitButton quitButton = new QuitButton(5, 700);
		helpPane.add(quitButton);
		quitButton.setOnAction(event -> {
			helpStage.hide();
			MenuDisplay menu = new MenuDisplay();
			menu.createMenuStage();
		});
	}

	/**
	 * This method add image of the instructions
	 */
	public void addInstructions() {
		instructions = new ImageView(new Image("file:src/main/resources/Img/HowToPlay.png", 500, 700, true, true));
		helpPane.add(instructions);
		instructions.setLayoutX(50);
		instructions.setLayoutY(250);

	}
	
}
