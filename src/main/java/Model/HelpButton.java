package Model;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;

/**
 * This class create the Help Button
 */

public class HelpButton extends Button {
    private final int width = 80;
    private final int height = 80;

    ImageView HelpButtonPressed = new ImageView(new Image("file:src/main/resources/Img/HelpButtonPressed.png", width, height, true, true));
    ImageView HelpButtonReleased = new ImageView(new Image("file:src/main/resources/Img/HelpButton.png", width, height, true, true));

    private final String Button_Style1 = "-fx-background-color: transparent";

    /**
     * This constructor combine all the method to create help button
     * @param Xpos Position X of the button
     * @param Ypos Position Y of the button
     */
    public HelpButton(double Xpos, double Ypos)
    {
        setGraphic(HelpButtonReleased);
        setStyle(Button_Style1);
        setPrefSize(80,80);
        setLayoutX(Xpos);
        setLayoutY(Ypos);
        initializeButtonListener();
    }

    /**
     * Set the style of the button when it's pressed
     */
    private void setButtonPressedStyle(){
        setGraphic(HelpButtonPressed);

    }

    /**
     * Set the style of the button when it's not pressed
     */
    private void setButtonReleasedStyle(){
        setGraphic(HelpButtonReleased);

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
