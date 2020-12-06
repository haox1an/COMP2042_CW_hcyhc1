package Model;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.input.MouseButton;


public class QuitButton extends Button{
	ImageView redButton;
	ImageView blackButton;
	private final int imgSize = 80;

	private final String Button_Style1 = "-fx-background-color: transparent";
	
	
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

	public void setButtonPressedStyle() {
		setGraphic(redButton);
		
	}
	
	public void setButtonReleasedStyle() {
		setGraphic(blackButton);
		
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
	
