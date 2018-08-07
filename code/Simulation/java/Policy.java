// Written by: Luke Miller
// Tested by: Luke Miller
// Debugged by: Luke Miller

package simulation;

import java.sql.Timestamp;

public class Policy {

	public boolean AlwaysApplicable;
	public Timestamp StartTime;
	public Timestamp StopTime;
	public double HourlyPrice;

	public Policy(boolean AlwaysApplicable, Timestamp StartTime, Timestamp StopTime, double HourlyPrice){
		this.AlwaysApplicable = AlwaysApplicable;
		this.StartTime = StartTime;
		this.StopTime = StopTime;
		this.HourlyPrice = HourlyPrice;
	}
	
}
