package Controller;

import javafx.scene.image.ImageView;
import java.util.ArrayList;


/**
 * This is an abstract class for sprite
 * @author Chung Hao Xian
 */
public abstract class Actor extends ImageView{

    /**
     * This method allow sprite to move horizontally and vertically
     * @param dx speed moving horizontally
     * @param dy speed moving vertically
     */
    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }

    /**
     * This method reposition sprite when it is outside of the window
     * @param pos1 Set in position X
     * @param pos2 Set in position Y
     * @param speed Make sure the sprite is moving
     */
    public void reposition(double pos1, double pos2, double speed) {
    	if (getX() > 650 && speed >0)
			setX(pos1);
		if (getX() < -300 && speed <0)
			setX(pos2);
    }

    /**
     * This method return the Pane
     * @return (World) getParent()
     */
    public World getWorld() {
        return (World) getParent();
    }


    /**
     * This method is used to check intersection between two actors
     * @param cls object of class
     * @param <A> type of class
     * @return objectArray array containing actors intersected with
     */
    public <A extends Actor> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls){
        ArrayList<A> objectArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                objectArray.add(actor);
            }
        }
        return objectArray;
    }

    public abstract void act(long now);


}
