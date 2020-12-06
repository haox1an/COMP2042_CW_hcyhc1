package Controller;


import Model.*;
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
	public boolean intersectCar = false;
	public boolean intersectWater = false;

	public int DeathAnimationTime = 0;

	public int frogLevel;
	LevelInfo frogSpeed = new LevelInfo();

	
	
	public Animal() {

		setImage(frogImg(0));
		frogReposition();
		keyListener();
	
	}

	public Image frogImg(int num){
		frog = new Image[8];
		frog[0] = new Image("file:src/main/resources/Img/froggerUp.png", FrogImgSize, FrogImgSize, true, true);
		frog[1] = new Image("file:src/main/resources/Img/froggerLeft.png", FrogImgSize, FrogImgSize, true, true);
		frog[2] = new Image("file:src/main/resources/Img/froggerDown.png", FrogImgSize, FrogImgSize, true, true);
		frog[3] = new Image("file:src/main/resources/Img/froggerRight.png", FrogImgSize, FrogImgSize, true, true);
		frog[4] = new Image("file:src/main/resources/Img/froggerUpJump.png", FrogImgSize, FrogImgSize, true, true);
		frog[5] = new Image("file:src/main/resources/Img/froggerLeftJump.png", FrogImgSize, FrogImgSize, true, true);
		frog[6] = new Image("file:src/main/resources/Img/froggerDownJump.png", FrogImgSize, FrogImgSize, true, true);
		frog[7] = new Image("file:src/main/resources/Img/froggerRightJump.png", FrogImgSize, FrogImgSize, true, true);
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
				addPoints(10);

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
				addPoints(-10);
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
				addPoints(10);
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
				addPoints(-10);
			}
			if (event.getCode() == KeyCode.D || event.getCode() == KeyCode.RIGHT) {
				 move(movementX, 0);
				setImage(frogImg(3));
			}
		}
		});
	}

	public void setFrogLevel(int level){
		this.frogLevel = level;
	}
		
	public void frogReposition() {
		setY(FrogPositionY);
		setX(FrogPositionX);		
		}
	
	public void frogDeath(long now, String type) {
		String car = "car";
		String water = "water";
		death = true;

		final Image[] cardeath = new Image[4];
		cardeath[0] = new Image("file:src/main/resources/Img/cardeath1.png", FrogImgSize, FrogImgSize, true, true);
		cardeath[1] = new Image("file:src/main/resources/Img/cardeath2.png", FrogImgSize, FrogImgSize, true, true);
		cardeath[2] = new Image("file:src/main/resources/Img/cardeath3.png", FrogImgSize, FrogImgSize, true, true);
		cardeath[3] = new Image("file:src/main/resources/Img/cardeath3.png", FrogImgSize, FrogImgSize, true, true);

		final Image[] waterdeath = new Image[4];
		waterdeath[0] = new Image("file:src/main/resources/Img/waterdeath1.png", FrogImgSize, FrogImgSize, true, true);
		waterdeath[1] = new Image("file:src/main/resources/Img/waterdeath2.png", FrogImgSize, FrogImgSize, true, true);
		waterdeath[2] = new Image("file:src/main/resources/Img/waterdeath3.png", FrogImgSize, FrogImgSize, true, true);
		waterdeath[3] = new Image("file:src/main/resources/Img/wwaterdeath4.png", FrogImgSize, FrogImgSize, true, true);

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
				addPoints(-100);


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

	public void addPoints(int point){
		this.points += point;
	}

	public void IntersectEnd() {
		if (getIntersectingObjects(End.class).get(0).isEnd()) {
			this.end--;
			addPoints(-100);
		}
		points+=100;
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
				move(frogSpeed.ObjSpeed(frogLevel, 6), 0);
			}

			else if (getIntersectingObjects(LongLog.class).size() >= 1 && !death) {

				move(frogSpeed.ObjSpeed(frogLevel, 8), 0);
			}

			else if (getIntersectingObjects(Turtle.class).size() >= 1) {
				if (getIntersectingObjects(Turtle.class).get(0).isSunk()) {
					intersectWater = true;
				} else {
					move(frogSpeed.ObjSpeed(frogLevel, 7), 0);
				}
			}
			 else if (getIntersectingObjects(End.class).size() >= 1) {

					IntersectEnd();
				}

			else if (getY() < waterPositionY) {
//				intersectWater = true;
			}
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
	}
}
