package View;


import java.util.List;

import Controller.Actor;
import Controller.Animal;
import Controller.MyStage;
import Model.BackgroundImage;
import Model.Car;
import Model.Digit;
import Model.End;
import Model.Log;
import Model.LongLog;
import Model.LongTruck;
import Model.Truck;
import Model.Turtle;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class DisplayGame{
	AnimationTimer timer;
	Scene gameScene;
	MyStage gamePane;
	Animal frog;
	Stage gameStage;
	
	final int endSceneYPos = 108;
	final int GridY = 55;
	
	
	public DisplayGame(){
		
		gamePane = new MyStage();
		gameScene = new Scene(gamePane,600,800);
		gameStage = new Stage();
		gameStage.setScene(gameScene);
		createBackground();
		addObstacles();
		addFrog();
		addEndImg();
		timerstart();
	}
	
	
	
	public void addObstacles() {
		int[] lane = new int[11];
		for (int i = 0; i < lane.length; i++)
		{
			lane[i] = 704 - GridY*(i);
		}
		//row0
		gamePane.add(new Car(0,lane[0],-2));
		
		//row1 
		gamePane.add(new Truck(0,lane[1],3));
		gamePane.add(new Truck(300,lane[1],3));
		
		//row2
		gamePane.add(new Car(100,lane[2],1));
		gamePane.add(new Car(300,lane[2],1));
		gamePane.add(new Car(500,lane[2],1));
		
		
		//row3
		gamePane.add(new LongTruck(100,704-GridY*3,-1));
		gamePane.add(new Car(500,704-GridY*3,-1));
		
		
		//row4
		gamePane.add(new Car (0,704-GridY*4,-2));
		
		//row5
		gamePane.add(new Turtle(500, 704-GridY*6, -1));
		gamePane.add(new Turtle(300, 704-GridY*6, -1));
		gamePane.add(new Turtle(700, 704-GridY*6, -1));
		
		//row6
		gamePane.add(new Log(50, 704-GridY*7, 0.75));
		gamePane.add(new Log(270, 704-GridY*7, 0.75));
		gamePane.add(new Log(490, 704-GridY*7, 0.75));
		
		//row7
		gamePane.add(new Turtle(600, 217, -1));
		gamePane.add(new Turtle(400, 217, -1));
		gamePane.add(new Turtle(200, 217, -1));
		
		//row8
		gamePane.add(new LongLog(0, 276, -2));
		gamePane.add(new LongLog(400, 276, -2));
		
		//row9
		gamePane.add(new Log(0, 166, 0.75));
		gamePane.add(new Log(220, 166, 0.75));
		gamePane.add(new Log(440, 166, 0.75));
	}
	
	public void addEndImg() {
		gamePane.add(new End(15));
		gamePane.add(new End(143));
		gamePane.add(new End(271));
		gamePane.add(new End(399));
		gamePane.add(new End(527));
	}

	public void createBackground() {
		BackgroundImage gameBackground = new BackgroundImage("file:src/View/iKogsKW.png");
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
		Digit digit = new Digit(0,30,360,25);
		gamePane.add(digit);
	}
	
	public void addMusic() {
		gamePane.playMusic();
	}
	

	
	public void gameTimer() {
		 timer = new AnimationTimer() {
	            @Override
	            public void handle(long now) {
					List<Actor> actors = gamePane.getObjects(Actor.class);
					
					for (Actor anActor: actors) {
						anActor.act(now);
					}
	            	if (frog.changeScore()) {
	            		setNumber(frog.getPoints());
	            	}
	            	if (frog.getStop()) {
	            		System.out.print("STOPP");
//	            		gamePane.stopMusic(); 
	            		// stop();
	            		timer.stop();
	   	        		Alert alert = new Alert(AlertType.INFORMATION);
	            		alert.setTitle("You Have Won The Game!");
//	            		alert.setHeaderText("Your High Score: "+frog.getPoints()+"!");
//	            		alert.setContentText("Highest Possible Score: 800");
	            		alert.show();
	            	}
	            }
	        };
	    }
		
	public void timerstart() {
		gameTimer();
		timer.start();
				}
	

		public void setNumber(int n) {
			int shift = 0;
			while (n > 0) {
				  int d = n / 10;
				  int k = n - d * 10;
				  n = d;
				  gamePane.add(new Digit(k, 30, 360 - shift, 25));
				  shift+=30;
				}
		}
		
		}

		


	
	
	
	

