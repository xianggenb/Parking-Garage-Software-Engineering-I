// Written by: Luke Miller
// Tested by: Luke Miller
// Debugged by: Luke Miller

package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandRunner {

	private CommandRunner(){
		
	}
	
	public static void Departure() throws IOException{
		
		String[] cmd = {"cmd.exe","/c","dir"};
		  
		Process p = Runtime.getRuntime().exec(cmd);
		  
		BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
		  
		String temp = "";
		  
		while ((temp = input.readLine()) != null)
		   System.out.println(temp);
		  
		input.close();
		
	}
	
	
	
}
