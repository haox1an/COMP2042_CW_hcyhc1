package p4_group_8_repo;

import Controller.Animal;
import Controller.MyStage;
import View.DisplayWin;
import View.MenuDisplay;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import View.DisplayGameOver;

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
		DisplayWin win = new DisplayWin();
		DisplayGameOver game = new DisplayGameOver();
		primaryStage = menu.getStage();
		primaryStage.show();
		
	}
}