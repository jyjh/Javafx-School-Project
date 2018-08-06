package appMain;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.*;
public class UserDetailsScreen {
	private final Label name = new Label("Tester");
	private final Label birthDate = new Label("1/1/1900");
	private final Button toReactionGame = new Button();
	private final GridPane screen = new GridPane();
	private final Stage primaryStage = new Stage();
	UserDetailsScreen(){
		primaryStage.setTitle("Main Menu");
		toReactionGame.setText("Reaction Time Test");
		screen.add(new Label("Name: "), 0, 0);
		screen.add(name, 1, 0);
		screen.add(new Label("Birthday: "), 0, 1);
		screen.add(birthDate, 1, 1);
		toReactionGame.setOnAction(new EventHandler<ActionEvent>() {
        	
            @Override
            public void handle(ActionEvent event) {
            	primaryStage.close();
            	ReactionMiniGame temp = new ReactionMiniGame();
                
            }
        });
		screen.add(toReactionGame, 0, 2);
		primaryStage.setScene(new Scene(screen, 300, 250));
        primaryStage.show();
	}
}
