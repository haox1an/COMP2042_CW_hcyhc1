package View;

import Controller.StartButton;
import Controller.HelpButton;
import Controller.World;
import Controller.QuitButton;
import Model.BackgroundImage;
import Model.Music;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuDisplay {
	World mainPane;
	Scene menuScene;
	Stage menuStage;
	Music music;
	
	StartButton startButton;
	HelpButton helpButton;
	QuitButton quitButton;
	
	
	public MenuDisplay() {
		
		mainPane = new World();
		menuScene = new Scene(mainPane, 600, 800);
		menuStage = new Stage();
		menuStage.setScene(menuScene);
		createBackground();
		createStartButton();
		createHelpButton();
		createQuitButton();
		addMusic();
		
	}
	
	public void createMenuStage() {
		menuStage.show();
		
	}
	
	public Stage getStage() {
		return menuStage;
	}
	
	public void createBackground() {
		BackgroundImage menuBackground = new BackgroundImage("file:src/main/resources/Img/Menu.jpg");
		mainPane.add(menuBackground);
	}
	
	
	public void createStartButton() 
	{
		startButton = new StartButton( 65, 300);
		mainPane.add(startButton);
		
		startButton.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
				{
					menuStage.hide();
					DisplayGame game = new DisplayGame();
					game.createGame();
				}
			});	
		}
	
	public void createHelpButton() 
	{
		helpButton = new HelpButton( 500, 700);
		mainPane.add(helpButton);
		
		helpButton.setOnAction(new EventHandler<ActionEvent>()
			{
					
			@Override
			public void handle(ActionEvent event)
			{
				menuStage.hide();
				HelpDisplay help = new HelpDisplay();
				help.createHelpStage();
			}
		});	
	}
	
	public void createQuitButton()
	{
		quitButton = new QuitButton(5, 700);
		mainPane.add(quitButton);
		
		quitButton.setOnAction(new EventHandler<ActionEvent>()
		{	
		@Override
		public void handle(ActionEvent event)
		{
			Platform.exit();
		}
	});	
		
	}
	
	public void addMusic() {
		music.playMusic();
	}
	
	
	
}
