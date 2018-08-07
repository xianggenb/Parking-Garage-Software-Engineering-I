// Written by: Luke Miller
// Tested by: Luke Miller
// Debugged by: Luke Miller

package simulation;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

public class User {
	
	private String Name;
	public int ZipCode;
	public String UserID;
	private String Password;
	
	ArrayList<Reservation> ResList;
	ArrayList<Vehicle> VehList;
	ArrayList<PaymentMethod> PaymentMethods;
	
	public User(){
		this.Name = selectName();
		this.ZipCode = selectZip();
		this.UserID = selectUserName();
		this.Password = selectUserName();
		
		ResList = new ArrayList<Reservation>();
		VehList = new ArrayList<Vehicle>();
		PaymentMethods = new ArrayList<PaymentMethod>();
		
	}
	
	public String toString(){
		
		return UserID;
		
	}
	
	public String getFirstName(){
		
		String First = Name.substring(0, Name.indexOf(' '));
		return First;
	}
	
	public String getLastName(){
		return Name.substring(Name.indexOf(' '), Name.length());
	}
	
	public void addVehicle(){
		
		int VID = randomVID();
		String License = randomLicense();
		String Make = randomMake();
		String Model = randomModel();
		int Year = randomWithRange(1990,2016);
		
		
		Vehicle V = new Vehicle(VID, License, Make, Model, Year) ;
		VehList.add(V);
		
		AccessWebsite.addVehicle(UserID+"@gmail.com", Password, Make, Model, Year, License);
		
	}
	
	public void addPayment(){
		
		
		String CardNumber = randomCard();
		String SecurityCode = randomSecurity();
		
		PaymentMethods.add(new PaymentMethod("Visa", CardNumber, Name, "07/18", SecurityCode));
		AccessWebsite.addPayment(UserID+"@gmail.com", "password", Name, CardNumber, "07/18", SecurityCode);
		
	}
	
	private String randomMake(){
		
		String UserName = "";
		
		
		int F = randomWithRange(1,10);
		switch(F){
		
		case 1:
			UserName += "Subaru";
			break;
			
		case 2:
			UserName += "Ford";
			break;
			
		case 3:
			UserName += "Tesla";
			break;
			
		case 4:
			UserName += "Chevy";
			break;
			
		case 5:
			UserName += "Toyota";
			break;
			
		case 6:
			UserName += "Honda";
			break;
			
		case 7:
			UserName += "Mercury";
			break;
			
		case 8:
			UserName += "Lexus";
			break;
			
		case 9:
			UserName += "Mitsubishi";
			break;
			
		case 10:
			UserName += "Saturn";
			break;
		
		}
		
		return UserName;
		
		
	}
	
	
	private String randomModel(){
		
		String UserName = "";
		
		
		int F = randomWithRange(1,10);
		switch(F){
		
		case 1:
			UserName += "Charger";
			break;
			
		case 2:
			UserName += "Outback";
			break;
			
		case 3:
			UserName += "Forester";
			break;
			
		case 4:
			UserName += "Model D";
			break;
			
		case 5:
			UserName += "Lancer";
			break;
			
		case 6:
			UserName += "Civic";
			break;
			
		case 7:
			UserName += "Model D";
			break;
			
		case 8:
			UserName += "Camry";
			break;
			
		case 9:
			UserName += "Impreza";
			break;
			
		case 10:
			UserName += "Escape";
			break;
		
		}
		
		return UserName;
		
		
	}
	
	private int randomVID(){
		
		Random rnd = new Random();
		return 10000 + rnd.nextInt(90000);
		
	}
	
	private String randomCard(){
		
		String Card = "";
		
		for(int i = 1; i <= 4; i++){
			Random r = new Random();
			Card += r.nextInt(8)+1;
		}
		
		Card += "-";
		
		for(int i = 1; i <= 4; i++){
			Random r = new Random();
			Card += r.nextInt(8)+1;
		}
		
		Card += "-";
		for(int i = 1; i <= 4; i++){
			Random r = new Random();
			Card += r.nextInt(8)+1;
		}
		
		Card += "-";
		
		for(int i = 1; i <= 4; i++){
			Random r = new Random();
			Card += r.nextInt(8)+1;
		}
		
		return Card;
		
	}
	
	private String randomSecurity(){
		
		String Sec = "";
		
		for(int i = 1; i <= 3; i++){
			Random r = new Random();
			Sec += r.nextInt(8)+1;
		}
		
		return Sec;
		
	}
	
	private String randomLicense(){
		
		String License = "";
		
		for(int i = 1; i <= 3; i++){
			Random r = new Random();
			char c = (char)(r.nextInt(26) + 'a');
			License += c;
		}
		
		License += "-";
		
		for(int i = 1; i <= 3; i++){
			Random r = new Random();
			char c = (char)(r.nextInt(26) + 'a');
			License += c;
		
		}
		
		return License;
	}
	
	public void details(){
		
		System.out.println("Name: " + Name);
		System.out.println("ZipCode: " + ZipCode);
		System.out.println("UserID: " + UserID);
	}
	
	public String selectUserName(){
		
		String UserName = "";
		
		for (int i = 0; i < 3; i++){
		
		int F = randomWithRange(1,10);
		switch(F){
		
		case 1:
			UserName += "Dog";
			break;
			
		case 2:
			UserName += "2";
			break;
			
		case 3:
			UserName += "Cat";
			break;
			
		case 4:
			UserName += "Shrimp";
			break;
			
		case 5:
			UserName += "Blue";
			break;
			
		case 6:
			UserName += "Green";
			break;
			
		case 7:
			UserName += "88";
			break;
			
		case 8:
			UserName += "Sky";
			break;
			
		case 9:
			UserName += "Dancer";
			break;
			
		case 10:
			UserName += "Car";
			break;
		
		}
		}
		
		return UserName;
	}
	
	public int selectZip(){
		
		Random rnd = new Random();
		return 10000 + rnd.nextInt(90000);
		
	}
	
	public String selectName(){
		
		int F = randomWithRange(1,10);
		int L = randomWithRange(1,10);
		String First = "";
		String Last = "";
		
		switch(F){
		
		case 1:
			First = "Bob";
			break;
			
		case 2:
			First = "Jane";
			break;
			
		case 3:
			First = "George";
			break;
			
		case 4:
			First = "Linda";
			break;
			
		case 5:
			First = "Sam";
			break;
			
		case 6:
			First = "Sally";
			break;
			
		case 7:
			First = "Garth";
			break;
			
		case 8:
			First = "Christina";
			break;
			
		case 9:
			First = "David";
			break;
			
		case 10:
			First = "Beth";
			break;
		
		}
		
		
		
		switch(L){
		
		case 1:
			Last = "Jones";
			break;
			
		case 2:
			Last = "Miller";
			break;
			
		case 3:
			Last = "Cohen";
			break;
			
		case 4:
			Last = "Smith";
			break;
			
		case 5:
			Last = "Rockford";
			break;
			
		case 6:
			Last = "LaForge";
			break;
			
		case 7:
			Last = "Meadows";
			break;
			
		case 8:
			Last = "Summers";
			break;
			
		case 9:
			Last = "Johnson";
			break;
			
		case 10:
			Last = "Brown";
			break;
		
		}
		
		return First + " " + Last;
		
	}
	
	public static int randomWithRange(int min, int max)
	{
	   int range = (max - min) + 1;     
	   return (int)(Math.random() * range) + min;
	
	}

}
