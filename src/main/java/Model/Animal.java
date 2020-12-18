package Model;


import Controller.Actor;
import Controller.LevelInfo;
import Model.*;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

/**
 * This class is to create sprite where actor can control to achieve the objectives
 * @author Chung Hao Xian
 */

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

	/**
	 * This method stores numbers of images of the sprite(frog)
	 * @param num number represent the specific image of the sprite(frog)
	 * @return image of the sprite(frog)
	 */
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

	/**
	 * This method allows player to control the sprite with keyboard
	 * Mainly keys W,A,S,D
	 */
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

	/**
	 * This method set sprite's level
	 * @param level level of the game
	 */
	public void setFrogLevel(int level){
		this.frogLevel = level;
	}

	/**
	 * This method reposition the sprite to it's spawn location
	 */
	public void frogReposition() {
		setY(FrogPositionY);
		setX(FrogPositionX);		
		}

	/**
	 * This method display the animation of the sprite when the sprite intersect with different object
	 * Different animation will show, if intersect with different object ( water or car)
	 * @param now Time frame of the game
	 * @param type Type of animation to be shown
	 */
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


	/**
	 * This method prevent the sprite move out of the window
	 */
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

	/**
	 * This method record the points of the score
	 * @param point point of the sprite, will differ according to different movement
	 */
	public void addPoints(int point){
		this.points += point;
	}

	/**
	 * This method shown what happen if intersect with the 'end'(cave-like image)
	 */
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

	/**
	 * This method update the sprite according to frame at the moment of the time
	 * @param now current frame of the animation
	 */
	@Override
	public void act(long now) {

		checkIsFrogAtTheEdge();
			if (getIntersectingObjects(Car.class).size() >= 1 ||
				getIntersectingObjects(Truck.class).size() >= 1 ||
				getIntersectingObjects(LongTruck.class).size() >= 1)
				{
					intersectCar = true;
				}

			else if (getIntersectingObjects(Log.class).size() >= 1 && !death) {
				move(frogSpeed.ObjSpeed(frogLevel, 6), 0);
			}

			else if (getIntersectingObjects(LongLog.class).size() >= 1 && !death) {

				move(frogSpeed.ObjSpeed(frogLevel, 8), 0);
			}

			else if (getIntersectingObjects(Turtle.class).size() >= 1) {
				move(frogSpeed.ObjSpeed(frogLevel, 7), 0);
			}
			else if (getIntersectingObjects(WetTurtle.class).size() >= 1){
				if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
					intersectWater = true;
				} else {
					move(frogSpeed.ObjSpeed(frogLevel, 7), 0);
				}
			}
			 else if (getIntersectingObjects(End.class).size() >= 1) {

					IntersectEnd();
				}

			else if (getY() < waterPositionY) {
				intersectWater = true;
			}
			getlives();

			CheckIntersect(intersectCar, intersectWater, now);
		}

	/**
	 * This method check if the this sprite(frog) has intersected with other object
	 * @param intersectCar boolean check if intersected with car or truck
	 * @param intersectWater  boolean check if intersected with water
 	 * @param now current frame of the animation
	 */
	public void CheckIntersect(boolean intersectCar, boolean intersectWater, long now) {
			if(intersectCar)
				frogDeath(now, "car");
			if(intersectWater)
				frogDeath(now, "water");
		}

	/**
	 * check if the player has achieved the objectives
	 * @return boolean true to inform the system that player has completed
	 */
	public boolean getStop() {
		return end == 5;
	}

	/**
	 * Get the points of the player
	 * @return int points of player
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * Check if player has used up sprite's lives
	 * @return boolean true to inform the system that game over
	 */
	public boolean gameOver(){
		return this.lives < 1;
	}

	/**
	 * Get the 'lives' of the sprite
	 * @return int of live of sprite
	 */
	public int getlives(){
		return this.lives;
	}

	/**
	 * This method is use to reset the sprite back to initial state
	 */
	public void reset(){
		frogReposition();
		lives = 5;
		end = 0;
	}
}
