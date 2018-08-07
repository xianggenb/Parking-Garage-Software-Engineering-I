
	To run the code, you need to start up Interface.java. This class contains several testcases which illustrate the  
capabilites of the Arrival code i wrote. However before you do it, you need to import the databases under a schema 
named reservations, spelled exactly as written. Again the schema where the tables fall under is reservations. Also this needs to be a 
local host under port 3306. Furthermore, several testcases will actually be incorrect when you run it since, the time dependent 
testcases have to calibrated on the day of use in order to work, so you could change the entries but in this folder, 
there will be images which are screenshots of the console to help illustrate these special cases. 

Again, Some TESTCASES MAY BE WRONG BECAUSE OF SPECIFIC TIMES NEEDED IN THE DATABASE, SO WHEN YOU RUN IT YOU MAY 
GET DIFFERENT OUTPUT THEN I

Before you run, all the tables under database schema named reservations, and local host, port 3306. 

Test Case 1: 
		Testing basic arrival, first car is expected because he comes in about right on time, and is in the database
	     Second car has invalid confirmationnumber, and hence should not be there and is asked to back up
	     Third car arrives too soon and has to be sent away 
	      Fourth car licenseplate is not read correctly, but his confirmationnumber is correct so he gets a spot
		The next 3 cars are good and have no real testing purposes 
		The 7th car is denied even though his confirmationnumber is correct, he arrived too early
		The last car gets the spot 4 since car 4 left inbetween car 8 arriving 


output:

Here is your spot: 1
Invalid Confirmation Number, please back up
Come back at the scheduled time
Here is your spot: 2
Here is your spot: 3
Here is your spot: 4
Here is your spot: 5
Come back at the scheduled time
Here is your spot: 4


Test Case 2: 
	In order to run this testcase, you need to modifty the rows where the LicensePlate entries are DGH-123,ABC-4567
DGH-123 gets a time within 30 mins of the currentime and ABC-4567 gets a time not within 30 mins of the currentime

Use these statements, update dailytable set StartTime = '(within 30 mins of currentime)' where LP = 'DGH-123'
			update dailytable set StartTime = '(not within 30 mins of currentime)' where LP = 'ABC-4567'

		This testcase deals with recurring customers
		The first makes the grace period
		The second car arrives early 
		The third car misses grace period but still get a spot since no other cars have came, but still gets
		a warning message to indicate in the future this action is not tolerated 
Here is your spot: 1
Come back at the scheduled time
You missed your your grace period, please come on time sooner
Here is your spot: 2




Test Case 3: To tun this testcase you need to do several things, first 
		update dailytable set State = '1' where LP = 'DGH-123'
		update dailytable set State = '1' where LP = 'ABC-4567'
		update dailytable set State = '0' where LP = 'GHJ-878'
		update dailytable set State = '0' where LP = 'bgh'
		update dailytable set State = '0' where LP = 'ABC-567'
		update dailytable set StartTime = '(within 30 mins of currentime)' where LP = 'GHJ-878'
	



	This testcase deals with recurring customers who missed the grace period and other cars arrive before them, the dilemma that arises
	For this testcase only 31 spots exist in the parking garage, hence the first 29 will be filled up by just normal 
	reservations, however the 2 cars arrives after both missed their grace periods and will be in for a rude awakening
	when they find out their spots have been given away, the last car doesn't miss his grace period and is on time

Here is your spot: 1
Here is your spot: 2
Here is your spot: 3
...
Here is your spot: 26
No more spots are left for non-premium members
No more spots are left for non-premium members
You missed your your grace period, please come on time sooner
Your spot was given since you messed the grace period, please come on time, we are looking for a new spot
We apologize, but the only spots remaining are those premium members who did not violate the grace period
You missed your your grace period, please come on time sooner
Your spot was given since you messed the grace period, please come on time, we are looking for a new spot
We apologize, but the only spots remaining are those premium members who did not violate the grace period
Here is your spot: 28

P.S: The reason it stops at 26 and not 29 is because of the way the code is written and the fact that there are extra entries
in the database, however the bitmap doesn't realize that because in the real world, if a recurring customers enters the bitmap 
will realize that and update the number of daily customers who need spots, however for testing sake this not covered but the end 
result is still the same. 










