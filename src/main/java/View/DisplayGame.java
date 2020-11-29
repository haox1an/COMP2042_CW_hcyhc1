package View;


import java.util.List;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import Controller.*;
import Model.*;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class DisplayGame {
	AnimationTimer timer;
	Scene gameScene;
	MyStage gamePane;
	Animal frog;
	Stage gameStage;
	DisplayGameOver displayGameOver;
	final int GridY = 55;
	int level = 1;

	public DisplayGame() {

		gamePane = new MyStage();
		gameScene = new Scene(gamePane, 600, 800);
		gameStage = new Stage();
		gameStage.setScene(gameScene);
		gameStage.setTitle("Frogger");
		createBackground();
		addObstacles(level);
		addFrog();
		addEnd();
		addQuitButton();
		timerstart();
		addDigit();

	}



	public void addObstacles(int lvl) {
		int i;
		int[] lane = new int[11];

		for (i = 0; i < lane.length; i++) {
			lane[i] = 708 - GridY * (i);
		}
		//row0
		ObjectInfo info = new ObjectInfo();
//		for (i = 0; i < info.ObjNum(lvl,0); i++) {
//			gamePane.add(new Car(0 + (i * 200), lane[0], info.ObjSpeed(lvl, 0)));
//		}
			//row1w
//		gamePane.add(new Truck(0, lane[1], info.ObjSpeed(0,0)));
//		gamePane.add(new Truck(300, lane[1], 3));
//
//		//row2
//		gamePane.add(new Car(100, lane[2], 1));
//		gamePane.add(new Car(300, lane[2], 1));
//		gamePane.add(new Car(500, lane[2], 1));
//
//
//		//row3
//		gamePane.add(new LongTruck(100, lane[3], -1));
//		gamePane.add(new Car(500, lane[3], -1));
//
//
//		//row4
//		gamePane.add(new Car(0, lane[4], -2));
//
//		//row5
//		gamePane.add(new Turtle(500, lane[6], -1));
//		gamePane.add(new Turtle(300, lane[6], -1));
//		gamePane.add(new Turtle(700, lane[6], -1));
//
//		//row6
//		gamePane.add(new Log(50, lane[7], 0.75));
//		gamePane.add(new Log(270, lane[7], 0.75));
//		gamePane.add(new Log(490, lane[7], 0.75));
//
//		//row7
//		gamePane.add(new Turtle(600, lane[8], -1));
//		gamePane.add(new Turtle(400, lane[8], -1));
//		gamePane.add(new Turtle(200, lane[8], -1));
//
//		//row8
//		gamePane.add(new LongLog(0, lane[9], -2));
//		gamePane.add(new LongLog(400, lane[9], -2));
//
//		//row9
//		gamePane.add(new Log(0, lane[10]+7, 0.75));
//		gamePane.add(new Log(220, lane[10]+7, 0.75));
//		gamePane.add(new Log(440, lane[10]+7, 0.75));
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
	}

	public void addDigit() {
//		Digit digit = new Digit(0, 30, 500, 25);
//		gamePane.add(digit);
		gamePane.add(new ScoreBar(40));
	}

	public void addMusic() {
		gamePane.playMusic();
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
		quitButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				gameStage.hide();
				MenuDisplay menu = new MenuDisplay();
				menu.createMenuStage();
			}
		});

	}


	public void timerstart() {
		gameTimer();
		timer.start();
	}

	public void showGameOver() {
		if (frog.gameOver()) {
			gameStage.hide();
			displayGameOver = new DisplayGameOver();
			displayGameOver.createStage();
			timer.stop();
		}


	}

	public void showWinning() {
		if (frog.getStop()) {
			if (level >= 10) {
				gameStage.hide();
				DisplayWin displayWin = new DisplayWin();
				displayWin.createStage();
				timer.stop();
			}
			else {
				level++;
				changeLv(level);
			}
		}
	}

	public void changeLv(int level){
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
				if (frog.changeScore()) {
					setNumber(frog.getPoints());
				}
				showWinning();
				showGameOver();
				addLives();
				addLevel();
				System.out.println(level);


			}
		};
	}

}

		


	
	
	
	

