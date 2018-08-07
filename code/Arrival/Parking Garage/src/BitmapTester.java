
public class BitmapTester {

	public static void main(String[] args) 
	{
		BitmapTester x = new BitmapTester();
		x.Test3();
	}
	//Test to see whether all 31 spots is used first before moving to next int 
	public void Test1()
	{
		Bitmap y = new Bitmap();
		y.createLowerDeckBitmap();
		y.createUpperDeckBitmap();
		int[] spot = new int[2];
		for(int i = 0; i < 31; i++)
		{
			y.findfirstAvailableSpotLowerDeck(spot);
		}
		System.out.println(spot[0] + " " + spot[1]);
		y.findfirstAvailableSpotLowerDeck(spot);
		System.out.println(spot[0] + " " + spot[1]);
	}
	
	/*
	 * Testing to see if deleting a spot makes it avaliable, i first make 1 spot print it out then
	 * make 3 more, print out the 4th spot. I then make the 3rd spot free, in order to see if that
	 * spot gets reused before moving to the next spot 
	 */
	public void Test2()
	{
		Bitmap y = new Bitmap();
		y.createLowerDeckBitmap();
		y.createUpperDeckBitmap();
		int[] spot = new int[2];
		y.findfirstAvailableSpotLowerDeck(spot);
		System.out.println(spot[0] + " " + spot[1]);
		y.findfirstAvailableSpotLowerDeck(spot);
		y.findfirstAvailableSpotLowerDeck(spot);
		y.findfirstAvailableSpotLowerDeck(spot);
		System.out.println(spot[0] + " " + spot[1]);
		int[] x = {0,2};
		y.changeSpotToFree(x, 1);
		y.findfirstAvailableSpotLowerDeck(spot);
		System.out.println(spot[0] + " " + spot[1]);
	}

	
	public void Test3()
	{
		Bitmap y = new Bitmap();
		y.createLowerDeckBitmap();
		int counter = 0;
		int[] spot = new int[2];
		while(counter < 4)
		{
		for(int i = 0;i < 31;i ++)
		{
			y.findFirstAvailableSpot(spot, 1);
		}
		counter++;
		}
		System.out.println("Last spot set is : " + spot[0] + " " + spot[1]);
		int[] spot1 = {2,30};
		int[] spot2 = {3,15};
		int[] spot3 = {1,17};
		int[] spot4 = {0,5};
		y.changeSpotToFree(spot1, 1);
		y.changeSpotToFree(spot2, 1);
		y.changeSpotToFree(spot3, 1);
		y.changeSpotToFree(spot4, 1);
		y.findFirstAvailableSpot(spot, 1);
		System.out.println("Spot found is : " + spot[0] + " " + spot[1]);
		y.findFirstAvailableSpot(spot, 1);
		System.out.println("Spot found is : " + spot[0] + " " + spot[1]);
		y.findFirstAvailableSpot(spot, 1);
		System.out.println("Spot found is : " + spot[0] + " " + spot[1]);
		y.findFirstAvailableSpot(spot, 1);
		System.out.println("Spot found is : " + spot[0] + " " + spot[1]);
		y.findFirstAvailableSpot(spot, 1);
		System.out.println("Spot found is : " + spot[0] + " " + spot[1]);
	}
}
