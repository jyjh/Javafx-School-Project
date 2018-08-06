package appMain;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.time.Instant;
public class ReactionMiniGame {
	private Random random = new Random();
	private Button clicktomeasure = new Button("Start");
	private Button end = new Button("Click!");
	private Button returnMenu = new Button("Return to Main Menu");
	private final Stage primaryStage = new Stage();
	private final BorderPane screen = new BorderPane();
	private int rando; 
	private long  start;
	private long ends;
	private long score = 0;
	private Label scoreText = new Label();
	private HBox top = new HBox();
	
	public ReactionMiniGame() {
		primaryStage.setTitle("Main Menu");
		screen.setBottom(returnMenu);
		top.getChildren().addAll(clicktomeasure,scoreText);
		screen.setTop(top);
		screen.setCenter(end);
		screen.setStyle("-fx-background-color: #FFFFFF;");
		clicktomeasure.setOnAction(new EventHandler<ActionEvent>() {
        	
            @Override
            public void handle(ActionEvent event) {
            	try {
					StartGame();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
            }
        });
		end.setOnAction(new EventHandler<ActionEvent>() {
        	
            @Override
            public void handle(ActionEvent event) {
            	EndGame();
            }
        });
		returnMenu.setOnAction(new EventHandler<ActionEvent>() {
        	
            @Override
            public void handle(ActionEvent event) {
            	UserDetailsScreen temp = new UserDetailsScreen();
                primaryStage.close();
            }
        });
		primaryStage.setScene(new Scene(screen,350,400));
		primaryStage.show();
	}
	private void StartGame() throws InterruptedException {
		end.setDisable(true);
		rando = random.nextInt(5000)+1000;
		start = Instant.now().toEpochMilli();
		TimeUnit.MILLISECONDS.sleep(rando);
		end.setDisable(false);
		screen.setStyle("-fx-background-color: #A0C4FF;");
		
	}
	private void EndGame() {
		ends = Instant.now().toEpochMilli();
		screen.setStyle("-fx-background-color: #FFFFFF;");
		score = ends-start-rando;
		scoreText.setText("Score: "+score+"ms");
		System.out.println(""+score);
	}
}
