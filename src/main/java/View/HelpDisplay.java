package View;

import Controller.World;
import Controller.QuitButton;
import Model.BackgroundImage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class HelpDisplay {
		World helpPane;
		Scene helpScene;
		ImageView instructions;
		Stage helpStage;
				
	public HelpDisplay() {
		
		helpStage = new Stage();
		
		helpPane = new World();
		helpScene = new Scene(helpPane, 600, 800);
		helpStage.setScene(helpScene);
		helpStage.setTitle("Frogger");
		helpStage.show();
		createBackground();
		createQuitButton();
		addInstructions();
	}
	
	public void createHelpStage() {
		helpStage.show();
		
	}
	
	public void createBackground()
	{
		BackgroundImage helpBackground = new BackgroundImage("file:src/main/resources/Img/Menu.jpg");
		helpPane.add(helpBackground);
	}
	
	
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
	
	public void addInstructions() {
		instructions = new ImageView(new Image("file:src/main/resources/Img/HowToPlay.png", 500, 700, true, true));
		helpPane.add(instructions);
		instructions.setLayoutX(50);
		instructions.setLayoutY(250);

	}
	
}
