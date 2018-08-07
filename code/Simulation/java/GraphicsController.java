// Written by: Luke Miller
// Tested by: Luke Miller
// Debugged by: Luke Miller

package application;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;

import com.jniwrapper.win32.process.ProcessMemoryCounters;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import simulation.Garage;
import simulation.Reservation;
import simulation.Simulation;

public class GraphicsController {

	
//	@FXML Button logoutButton;
//	@FXML Button createUserButton;
//	@FXML Button deleteUserButton;
	@FXML Label rescount;
	@FXML Label pcount;
	@FXML ListView<String> ReservedList;
	@FXML ListView<String> ParkedList;
    
	private static ObservableList<String> obsList;
	private static ObservableList<String> obsList2;
	@FXML
	public void start(Stage mainStage) {
		
		obsList = FXCollections.observableArrayList();
		obsList2 = FXCollections.observableArrayList();
		
		ReservedList.setItems(obsList);
		ParkedList.setItems(obsList2);
		
		//rescount.setText("1");
		
		//Looper();
		
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
			
			String Time = (R.StartTime.getTime() - CurrentTime.getTime())/1000 + "";
			
			if(Integer.parseInt(Time) >= 0){
				obsList.add(Name + " [Arriving: " + Time + " Sec]");
			}else{
				obsList.add(Name);
			}
		}
		
		Iterator<Reservation> lateiter = Garage.GetLateArrival().iterator();
		while(lateiter.hasNext()){
			
			Reservation R = lateiter.next();
			String Name = R.U.getFirstName() + " " + R.U.getLastName();
			//String Time = R.StartTime.getSeconds() - CurrentTime. + "";
			

				obsList.add(Name + " [Arriving: "+ "???]");
		}
		
		Iterator<Reservation> iter2 = Garage.GetParked().iterator();
		while(iter2.hasNext()){
			
			Reservation R = iter2.next();
			String Name = R.U.getFirstName() + " " + R.U.getLastName();
			//String Time = R.StopTime.getMinutes() - CurrentTime.getMinutes() + "";
			String Time = (R.StopTime.getTime() - CurrentTime.getTime())/1000 + "";
			
			if(Integer.parseInt(Time) >= 0){
				obsList2.add(Name + " [Leaving: " + Time + " Sec]");
			}else{
				obsList2.add(Name);
			}
			
			
		}
		
	}
	
	
}
