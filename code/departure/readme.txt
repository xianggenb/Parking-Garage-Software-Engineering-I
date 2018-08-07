Xiang Xing

This contains the departure code for the Park-A-Lot system. The files was written and tested by Xiang Xing. 
first import the depature.sql to mysql database so it can connect to the database. Or it can connect to remote database by adding correct information to the code
The simulation can be run under linux system with following command
g++ -o output $(mysql_config --cflags)) connect.cpp $(mysql_config --libs)
./output
Then the program will automatically listen to the information from the sender, which is achieved by using udp socket.
you can create a boardcast with the sender.cpp 
As soon as the License Plate number is given by the simulator, the program will check out the customer information from database, such as arrival time, 
estimate depature time and send a confirmation email to the email address.
After that , the payment will be calculated based on our charging policy and send a confirmation email to the user.
At last, the information for this vehicle will be deleted from database and stored in a file as historylog and a confirmation email will be send to the email address.
