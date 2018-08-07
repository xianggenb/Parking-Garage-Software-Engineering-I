// Written by: Luke Miller
// Tested by: Luke Miller
// Debugged by: Luke Miller

package simulation;

public class Vehicle {
	
	public User U;
	private int VID;
	private String Make;
	private String Model;
	private int Year;
	private String License;
	
	public Vehicle(int VID, String License, String Make, String Model, int Year){
		this.VID = VID;
		this.License = License;
		this.Make = Make;
		this.Model = Model;
		this.Year = Year;
	}
	
	public void getInfo(){
		System.out.println("VID: " + VID);
		System.out.println("Make: " + Make);
		System.out.println("Model: " + Model);
		System.out.println("Year: " + Year);
		System.out.println("License :" + License);
	}
	
	public String getLicense(){
		return License;
	}

}
