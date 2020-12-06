package View;


import java.util.List;

import Controller.*;
import Model.*;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
	int Maxlevel = 9;

	public DisplayGame() {

		gamePane = new World();
		gameScene = new Scene(gamePane, 600, 800);
		gameStage = new Stage();
		gameStage.setScene(gameScene);
		gameStage.setTitle("Frogger");
		createBackground();
		setLevel(1);
		addObstacles(level);
		addFrog();
		addEnd();
		addQuitButton();
		timerstart();
	}

	public void setLevel(int level){
		this.level = level;
	}


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


//		//row2

		for (i = 0; i < info.ObjNum(lvl,2); i++) {
			gamePane.add(new Car(0 + (i * 230), lane[2], info.ObjSpeed(lvl, 2)));
		}

//		//row3
		for (i = 0; i < info.ObjNum(lvl,3); i++) {
			gamePane.add(new LongTruck(0 + (i * 450), lane[3], info.ObjSpeed(lvl, 3)));
		}

		//row4
		for (i = 0; i < info.ObjNum(lvl,4); i++) {
			gamePane.add(new Car(0 + (i * 200), lane[4], info.ObjSpeed(lvl, 4)));
		}

		//row5
		for (i = 0; i < info.ObjNum(lvl,5); i++) {
			gamePane.add(new Turtle(0 + (i * 300), lane[6], info.ObjSpeed(lvl, 7)));
		}


		//row6

		for (i = 0; i < info.ObjNum(lvl,6); i++) {
			gamePane.add(new Log(0 + (i * 220), lane[7], info.ObjSpeed(lvl, 6)));
		}

//		//row7

		for (i = 0; i < info.ObjNum(lvl,7); i++) {
			gamePane.add(new Turtle(0 + (i * 250), lane[8], info.ObjSpeed(lvl, 7)));
		}
//
//		//row8

		for (i = 0; i < info.ObjNum(lvl,8); i++) {
			gamePane.add(new LongLog(0 + (i * 350), lane[9], info.ObjSpeed(lvl, 8)));
		}
//
//		//row9

		for (i = 0; i < info.ObjNum(lvl,9); i++) {
			gamePane.add(new Log(0 + (i * 250), lane[10], info.ObjSpeed(lvl, 9)));
		}
	}

	public void addEnd() {
		gamePane.add(new End(15));
		gamePane.add(new End(143));
		gamePane.add(new End(271));
		gamePane.add(new End(399));
		gamePane.add(new End(527));
	}

	public void createBackground() {
		BackgroundImage gameBackground = new BackgroundImage("file:src/main/resources/Img/iKogsKW.png");
		gamePane.add(gameBackground);
	}

	public void createGame() {
		gameStage.show();
	}

	public void addFrog() {
		frog = new Animal();
		gamePane.add(frog);
		frog.setFrogLevel(level);
	}

	public void addLevel(){
		gamePane.add(new Level(0));
		gamePane.add(new Level(level));

	}

	public void addLives() {
		gamePane.add(new FrogLife(frog.getlives()));
	}

	public void setNumber(int n) {
		int shift = 0;
		while (n > 0) {
			int d = n / 10;
			int k = n - d * 10;
			n = d;
			gamePane.add(new Digit(k, 30, 700 - shift, 25));
			shift += 30;
		}
	}

	public void addQuitButton() {
		QuitButton quitButton = new QuitButton(510, -2);
		gamePane.add(quitButton);
		quitButton.setOnAction(event -> {
			gameStage.hide();
			MenuDisplay menu = new MenuDisplay();
			menu.createMenuStage();
		});

	}

	public void setTotalscore(int frogpoints){
		this.totalpoints = frogpoints;

	}


	public void timerstart() {
		gameTimer();
		timer.start();
//		music.playMusic();
	}

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
				System.out.println(frog.frogLevel);
			}
		};
	}

}