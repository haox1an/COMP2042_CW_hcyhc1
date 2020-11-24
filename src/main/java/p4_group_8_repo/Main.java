package main.java.p4_group_8_repo;

import main.java.Controller.Animal;
import main.java.Controller.MyStage;
import main.java.View.DisplayGame;
import main.java.View.MenuDisplay;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	AnimationTimer timer;
	MyStage background;
	Animal frog;
	

	
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		MenuDisplay menu = new MenuDisplay();
		primaryStage = menu.getStage();
		primaryStage.show();
		
	}
}