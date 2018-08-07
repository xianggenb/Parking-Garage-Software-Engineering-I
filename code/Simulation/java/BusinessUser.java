// written by: Luke Miller
// tested by: Luke Miller
// debugged by: Luke Miller

package simulation;

import java.util.ArrayList;

public class BusinessUser extends User{

	ArrayList<User> UserList;
	
	public BusinessUser(){
		super(); //Calls super constructor
		
		UserList = new ArrayList<User>();
		
		for(int i = 0; i <=5; i++){
			UserList.add(new User());
		}
		
	}
	
	public String toString(){ //Override inherited method
		
		String ListofUsers = "";
		
		for(User U: UserList){
			ListofUsers.concat(U.UserID + ", ");
		}
		
		return "Manager: " + UserID + " " + ListofUsers;
		
	}
	
	
}
