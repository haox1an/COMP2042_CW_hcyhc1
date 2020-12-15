package Model;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;

/**
 * This class create the Start Button
 */

public class StartButton extends Button {
    private final int width = 450;
    private final int height =1000;

    ImageView StartButtonPressed = new ImageView(new Image("file:src/main/resources/Img/StartButtonPressed.png", width, height, true, true));
    ImageView StartButtonReleased = new ImageView(new Image("file:src/main/resources/Img/StartButtonReleased.png", width, height, true, true));



    private final String Button_Style1 = "-fx-background-color: transparent";

    /**
     * This constructor combine all the method to create help button
     * @param Xpos Position X of the button
     * @param Ypos Position Y of the button
     */
    public StartButton(double Xpos, double Ypos)
    {
        setGraphic(StartButtonReleased);
        setStyle(Button_Style1);
        setLayoutX(Xpos);
        setLayoutY(Ypos);
        initializeButtonListener();
    }

    /**
     * Set the style of the button when it's pressed
     */
    private void setButtonPressedStyle(){
        setGraphic(StartButtonPressed);

    }

    /**
     * Set the style of the button when it's not pressed
     */
    private void setButtonReleasedStyle(){
        setGraphic(StartButtonReleased);

    }

    /**
     * Change the style of button when it is interact with mouse button
     */
    private void initializeButtonListener() {
        setOnMousePressed(event -> {
            if(event.getButton().equals(MouseButton.PRIMARY))
            {
                setButtonPressedStyle();
            }
        });

        setOnMouseReleased(event -> {
            if(event.getButton().equals(MouseButton.PRIMARY))
            {
                setButtonReleasedStyle();
            }
        });
        setOnMouseEntered(event -> setButtonPressedStyle());
        setOnMouseExited(event -> setButtonReleasedStyle());
    }
}
