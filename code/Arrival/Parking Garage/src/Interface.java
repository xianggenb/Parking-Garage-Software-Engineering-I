import java.util.Date;
import java.util.Random;


import java.util.Scanner;
import java.io.*;
import java.sql.Time;
import java.sql.Timestamp;
public class Interface {
	
	Bitmap y;
	
	
	
	public static void main(String[] args)
	{
		Bitmap2 U = new Bitmap2();
		U.createUpperDeckBitmap();
		int size = 0;
		//DataBaseAccessor DB = new DataBaseAccessor(URL,account,password);
		String URL = "jdbc:mysql://localhost:3306/reservations";
		String account = "root";
		String password = "Chesstyu100";
		DataBaseAccessor DB = new DataBaseAccessor(URL,account,password);
		size = DB.retreiveDailySpotBuffer("dailytable");
		U.setupDailySpots(size);
		
		Scanner yz = new Scanner(System.in);
		int x = 0;
		System.out.println("Which test case do you want run");
		x = yz.nextInt();
		
		if(x == 1)
		{
			RunInterface("AB-123",2,U);
			RunInterface("ABCEDDE-5679",213213,U);
			RunInterface("ABCDE-5679",2,U);
		
			RunInterface("ABC-789",1235675,U);
			RunInterface("ABC-1",1,U);
			RunInterface("ABC-2",1,U);
			RunInterface("ABC-2",1,U);
			RunInterface("jkjk",1234567895,U);
			int spotnumber = -1;
			spotnumber = DB.changeStatetoFree("spottable","ABC-1" ,spotnumber);
			DB.getFreeSpots("spottable");
			//System.out.println(spotnumber);
			int a = spotnumber/31;
			int b = spotnumber%31;
			int[] c = new int[2];
			c[0] = a;
			c[1] = b;
			U.changeSpotToFreeorOccupied(c,2);
			RunInterface("ABC-2",1,U);
			DB.deleteSpotsDB("spottable");
		}
		
		if(x == 2)
		{	
			RunInterface("DGH-123",1,U);
			RunInterface("ABC-889",1,U);
			RunInterface("ABC-4567",1,U);
			DB.deleteSpotsDB("spottable");
		}
		
		if(x == 3)
		{
			
		for(int i = 0; i < 29; i++)
		{
			RunInterface("ABC-1",1,U);
		}

		//RunInterface("ABC-4567",1,U);
		System.out.println(U.numberofspotstaken + ":" +  U.numberofdailyspots);
		RunInterface("bgh",1,U);
		RunInterface("ABC-567",1,U);
		RunInterface("GHJ-878",1,U);
		DB.carArrivedDailySpots("dailytable", "GHJ-878");
		DB.deleteSpotsDB("spottable");
		//System.out.println(U.numberofspotstaken + ":" +  U.numberofdailyspots);
		//RunInterface("DGH-123",1,U);
		}
		
		
		
	}
	
	
	
	
	public static boolean RunInterface(String LP, int confirmationnumber, Bitmap2 y)
	{
		String URL = "jdbc:mysql://localhost:3306/reservations?useSSL=false" ;
		String account = "root";
		String password = "Chesstyu100";
		int size = 0;
		//DataBaseAccessor DB = new DataBaseAccessor(URL,account,password);
		
		DataBaseAccessor DB = new DataBaseAccessor(URL,account,password);
		
		
			
		int[] spot = new int[2];
		int reservationmember = DB.checkLicensePlate(LP,"reservations");
		//System.out.println(reservationmember);
		int recurringmember = DB.checkLicensePlate(LP, "dailytable");
		int value;
		while(true)
		{
		value = DB.getFreeSpots("spottable");
		if(value == -1)
		{
			break;
		}
		System.out.println(value);
		int a = value/31;
		int b = value%31;
		int[] c = new int[2];
		c[0] = a;
		c[1] = b;
		y.changeSpotToFreeorOccupied(c,2);
		
		 
		}
		
		if(recurringmember == 1)
		{
			Timestamp currentime = new Timestamp(System.currentTimeMillis());
			Timestamp xyz = currentime;
			
			xyz = DB.RetrieveTimeofReservation(LP,"dailytable");
			if(System.currentTimeMillis() - xyz.getTime() >= 1800000 )
			{
				System.out.println("You missed your your grace period, please come on time sooner");
				int check = DB.retreiveStateofDailySpot("dailytable", LP);
				if(check == 1)
				{
					System.out.println("Your spot was given since you messed the grace period, please come on time, we are looking for a new spot");
					
				}
				
				
				if(DB.determineWhoLosesTheirSpot("dailytable") == -1)
				{
					System.out.println("We apologize, but the only spots remaining are those premium members who did not violate the grace period");
					return false;
				}
			}
			//System.out.println(xyz.toString());
			if(currentime.before(xyz))
			{
				System.out.println("Come back at the scheduled time");
				return false;
			}
			
			
			if(y.spotsleft() == 3 || y.spotsleft() == 2)
			{
				int c = y.findFirstAvailableSpot(spot, 2,0);
				
			}
			
			
			else if(y.spotsleft() == 4)
			{
				int check = DB.retreiveStateofDailySpot("dailytable", LP);
				if(check == 1)
				{
					System.out.println("Your spot was given since you messed the grace period, please come on time, we are looking for a new spot");
					
				}
				
				
				if(DB.determineWhoLosesTheirSpot("dailytable") == -1)
				{
					System.out.println("We apologize, but the only spots remaining are those premium members who did not violate the grace period");
					return false;
				}
				
				
				int c = y.findFirstAvailableSpot(spot, 2,0);
			}
			
			else if(y.spotsleft() == 1)
			{
				System.out.println("We are sorry, no more spots are left and you messed your grace period");
				return false;
			}
			
			
			int spotnum = (spot[0] * 31) + spot[1] + 1;
			DB.addtoUpperSpotsDataBase(LP, spotnum, "spottable");
			System.out.println("Here is your spot: " + (spot[0]*31 + spot[1] + 1));
			//System.out.println("Here is your spot: " + (spot[0]*31 + spot[1] + 1));
			return true;
		}
		
		
		
		if(reservationmember == -1)
		{
			//if confirmationnumber is -1, means someone made a spelling problem
			
			
			
			if(confirmationnumber == -1)
			{
				System.out.println("License Plate is not in Reservation Database, back up");
				return false;
			}
			
			
			else
			{
				int check = DB.checkConfirmationNumber("reservations", confirmationnumber);
				//System.out.println(":" + check);
				if(check == -1)
				{
					System.out.println("Invalid Confirmation Number, please back up");
					return false;
				}
			}
		}
		
			
			
			Timestamp currentime = new Timestamp(System.currentTimeMillis());
			Timestamp xyz = currentime;
			
			if(reservationmember == 1)
			xyz = DB.retrieveTimeofReservation(LP,"reservations",0,-1);
			else if(reservationmember == -1)
				xyz = DB.retrieveTimeofReservation(LP,"reservations",1,confirmationnumber);
			//System.out.println(xyz.toString());
			if(currentime.before(xyz))
			{
				System.out.println("Come back at the scheduled time");
				return false;
			}
			
			if(y.spotsleft() == 1)
			{
				System.out.println("We apologize, but currently all spots are taken");
				return false;
			}
			
			else if(y.spotsleft() == 3)
			{
				y.findFirstAvailableSpot(spot, 2,1);
			}
			
			else if(y.spotsleft() == 2 || y.spotsleft() == 4)
			{
					int u = DB.determineWhoLosesTheirSpot("dailytable");
					//System.out.println("reached");
					//System.out.println(u);
					if(u == 1)
					{
						y.findFirstAvailableSpot(spot, 2, 0);
						//return true;
					}
				
					else
					{
						System.out.println("No more spots are left for non-premium members");
						return false;
					}
				
				
				
					//System.out.println("We apologize, but all of the spots are currently taken by non-preimum members");
					
				

				
			}
			
			//y.findFirstAvailableSpot(spot, 2,1);
			
			int spotnum = (spot[0] * 31) + spot[1] + 1;
			DB.addtoUpperSpotsDataBase(LP, spotnum, "spottable");
			System.out.println("Here is your spot: " + (spot[0]*31 + spot[1] + 1));
			//System.out.println(y.numberofspotstaken);
			return true;
		}
		
		
		
		
	
	
	
	
	
	
	

}
