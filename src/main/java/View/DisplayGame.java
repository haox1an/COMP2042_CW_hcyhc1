package View;


import java.util.List;

import Controller.*;
import Model.*;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This class 'DisplayGame', display the stage of the game
 * @author Chung Hao Xian
 *
 */
public class DisplayGame {
	AnimationTimer timer;
	Scene gameScene;
	World gamePane;
	Animal frog;
	Stage gameStage;
	Music music = new Music();
	DisplayGameOver displayGameOver;

	final int GridY = 55;
	int level;
	int totalpoints;

	/**
	 * DisplayGame() display sprite of the game, score, buttons, background, level no.
	 */
	public DisplayGame() {
		initializeStage();
		createBackground();
		setLevel(1);
		addObstacles(level);
		addFrog();
		addEnd();
		addQuitButton();
		timerstart();
	}

	/**
	 * initiializeStage() initialize pane, scene, stage, set scene and title
	 */
	public void initializeStage(){
		gamePane = new World();
		gameScene = new Scene(gamePane, 600, 800);
		gameStage = new Stage();
		gameStage.setScene(gameScene);
		gameStage.setTitle("Frogger");
	}

	/**
	 *	setLevel() set current level of the game
	 *
	 * @param level to set level of the game
	 */
	public void setLevel(int level){
		this.level = level;
	}


	/**
	 * addObstacles() add sprite onto the scene
	 * @param lvl set speed and number of sprite according to this parameter
	 */
	public void addObstacles(int lvl) {
		int i;
		int[] lane = new int[11];

		for (i = 0; i < lane.length; i++) {
			lane[i] = 708 - GridY * (i);
		}
		//row0
		LevelInfo info = new LevelInfo();
		for (i = 0; i < info.ObjNum(lvl,0); i++) {
			gamePane.add(new Car(100 + (i * 400), lane[0], info.ObjSpeed(lvl, 0)));
		}
		//row 1
		for (i = 0; i < info.ObjNum(lvl,1); i++) {
			gamePane.add(new Truck(0 + (i * 330), lane[1], info.ObjSpeed(lvl, 1)));
		}
		//row2
		for (i = 0; i < info.ObjNum(lvl,2); i++) {
			gamePane.add(new Car(0 + (i * 230), lane[2], info.ObjSpeed(lvl, 2)));
		}
		//row3
		for (i = 0; i < info.ObjNum(lvl,3); i++) {
			gamePane.add(new LongTruck(0 + (i * 450), lane[3], info.ObjSpeed(lvl, 3)));
		}
		//row4
		for (i = 0; i < info.ObjNum(lvl,4); i++) {
			gamePane.add(new Car(300 + (i * 200), lane[4], info.ObjSpeed(lvl, 4)));
		}
		//row5
		for (i = 0; i < info.ObjNum(lvl,5); i++) {
			gamePane.add(new Turtle(25 + (i * 350), lane[6], info.ObjSpeed(lvl, 7)));
		}
		//row6
		for (i = 0; i < info.ObjNum(lvl,6); i++) {
			gamePane.add(new Log( (i * 220), lane[7], info.ObjSpeed(lvl, 6)));
		}
		//row7
		for (i = 0; i < info.ObjNum(lvl,7); i++) {
			gamePane.add(new WetTurtle(50 + (i * 250), lane[8], info.ObjSpeed(lvl, 7)));
		}
		//row8
		for (i = 0; i < info.ObjNum(lvl,8); i++) {
			gamePane.add(new LongLog(200 + (i * 350), lane[9], info.ObjSpeed(lvl, 8)));
		}
		//row9
		for (i = 0; i < info.ObjNum(lvl,9); i++) {
			gamePane.add(new Log(150 + (i * 250), lane[10], info.ObjSpeed(lvl, 9)));
		}
	}

	/**
	 * addEnd() add 'end' sprite to the scene
	 *
	 */
	public void addEnd() {
		gamePane.add(new End(15));
		gamePane.add(new End(143));
		gamePane.add(new End(271));
		gamePane.add(new End(399));
		gamePane.add(new End(527));
	}

	/**
	 * createBackground() add background image to the scene
	 * using BackgroundImage() class
	 */
	public void createBackground() {
		BackgroundImage gameBackground = new BackgroundImage("file:src/main/resources/Img/iKogsKW.png");
		gamePane.add(gameBackground);
	}

	/**
	 * createGame() show the stage
	 */
	public void createGame() {
		gameStage.show();
	}

	/**
	 * addFrog() create 'Frog' sprite onto the scene
	 */
	public void addFrog() {
		frog = new Animal();
		gamePane.add(frog);
		frog.setFrogLevel(level);
	}

	/**
	 * addLevel() Display the number of the current level
	 */
	public void addLevel(){
		gamePane.add(new Level(0));
		gamePane.add(new Level(level));
	}

	/**
	 * addLives() display the number of lives the player has
	 */
	public void addLives() {
		gamePane.add(new FrogLife(frog.getlives()));
	}

	/**
	 * addQuitButton() display quit button
	 * button exits to menu when pressed
	 */
	public void addQuitButton() {
		QuitButton quitButton = new QuitButton(510, -2);
		gamePane.add(quitButton);
		quitButton.setOnAction(event -> {
			gameStage.hide();
			MenuDisplay menu = new MenuDisplay();
			menu.createMenuStage();
			music.stopMusic();
		});

	}

	/**
	 *setTotalscore() add all the score from every level
	 * @param frogpoints record the total score through out every level
	 */
	public void setTotalscore(int frogpoints){
		this.totalpoints += frogpoints;
	}

	/**
	 * timerstart() start the timer
	 * and play music
	 */
	public void timerstart() {
		gameTimer();
		timer.start();
		music.playMusic();
	}

	/**
	 * showGameOver() change scene when player loses the game
	 *
	 */
	public void showGameOver() {
		if (frog.gameOver()) {
			setTotalscore(frog.getPoints());
			gameStage.hide();
			displayGameOver = new DisplayGameOver(totalpoints);
			displayGameOver.createStage();
			timer.stop();
			music.stopMusic();
		}
	}

	/**
	 * showGameOver()
	 * the level increment, when player has achieved the objectives
	 * If level > 10, change scene
	 */
	public void showWinning() {

		if (frog.getStop()) {
			if (level > 9) {
				setTotalscore(frog.getPoints());
				gameStage.hide();
				DisplayWin displayWin = new DisplayWin(totalpoints);
				displayWin.createStage();
				timer.stop();
				music.stopMusic();
			}

			else {
				level++;
				changeLv(level);
				frog.frogLevel = level;
			}
		}
	}

	/**
	 * changeLv() update the scene according to the level
	 * @param level display sprite according to level
	 */
	public void changeLv(int level){
		setTotalscore(frog.getPoints());
		frog.reset();
		gamePane.getChildren().clear();
		createBackground();
		addObstacles(level);
		addFrog();
		addEnd();
		addQuitButton();
	}

	/**
	 * gameTimer() create timer to update the sprites.
	 */
	public void gameTimer() {
		timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				List<Actor> actors = gamePane.getObjects(Actor.class);
				for (Actor anActor : actors) {
					anActor.act(now);
				}
				showWinning();
				showGameOver();
				addLives();
				addLevel();
			}
		};
	}

}