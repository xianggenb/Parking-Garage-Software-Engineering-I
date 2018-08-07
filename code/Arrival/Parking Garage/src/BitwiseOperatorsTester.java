import java.math.*;
public class BitwiseOperatorsTester {

	public static void main(String[] args) 
	{
		int c = (1 << 31)- 1 - (1 << 6) - (1 << 4);
		c = c + (1 << 6);
		int x = (1 << 31) - 1 - (1 << 5);
		int y = (1 << 31) - 1 - (1 << 7);
		
		for(int i = 31; i > -1; i--)
		{
			if(((1 << i) & (c)) == (1 << i))
				{
					System.out.println("Free spot: " + i);
				}
		}
	

}
}

