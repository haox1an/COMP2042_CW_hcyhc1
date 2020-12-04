package Controller;

import java.util.ArrayList;
import java.util.List;

import Model.Car;
import Model.End;
import Model.Log;
import Model.LongLog;
import Model.LongTruck;
import Model.Truck;
import Model.Turtle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;


public class Animal extends Actor {

	public Image[] frog;

	public int lives = 5;
	public int points = 0;
	public int end = 0;
	
	private final double FrogPositionX = 300;
	private final double FrogPositionY = 750;
	private final double waterPositionY = 413;
	
	private final double movementY = 26.5;
	private final double movementX = 21.5;
	private final int FrogImgSize = 40;
	
	public boolean death = false;
	public boolean changeScore = false;
	public boolean intersectCar = false;
	public boolean intersectWater = false;
	public int DeathAnimationTime = 0;
	double w = 800;
	ArrayList<End> inter = new ArrayList<End>();
	public int totalscore;
	public int frogLevel = 1;
	LevelInfo frogSpeed = new LevelInfo();

	
	
	public Animal() {

		setImage(frogImg(0));
		frogReposition();
		keyListener();
	
	}

	public Image frogImg(int num){
		frog = new Image[8];
		frog[0] = new Image("file:src/main/java/Controller/froggerUp.png", FrogImgSize, FrogImgSize, true, true);
		frog[1] = new Image("file:src/main/java/Controller/froggerLeft.png", FrogImgSize, FrogImgSize, true, true);
		frog[2] = new Image("file:src/main/java/Controller/froggerDown.png", FrogImgSize, FrogImgSize, true, true);
		frog[3] = new Image("file:src/main/java/Controller/froggerRight.png", FrogImgSize, FrogImgSize, true, true);
		frog[4] = new Image("file:src/main/java/Controller/froggerUpJump.png", FrogImgSize, FrogImgSize, true, true);
		frog[5] = new Image("file:src/main/java/Controller/froggerLeftJump.png", FrogImgSize, FrogImgSize, true, true);
		frog[6] = new Image("file:src/main/java/Controller/froggerDownJump.png", FrogImgSize, FrogImgSize, true, true);
		frog[7] = new Image("file:src/main/java/Controller/froggerRightJump.png", FrogImgSize, FrogImgSize, true, true);
		return frog[num];
	}

		public void keyListener() {
		setOnKeyPressed(event -> {
			if(death) {}
			else 	{
			if (event.getCode() == KeyCode.W || event.getCode() == KeyCode.UP)
			{
				move(0, -movementY);
				setImage(frogImg(4));
				changeScore = true;
				points += 10;

			}

			if (event.getCode() == KeyCode.A || event.getCode() == KeyCode.LEFT)
			{
				move(-movementX, 0);
				setImage(frogImg(5));
			}

			if (event.getCode() == KeyCode.S || event.getCode() == KeyCode.DOWN)
			{
				move(0, movementY);
				setImage(frogImg(6));
			}

			if (event.getCode() == KeyCode.D || event.getCode() == KeyCode.RIGHT)
			{
				move(movementX, 0);
				setImage(frogImg(7));
			}

		}
			});
		setOnKeyReleased(event -> {
		if (death) {}
			else {
			if (event.getCode() == KeyCode.W || event.getCode() == KeyCode.UP) {
				changeScore = true;
				points+=10;
				setImage(frogImg(0));
				move(0, -movementY);
			}
			if (event.getCode() == KeyCode.A || event.getCode() == KeyCode.LEFT)  {
				 move(-movementX, 0);
				setImage(frogImg(1));
			}
			if (event.getCode() == KeyCode.S || event.getCode() == KeyCode.DOWN) {
				 move(0, movementY);
				setImage(frogImg(2));
			}
			if (event.getCode() == KeyCode.D || event.getCode() == KeyCode.RIGHT) {
				 move(movementX, 0);
				setImage(frogImg(3));
			}
		}
		});
	}
		
	public void frogReposition() {
		setY(FrogPositionY);
		setX(FrogPositionX);		
		}
	
	public void frogDeath(long now, String type) {
		String car = "car";
		String water = "water";
		death = true;
		changeScore = true;


		final Image[] cardeath = new Image[4];
		cardeath[0] = new Image("file:src/main/java/Controller/cardeath1.png", FrogImgSize, FrogImgSize, true, true);
		cardeath[1] = new Image("file:src/main/java/Controller/cardeath2.png", FrogImgSize, FrogImgSize, true, true);
		cardeath[2] = new Image("file:src/main/java/Controller/cardeath3.png", FrogImgSize, FrogImgSize, true, true);
		cardeath[3] = new Image("file:src/main/java/Controller/cardeath3.png", FrogImgSize, FrogImgSize, true, true);

		final Image[] waterdeath = new Image[4];
		waterdeath[0] = new Image("file:src/main/java/Controller/waterdeath1.png", FrogImgSize, FrogImgSize, true, true);
		waterdeath[1] = new Image("file:src/main/java/Controller/waterdeath2.png", FrogImgSize, FrogImgSize, true, true);
		waterdeath[2] = new Image("file:src/main/java/Controller/waterdeath3.png", FrogImgSize, FrogImgSize, true, true);
		waterdeath[3] = new Image("file:src/main/java/Controller/waterdeath4.png", FrogImgSize, FrogImgSize, true, true);

		Image[] array = new Image[4];
		if (type == car)
			array = cardeath;
		if (type == water)
			array = waterdeath;
			if ((now) % 15 == 0) {
				this.DeathAnimationTime++;
			}
			if (DeathAnimationTime == 1) {
				setImage(array[0]);
			}
			if (DeathAnimationTime == 3) {
				setImage(array[1]);
			}
			if (DeathAnimationTime == 5) {
				setImage(array[2]);
			}
			if (DeathAnimationTime == 7) {
				setImage(array[3]);
			}
			if (DeathAnimationTime == 9) {
				this.lives -= 1;
				frogReposition();
				intersectCar = false;
				intersectWater = false;
				this.DeathAnimationTime = 0;
				setImage(frog[0]);
				death = false;
				points-= 20;


			}

		}

	public void checkIsFrogAtTheEdge() {
		if (getY()<0 || getY()>800) {
			setY(FrogPositionY);	
		}
		if (getX()<-20) {
			move(movementX*2, 0);
		} else if (getX()>600) {
			move(-movementX*2, 0);
		}
		if (getY()<130 && ! ((getIntersectingObjects(End.class).size() >= 1))) {
			move(0, movementY*2);
			
		}
	}

	public void IntersectLongLog() {
		move(frogSpeed.frogSpeed(frogLevel, 1), 0);
	}

	public void IntersectLog() {
		move(frogSpeed.frogSpeed(frogLevel, 0), 0);
	}
	

	
	
	public void IntersectTurtle() {
		move(frogSpeed.frogSpeed(frogLevel, 2), 0);
	}

	public void IntersectEnd() {
		if (getIntersectingObjects(End.class).get(0).isEnd()) {
			this.end--;
			points -= 50;
		}
		points+=50;
		changeScore = true;
		getIntersectingObjects(End.class).get(0).setEnd();
		frogReposition();
		this.end++;
	}
	
	
	@Override
	public void act(long now) {

		checkIsFrogAtTheEdge();
			if (getIntersectingObjects(Car.class).size() >= 1 ||
				getIntersectingObjects(Truck.class).size() >= 1 ||
				getIntersectingObjects(LongTruck.class).size() >= 1)
				{
//					intersectCar = true;
				}

			else if (getIntersectingObjects(Log.class).size() >= 1 && !death) {
				IntersectLog();
			}

			else if (getIntersectingObjects(LongLog.class).size() >= 1 && !death) {
				IntersectLongLog();
			}

			else if (getIntersectingObjects(Turtle.class).size() >= 1) {
				if (getIntersectingObjects(Turtle.class).get(0).isSunk()) {
					intersectWater = true;
				} else {
					IntersectTurtle();
				}
			}
			 else if (getIntersectingObjects(End.class).size() >= 1) {

					IntersectEnd();
				}
//
//			else if (getY() < waterPositionY) {
//				intersectWater = true;
//			}
			getlives();

			CheckIntersect(intersectCar, intersectWater, now);
		}
	public void CheckIntersect(boolean intersectCar, boolean intersectWater, long now) {
			if(intersectCar)
				frogDeath(now, "car");
			if(intersectWater)
				frogDeath(now, "water");
		}

	public boolean getStop() {

		return end == 5;
	}
	
	public int getPoints() {
		return points;
	}
	
	public boolean changeScore() {
		if (changeScore){
			changeScore = false;
		return true;
	}
		return false;
	}
	
	public boolean gameOver(){
		return this.lives < 1;
	}

	public int getlives(){
		return this.lives;
	}

	public void reset(){
		frogReposition();
		lives = 5;
		end = 0;
		totalscore = this.points;

	}


}
