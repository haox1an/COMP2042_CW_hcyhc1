package Model;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.input.MouseButton;


/**
 * This class is used to create Quit button
 */
public class QuitButton extends Button{
	ImageView redButton;
	ImageView blackButton;
	private final int imgSize = 80;

	private final String Button_Style1 = "-fx-background-color: transparent";

	/**
	 * Constructor combined all the method to create quit button
 	 * @param Xpos Position X of button
	 * @param Ypos Position Y of button
	 */
	public QuitButton(double Xpos, double Ypos) 
	{
		blackButton = new ImageView(new Image("file:src/main/resources/Img/BlackButton3.png", imgSize, imgSize, true, true));
		redButton = new ImageView(new Image("file:src/main/resources/Img/RedButton3.png", imgSize, imgSize, true, true));
		setStyle(Button_Style1);
		setPrefSize(80,80);
		setGraphic(blackButton);
		initializeButtonListener();
		setLayoutX(Xpos);
		setLayoutY(Ypos);
	}

	/**
	 * Set the style of the button when it's pressed
	 */
	private void setButtonPressedStyle() {
		setGraphic(redButton);
		
	}

	/**
	 * Set the style of the button when it's not pressed
	 */
	private void setButtonReleasedStyle() {
		setGraphic(blackButton);
		
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
	
