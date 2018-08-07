// Written by: Luke Miller
// Tested by: Luke Miller
// Debugged by: Luke Miller

package simulation;

import javax.swing.text.html.HTML.Tag;

import org.watij.webspec.dsl.WebSpec;

public class AccessWebsite {
	
	public static boolean NewReservation(String FirstName, String LastName, String ArrivalTime, String DepartureTime, String LicensePlate){
		
		if(Simulation.AutomateWebsite == false){
			return false;
		}
		
		WebSpec spec = new WebSpec();
		spec.ie().open("http://localhost/AccountManagement/reservation_store.php");
		
		spec.find.input().with.name("firstName").set.value(FirstName);
		
		demodelay();
		
		spec.find.input().with.name("lastName").set.value(LastName);
		
		demodelay();
		
		spec.find.input().with.name("StartDateTime").set.value(ArrivalTime);
		
		demodelay();
		
		spec.find.input().with.name("EndDateTime").set.value(DepartureTime);
		
		demodelay();
		
		spec.find.input().with.name("LicensePlate").set.value(LicensePlate);
		
		demodelay();

		spec.find.input().with.value("Confirm").click();
		
		demodelay();
		
		spec.closeAll();
		
		return false;
	}
	
	public static boolean NewRate(String Name, String Valid, int Rate){
		
		if(Simulation.AutomateWebsite == false){
			return false;
		}
		
		WebSpec spec = new WebSpec();
		spec.ie().open("http://localhost/AccountManagement/tom/managehome.html");
		
		demodelay();
		spec.ie().open("http://localhost/AccountManagement/tom/rates.php");
		
		demodelay();
		
		spec.ie().open("http://localhost/AccountManagement/tom/rateadd.php");
		
		demodelay();
		
		spec.find.input().with.name("ratename").set.value(Name);
		
		demodelay();
		
		spec.find.input().with.name("activeperiod").set.value(Valid);
		
		demodelay();
		
		spec.find.input().with.name("cost").set.value(Rate + "");
		
		demodelay();
		

		spec.find.button().with.name("Submit").click();
		
		demodelay();
		
		spec.closeAll();
		
		return false;
	}
	
	
	public static boolean NewRecReservation(String FirstName, String LastName, String ArrivalTime, String DepartureTime, String LicensePlate){
		
		if(Simulation.AutomateWebsite == false){
			return false;
		}
		
		WebSpec spec = new WebSpec();
		spec.ie().open("http://localhost/AccountManagement/recurring.html");
		
		spec.find.input().with.name("firstname").set.value(FirstName);
		
		demodelay();
		
		spec.find.input().with.name("lastname").set.value(LastName);
		
		demodelay();
		
		spec.find.input().with.name("starttime").set.value(ArrivalTime);
		
		demodelay();
		
		spec.find.input().with.name("endtime").set.value(DepartureTime);
		
		demodelay();
		
		spec.find.input().with.name("licenseplate").set.value(LicensePlate);
		
		demodelay();

		spec.find.input().with.value("Submit").click();
		
		demodelay();
		
		spec.closeAll();
		
		return false;
	}
	
	
	public static boolean NewBReservation(String FirstName, String LastName, String ArrivalTime, String DepartureTime, String LicensePlate){
		
		if(Simulation.AutomateWebsite == false){
			return false;
		}
		
		WebSpec spec = new WebSpec();
		spec.ie().open("http://localhost/AccountManagement/businesshtml.php");
		
		spec.find.input().with.name("date").set.value(ArrivalTime);
		
		demodelay();
		
		spec.find.input().with.name("lastName").set.value(LastName);
		
		demodelay();
		
		spec.find.input().with.name("StartDateTime").set.value(ArrivalTime);
		
		demodelay();
		
		spec.find.input().with.name("EndDateTime").set.value(DepartureTime);
		
		demodelay();
		
		spec.find.input().with.name("LicensePlate").set.value(LicensePlate);
		
		demodelay();

		spec.find.input().with.value("Confirm").click();
		
		demodelay();
		
		spec.closeAll();
		
		return false;
	}
	
	public static boolean login(String username, String password){
		
		if(Simulation.AutomateWebsite == false){
			return false;
		}
		
		WebSpec spec = new WebSpec();
		//spec.ie().open("http://localhost/AccountManagement/homepage.html");

		spec.ie().open("http://localhost/AccountManagement/homepage.html");
		
		spec.find.input().with.name("useremail").set.value(username);
		
		demodelay();
		
		spec.find.input().with.name("userpassword").set.value(password);
		
		demodelay();
		
		spec.find.input().with.value("Submit").click();
		
		demodelay();
		
		spec.ie().close();
		
		return false;
	}
	
	public static boolean register(String firstname, String lastname, String email, int phone, int zipcode){
		
		if(Simulation.AutomateWebsite == false){
			return false;
		}
		
		WebSpec spec = new WebSpec();

		spec.ie().open("http://localhost/AccountManagement/Registeration.html");
		
		spec.find.input().with.name("fnameinput").set.value(firstname);
		
		demodelay();
		
		spec.find.input().with.name("lnameinput").set.value(lastname);
		demodelay();
		spec.find.input().with.name("emailinput").set.value(email);
		demodelay();
		spec.find.input().with.name("phoneinput").set.value(Integer.toString(phone));
		demodelay();
		spec.find.input().with.name("Password1").set.value("password");
		demodelay();
		spec.find.input().with.name("Password2").set.value("password");
		demodelay();
		spec.find.input().with.name("zipinput").set.value(Integer.toString(zipcode));
		demodelay();
		spec.find.input().with.value("Submit").click();
		demodelay();
		
		spec.closeAll();
		
		
		
		
		return false;		
	}
	
	public static boolean bregister(String companyName, String lastname, String lpassword, String address,String state, String email, int phone, int zipcode){
		
		if(Simulation.AutomateWebsite == false){
			return false;
		}
		
		WebSpec spec = new WebSpec();

		spec.ie().open("http://localhost/AccountManagement/BusinessRegisteration.html");
		
		spec.find.input().with.name("nameinput").set.value(companyName);
		demodelay();
		
		spec.find.input().with.name("emailinput").set.value(email);
		demodelay();
		spec.find.input().with.name("addressinput").set.value(address);
		demodelay();
		
		spec.find.input().with.name("LPassword1").set.value(lpassword);
		demodelay();
		
		spec.find.input().with.name("LPassword2").set.value(lpassword);
		demodelay();
		
		spec.find.input().with.name("stateinput").set.value(state);
		demodelay();
		spec.find.input().with.name("phoneinput").set.value(Integer.toString(phone));
		demodelay();
		spec.find.input().with.name("Password1").set.value("password");
		demodelay();
		spec.find.input().with.name("Password2").set.value("password");
		demodelay();
		spec.find.input().with.name("zipinput").set.value(Integer.toString(zipcode));
		demodelay();
		
		spec.find.input().with.value("Submit").click();
		demodelay();
		demodelay();
		demodelay();
		spec.closeAll();
		
		
		
		
		return false;		
	}
	
	public static boolean addVehicle(String email, String password, String make, String model, int year, String license){
		
		if(Simulation.AutomateWebsite == false){
			return false;
		}
		
		WebSpec spec = new WebSpec();
		
		spec.ie().open("http://localhost/AccountManagement/homepage.html");
		
		demodelay();
		spec.find.input().with.name("useremail").set.value(email);
		demodelay();
		spec.find.input().with.name("userpassword").set.value("password");
		demodelay();
		spec.find.input().with.value("Submit").click();
		demodelay();
		//spec.ie().find.a().with.href("vehicleInfo.php").click();
		
		spec.ie().open("http://localhost/AccountManagement/vehicleInfo.php");
		
		spec.find.input().with.name("makeinput").set.value(make);
		demodelay();
		spec.find.input().with.name("modelinput").set.value(model);
		demodelay();
		spec.find.input().with.name("yearinput").set.value(Integer.toString(year));
		demodelay();
		spec.find.input().with.name("licensenumberinput").set.value(license);
		demodelay();
		
		spec.find.button().with.name("Submit").click();
		demodelay();
		
		spec.closeAll();
		
		return false;
	}
	
	
public static boolean link(String email, String password, String BusName, String linkkey){
		
		if(Simulation.AutomateWebsite == false){
			return false;
		}
		
		WebSpec spec = new WebSpec();
		
		spec.ie().open("http://localhost/AccountManagement/homepage.html");
		
		demodelay();
		spec.find.input().with.name("useremail").set.value(email);
		demodelay();
		spec.find.input().with.name("userpassword").set.value("password");
		demodelay();
		spec.find.input().with.value("Submit").click();
		demodelay();
		//spec.ie().find.a().with.href("vehicleInfo.php").click();
		
		spec.ie().open("http://localhost/AccountManagement/linkCompany.html");
		
		spec.find.input().with.name("companyname").set.value(BusName);
		demodelay();
		spec.find.input().with.name("userpassword1").set.value(linkkey);
		demodelay();
	
		spec.find.input().with.value("Submit").click();
		demodelay();
		
		spec.closeAll();
		
		return false;
	}
	
	public static boolean addPayment(String email, String password, String name, String cardnumber, String expiration, String securitycode){
		
		
		if(Simulation.AutomateWebsite == false){
			return false;
		}
		
		WebSpec spec = new WebSpec();
		
		spec.ie().open("http://localhost/AccountManagement/homepage.html");
		
		spec.find.input().with.name("useremail").set.value(email);
		demodelay();
		spec.find.input().with.name("userpassword").set.value("password");
		demodelay();
		spec.find.input().with.value("Submit").click();
		demodelay();
		spec.ie().open("http://localhost/AccountManagement/PaymentMethod.php");
		demodelay();
		spec.find.input().with.name("nameinput").set.value(name);
		demodelay();
		spec.find.input().with.name("cardnumberinput").set.value(cardnumber);
		demodelay();
		spec.find.input().with.name("dateinput").set.value(expiration);
		demodelay();
		spec.find.input().with.name("securityinput").set.value(securitycode);
		demodelay();
		
		spec.find.button().with.name("Submit").click();
		demodelay();
		
		spec.closeAll();
		
		return false;
	}
	
	public static void demodelay(){
		
		//
		//Delay for Demo
		try {
			Thread.sleep(Simulation.CheckTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//
		//
		
	}
	
	
}
