
/* This class defines the Bitmap data-structure used
 * and it also defines the helper functions needed
 * to access it 
 */
public class Bitmap2 {

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

	// Create standard bitmap deck, for only 3100 spots
	public void createLowerDeckBitmap() {
		lowerdeck = new int[100];
		for (int i = 0; i < 100; i++) {
			lowerdeck[i] = (1 << 31) - 1;
		}

		lastchosenlowerdeck = 0;
		lastlowerdeckindex = 0;
		isfreespotslower = 0;

	}

	// Create a standard bitmap deck, for a specific size
	// however be warned, each int can store 32 bits hence
	// 31 spots because of the 2 complement, so spots will be wasted if the
	// number of spots isn't
	// divisible by 31 which is a prime number, and hence there will be a
	// further update to fix this
	public void createLowerDeckBitmap(int size) {
		lowerdeck = new int[size];
		for (int i = 0; i < size; i++) {
			lowerdeck[i] = (1 << 31) - 1;
		}

		lastchosenlowerdeck = 0;
		lastlowerdeckindex = 0;
	}

	// Create standard bitmap deck, for only 3100 spots
	public void createUpperDeckBitmap() {
		upperdeck = new int[1];
		for (int i = 0; i < 1; i++) {
			upperdeck[i] = (1 << 31) - 1;
		}

		lastchosenupperdeck = 0;
		lastupperdeckindex = 0;
		isfreespotsupper = 0;
		numberofspotstaken = 0;
	}

	// Create a standard bitmap deck, for a specific size
	// however be warned, each int can store 32 bits hence
	// 31 spots, so spots will be wasted if the spots, can't
	// evenly be divided
	public void createUpperDeckBitmap(int size) {
		upperdeck = new int[size];
		for (int i = 0; i < size; i++) {
			upperdeck[i] = (1 << 31) - 1;
			;
		}

		lastchosenupperdeck = 0;
		lastupperdeckindex = 0;
	}
	// This function finds a spot and passes the index spot in the bitmap, and
	// offset(actual spot) to the
	// spot argument, if a spot can't be found
	// then it returns -1 and spot is set also to -1
	// Mode indicates whether you are searching the upper
	// or lower deck

	public int findFirstAvailableSpot(int[] spot, int mode, int mode2)

	{

		if (mode == 1) {
			int iserror = findfirstAvailableSpotLowerDeck(spot);
			if (iserror == -1) {
				spot[0] = -1;
				spot[1] = -1;
				return -1;
			}

		}

		else if (mode == 2) {
			int iserror = findfirstAvaliableSpotUpperDeck(spot, mode2);
			if (iserror == -1) {
				spot[0] = -1;
				spot[1] = -1;
				return -1;
			}

			else if (iserror == -3) {
				return -3;
			}
		}

		else {
			spot[0] = -1;
			spot[1] = -1;
			return -1;
		}

		return 0;
	}

	// This is the function for the lower deck, the upper deck has exact same
	// code however for the
	// upperdeck array
	public int findfirstAvailableSpotLowerDeck(int[] spot) {
		int v = 0;
		for (int i = 0; i < lowerdeck.length; i++) {
			for (; v < 30; v++) {
				int temp = lowerdeck[i];
				if ((temp & (1 << v)) == (1 << v)) {
					spot[0] = i;
					spot[1] = v;
					lowerdeck[i] -= (1 << v);
					return 1;
				}
			}

		}

		return -1;
	}

	public int findfirstAvaliableSpotUpperDeck(int[] spot, int mode) {
		int v = 0;
		for (int i = 0; i < upperdeck.length; i++) {
			for (; v < 31; v++) {
				int temp = upperdeck[i];
				if ((temp & (1 << v)) == (1 << v)) {
					spot[0] = i;
					spot[1] = v;
					upperdeck[i] -= (1 << v);
					numberofspotstaken++;
					if (mode == 0) {
						numberofdailyspots--;
					}
					return 1;
				}
			}

		}

		return -1;
	}

	/*
	 * This function performs a quick update to a spot by changing the state to
	 * free, THIS IS USED BY DEPATURE! , this function now also changes a spot
	 * to occupied for upperdeck only
	 */
	public int changeSpotToFreeorOccupied(int[] spot, int mode) {
		int block = spot[0];
		int offset = spot[1];
		if (mode == 1) {
			isfreespotslower++;
			lowerdeck[block] = +(1 << offset);
			// numberofspotstaken--;

		}

		else if (mode == 2) {
			isfreespotsupper++;
			upperdeck[block] = +(1 << offset);
			numberofspotstaken--;
		}

		else if (mode == 3) {
			upperdeck[block] -= (1 << offset);
			numberofspotstaken++;

		}

		else {

			return -1;
		}

		return 1;
	}

	/*
	 * Quick function to determine if there are free spots
	 */
	public int checkifFreespots(int mode) {
		if (mode == 1) {
			if (lastchosenlowerdeck == lowerdeck.length) {
				return -1;
			}

			return 1;
		}

		else if (mode == 2) {
			if (lastchosenupperdeck == upperdeck.length) {
				return -1;

			}
			return 1;
		}

		return -2;
	}

	public int setupDailySpots(int size) {
		numberofdailyspots = size;

		return 1;

	}

	public int spotsleft() {
		if (numberofspotstaken == (upperdeck.length * 31)) {
			return 1;
		}

		else if (numberofspotstaken == ((upperdeck.length * 31) - numberofdailyspots)) {
			return 2;
		}

		else if (numberofspotstaken < ((upperdeck.length * 31) - numberofdailyspots)) {
			return 3;
		}

		else if (numberofspotstaken > ((upperdeck.length * 31) - numberofdailyspots))
			return 4;
		return -1;
	}

}
