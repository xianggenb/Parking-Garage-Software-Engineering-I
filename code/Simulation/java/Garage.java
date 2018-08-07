// Written by: Luke Miller
// Tested by: Luke Miller
// Debugged by: Luke Miller

package simulation;

import java.util.ArrayList;

public class Garage {
	
	public String GarageName;
	public int GarageNumber;
	public int vacany;
	
	private static ArrayList<Reservation> Parked;
	public static ArrayList<Reservation> Reserved = new ArrayList<Reservation>();
	
	public static ArrayList<User> Users;
	public static ArrayList<Policy> GaragePolicies;
	
	private static ArrayList<Reservation> OverStay = new ArrayList<Reservation>();
	static ArrayList<Reservation> LateArrival = new ArrayList<Reservation>();
	
	public static synchronized void OverStayAdd(Reservation R){
		OverStay.add(R);
	}
	
	public static synchronized void OverStayRemove(Reservation R){
		OverStay.remove(R);
	}
	
	public static synchronized ArrayList<Reservation> GetOverStay(){
		return OverStay;
	}
	
	public static synchronized void LateArrivalAdd(Reservation R){
		LateArrival.add(R);
	}

	public static synchronized void LateArrivalRemove(Reservation R){
		LateArrival.remove(R);
	}
	
	public static synchronized ArrayList<Reservation> GetLateArrival(){
		return LateArrival;
	}
	
	public static synchronized void ParkedAdd(Reservation R){
		Parked.add(R);
	}

	public static synchronized void ParkedRemove(Reservation R){
		Parked.remove(R);
	}
	
	public static synchronized ArrayList<Reservation> GetParked(){
		return Parked;
	}
	
	public static synchronized void ReservedAdd(Reservation R){
		
		System.out.println("Called");
		Reserved.add(R);
	}

	public static synchronized void ReservedRemove(Reservation R){
		Reserved.remove(R);
	}
	
	public static synchronized ArrayList<Reservation> GetReserved(){
		return Reserved;
	}
	
	
	
	public Garage(String Name, int Number, int Vacancy){
		
		GarageName = Name;
		GarageNumber = Number;
		this.vacany = Vacancy;
		
		Parked = new ArrayList<Reservation>();
		Reserved = new ArrayList<Reservation>();
		Users = new ArrayList<User>();
		Garage.GaragePolicies = new ArrayList<Policy>();
		
	}
		
	
	
}
