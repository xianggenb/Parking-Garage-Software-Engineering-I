// Written by: Luke Miller
// Tested by: Luke Miller
// Debugged by: Luke Miller

package simulation;

public class PaymentMethod {

	public String Type;
	public String CardNumber;
	public String Name;
	public String ExpirationDate;
	public String SecuirtyCode;
	
	public PaymentMethod(String Type, String CardNumber, String Name, String ExpirationDate, String SecuirtyCode){
		
		this.Type = Type;
		this.CardNumber = CardNumber;
		this.Name = Name;
		this.ExpirationDate = ExpirationDate;
		this.SecuirtyCode = SecuirtyCode;
		
	}
	
}
