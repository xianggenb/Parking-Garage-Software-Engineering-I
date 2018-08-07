import java.sql.*;

//This class is a tester for the mysql based functions 
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//Attempt to get connection
		try
		{
			Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/reservations","root","Chesstyu100");
			Statement myStat = myconn.createStatement();
			ResultSet myresult = myStat.executeQuery("select * from reservationtable");
			while(myresult.next())
			{
				System.out.println(myresult.getString("ConfirmationNumber"));
			}
		}
		
		
		
		catch(Exception exc)
		{
			System.out.println("You fucked up");
		}

	}

}
