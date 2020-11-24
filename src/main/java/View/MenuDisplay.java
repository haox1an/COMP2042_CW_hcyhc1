package View;

import Controller.FroggerButton;
import Controller.StartButton;
import Controller.HelpButton;
import Controller.MyStage;
import Controller.QuitButton;
import Model.BackgroundImage;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuDisplay {
	MyStage mainPane;
	Scene menuScene;
	Stage menuStage;
	
	FroggerButton startButton;
	FroggerButton helpButton;
	QuitButton quitButton;
	
	
	public MenuDisplay() {
		
		mainPane = new MyStage();
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
		BackgroundImage menuBackground = new BackgroundImage("file:src/main/java/View/Menu.jpg");
		mainPane.add(menuBackground);
	}
	
	
	public void createStartButton() 
	{
		StartButton startButton = new StartButton( 65, 250);
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
		HelpButton helpButton = new HelpButton( 550, 700);
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
		mainPane.playMusic();
	}
	
	
	
}
