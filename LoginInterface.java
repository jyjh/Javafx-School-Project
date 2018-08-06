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
 
public class LoginInterface extends Application {
	final Button login = new Button();
	final TextField loginuserTextField = new TextField();
	final PasswordField loginpasswordTextField = new PasswordField();
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Login");
        GridPane loginscreen = new GridPane();
        login.setText("Login");
        login.setOnAction(new EventHandler<ActionEvent>() {
        	
            @Override
            public void handle(ActionEvent event) {
            	
                if (FileInputOutputUserData.check(loginuserTextField.getText(), loginpasswordTextField.getText())) {
                UserDetailsScreen userdetails = new UserDetailsScreen();
                primaryStage.close();
            }
        }});
        loginscreen.add(new Label("Username: "), 0, 0);
        loginscreen.add(loginuserTextField, 1, 0);
        loginscreen.add(new Label("Password: "), 0, 1);
        loginscreen.add(loginpasswordTextField, 1, 1);
        loginscreen.add(login, 0, 2);
        primaryStage.setScene(new Scene(loginscreen, 300, 250));
        primaryStage.show();
    }
}