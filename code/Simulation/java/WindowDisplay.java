// Written by: Luke Miller
// Tested by: Luke Miller
// Debugged by: Luke Miller

package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class WindowDisplay extends Application implements Runnable {
	@Override
	public void start(Stage primaryStage) {
		//Comment Out line 17 to start with empty Manager
				//Manager.loadManager();
				
				try {

				    
					FXMLLoader loader = new FXMLLoader();   
				      loader.setLocation(
				         getClass().getResource("LogDisplay.fxml"));
				      AnchorPane root = (AnchorPane)loader.load();
				      
				      LogScreenController photoController = loader.getController();
				      photoController.start(primaryStage);

				      Scene scene = new Scene(root, 452, 732);
				      primaryStage.setScene(scene);
				      primaryStage.show(); 
				      
				  
				      
				} catch(Exception e) {
					e.printStackTrace();
				}
				
				
				try {

				    Stage smallstage = new Stage();
					FXMLLoader loader = new FXMLLoader();   
				      loader.setLocation(
				         getClass().getResource("MainDisplay.fxml"));
				      AnchorPane root = (AnchorPane)loader.load();
				      
				      GraphicsController photoController = loader.getController();
				      photoController.start(primaryStage);

				      Scene scene = new Scene(root, 452, 274);
				      smallstage.setScene(scene);
				      smallstage.show(); 
				      
				  
				      
				} catch(Exception e) {
					e.printStackTrace();
				}
				
				
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.main(null);
		
	}
}
