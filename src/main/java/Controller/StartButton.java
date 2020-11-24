package Controller;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;


public class StartButton extends Button {
    private final int width = 450;
    private final int height =1000;

    ImageView StartButtonPressed = new ImageView(new Image("file:src/main/resources/Img/StartButtonPressed.png", width, height, true, true));
    ImageView StartButtonReleased = new ImageView(new Image("file:src/main/resources/Img/StartButtonReleased.png", width, height, true, true));



    private final String Button_Style1 = "-fx-background-color: transparent";

    public StartButton(double Xpos, double Ypos)
    {
        setGraphic(StartButtonReleased);
        setStyle(Button_Style1);
        setLayoutX(Xpos);
        setLayoutY(Ypos);
        initializeButtonListener();
    }

    private void setButtonPressedStyle(){
        setGraphic(StartButtonPressed);

    }

    private void setButtonReleasedStyle(){
        setGraphic(StartButtonReleased);

    }


    private void initializeButtonListener() {
        setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getButton().equals(MouseButton.PRIMARY))
                {
                    setButtonPressedStyle();
                }
            }
        });

        setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getButton().equals(MouseButton.PRIMARY))
                {
                    setButtonReleasedStyle();
                }
            }
        });


        setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                {
                    setButtonPressedStyle();
                }
            }
        });


        setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                {
                    setButtonReleasedStyle();
                }
            }
        });
    }
}
