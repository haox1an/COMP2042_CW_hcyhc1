package Controller;

import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;

import java.lang.Class;
import java.util.ArrayList;


public abstract class Actor extends ImageView{

    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }
    
    public void reposition(double pos1, double pos2, double speed) {
    	if (getX() > 650 && speed >0)
			setX(pos1);
		if (getX() < -300 && speed <0)
			setX(pos2);
    }
    

    public World getWorld() {
        return (World) getParent();
    }


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
