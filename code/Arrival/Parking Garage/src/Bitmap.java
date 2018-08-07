
/* This class defines the Bitmap data-structure used
 * and it also defines the helper functions needed
 * to access it 
 */
public class Bitmap {

	int[] lowerdeck; 
	int[] upperdeck;
	int numberofdailyspots;
	int lastchosenlowerdeck;
	int lastchosenupperdeck;
	int lastlowerdeckindex;
	int lastupperdeckindex;
	int isfreespotslower;
	int isfreespotsupper;
	int numberofspotstaken;
	
	//Create standard bitmap deck, for only 3100 spots
	public void createLowerDeckBitmap()
	{
		lowerdeck = new int[100];
		for(int i = 0; i < 100; i++)
		{
			lowerdeck[i] = (1 << 31) - 1;
		}
		
		lastchosenlowerdeck = 0;
		lastlowerdeckindex = 0;
		isfreespotslower = 0;
		
	}
	//Create a standard bitmap deck, for a specific size
	//however be warned, each int can store 32 bits hence
	//31 spots because of the 2 complement, so spots will be wasted if the number of spots isn't 
	//divisible by 31 which is a prime number, and hence there will be a further update to fix this
	public void createLowerDeckBitmap(int size)
	{
		lowerdeck = new int[size];
		for(int i = 0; i < size; i++)
		{
			lowerdeck[i] = (1 << 31) - 1;
		}
		
		lastchosenlowerdeck = 0;
		lastlowerdeckindex = 0;
	}
	

	//Create standard bitmap deck, for only 3100 spots
	public void createUpperDeckBitmap()
	{
		upperdeck = new int[1];
		for(int i = 0; i < 1; i++)
		{
			upperdeck[i] = (1 << 31) - 1;
		}
		
		lastchosenupperdeck = 0;
		lastupperdeckindex = 0;
		isfreespotsupper = 0;
		numberofspotstaken = 0;
	}
	//Create a standard bitmap deck, for a specific size
	//however be warned, each int can store 32 bits hence
	//31 spots, so spots will be wasted if the spots, can't
	//evenly be divided
	public void createUpperDeckBitmap(int size)
	{
		upperdeck = new int[size];
		for(int i = 0; i < size; i++)
		{
			upperdeck[i] = (1 << 31) - 1;;
		}
		
		lastchosenupperdeck = 0;
		lastupperdeckindex = 0;
	}
	//This function finds a spot and passes the index spot in the bitmap, and offset(actual spot) to the
	//spot argument, if a spot can't be found
	//then it returns -1 and spot is set also to -1
	//Mode indicates whether you are searching the upper
	//or lower deck 
	
	public int findFirstAvailableSpot(int[] spot, int mode, int mode2)

	
	{
		
	
		if(mode == 1)
		{
				int iserror = findfirstAvailableSpotLowerDeck(spot);
				if(iserror == -1)
				{
					spot[0] = -1;
					spot[1] = -1;
					return -1;
				}
				
				
		}	
		
		else if(mode == 2)
		{
			int iserror = findfirstAvaliableSpotUpperDeck(spot, mode2);
			if(iserror == -1)
			{
				spot[0] = -1;
				spot[1] = -1;
				return -1;
			}
			
			else if(iserror == -3)
			{
				return -3;
			}
		}
		
		else
		{
			spot[0] = -1;
			spot[1] = -1;
			return -1;
		}
	

		return 0;
	}
	
	
	//This is the function for the lower deck, the upper deck has exact same code however for the 
	//upperdeck array
	public int findfirstAvailableSpotLowerDeck(int[] spot)
	{
		/*This function works by updating the bitmap sequentially,
		 * hence by going from 0...., we give unused spots to the right,
		 * while spots that are free are to the left,by this simple approach
		 * we either go left or right to find a spot, but we attempt a
		 * free spot first before moving to the right
		 * */
		if(isfreespotslower == 0)
		{
			//Error checking, see if all the spots are taken
			if(lastchosenlowerdeck == lowerdeck.length)
			{
				return -2;
				
			}
			spot[0] = lastchosenlowerdeck;
			spot[1] = lastlowerdeckindex;
			/*Block and offset describe the block that was chosen(each int element
			 * in the array is a block), and offset is the actual block
			 * We then go the bitmap and indicate this spot is taken
			 */
			int Block = lastchosenlowerdeck;
			int offset = lastlowerdeckindex;
			lastlowerdeckindex++;
			if(lastlowerdeckindex == 31)
			{
				lastlowerdeckindex = 0;
				lastchosenlowerdeck++;
				
			}
			
			/*Since the max range of the int is up to 2^31-1, 2^31 with Math Library but i would prefer not to use it in case of error 
			 * and while java does now have unsigned integers
			 * i am not sure if we can use them for arrays, 
			 * so we make our 31th spot, be
			 * 2^30, then 30th will be 2^29,...
			 * */
			//Here we set the block value to now indicate every spot up to and including 
			//the offset is used 
			lowerdeck[Block] -= (1 << offset);
			
			return 1;
			
			/*Now we indicated in the bitmap, that this spot is taken, hence when we 
			 * search for free spots, we won't try to allocate this spot 
			 * 
			 */
			
		}
	
/*
 * There are free spots hence, we take our current index and search to the left
 * we don't update our current spot since we know everything after
 * our current spot is unused
 * 
 * 	*/
		else
		{
			/*Use for loop to start at current block, traverse to the left 
			 * 
			 */
			
			int currentblock = lastchosenlowerdeck;
			int currentoffset = lastlowerdeckindex;
			//newblock hence we start 1 back
			if(currentoffset == 0)
			{
				currentblock--;
			}
			int offsetpointer = currentoffset;
			for(int blockpointer = currentblock; blockpointer > -1; blockpointer--)
			{
				//After finishing current block, we need to move to the left traversing, complete blocks 
				//Check indicates whether we moved past current block 
				if(blockpointer != lastchosenlowerdeck)
				{
					offsetpointer = 30;
				}
				
				for(; offsetpointer > -1; offsetpointer--)
				{
					
	
					int ideal_spot_value = (1 << offsetpointer);
					/*We take the complement of the current spot since it would be
					 * 111...0.111, hence the complement is the 2^(offsetpointer), we find
					 * first one that matches, its a free spot
					 * 
					 * 
					 * 
					 */
					int isfreespot = lowerdeck[blockpointer] & ideal_spot_value;
					//System.out.println(isfreespot + " " + ideal_spot_value);
					//spot is good 
					if(isfreespot == ideal_spot_value)
					{
						//System.out.println("This got reached");
						spot[0] = blockpointer;
						spot[1] = offsetpointer;
						lowerdeck[blockpointer] -= (1 << offsetpointer);
						isfreespotslower--;
						return 1;
					}
					
				}
			}
				findfirstAvailableSpotLowerDeck(spot);
				return -1;
		}
	}
		
		
	public int findfirstAvaliableSpotUpperDeck(int[] spot, int mode)
		{
			int returncheck = 0;
			/*This function works by updating the bitmap sequentially,
			 * hence by going from 0...., we give unused spots to the right,
			 * while spots that are free are to the left,by this simple approach
			 * we either go left or right to find a spot, but we attempt a
			 * free spot first before moving to the right
			 * */
			if(isfreespotsupper == 0)
			{
				//Error checking, see if all the spots are taken
				if(numberofspotstaken >= ((upperdeck.length * 31) - numberofdailyspots))
				{
					if(numberofspotstaken == (upperdeck.length * 31))
					{
						return -1;
					}
					

					
				}
				spot[0] = lastchosenupperdeck;
				spot[1] = lastupperdeckindex;
				/*Block and offset describe the block that was chosen(each int element
				 * in the array is a block), and offset is the actual block
				 * We then go the bitmap and indicate this spot is taken
				 */
				
				
				int Block = lastchosenupperdeck;
				int offset = lastupperdeckindex;
				lastupperdeckindex++;
				if(lastupperdeckindex == 31)
				{
					lastupperdeckindex = 0;
					lastchosenupperdeck++;
					
				}
				
				/*Since the max range of the int is up to 2^31-1, 2^31 with Math Library but i would prefer not to use it in case of error 
				 * and while java does now have unsigned integers
				 * i am not sure if we can use them for arrays, 
				 * so we make our 32nd spot 2^31-1, while 31th will be
				 * 2^30, then 30th will be 2^29,...
				 * */
				
				
				
				//Here we set the block value to now indicate every spot up to and including 
				//the offset is used 
				upperdeck[Block] -= (1 << offset);
				numberofspotstaken++;
				
				if(mode == 0)
				{
					numberofdailyspots--;
				}
				
				return 1;
				
				/*Now we indicated in the bitmap, that this spot is taken, hence when we 
				 * search for free spots, we won't try to allocate this spot 
				 * 
				 */
				
			}
		
	/*
	 * There are free spots hence, we take our current index and search to the left
	 * we don't update our current spot since we know everything after
	 * our current spot is unused
	 * 
	 * 	*/
			else
			{
				/*Use for loop to start at current block, traverse to the left 
				 * 
				 */
				
				int currentblock = lastchosenupperdeck;
				int currentoffset = lastchosenupperdeck;
				int offsetpointer = currentoffset;
				for(int blockpointer = currentblock; blockpointer > -1; blockpointer--)
				{
					//After finishing current block, we need to move to the left traversing, complete blocks 
					//Check indicates whether we moved past current block 
					if(blockpointer != currentblock)
					{
						offsetpointer = 31;
					}
					
					for(; offsetpointer > -1 ; offsetpointer--)
					{
						int ideal_spot_value = (1 << offsetpointer);
						/*We take the complement of the current spot since it would be
						 * 111...0.111, hence the complement is the 2^(offsetpointer), we find
						 * first one that matches, its a free spot
						 * 
						 * 
						 * 
						 */
						int isfreespot = upperdeck[blockpointer] & ideal_spot_value;
						//spot is good 
						if(isfreespot == ideal_spot_value)
						{
							spot[0] = blockpointer;
							spot[1] = offsetpointer;
							isfreespotsupper--;
							numberofspotstaken++;
							return 1;
						}
						
					}
				}
					//isfreespots = 0;
					findfirstAvaliableSpotUpperDeck(spot,mode);
					return -1;
			}
		
		
		
		
}
	
	
	/*
	 * This function performs a quick update to a spot by changing the state to free, THIS IS USED BY DEPATURE!
	 * , this function now also changes a spot to occupied for upperdeck only
	 * */
	public int changeSpotToFreeorOccupied(int[] spot, int mode)
	{
		int block = spot[0];
		int offset = spot[1];
		if(mode == 1)
		{
			isfreespotslower ++;
			lowerdeck[block] =+ (1 << offset);
			//numberofspotstaken--;
			
		}
		
		else if(mode == 2)
		{
			isfreespotsupper ++;
			upperdeck[block] =+ (1 << offset);
			numberofspotstaken--;
		}
		
		else if(mode == 3)
		{
			upperdeck[block] -= (1 << offset);
			numberofspotstaken++;
		}
		
	
		else
		{
			
			return -1;
		}
			
		
		return 1;
	}

	
	/*
	 * Quick function to determine if there are free spots 
	 */
	public int checkifFreespots(int mode)
	{
		if(mode == 1)
		{
			if(lastchosenlowerdeck == lowerdeck.length)
			{
				return -1;
			}
			
			return 1;
		}
		
		else if(mode == 2)
		{
			if(lastchosenupperdeck == upperdeck.length)
			{
				return -1;
				
			}
			return 1;
		}
		
		return -2;
	}

	
	public int setupDailySpots(int size)
	{
		numberofdailyspots = size;
		
		return 1;
		
	}

	public int spotsleft()
	{
		if(numberofspotstaken == (upperdeck.length * 31))
		{
			return 1;
		}
		
		else if(numberofspotstaken == ((upperdeck.length * 31) - numberofdailyspots))
		{		
		return 2;
		}
		
		else if(numberofspotstaken < ((upperdeck.length * 31) - numberofdailyspots))
		{
			return 3;
		}
		
		else if(numberofspotstaken > ((upperdeck.length * 31) - numberofdailyspots))
			return 4;
		return -1;
	}

	
}
	


