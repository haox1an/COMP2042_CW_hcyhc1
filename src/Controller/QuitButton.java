package Controller;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class QuitButton extends Button{
	ImageView redButton;
	ImageView blackButton;
	private final int imgSize = 80;

	private final String Button_Style1 = "-fx-background-color: transparent";
	
	
	public QuitButton(double Xpos, double Ypos) 
	{
		blackButton = new ImageView(new Image("file:src/Controller/BlackButton3.png", imgSize, imgSize, true, true));
		redButton = new ImageView(new Image("file:src/Controller/RedButton3.png", imgSize, imgSize, true, true));
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
	
