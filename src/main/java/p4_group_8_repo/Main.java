package p4_group_8_repo;

import View.MenuDisplay;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * This program is an re-implementation of a classic retro game called "Frogger"
 * The source of the program : https://github.com/hirish99/Frogger-Arcade-Game
 *
 * @author Chung Hao Xian
 * @version 2.0
 * @since 24-11-2020
 */


public class Main extends Application {


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