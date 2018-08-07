import java.sql.Connection;
import java.sql.Time;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

/*This class deals with functions in order to retrieve information from a database, 
 * delete information and change information. These functions check whether or not
 * the given value, exists in the database
 */
public class DataBaseAccessor {
	//ResultSet original-table;
	//Statement myStat;
	String URL;
	String table;
	String account;
	String password;
	Connection myconn;
	Statement myStat;
	//String tablecommand;
	ResultSet Table;
	public DataBaseAccessor(String x, String y, String z)
	{
		URL = x;
		account = y;
		 password = z;
	}


	public int retreiveMySQLObjects(Connection myconn, Statement myStat, String tablecommand, ResultSet Table, int mode, String functionname, String tablename)
	{
		
		try
		{
			myconn = DriverManager.getConnection(URL,account,password);
			
		}
		
		catch(Exception SQLException)
		{
			SQLException.getMessage();
			System.out.println("Error in " + functionname + ", error with getting Connection myconn");
			return -1;
		}
		
		try
		{
			 myStat = myconn.createStatement();
		}
		
		catch(Exception SQlException)
		{
			SQlException.getMessage();
			System.out.println("Error in " + functionname + ", error with getting Statement myStat");
			return -1;
			//SQlException.getMessage();
		}
		
		try
		{
			tablecommand = "select * from " + tablename;
		}
		
		catch(Exception SQlException)
		{
			SQlException.getMessage();
			System.out.println("Error in " + functionname + ", error with getting tablecommand ");
			return -1;
		}
		
		try
		{
			 Table = myStat.executeQuery(tablecommand);
		
		}
		catch(Exception SQlException)
		{
			SQlException.getMessage();
			System.out.println("Error in " + functionname + ", error with getting ResultSet Table");
			return -1;
		}
		
		try
		{
		if(myconn != null)
		myconn.close();
		if(myStat != null)
		myStat.close();
		if(Table != null)
		Table.close();
		}
		
		catch(Exception SQLException)
		{
			
		}
		return 1;		
}
		
	public int checkConfirmationNumber(String tablename, int value)
	{
		
		Connection myconn = null;
		Statement myStat = null;
		String tablecommand = null;
		ResultSet Table = null;
		String functionname = "checkConfirmationNumber()";
		
		
		
		try
		{
			myconn = DriverManager.getConnection(URL,account,password);
			
		}
		
		catch(Exception SQLException)
		{
			SQLException.getMessage();
			System.out.println("Error in " + functionname + ", error with getting Connection myconn");
			return -1;
		}
		
		try
		{
			 myStat = myconn.createStatement();
		}
		
		catch(Exception SQlException)
		{
			SQlException.getMessage();
			System.out.println("Error in " + functionname + ", error with getting Statement myStat");
			return -1;
			//SQlException.getMessage();
		}
		

		try
		{
			tablecommand = "select * from " + tablename;
		}
		
		catch(Exception SQlException)
		{
			SQlException.getMessage();
			System.out.println("Error in " + functionname + ", error with getting tablecommand ");
			return -1;
		}
		
		try
		{
			 Table = myStat.executeQuery(tablecommand);
		
		}
		catch(Exception SQlException)
		{
			SQlException.getMessage();
			System.out.println("Error in " + functionname + ", error with getting ResultSet Table");
			return -1;
		}
		
		try
		{
		while(Table.next())
		{
			//System.out.println(table.getInt("Confirmation Number"));
			if(Table.getInt("Confirmation Number") == value)
			{
				return 1;
			}
		}
		}
			
		catch(Exception SQlException)
		{
			SQlException.getMessage();
			System.out.println("Error in checkConfirmationNumber(), error with getting Values from ResultTable");
		}
		try
		{
		if(myconn != null)
		myconn.close();
		if(myStat != null)
		myStat.close();
		if(Table != null)
		Table.close();
		}
		
		catch(Exception SQLException)
		{
			
		}
		return -1;
	}
	
	//Similar to the above function, this instead checks LicensePlate in the reservation, or daily datatably
	public int checkLicensePlate(String LicensePlate, String tablename)
	{
		
		Connection myconn = null;
		Statement myStat = null;
		String tablecommand = null;
		ResultSet Table = null;
		String functionname = "checkLicensePlate()";
		
		try
		{
			myconn = DriverManager.getConnection(URL,account,password);
			
		}
		
		catch(Exception SQLException)
		{
			SQLException.getMessage();
			System.out.println("Error in " + functionname + ", error with getting Connection myconn");
			return -1;
		}
		
		try
		{
			 myStat = myconn.createStatement();
		}
		
		catch(Exception SQlException)
		{
			SQlException.getMessage();
			System.out.println("Error in " + functionname + ", error with getting Statement myStat");
			return -1;
			//SQlException.getMessage();
		}
		
	
		try
		{
			tablecommand = "select * from " + tablename;
		}
		
		catch(Exception SQlException)
		{
			SQlException.getMessage();
			System.out.println("Error in " + functionname + ", error with getting tablecommand ");
			return -1;
		}
		
		try
		{
			 Table = myStat.executeQuery(tablecommand);
		
		}
		catch(Exception SQlException)
		{
			SQlException.getMessage();
			System.out.println("Error in " + functionname + ", error with getting ResultSet Table");
			return -1;
		}
		
		
		
		try
		{
			
		while(Table.next())
		{
			//System.out.println(table.getInt("Confirmation Number"));
			if(Table.getString("LP").compareTo(LicensePlate) == 0)
			{
	
				return 1;
			}
		}
		}
			
		catch(Exception SQlException)
		{
			//SQlException.getMessage();
			System.out.println("Error in checkLicensePlate(), error with getting Values from ResultSet Table");
		}
		try
		{
		if(myconn != null)
		myconn.close();
		if(myStat != null)
		myStat.close();
		if(Table != null)
		Table.close();
		}
		
		catch(Exception SQLException)
		{
			
		}
		return -1;
	
		
	}

	//Adds an entry to the Reservation Database
	public int addtoReservationDataBase(String licenseplate,int confirmationnumber, String startime, String endtime, String tablename)
	{
		Connection myconn = null;
		Statement myStat = null;
		String tablecommand = null;
		ResultSet Table = null;
		String functionname = "addtoReservationDatabase()";
		try
		{
			myconn = DriverManager.getConnection(URL,account,password);
			
		}
		
		catch(Exception SQLException)
		{
			SQLException.getMessage();
			System.out.println("Error in " + functionname + ", error with getting Connection myconn");
			return -1;
		}
		
		try
		{
			 myStat = myconn.createStatement();
		}
		
		catch(Exception SQlException)
		{
			SQlException.getMessage();
			System.out.println("Error in " + functionname + ", error with getting Statement myStat");
			return -1;
			//SQlException.getMessage();
		}
		
		try
		{
			tablecommand = "select * from " + tablename;
		}
		
		catch(Exception SQlException)
		{
			SQlException.getMessage();
			System.out.println("Error in " + functionname + ", error with getting tablecommand ");
			return -1;
		}
		
		try
		{
			 Table = myStat.executeQuery(tablecommand);
		
		}
		catch(Exception SQlException)
		{
			SQlException.getMessage();
			System.out.println("Error in " + functionname + ", error with getting ResultSet Table");
			return -1;
		}
			
	
		try
		{
		String command = "INSERT INTO " + tablename
		 + "(LP, ArrivalTime, DepatureTime, ConfirmationNumber)"
		 + " VALUES ('" + licenseplate  + "', '" + confirmationnumber + "', '" + startime + "', '" + endtime + "')";
		System.out.println(command);
		myStat.executeUpdate(command);
		}
		
		catch(Exception SQLException)
		{
			SQLException.getMessage();
			System.out.println("Error in addtoReservationDatabase, error with myStat.executeUpdate()");
			return -1;
		}
		try
		{
		if(myconn != null)
		myconn.close();
		if(myStat != null)
		myStat.close();
		if(Table != null)
		Table.close();
		}
		
		catch(Exception SQLException)
		{
			
		}
		return 1;
	}
	
	public int deletefromReservationDatabase(String platetobedeleted, String tablename)
	{
	
		Connection myconn = null;
		Statement myStat = null;
		String tablecommand = null;
		ResultSet Table = null;
		String functionname = "deletefromReservationDatabase()";
		
		try
		{
			myconn = DriverManager.getConnection(URL,account,password);
			
		}
		
		catch(Exception SQLException)
		{
			SQLException.getMessage();
			System.out.println("Error in " + functionname + ", error with getting Connection myconn");
			return -1;
		}
		
		try
		{
			 myStat = myconn.createStatement();
		}
		
		catch(Exception SQlException)
		{
			SQlException.getMessage();
			System.out.println("Error in " + functionname + ", error with getting Statement myStat");
			return -1;
			//SQlException.getMessage();
		}
		
		try
		{
			tablecommand = "select * from " + tablename;
		}
		
		catch(Exception SQlException)
		{
			SQlException.getMessage();
			System.out.println("Error in " + functionname + ", error with getting tablecommand ");
			return -1;
		}
		
		try
		{
			 Table = myStat.executeQuery(tablecommand);
		
		}
		catch(Exception SQlException)
		{
			SQlException.getMessage();
			System.out.println("Error in " + functionname + ", error with getting ResultSet Table");
			return -1;
		}
		
		String command = "delete from " + tablename + " where LP='" + platetobedeleted + "'"; 
		try
		{
			
			myStat.executeUpdate(command);
		}
		
		catch(Exception SQLException)
		{
			SQLException.getMessage();
			System.out.println("Error in deletefromReservationDatabase(), with executeUpdate()");
			return -1;
		}
		
		
	
		try
		{
		if(myconn != null)
		myconn.close();
		if(myStat != null)
		myStat.close();
		if(Table != null)
		Table.close();
		}
		
		catch(Exception SQLException)
		{
			
		}
		return 1;
	}

	/*
	 * Searches for the right license-plate, and retrieves the timestamp 
	 */
	public Timestamp retrieveTimeofReservation(String LicensePlate, String tablename, int mode, int confirmationnumber)
	
	{
		Connection myconn = null;
		Statement myStat = null;
		String tablecommand = null;
		ResultSet Table = null;
		String functionname = "retrieveTimeofReservation()";
		
		try
		{
			myconn = DriverManager.getConnection(URL,account,password);
			
		}
		
		catch(Exception SQLException)
		{
			SQLException.getMessage();
			System.out.println("Error in " + functionname + ", error with getting Connection myconn");
			return null;
		}
		
		try
		{
			 myStat = myconn.createStatement();
		}
		
		catch(Exception SQlException)
		{
			SQlException.getMessage();
			System.out.println("Error in " + functionname + ", error with getting Statement myStat");
			return null;
			//SQlException.getMessage();
		}
		
		try
		{
			tablecommand = "select * from " + tablename;
		}
		
		catch(Exception SQlException)
		{
			SQlException.getMessage();
			System.out.println("Error in " + functionname + ", error with getting tablecommand ");
			return null;
		}
		
		try
		{
			 Table = myStat.executeQuery(tablecommand);
		
		}
		catch(Exception SQlException)
		{
			SQlException.getMessage();
			System.out.println("Error in " + functionname + ", error with getting ResultSet Table");
			return null;
		}
		
		
		
	
		
		try
		{
			while(Table.next())
			{
				if(mode == 0)
				{
				if(Table.getString("LP").compareTo(LicensePlate) == 0)
				{
					//System.out.println(Table.getTimestamp("Arrival Time"));
					return Table.getTimestamp("Arrival Time");
				}
				}
				
				if(mode == 1)
				{
					if(Table.getInt("Confirmation Number") == confirmationnumber)
					return Table.getTimestamp("Arrival Time");
				}
			}
		}
		
		catch(Exception SQLException)
		{
			SQLException.getMessage();
			System.out.println("Error in retrieveTimeofReservation(), error with getting Resultset Table values ");
			return null;
		}
		try
		{
		if(myconn != null)
		myconn.close();
		if(myStat != null)
		myStat.close();
		if(Table != null)
		Table.close();
		}
		
		catch(Exception SQLException)
		{
			
		}
		return null;
	}

	public int addTimetoLowerDeck(int spot, String x, String tablename)
	{
		Connection myconn = null;
		Statement myStat = null;
		String tablecommand = null;
		ResultSet Table = null;
		String functionname = "addTimetoLowerDeck()";
				try
		{
			myconn = DriverManager.getConnection(URL,account,password);
			
		}
		
		catch(Exception SQLException)
		{
			SQLException.getMessage();
			System.out.println("Error in " + functionname + ", error with getting Connection myconn");
			return -1;
		}
		
		try
		{
			 myStat = myconn.createStatement();
		}
		
		catch(Exception SQlException)
		{
			SQlException.getMessage();
			System.out.println("Error in " + functionname + ", error with getting Statement myStat");
			return -1;
			//SQlException.getMessage();
		}
		
		try
		{
			tablecommand = "select * from " + tablename;
		}
		
		catch(Exception SQlException)
		{
			SQlException.getMessage();
			System.out.println("Error in " + functionname + ", error with getting tablecommand ");
			return -1;
		}
		
		try
		{
			 Table = myStat.executeQuery(tablecommand);
		
		}
		catch(Exception SQlException)
		{
			SQlException.getMessage();
			System.out.println("Error in " + functionname + ", error with getting ResultSet Table");
			return -1;
		}		
		
		
		try
		{
		
		String command = "INSERT INTO " + tablename
				 + "(Spot,StartTime)"
				 + " VALUES ('" + spot  + "', '" + x +"')";
				System.out.println(command);
				myStat.executeUpdate(command);
		}
		
		catch(Exception SQLException)
		{
			SQLException.getMessage();
			System.out.println("Error in addTimetoLowerDeck(), with executingUpdate");
			return -1;
		}
		
		
		try
		{
		if(myconn != null)
		myconn.close();
		if(myStat != null)
		myStat.close();
		if(Table != null)
		Table.close();
		}
		
		catch(Exception SQLException)
		{
			
		}
		return 1;
	}
	
	public int retrieveStartTimeofLowerDeckSpot(int spot, String tablename, Time starttime)
	{
		Connection myconn = null;
		Statement myStat = null;
		String Tablecommand = null;
		ResultSet Table = null;
		String functionname = "retrieveStartTimeofLowerDeckSpot";
		
		try
		{
			myconn = DriverManager.getConnection(URL,account,password);
			
		}
		
		catch(Exception SQLException)
		{
			SQLException.getMessage();
			System.out.println("Error in " + functionname + ", error with getting Connection myconn");
			return -1;
		}
		
		try
		{
			 myStat = myconn.createStatement();
		}
		
		catch(Exception SQlException)
		{
			SQlException.getMessage();
			System.out.println("Error in " + functionname + ", error with getting Statement myStat");
			return -1;
			//SQlException.getMessage();
		}
		
		try
		{
			Tablecommand = "select * from " + tablename;
		}
		
		catch(Exception SQlException)
		{
			SQlException.getMessage();
			System.out.println("Error in " + functionname + ", error with getting tablecommand ");
			return -1;
		}
		
		try
		{
			 Table = myStat.executeQuery(Tablecommand);
		
		}
		catch(Exception SQlException)
		{
			SQlException.getMessage();
			System.out.println("Error in " + functionname + ", error with getting ResultSet Table");
			return -1;
		}
		
	
		try
		{
		

			String tablecommand = "select * from " + tablename + " where Spot=" + spot;
			ResultSet table = myStat.executeQuery(tablecommand);
			if(table.next())
			{
				starttime = table.getTime("StartTime");
			}
		}
		
		
		catch(Exception SQLException)
		{
			SQLException.getMessage();
			System.out.println("Error in retrieveStartTimeofLowerDeckSpot(), with ");
			return -1;
		}
		try
		{
		if(myconn != null)
		myconn.close();
		if(myStat != null)
		myStat.close();
		if(Table != null)
		Table.close();
		}
		
		catch(Exception SQLException)
		{
			
		}
		return 1;
	}
		
	//retrieves the number of pre-reserved spots for the day 
	public int retreiveDailySpotBuffer(String tablename)
	{
		int size = 0;
		Connection myconn = null;
		Statement myStat = null;
		String tablecommand = null;
		ResultSet Table = null;
		String functionname = "retreiveDailySpotBuffer()";
		try
		{
			myconn = DriverManager.getConnection(URL,account,password);
			
		}
		
		catch(Exception SQLException)
		{
			SQLException.getMessage();
			System.out.println("Error in " + functionname + ", error with getting Connection myconn");
			return -1;
		}
		
		try
		{
			 myStat = myconn.createStatement();
		}
		
		catch(Exception SQlException)
		{
			SQlException.getMessage();
			System.out.println("Error in " + functionname + ", error with getting Statement myStat");
			return -1;
			//SQlException.getMessage();
		}
		
		try
		{
			tablecommand = "select * from " + tablename;
		}
		
		catch(Exception SQlException)
		{
			SQlException.getMessage();
			System.out.println("Error in " + functionname + ", error with getting tablecommand ");
			return -1;
		}
		
		try
		{
			 Table = myStat.executeQuery(tablecommand);
		
		}
		catch(Exception SQlException)
		{
			SQlException.getMessage();
			System.out.println("Error in " + functionname + ", error with getting ResultSet Table");
			return -1;
		}
		
		

		try
		{
			//int counter = 0;
		while(Table.next())
		{
			//System.out.println(table.getInt("Confirmation Number"));
			size++;
		}
		}
		
		catch(Exception SQlException)
		{
			SQlException.getMessage();
			System.out.println("Error retreiveDailySpotBuffer(), error with getting ResultSet Table");
		}
		try
		{
		if(myconn != null)
		myconn.close();
		if(myStat != null)
		myStat.close();
		if(Table != null)
		Table.close();
		}
		
		catch(Exception SQLException)
		{
			
		}
		return size;
	}


	public int retreiveTimeofDailySpot(String LicensePlate, String tablename, Timestamp starttime)
{
		Connection myconn = null;
		Statement myStat = null;
		String tablecommand = null;
		ResultSet Table = null;
		String functionname = "retreiveTimeofDailySpot()";
		
		try
		{
			myconn = DriverManager.getConnection(URL,account,password);
			
		}
		
		catch(Exception SQLException)
		{
			SQLException.getMessage();
			System.out.println("Error in " + functionname + ", error with getting Connection myconn");
			return -1;
		}
		
		try
		{
			 myStat = myconn.createStatement();
		}
		
		catch(Exception SQlException)
		{
			SQlException.getMessage();
			System.out.println("Error in " + functionname + ", error with getting Statement myStat");
			return -1;
			//SQlException.getMessage();
		}
		
		try
		{
			tablecommand = "select * from " + tablename;
		}
		
		catch(Exception SQlException)
		{
			SQlException.getMessage();
			System.out.println("Error in " + functionname + ", error with getting tablecommand ");
			return -1;
		}
		
		try
		{
			 Table = myStat.executeQuery(tablecommand);
		
		}
		catch(Exception SQlException)
		{
			SQlException.getMessage();
			System.out.println("Error in " + functionname + ", error with getting ResultSet Table");
			return -1;
		}
		
		String Tablecommand = "select * from " + tablename + " where LP=" + LicensePlate;
		try
	{
		ResultSet table = myStat.executeQuery(Tablecommand);
		if(table.next())
		{
			starttime = table.getTimestamp("StartTime");
		}
	}
		
	
	
	catch(Exception SQLException)
	{
		SQLException.getMessage();
		System.out.println("Error in retrieveTimeofDailySpot(), with the executeQuery() ");
		return -1;
	}
		try
		{
		if(myconn != null)
		myconn.close();
		if(myStat != null)
		myStat.close();
		if(Table != null)
		Table.close();
		}
		
		catch(Exception SQLException)
		{
			
		}	
	return 1;	
}
	
	
	public int getFreeSpots(String tablename)
	{
		int value;
		
		Connection myconn = null;
		Statement myStat = null;
		String tablecommand = null;
		ResultSet Table = null;
		String functionname = "getFreeSpots()";
		try
		{
			myconn = DriverManager.getConnection(URL,account,password);
			
		}
		
		catch(Exception SQLException)
		{
			SQLException.getMessage();
			System.out.println("Error in " + functionname + ", error with getting Connection myconn");
			return -1;
		}
		
		try
		{
			 myStat = myconn.createStatement();
		}
		
		catch(Exception SQlException)
		{
			SQlException.getMessage();
			System.out.println("Error in " + functionname + ", error with getting Statement myStat");
			return -1;
			//SQlException.getMessage();
		}
		
		try
		{
			tablecommand = "select * from " + tablename;
		}
		
		catch(Exception SQlException)
		{
			SQlException.getMessage();
			System.out.println("Error in " + functionname + ", error with getting tablecommand ");
			return -1;
		}
		
		try
		{
			 Table = myStat.executeQuery(tablecommand);
		
		}
		catch(Exception SQlException)
		{
			SQlException.getMessage();
			System.out.println("Error in " + functionname + ", error with getting ResultSet Table");
			return -1;
		}
		
		
	
		int counter = 0;
		try
		{
		while(Table.next())
		{
			//counter++;
			if(Table.getInt("State") == 1)
			{
				value = Table.getInt("Spot");
				System.out.println(value);
				String command = "delete from " + tablename + " where Spot=" + value;
				myStat.execute(command);
				counter = 1;
				return value;
				
			}
			
			
		}
		if(counter == 0)
		{
			return -1;
		}
		}
		
		catch(Exception SQlException)
		{
			SQlException.printStackTrace();
			System.out.println("Error in " + functionname + ", error with looping ");
			return -1;
		}
		
		
		


		
		
		
		try
		{
		if(myconn != null)
		myconn.close();
		if(myStat != null)
		myStat.close();
		if(Table != null)
		Table.close();
		}
		
		catch(Exception SQLException)
		{
			
		}
		return 1;
	}
	
	
	public int determineWhoLosesTheirSpot(String tablename)
	{

		Connection myconn = null;
		Statement myStat = null;
		String tablecommand = null;
		ResultSet Table = null;
		String functionname = "determineWhoLosesTheirSpot()";
		try
		{
			myconn = DriverManager.getConnection(URL,account,password);
			
		}
		
		catch(Exception SQLException)
		{
			SQLException.getMessage();
			System.out.println("Error in " + functionname + ", error with getting Connection myconn");
			return -1;
		}
		
		try
		{
			 myStat = myconn.createStatement();
		}
		
		catch(Exception SQlException)
		{
			SQlException.getMessage();
			System.out.println("Error in " + functionname + ", error with getting Statement myStat");
			return -1;
			//SQlException.getMessage();
		}
		
		try
		{
			tablecommand = "select * from " + tablename;
		}
		
		catch(Exception SQlException)
		{
			SQlException.getMessage();
			System.out.println("Error in " + functionname + ", error with getting tablecommand ");
			return -1;
		}
		
		try
		{
			 Table = myStat.executeQuery(tablecommand);
		
		}
		catch(Exception SQlException)
		{
			SQlException.getMessage();
			System.out.println("Error in " + functionname + ", error with getting ResultSet Table");
			return -1;
		}
		try
	{
			
		Long maxdifference = (long)0;
		Timestamp choppingblock = null;
		Long difference = (long)0;
		while(Table.next())
		{
			Timestamp b = Table.getTimestamp("StartTime");
			//System.out.println("Reached");
			difference = System.currentTimeMillis() - b.getTime();
			//System.out.println(difference + " for " + Table.getString("LP"));
			if(Table.getInt("State") == 1)
			{
				continue;
			}
			long x = 1800000;//30 minutes
			if(difference >= x)
			{
				if(difference > maxdifference)
				{
					//System.out.println(difference + " for " + Table.getString("LP"));

					maxdifference = difference; 
					choppingblock = b;
				}
			}
			
		}
		if(choppingblock == null)
			return -1;
		//System.out.println(difference + " for " + Table.getString("LP"));
		String updateStatement = "update " + tablename + " set state = " + 1 + " where StartTime = '" + choppingblock.toString() + "'";
		//6System.out.println(updateStatement);
		myStat.executeUpdate(updateStatement);
	}
		
		
		catch(Exception SQlException)
		{
			//SQlException.printStackTrace();
			System.out.println("Error in " + functionname + ", error with getting ResultSet Table of TimeStamp Entries");
			return -1;
		}
		
		try
		{
		if(myconn != null)
		myconn.close();
		if(myStat != null)
		myStat.close();
		if(Table != null)
		Table.close();
		}
		
		catch(Exception SQLException)
		{
			
		}
		return 1;
	}

	public int retreiveStateofDailySpot(String tablename, String LicensePlate)
	{
		Connection myconn = null;
		Statement myStat = null;
		String tablecommand = null;
		ResultSet Table = null;
		String functionname = "retreiveStateofDailySpot()";
		try
		{
			myconn = DriverManager.getConnection(URL,account,password);
			
		}
		
		catch(Exception SQLException)
		{
			SQLException.getMessage();
			System.out.println("Error in " + functionname + ", error with getting Connection myconn");
			return -1;
		}
		
		try
		{
			 myStat = myconn.createStatement();
		}
		
		catch(Exception SQlException)
		{
			SQlException.getMessage();
			System.out.println("Error in " + functionname + ", error with getting Statement myStat");
			return -1;
			//SQlException.getMessage();
		}
		
		try
		{
			tablecommand = "select * from " + tablename;
		}
		
		catch(Exception SQlException)
		{
			SQlException.getMessage();
			System.out.println("Error in " + functionname + ", error with getting tablecommand ");
			return -1;
		}
		
		try
		{
			 Table = myStat.executeQuery(tablecommand);
		
		}
		catch(Exception SQlException)
		{
			SQlException.getMessage();
			System.out.println("Error in " + functionname + ", error with getting ResultSet Table");
			return -1;
		}
		try
		{
		while(Table.next())
		{
			//System.out.println(table.getInt("Confirmation Number"));
			if(Table.getString("LP").compareTo(LicensePlate) == 0)
			{
	
				return Table.getInt("State");
			}
		}
		}
			
		catch(Exception SQlException)
		{
			//SQlException.getMessage();
			System.out.println("Error in retrieveStateofDailySpot(), error with getting Values from ResultSet Table");
			return -1;
		}
		
		try
		{
		if(myconn != null)
		myconn.close();
		if(myStat != null)
		myStat.close();
		if(Table != null)
		Table.close();
		}
		
		catch(Exception SQLException)
		{
			
		}
		return -2;
		
		
	}
	
	

public Timestamp RetrieveTimeofReservation(String LicensePlate, String tablename)

{
	Timestamp starttime = null;
		Connection myconn = null;
		Statement myStat = null;
		String tablecommand = null;
		ResultSet Table = null;
		String functionname = "RetrieveTimeofReservation()";
		
		try
		{
			myconn = DriverManager.getConnection(URL,account,password);
			
		}
		
		catch(Exception SQLException)
		{
			SQLException.printStackTrace();
			System.out.println("Error in " + functionname + ", error with getting Connection myconn");
			return null;
		}
		
		try
		{
			 myStat = myconn.createStatement();
		}
		
		catch(Exception SQlException)
		{
			SQlException.getMessage();
			System.out.println("Error in " + functionname + ", error with getting Statement myStat");
			return null;
			//SQlException.getMessage();
		}
		
		try
		{
			tablecommand = "select * from " + tablename;
		}
		
		catch(Exception SQlException)
		{
			SQlException.getMessage();
			System.out.println("Error in " + functionname + ", error with getting tablecommand ");
			return null;
		}			
		try
		{
			 Table = myStat.executeQuery(tablecommand);
		
		}
		
		catch(Exception SQlException)
		{
			
		}

		
		try
		{

			String Tablecommand = "select * from " + tablename + " where LP= '" + LicensePlate + "'";
			//System.out.println(Tablecommand);
			ResultSet table = myStat.executeQuery(Tablecommand);
			if(table.next())
			{
				starttime = table.getTimestamp("StartTime");
				//System.out.println(starttime.toString());
			}
		}
		
		catch(Exception SQLException)
		{
			SQLException.getMessage();
			System.out.println("Error in RetrieveTimeofReservation(Time), error with getting Resultset Table values ");
			return null;
		}
		try
		{
		if(myconn != null)
		myconn.close();
		if(myStat != null)
		myStat.close();
		if(Table != null)
		Table.close();
		}
		
		catch(Exception SQLException)
		{
			
		}
		return starttime;
	}


	public int addtoUpperSpotsDataBase(String LicensePlate, int spot, String tablename)
	{
		Connection myconn = null;
		Statement myStat = null;
		String tablecommand = null;
		ResultSet Table = null;
		String functionname = "addtoUpperSpotsDatabase()";
				try
		{
			myconn = DriverManager.getConnection(URL,account,password);
			
		}
		
		catch(Exception SQLException)
		{
			SQLException.getMessage();
			System.out.println("Error in " + functionname + ", error with getting Connection myconn");
			return -1;
		}
		
		try
		{
			 myStat = myconn.createStatement();
		}
		
		catch(Exception SQlException)
		{
			SQlException.getMessage();
			System.out.println("Error in " + functionname + ", error with getting Statement myStat");
			return -1;
			//SQlException.getMessage();
		}
		
		try
		{
			tablecommand = "select * from " + tablename;
		}
		
		catch(Exception SQlException)
		{
			SQlException.getMessage();
			System.out.println("Error in " + functionname + ", error with getting tablecommand ");
			return -1;
		}
		
		try
		{
			 Table = myStat.executeQuery(tablecommand);
		
		}
		catch(Exception SQlException)
		{
			SQlException.getMessage();
			System.out.println("Error in " + functionname + ", error with getting ResultSet Table");
			return -1;
		}		
		
		try
		{
			String command = "INSERT INTO " + tablename + " (Spot,LP,State)" + 
			" Values ('" + spot + "', '" + LicensePlate + "', '" + 0 + "')";
			//System.out.println(command);
			myStat.executeUpdate(command);
		}
		
		catch(Exception SQlException)
		{
			//System.out.println("Error in addtoUpperSpotsDatabase, with updating" );
			return -1;
		}
		
		
		return 1;
	}


public int deleteSpotsDB(String tablename)
{
	Connection myconn = null;
	Statement myStat = null;
	String tablecommand = null;
	ResultSet Table = null;
	String functionname = "deleteSpotsDB()";
			try
	{
		myconn = DriverManager.getConnection(URL,account,password);
		
	}
	
	catch(Exception SQLException)
	{
		SQLException.getMessage();
		System.out.println("Error in " + functionname + ", error with getting Connection myconn");
		return -1;
	}
	
	try
	{
		 myStat = myconn.createStatement();
	}
	
	catch(Exception SQlException)
	{
		SQlException.getMessage();
		System.out.println("Error in " + functionname + ", error with getting Statement myStat");
		return -1;
		//SQlException.getMessage();
	}
	
	try
	{
		tablecommand = "select * from " + tablename;
	}
	
	catch(Exception SQlException)
	{
		SQlException.getMessage();
		System.out.println("Error in " + functionname + ", error with getting tablecommand ");
		return -1;
	}
	
	try
	{
		 Table = myStat.executeQuery(tablecommand);
	
	}
	catch(Exception SQlException)
	{
		SQlException.getMessage();
		System.out.println("Error in " + functionname + ", error with getting ResultSet Table");
		return -1;
	}		
	
	try
	{
	String command = "delete from " + tablename;
	myStat.execute(command);
	}
	
	catch(Exception SQlException)
	{
		System.out.println("error in deleting");
		return -1;
	}
	
	
	return 1;
}


public int changeStatetoFree(String tablename, String LicensePlate, int spotnumber)
{
	Connection myconn = null;
	Statement myStat = null;
	String tablecommand = null;
	ResultSet Table = null;
	String functionname = "changeStatetoFree()";
			try
	{
		myconn = DriverManager.getConnection(URL,account,password);
		
	}
	
	catch(Exception SQLException)
	{
		SQLException.getMessage();
		System.out.println("Error in " + functionname + ", error with getting Connection myconn");
		return -1;
	}
	
	try
	{
		 myStat = myconn.createStatement();
	}
	
	catch(Exception SQlException)
	{
		SQlException.getMessage();
		System.out.println("Error in " + functionname + ", error with getting Statement myStat");
		return -1;
		//SQlException.getMessage();
	}
	
	try
	{
		tablecommand = "select * from " + tablename;
	}
	
	catch(Exception SQlException)
	{
		SQlException.getMessage();
		System.out.println("Error in " + functionname + ", error with getting tablecommand ");
		return -1;
	}
	
	try
	{
		 Table = myStat.executeQuery(tablecommand);
	
	}
	catch(Exception SQlException)
	{
		SQlException.getMessage();
		System.out.println("Error in " + functionname + ", error with getting ResultSet Table");
		return -1;
	}		
	try
	{
		while(Table.next())
		{
			if(Table.getString("LP").compareTo(LicensePlate) == 0)
			{
				spotnumber = Table.getInt("Spot");
				return spotnumber;
			}
		}
	}
	
	catch(Exception SQlException)
	{
		SQlException.getMessage();
		System.out.println("Error in " + functionname + ", error with finding spot");
		return -1;
	}
		
	try
	{

	String updateStatement = "update " + tablename + " set state = " + 1 + " where LP = '" + LicensePlate + "'";
	myStat.execute(updateStatement);
	
	}
	
	

		catch(Exception SQlException)
		{
			SQlException.getMessage();
			System.out.println("Error in " + functionname + ", error with changing stateofspot");
			return -1;
		}
		
	
	
	
	
	
	
	
	
	
	
	
	return 0;
}




public int carArrivedDailySpots(String tablename, String LicensePlate)
{
	Connection myconn = null;
	Statement myStat = null;
	String tablecommand = null;
	ResultSet Table = null;
	String functionname = "carArrivedDailySpots()";
			try
	{
		myconn = DriverManager.getConnection(URL,account,password);
		
	}
	
	catch(Exception SQLException)
	{
		SQLException.getMessage();
		System.out.println("Error in " + functionname + ", error with getting Connection myconn");
		return -1;
	}
	
	try
	{
		 myStat = myconn.createStatement();
	}
	
	catch(Exception SQlException)
	{
		SQlException.getMessage();
		System.out.println("Error in " + functionname + ", error with getting Statement myStat");
		return -1;
		//SQlException.getMessage();
	}
	
	try
	{
		tablecommand = "select * from " + tablename;
	}
	
	catch(Exception SQlException)
	{
		SQlException.getMessage();
		System.out.println("Error in " + functionname + ", error with getting tablecommand ");
		return -1;
	}
	
	try
	{
		 Table = myStat.executeQuery(tablecommand);
	
	}
	catch(Exception SQlException)
	{
		SQlException.getMessage();
		System.out.println("Error in " + functionname + ", error with getting ResultSet Table");
		return -1;
	}		
	
	try
	{
	String updateStatement = "update " + tablename + " set state = " + 1 + " where LP = '" + LicensePlate + "'";
	myStat.execute(updateStatement);
	}
	catch(Exception SQlException)
	{
		SQlException.getMessage();
		System.out.println("Error in " + functionname + ", error with using UpdateStatement");
		return -1;
	}
	
	
	
	return 1;
}
}









	
	

	




	
	
	