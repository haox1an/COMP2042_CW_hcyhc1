package Controller;


import java.util.ArrayList;
import java.util.List;
import javafx.scene.Node;
import javafx.scene.layout.Pane;


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
    

    
    public void add(Actor actor) {
        getChildren().add(actor);
    }
    
    public void add(Node node) {
    	getChildren().add(node);
    	
    }

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
