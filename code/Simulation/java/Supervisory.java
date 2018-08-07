// Written by: Luke Miller
// Tested by: Luke Miller
// Debugged by: Luke Miller

package simulation;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;

import application.GraphicsController;
import application.LogScreenController;
import application.WindowDisplay;
import arrival.Bitmap;
import arrival.DataBaseAccessor;
import arrival.Interface;
import javafx.application.Platform;

public class Supervisory implements Runnable {

	Bitmap y;
	
	
	public void run() {
        
		//VIK
		
		
		try{
			y = new Bitmap();
			y.createUpperDeckBitmap();
			int size = 0;
			//DataBaseAccessor DB = new DataBaseAccessor(URL,account,password);
			String URL = "jdbc:mysql://localhost:3306/reservationdb";
			String account = "root";
			String password = "";
			DataBaseAccessor DB = new DataBaseAccessor(URL,account,password);
			size = DB.retreiveDailySpotBuffer("recurring");
			y.setupDailySpots(size);
		}catch(Exception e){System.out.println("Didn't Work");}
		
		
		
		
		//
		
		int cycles = 0;
		while(true){
			
			System.out.println("---");
			
			
			try{
			//if(Simulation.Lock == false){
			checkforArrivals();
			checkforDepartures();
			if(cycles > 3){
				UpdateGraphics();
			}
			cycles++;
			
			}catch(Error e){System.out.println("Lists are busy");}
			
			
			try {
				Thread.sleep(Simulation.ClockTick);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    }
	
	private void UpdateGraphics(){
		
		Platform.runLater(new Runnable() {
        @Override
        public void run() {
        	GraphicsController.update();
        }
   });
		
	}
	
	private void checkforArrivals(){
		
		//if(Simulation.ResLock.tryAcquire()){
		//Iterator<Reservation> iter = Garage.GetReserved().iterator();
		Iterator<Reservation> iter = Garage.Reserved.iterator();
		Iterator<Reservation> LateIter = Garage.LateArrival.iterator();
		//if(!Garage.Reserved.isEmpty()){
			
			Date date= new Date();
			Timestamp CurrentTime = new Timestamp(date.getTime());
			
			//Delay
			
			while(LateIter.hasNext()){
				
				Reservation Z = LateIter.next();
				if(User.randomWithRange(1, 10) == 5){
				
					
				
					if ((CurrentTime.getTime() - Z.StartTime.getTime())/1000 >= 5){


						Platform.runLater(new Runnable() {
					        @Override
					        public void run() {
					        	LogScreenController.post(Z.U.getFirstName() + " " + Z.U.getLastName() + " has missed the grace period");
					        }
					   });
						LateIter.remove();
						
						
					}
					
					else{
						
						
						if(Simulation.AutomateWebsite == true){
							//Interface.RunInterface(Z.U.VehList.get(0).getLicense(), -1);	
							
							
							//VIK CODE
							//Interface.RunInterface(Z.U.VehList.get(0).getLicense(), 1234, y);
							
							String License = Z.U.VehList.get(0).getLicense();
							UDPSend.sendVik(License);
							
							
						}
						
						//Remove reservation
						//Garage.ReservedRemove(R);
						LateIter.remove();
						//iter.remove();
						Garage.ParkedAdd(Z);
						//Remove reservation
						//GraphicsController.update();
						
						Platform.runLater(new Runnable() {
						@Override
						public void run() {
							GraphicsController.update();
						}
   });
						
						Platform.runLater(new Runnable() {
						    @Override
						    public void run() {
						    	LogScreenController.post(Z.U.getFirstName() + " " + Z.U.getLastName() + " has arrived within the grace period.");
						    }
   });
						
						
						
					}
					
					
				}
			}
			
				while(iter.hasNext()){
			
				//for(Reservation R:Garage.GetReserved()){
					
					Reservation R = iter.next();
					boolean Late = false;
					
					if(User.randomWithRange(1, 5) == 1){
						//flag this user for late arrival
						//Garage.Reserved.remove(R);
						iter.remove();
						Garage.LateArrival.add(R);
						
						
						Platform.runLater(new Runnable() {
					        @Override
					        public void run() {
					        	LogScreenController.post(R.U.getFirstName() + " " + R.U.getLastName() + " has not arrived on time.");
					        }
					   });
						
						Late = true;
					}
				
					if (CurrentTime.after(R.StartTime) && Late == false){
					//if (R.StartTime.after(CurrentTime)){
						System.out.println("Arrival Time: " + R);
						System.out.println("License: " + R.U.VehList.get(0).getLicense());
						Platform.runLater(new Runnable() {
					        @Override
					        public void run() {
					        	LogScreenController.post("New Arrival: " + R.U.getFirstName() + " " + R.U.getLastName());
					        }
					   });
						if(Simulation.AutomateWebsite == true){
							//Interface.RunInterface(R.U.VehList.get(0).getLicense(), -1);
							
							
							//VIK CODE
							//Interface.RunInterface(R.U.VehList.get(0).getLicense(), 1234, y);
						
							String License = R.U.VehList.get(0).getLicense();
							UDPSend.sendVik(License);
							
							
						}
						
						//Remove reservation
						//Garage.ReservedRemove(R);
						iter.remove();
						//iter.remove();
						Garage.ParkedAdd(R);
						//Remove reservation
						//GraphicsController.update();
						
						Platform.runLater(new Runnable() {
						@Override
						public void run() {
							GraphicsController.update();
						}
   });
					
					}
					
				}
			
		}
		
	
	private void checkforDepartures(){
		
		
		//System.out.println("Checking for departures");
		//Iterator<Reservation> iter3 = Garage.Parked.iterator();
		//Iterator<Reservation> iter4 = Garage.OverStay.iterator();
			
		//if(iter3.hasNext() || iter4.hasNext()){
		//if(!Garage.Parked.isEmpty()){
		//if(!Garage.Reserved.isEmpty()){
			
			Date date= new Date();
			Timestamp CurrentTime = new Timestamp(date.getTime());
			
			
				//Iterator<Reservation> iter1 = Garage.OverStay.iterator();
				
				//Reservation R = null;
				//while(iter1.hasNext()){
				//R = iter1.next();
				for(Reservation R:Garage.GetOverStay()){
					
					//if(User.randomWithRange(1, 6) == 4){
					if(((CurrentTime.getTime() - R.StopTime.getTime()/1000)/60) >= User.randomWithRange(1, 2)){ // change bsck to 10 60
						
						Garage.OverStayRemove(R); //User will leave 10-60 min after reservation
						System.out.println("Overstay: " + R.U + " has left LATE and paid: " + 2 *calculateAmountDue(R));
						Simulation.Profits += 2 * calculateAmountDue(R);
						
						Platform.runLater(new Runnable() {
					        @Override
					        public void run() {
					        	LogScreenController.post("Overstay: " + R.U.getFirstName() + " " + R.U.getLastName() + " has left LATE and paid: " + 2 *calculateAmountDue(R));
					        }
					   });
						
						//Frank's Code
						String License = R.U.VehList.get(0).getLicense();
						UDPSend.send(License);
						
						return;
						
					}
					
				}
				

				

				for(Reservation T: Garage.GetParked()){
				//for(Reservation R:Garage.GetReserved()){
					
					//System.out.println("Checking for departures blah blah");
					if(CurrentTime.after(T.StopTime)){
					
						System.out.println("After OverStay");
						//25% Chance of overstay
						//Change this bavk to 0 4
						if((User.randomWithRange(0, 4)) == 4){
							Garage.OverStayAdd(T);
							//Garage.ParkedAdd(T);
							Garage.ParkedRemove(T);
							System.out.println("User: " + T.U.UserID + " has decided to OverStay");
							Platform.runLater(new Runnable() {
						        @Override
						        public void run() {
						        	LogScreenController.post(T.U.getFirstName() + " " + T.U.getLastName() + " did not leave on time.");
						        }
						   });
							return;
						}
						
						else{
							Garage.ParkedRemove(T);
							System.out.println(T.U + " has left ON TIME and paid: " + calculateAmountDue(T));
							Simulation.Profits += calculateAmountDue(T);
							
							Platform.runLater(new Runnable() {
						        @Override
						        public void run() {
						        	LogScreenController.post(T.U.getFirstName() + " " + T.U.getLastName() + " has left ON TIME and paid: " + calculateAmountDue(T));
						        }
						   });
							
							//Frank's Code
							String License = T.U.VehList.get(0).getLicense();
							UDPSend.send(License);
							
							return;
						}
					}
					
				
			
			}
		
		//Simulation.ResLock.release();
		
		
		
	}
	
	private double calculateAmountDue(Reservation R){
		
		Date date= new Date();
		Timestamp CurrentTime = new Timestamp(date.getTime());
		
		long length = CurrentTime.getTime() - R.StartTime.getTime();
		//long length = R.StopTime.getTime() - R.StartTime.getTime();
		
		length = ((length/1000)/60)/60;
		if (length < 1){length = 1;}
		
		//System.out.println("Time Elapsed: " + length);
		
		double total = 0;
		
		for(Policy P:Garage.GaragePolicies){
			
			total = P.HourlyPrice * length;
			
		}
		
		return total;
	}
	
	
}
