// Written by: Luke Miller
// Tested by: Luke Miller
// Debugged by: Luke Miller

package application;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import simulation.Garage;
import simulation.Reservation;
import simulation.Simulation;

public class LogScreenController {

	
//	@FXML Button logoutButton;
//	@FXML Button createUserButton;
//	@FXML Button deleteUserButton;
	@FXML ListView<String> ReservedList;
	@FXML ListView<String> ParkedList;
    
	private static ObservableList<String> obsList;
	private static ObservableList<String> obsList2;
	@FXML
	public void start(Stage mainStage) {
		
		obsList = FXCollections.observableArrayList();
		obsList2 = FXCollections.observableArrayList();
		
		ReservedList.setItems(obsList);


		
		//Looper();
		
	}
	
	
	public static void post(String message){
		
		Platform.runLater(new Runnable() {
	        @Override
	        public void run() {
	        	obsList.add(message);
	        }
	   });
		
	
	}
	
	public static void update(){
		
		obsList.clear();
		obsList2.clear();
		
		Iterator<Reservation> iter = Garage.GetReserved().iterator();
		Date date= new Date();
		Timestamp CurrentTime = new Timestamp(date.getTime());
		
		while(iter.hasNext()){
			
			Reservation R = iter.next();
			String Name = R.U.getFirstName() + " " + R.U.getLastName();
			//String Time = R.StartTime.getSeconds() - CurrentTime. + "";
			
			String Time = (R.StartTime.getTime() - CurrentTime.getTime())/60 + "";
			
			if(Integer.parseInt(Time) >= 0){
				obsList.add(Name + " [Arriving: " + Time + " Sec]");
			}else{
				obsList.add(Name);
			}
		}
		
		
		Iterator<Reservation> iter2 = Garage.GetParked().iterator();
		while(iter2.hasNext()){
			
			Reservation R = iter2.next();
			String Name = R.U.getFirstName() + " " + R.U.getLastName();
			//String Time = R.StopTime.getMinutes() - CurrentTime.getMinutes() + "";
			String Time = (R.StopTime.getTime() - CurrentTime.getTime())/60 + "";
			
			if(Integer.parseInt(Time) >= 0){
				obsList2.add(Name + " [Leaving: " + Time + " Sec]");
			}else{
				obsList2.add(Name);
			}
			
			
		}
		
		
		
	}
	
	
}
