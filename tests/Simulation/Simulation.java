// Written by: Luke Miller
// Tested by: Luke Miller
// Debugged by: Luke Miller

package simulation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

import application.GraphicsController;
import application.LogScreenController;
import application.WindowDisplay;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Simulation {

	//Defines global clock tick increment (Used by simulation and supervisory loop)
	public static int ClockTick = 1000; //1000ms = 1s
	static int CheckTime = 500; //1000ms = 1s
	static Semaphore ResLock;
	static int UserCount = 10;
	static int TotalMaxReservations = 10;
	static boolean Lock = false;
	static boolean AutomateWebsite = false;
	static int Profits = 0;
	
	public static void main(String[] args) throws IOException{
		
		//UDPSend.send("Hi!");
	
		
		WindowDisplay WD = new WindowDisplay();
		Thread t = new Thread(WD);
		t.start();
		
		try {
		    Thread.sleep(3000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		
		ResLock = new Semaphore(1);
		
		//System.out.println(Simulation.ResLock.availablePermits());
		
		System.out.println("Simulation Started");
		LogScreenController.post("Simulation Started");
		
		
		(new Thread(new Supervisory())).start();
		
		System.out.println("Supervisory Loop Started");
		LogScreenController.post("Supervisory Thread Started");
		
		Garage myGarage = new Garage("Park-A-Lot", 1, UserCount);
		Garage.Users = initUsers(UserCount);
		
		
		
		for (User U: Garage.Users){
			
			System.out.println(U.getFirstName() + " " + U.getLastName());
			LogScreenController.post("New User: " + U.getFirstName() + " " + U.getLastName());
			AccessWebsite.register(U.getFirstName(), U.getLastName(), U.UserID+"@gmail.com", U.ZipCode, U.ZipCode);
			
		}
		
		System.out.println(UserCount + " Users have been created");
		
		SetupPolicies();
		
		AccessWebsite.NewRate("Hourly Rate", "Always", 10);
		
		System.out.println("Hourly Rate has been set at 10 Dollars");
		//LogScreenController.post("Hourly Rate has been set at $10");
		for (User U: Garage.Users){
			U.addVehicle();
			LogScreenController.post("New Vehicle: " + U.getFirstName() + " " + U.getLastName() + " - " + U.VehList.get(0).getLicense());
			//Reservation R = generateNewReservation(U);
		}
		
		//Setup business account
		
		User Guy = Garage.Users.get(0);
		AccessWebsite.bregister("LukeCorp", "Miller", "doggy", "413 Fake Street", "NJ", "luke@lukecorp.com", 827, 93847);
		AccessWebsite.link(Guy.UserID+"@gmail.com", "password", "LukeCorp", "doggy");
		
		
		System.out.println("Each User now has a randomized vehicle");
		
		for (User U: Garage.Users){
			U.addPayment();
		}
		
		System.out.println("Each User now has a randomized payment method");
		
		for(int i = 0; i <= TotalMaxReservations; i++){ //Generate n Reservations
		//while(true){ //Generate Infinite Reservations
			randomlyGenerateReservation();
		}
		
		
		infiniteloop();
		
		
	}
	


	public static void infiniteloop(){
		
		while(true){
		System.out.println("Reservations: " + Garage.GetReserved().size());
		System.out.println("Parked Cars: " + Garage.GetParked().size());
		System.out.println("Profits: " + Simulation.Profits);
		System.out.println("...");
		
		try {
		    Thread.sleep(Simulation.ClockTick);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		}
	}
	public static void SetupPolicies(){
		
		//Set the Hourly Rate of the garage to 10 dollars
		Garage.GaragePolicies.add(new Policy(true, null, null, 10.00));
		
	}
	
	public static void randomlyGenerateReservation(){
		
		//Total Number of Reservations Cap
		if(Garage.GetReserved().size() >= TotalMaxReservations){
			
			try {
			    Thread.sleep(Simulation.ClockTick);                
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
			
			return;
		}
		
		int i = 0;	
		while (i != 10){
			
			System.out.println("Reservations: " + Garage.GetReserved().size());
			System.out.println("Parked Cars: " + Garage.GetParked().size());
			System.out.println("Profits: " + Simulation.Profits);
			System.out.println("...");
			i = User.randomWithRange(0, 10);
			
			try {
			    Thread.sleep(Simulation.ClockTick);                 //1000 milliseconds is one second.
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
			
			
		}
		
		int j = User.randomWithRange(0, Simulation.UserCount -1);
		Reservation newRes = Reservation.generateNewReservation(Garage.Users.get(j));
		
			if(!Garage.Users.get(j).ResList.isEmpty()){
				return;
			}

			Garage.Users.get(j).ResList.add(newRes);
			
			//System.out.println(Garage.Users.get(j).ResList);
			
			System.out.println("New Reservation: " + newRes.U + ", Start: " + newRes.StartTime + ",Stop: " + newRes.StopTime);
			System.out.println(Garage.Users.get(j).VehList.get(0).getLicense());
	
			
			if(User.randomWithRange(1, 5) == 3){
				AccessWebsite.NewRecReservation(Garage.Users.get(j).getFirstName(), Garage.Users.get(j).getLastName(), newRes.StartTime.toString(), newRes.StopTime.toString(), Garage.Users.get(j).VehList.get(0).getLicense());
			}
			else{
				AccessWebsite.NewReservation(Garage.Users.get(j).getFirstName(), Garage.Users.get(j).getLastName(), newRes.StartTime.toString(), newRes.StopTime.toString(), Garage.Users.get(j).VehList.get(0).getLicense());
			}
			
			//AccessWebsite.NewRecReservation(Garage.Users.get(j).getFirstName(), Garage.Users.get(j).getLastName(), newRes.StartTime.toString(), newRes.StopTime.toString(), Garage.Users.get(j).VehList.get(0).getLicense());
			Garage.ReservedAdd(newRes);
			Simulation.ResLock.release();
			Simulation.Lock = false;
			
			Platform.runLater(new Runnable() {
		        @Override
		        public void run() {
		        	GraphicsController.update();
		        }
		   });
			
			Platform.runLater(new Runnable() {
		        @Override
		        public void run() {
		        	LogScreenController.post("New Reservation: " + newRes.U.getFirstName() + " " + newRes.U.getLastName());
		        }
		   });
			
		
		
	}
	
	public static ArrayList<User> initUsers(int number){
		
		ArrayList<User> CustomerList = new ArrayList<User>();
		for (int i = 1; i <= number; i++){
			
			User U;
			
			if(!(i == 1)){ //The rest will be regular users
				U = new User();
			}
			else{//Create one business user
				U = new BusinessUser();
				//System.out.println(U);
			}
			
			boolean match = false;
			
			for(User M:CustomerList){
				if (U.UserID.equals(M.UserID)){
					match = true;
					i--;
					break;
				}
			}
			
			if(match == false){
				CustomerList.add(new User());
			}
		}
		
		return CustomerList;
	}
	

}
