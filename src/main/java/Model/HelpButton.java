package Model;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;



public class HelpButton extends Button {
    private final int width = 80;
    private final int height = 80;

    ImageView HelpButtonPressed = new ImageView(new Image("file:src/main/resources/Img/HelpButtonPressed.png", width, height, true, true));
    ImageView HelpButtonReleased = new ImageView(new Image("file:src/main/resources/Img/HelpButton.png", width, height, true, true));



    private final String Button_Style1 = "-fx-background-color: transparent";

    public HelpButton(double Xpos, double Ypos)
    {
        setGraphic(HelpButtonReleased);
        setStyle(Button_Style1);
        setPrefSize(80,80);
        setLayoutX(Xpos);
        setLayoutY(Ypos);
        initializeButtonListener();
    }

    private void setButtonPressedStyle(){
        setGraphic(HelpButtonPressed);

    }

    private void setButtonReleasedStyle(){
        setGraphic(HelpButtonReleased);

    }


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
