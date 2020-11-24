package Controller;

import java.util.ArrayList;

import Model.Car;
import Model.End;
import Model.Log;
import Model.LongLog;
import Model.LongTruck;
import Model.Truck;
import Model.Turtle;
import javafx.event.EventHandler;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class Animal extends Actor {

	public Image[] frog;
	
	public int points = 0;
	public int end = 0;
	
	private final double FrogPositionX = 300;
	private final double FrogPositionY = 750;
	private final double waterPositionY = 413;
	
	private final double movementY = 26.5;
	private final double movementX = 21.5;
	private final int FrogImgSize = 40;
	
	public boolean death = false;
	public boolean carDeath = false;
	public boolean waterDeath = false;
	public boolean changeScore = false;
	
	public int DeathAnimationTime = 0;
	double w = 800;
	ArrayList<End> inter = new ArrayList<End>();
	
	
	
	public Animal() {
		frog = new Image[8];
		frog[0] = new Image("file:src/View/froggerUp.png", FrogImgSize, FrogImgSize, true, true);
		frog[1] = new Image("file:src/View/froggerLeft.png", FrogImgSize, FrogImgSize, true, true);
		frog[2] = new Image("file:src/View/froggerDown.png", FrogImgSize, FrogImgSize, true, true);
		frog[3] = new Image("file:src/View/froggerRight.png", FrogImgSize, FrogImgSize, true, true);
		frog[4] = new Image("file:src/View/froggerUpJump.png", FrogImgSize, FrogImgSize, true, true);
		frog[5] = new Image("file:src/View/froggerLeftJump.png", FrogImgSize, FrogImgSize, true, true);
		frog[6] = new Image("file:src/View/froggerDownJump.png", FrogImgSize, FrogImgSize, true, true);
		frog[7] = new Image("file:src/View/froggerRightJump.png", FrogImgSize, FrogImgSize, true, true);
		setImage(frog[0]);
		frogReposition();
		keyListener();
		
	
	}

		public void keyListener() {
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if(death) {}
				else 	{
				if (event.getCode() == KeyCode.W || event.getCode() == KeyCode.UP)
				{
					move(0, -movementY);
					setImage(frog[4]);
				}
				
				if (event.getCode() == KeyCode.A || event.getCode() == KeyCode.LEFT)
				{
					move(-movementX, 0);
					setImage(frog[5]);
				}
				
				if (event.getCode() == KeyCode.S || event.getCode() == KeyCode.DOWN)
				{
					move(0, movementY);
					setImage(frog[6]);
				}
				
				if (event.getCode() == KeyCode.D || event.getCode() == KeyCode.RIGHT)
				{
					move(movementX, 0);
					setImage(frog[7]);					
				}

			}	
				}		
		});
		setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
			if (death) {}
				else {
				if (event.getCode() == KeyCode.W || event.getCode() == KeyCode.UP) {	  
						changeScore = true;
						points+=10;
						setImage(frog[0]);
						move(0, -movementY);
	            }
				if (event.getCode() == KeyCode.A || event.getCode() == KeyCode.LEFT)  {	            	
	            	 move(-movementX, 0);
	            	 setImage(frog[1]);
	            }
	            if (event.getCode() == KeyCode.S || event.getCode() == KeyCode.DOWN) {	            	
	            	 move(0, movementY);
	            	 setImage(frog[2]);
	            }
	            if (event.getCode() == KeyCode.D || event.getCode() == KeyCode.RIGHT) {	            	
	            	 move(movementX, 0);
	            	 setImage(frog[3]);
	            }
	        }
			}
		});
	}
		
	public void frogReposition() {
		setY(FrogPositionY);
		setX(FrogPositionX);		
		}
	
	public void frogDeath(long now, String TypeOfDeath) {
		String car = "car";
		String water = "water";
		
		Image[] cardeath = new Image[4];
		cardeath [0] = new Image("file:src/View/cardeath1.png", FrogImgSize, FrogImgSize, true, true);
		cardeath [1] = new Image("file:src/View/cardeath2.png", FrogImgSize, FrogImgSize, true, true);
		cardeath [2] = new Image("file:src/View/cardeath3.png", FrogImgSize, FrogImgSize, true, true);
		cardeath [3] = new Image("file:src/View/cardeath3.png", FrogImgSize, FrogImgSize, true, true);
		
		Image[] waterdeath = new Image[4];
		waterdeath [0] = new Image("file:src/View/waterdeath1.png", FrogImgSize,FrogImgSize , true, true);
		waterdeath [1] = new Image("file:src/View/waterdeath2.png", FrogImgSize,FrogImgSize , true, true);
		waterdeath [2] = new Image("file:src/View/waterdeath3.png", FrogImgSize,FrogImgSize , true, true);
		waterdeath [3] = new Image("file:src/View/waterdeath4.png", FrogImgSize,FrogImgSize , true, true);
		
		Image[] array = new Image[4];
		if(TypeOfDeath == car)
			array = cardeath;
		if(TypeOfDeath == water)
			array = waterdeath;
		
		if ((now)% 12 == 0) {
			this.DeathAnimationTime++;
		}
		if (DeathAnimationTime == 1) {
			setImage(array[0]);
		}
		if (DeathAnimationTime == 2) {
			setImage(array[1]);
		}
		if (DeathAnimationTime == 3) {
			setImage(array[2]);
		}
		if (DeathAnimationTime == 4) {
			setImage(array[3]);
		}
		if (DeathAnimationTime == 5) {
			this.DeathAnimationTime = 0;
			setImage(frog[0]);
			death = false;
			frogReposition();
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
	
	public void IntersectCar(long now) {
		death = true;
		frogDeath(now, "car");
		
		
	}
	
	public void IntersectLongLog() {
		move(-2, 0);	
	}

	public void IntersectLog() {
			move (.75,0);
	}
	

	
	
	public void IntersectTurtle() {
		move(-1,0);
	}
	
	public void IntersectWetTurtle(long now) {
		death = true;
		frogDeath(now, "water");
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
		if(getStop() == false) {
			if (getIntersectingObjects(Car.class).size() >= 1 ||
				getIntersectingObjects(Truck.class).size() >= 1 ||
				getIntersectingObjects(LongTruck.class).size() >= 1)
				{
				IntersectCar(now);
			}

			else if (getIntersectingObjects(Log.class).size() >= 1 && !death) {
				IntersectLog();
			}
			
			else if (getIntersectingObjects(LongLog.class).size() >= 1 && !death) {
				IntersectLongLog();
			}
			
			else if (getIntersectingObjects(Turtle.class).size() >= 1) {
				if (getIntersectingObjects(Turtle.class).get(0).isSunk()) {
					IntersectWetTurtle(now);
				} else {
					IntersectTurtle();
				}
			}
			else if (getIntersectingObjects(End.class).size() >= 1) {
				
					IntersectEnd();
				}
			
			else if (getY() < waterPositionY){
				death = true;
				frogDeath(now, "water");
			}
		}
	}
	public boolean getStop() {
		return end == 5;
	}
	
	public int getPoints() {
		return points;
	}
	
	public boolean changeScore() {
		if(changeScore == true) {
			changeScore = false;
			return true;
		}
		return false;
	}
	
	public void EndScene() {
		
		
		
	}
	

}
