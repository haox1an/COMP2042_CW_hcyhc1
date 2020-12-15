package Controller;


import java.util.ArrayList;
import java.util.List;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

/**
 * This class is the pane and is used by all the Stages
 */

public class World extends Pane {
    
    public World() {
    	
    	sceneProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue != null) {
				newValue.setOnKeyReleased(event -> {
						if(getOnKeyReleased() != null)
						getOnKeyReleased().handle(event);
					List<Actor> myActors = getObjects(Actor.class);
					for (Actor anActor: myActors) {
						if (anActor.getOnKeyReleased() != null) {
							anActor.getOnKeyReleased().handle(event);
							}
					}
				});
				newValue.setOnKeyPressed(event -> {
					if(getOnKeyPressed() != null)
						getOnKeyPressed().handle(event);
					List<Actor> myActors = getObjects(Actor.class);
					for (Actor anActor: myActors) {
						if (anActor.getOnKeyPressed() != null) {
							anActor.getOnKeyPressed().handle(event);
						}
					}
				});
			}

		});
    }


	/**
	 * To add the actor to the pane
	 * @param actor actor to be added
	 */
	public void add(Actor actor) {
        getChildren().add(actor);
    }
	/**
	 * To add the node to the pane
	 * @param node node to be added
	 */
    public void add(Node node) {
    	getChildren().add(node);
    	
    }

	/**
	 * To remove the actor to the pane
	 * @param actor actor to be remove
	 */
    public void remove(Actor actor) {
        getChildren().remove(actor);
    }

    public <A extends Actor> List<A> getObjects(Class<A> cls) {
        ArrayList<A> objectArray = new ArrayList<A>();
        for (Node n: getChildren()) {
            if (cls.isInstance(n)) {
                objectArray.add((A)n);
            }
        }
        return objectArray;
    }

}
