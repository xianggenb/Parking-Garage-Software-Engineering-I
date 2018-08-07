import java.util.Random;


import java.util.Scanner;
import java.io.*;
import java.sql.Time;
import java.sql.Timestamp;
public class OfficalTester

{
	public static void main(String[] args)
	{
		//Create the standard objects and specifiy the database that will be used 
		Bitmap y = new Bitmap();
		String URL = "jdbc:mysql://localhost:3306/reservations";
		String account = "root";
		String password = "Chesstyu100";
		Random rand;
		DataBaseAccessor DB = new DataBaseAccessor(URL,account,password);
		y.createLowerDeckBitmap();
		y.createUpperDeckBitmap();
		int[] spot = new int[2];
	while(true)
	{
	
		System.out.println("\nWelcome to the Arrival Tester");
		Scanner x = new Scanner(System.in);
		//Simulate either walk in lower deck, or upper deck with reservations
		System.out.println("Which Deck lower or upper?");
		String answer = x.nextLine();
		//If lower deck, just spit out the spot 
		if(answer.compareTo("lower") == 0)
		{
			y.findFirstAvailableSpot(spot, 1);
			int actualspot = spot[0]*31 + spot[1] + 1;
			System.out.println("Your spot is : " + actualspot);
			Time currenttime = new Time(System.currentTimeMillis());
			String u = currenttime.toString();
			DB.addTimetoLowerDeck(actualspot,u,"lowerdecktable");
			//Add this to the lowerdeck parkingspotdatabase
		}
		//Upper deck scenario
		else if(answer.compareTo("upper") == 0)
		{
			//First step in the branching paths, whether or not the licenseplate is in reservations DB
			System.out.println("Please Enter your License Plate(in place of License plate Scanner)");
			String LP = x.nextLine();
			int backup = DB.checkLicensePlate(LP,"reservationtable");
			//we need to make sure, someone isn't coming early
			if(backup == 1)
			{
				Timestamp current = new Timestamp(System.currentTimeMillis());
				Timestamp dateandtime = current;
				//first check if date and time works 
				int errorcheck = DB.retrieveTimeofReservation(LP,dateandtime , "reservationtable");
				if(errorcheck == -1)
				{
					//not sure what to do to be honest
				}
				//if not before, they need to leave
				if(!dateandtime.before(current))
				{
					System.out.println("Come back at the correct time");
				}
				
				
				y.findfirstAvaliableSpotUpperDeck(spot);
				System.out.println("Your spot is : " + (spot[0]*31 + spot[1] + 1));
			}
			
			
			int ismember = DB.checkLicensePlate(LP, "membershiptable");
			//if not then progress with a series of checks
			if(backup == -1)
			{
				//if this person is in the membership DB, has to be in order to be in reservations DB
				if(ismember == 1)
				{
					System.out.println("Do you have a reservation");
					answer = x.nextLine();
					//if they have a reservation, they get their spot
					if(answer.compareTo("yes") == 0)
					{
						y.findfirstAvaliableSpotUpperDeck(spot);
						System.out.println("Your spot is : " + (spot[0]*31 + spot[1] + 1));
						System.out.println("Please Enter your Confirmation Number");
						String temp = x.nextLine();
						backup = DB.checkConfirmationNumber("reservationtable",temp);
						if(backup == -1)
						{
							System.out.println("Please Back the Fuck up");
							
						}
					}
					//if no, either they want a reservation, or they back the FUCK out
					else if(answer.compareTo("no") == 0)
					{
						//If there are freespots we give them the option of making a reservation
						if(y.checkifFreespots(2) == 1)
						{
						// if they say no, GTFO
						System.out.println("Would you like to make a reservation");
						answer = x.nextLine();
						if(answer.compareTo("yes") == 0)
						{
							System.out.println("Please enter your licenseplate");
							String Licenseplate = x.nextLine();
							System.out.println("Please enter your zipcode");
							String zipcode = x.nextLine();
							System.out.println("Please enter your end time");
							String endtime = x.nextLine();
							String confirmationstring = Licenseplate + zipcode;
							long currenttime = System.currentTimeMillis();
							Timestamp xyz = new Timestamp(currenttime);
							String starttimeandDor = xyz.toString();
							DB.addtoReservationDataBase(Licenseplate,confirmationstring,starttimeandDor,endtime,"reservationtable");
						}
						if(answer.compareTo("No") == 0)
						{
							System.out.println("Back the Fuck up");
						}
						}
					}
					
					
				}
				
			}
			
			
		}
		
		
		
		
		
		
	}
	
	
	
	}
	
}
