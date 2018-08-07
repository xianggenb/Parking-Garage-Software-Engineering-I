#include<iostream>
#include<stdlib.h>
#include<mysql/mysql.h>
#include<string.h>
#include <time.h>
#include<cmath>
#include<stdio.h>
#include <errno.h>
#include <fstream>
#include <sys/socket.h>
#include <unistd.h>
#include <sys/types.h>
#include <netdb.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include<sys/wait.h>
#include<assert.h>
#include <fcntl.h>  
using namespace std;
const char *host="localhost";
const char *user="root";
const char *pass="Xingxiang25";
const char *dbname="depature";


unsigned int port=3306;
static char* unix_socket=NULL;
unsigned int flag=0;

void calculate_fee(const char* est_time, const char* depature_time, const char* arrival_time){
    double weekday_rate; 
    double overstay_charge;
    double normal_charge;
    double total_charge;
    double overstay_rate=2;
        double winter_speical=0.75;
        double summer_special=0.5;
        double March_special=20;
        double june_special=20;
    double newyear_special=20;
    double indep_special=20;
    int month;
    int date; 
    int year;
time_t t1, t2, t3;
    struct tm tm1, tm2, tm3;
    const char* time1 = est_time;
    const char* time2 = depature_time;
    const char* time3 = arrival_time;
strptime(time1, "%F %T",&tm1);
strptime(time2, "%F %T",&tm2);
strptime(time3, "%F %T",&tm3);
t1 = mktime(&tm1);
t2 = mktime(&tm2);
t3 = mktime(&tm3);
sscanf(time3, "%d-%d-%d",&year,&month, &date);
int w=((date+2*month+3*(month+1)/5+year+year/4-year/100+year/400) % 7);
if(w==6 or w==7){
weekday_rate=16;
cout<<"you arrived on weekend and our weekend rate is $16 per hour"<<endl;

}
else{
weekday_rate=10;
cout<<"you arrived on weekday and our weekday rate is $10 per hour"<<endl;
}
double Diff1=difftime(t1,t3);
int j=ceil(Diff1/3600);
double Diff = difftime( t2, t1 );
int i=ceil(Diff/3600);
char c;
cout<<i<<" hours is your overstay time"<<endl;//first compare the estimate time(t1) and the depature time(t2) 
cout<<j<<" hours is your reservation time"<<endl;
if((date==17 and month==3) or(date==31 and month==12)or(date==4 and month==7)){
cout<<"you have to pay for the special rate $20 for holiday"<<endl;
if (Diff>=0){
double overstay_charge= i*overstay_rate;
double normal_charge=(i+j)*March_special;
double total_charge=overstay_charge+normal_charge;

cout<<"you have been overstayed for "<<i<<" hours \nand there will be and extra charge of "<< overstay_charge<<endl;
cout<<"your totoal charge will be "<<total_charge<<endl;

}
else{
double normal_charge=j*March_special;
cout<<"your reservation is completed"<<endl;
cout<<"your total charge is "<<normal_charge<<endl;



}
}
if(month==1){

cout<<"you have the winter discount 25% off"<<endl;
if (Diff>=0){
double overstay_charge= i*overstay_rate;
double normal_charge=(i+j)*weekday_rate;
double total_charge=(overstay_charge+normal_charge)*winter_speical;

cout<<"you have been overstayed for "<<i<<" hours \nand there will be and extra charge of "<< overstay_charge<<endl;
cout<<"your totoal charge will be "<<total_charge<<endl;

}
else{
double normal_charge=j*weekday_rate*winter_speical;
cout<<"your reservation is completed"<<endl;
cout<<"your total charge is "<<normal_charge<<endl;



}

}
if(month==6 and date>=1 and date<=8){

cout<<"you have the summer discount 50% off"<<endl;
if (Diff>=0){
double overstay_charge= i*overstay_rate;
double normal_charge=(i+j)*weekday_rate;
double total_charge=(overstay_charge+normal_charge)*summer_special;

cout<<"you have been overstayed for "<<i<<" hours \nand there will be and extra charge of "<< overstay_charge<<endl;
cout<<"your totoal charge will be "<<total_charge<<endl;

}
else{
double normal_charge=j*weekday_rate*summer_special;
cout<<"your reservation is completed"<<endl;
cout<<"your total charge is "<<normal_charge<<endl;



}

}

else{

if (Diff>=0){
double overstay_charge= i*overstay_rate;
double normal_charge=(i+j)*weekday_rate;
double total_charge=overstay_charge+normal_charge;

cout<<"you have been overstayed for "<<i<<" hours\nand there will be and extra charge of "<< overstay_charge<<endl;
cout<<"your totoal charge will be "<<total_charge<<endl;

}
else{
double normal_charge=j*weekday_rate;
cout<<"your reservation is completed"<<endl;
cout<<"your total charge is "<<normal_charge<<endl;




}

}

}

const std::string get_currentime() {
    time_t     now = time(0);
    struct tm  tstruct;
    char       buf[80];
    tstruct = *localtime(&now);
    
    strftime(buf, sizeof(buf), "%Y-%m-%d %X", &tstruct);

    return buf;
}
int main(){


const char* arrival_time;
const char* est_time;
const char* email;
const char* payment;
MYSQL*conn;
MYSQL_RES *res;
MYSQL_ROW row;
MYSQL*conn2;
MYSQL_RES *res2;
MYSQL_ROW row2;

std::string c=get_currentime();
const char*current_time=c.c_str();

/*conn=mysql_init(NULL);
if(!(mysql_real_connect(conn, host, user, pass, dbname, port, unix_socket,flag))){
fprintf(stderr, "\nerror: %s [%d]\n",mysql_error(conn),mysql_errno(conn));
exit(1);
};
std::cout<<"connection successful!"<<std::endl;
mysql_query(conn,"SELECT *FROM depature");
res=mysql_store_result(conn);*/


//std::cout<<"enter the plate number:"<<std::endl;
//std::cin>> ptn;
/*sockaddr_in si_me, si_other;
int s;
assert((s=socket(AF_INET, SOCK_DGRAM, IPPROTO_UDP))!=-1);
int port=6000;
int broadcast=1;

setsockopt(s, SOL_SOCKET, SO_BROADCAST,
            &broadcast, sizeof broadcast);

memset(&si_me, 0, sizeof(si_me));
si_me.sin_family = AF_INET;
si_me.sin_port = htons(port);
si_me.sin_addr.s_addr = INADDR_ANY;

assert(::bind(s, (sockaddr *)&si_me, sizeof(sockaddr))!=-1);

while(1)
{
    char buf[10000];
    unsigned slen=sizeof(sockaddr);
    recvfrom(s, buf, sizeof(buf)-1, 0, (sockaddr *)&si_other, &slen);

    printf("recv: %s\n", buf);
memcpy(ptn,buf,strlen(buf));
    
}*/

setvbuf(stdout, NULL, _IONBF, 0); 
	fflush(stdout); 

	// 绑定地址
	struct sockaddr_in addrto;
	bzero(&addrto, sizeof(struct sockaddr_in));
	addrto.sin_family = AF_INET;
	addrto.sin_addr.s_addr = htonl(INADDR_ANY);
	addrto.sin_port = htons(6000);
	
	// 广播地址
	struct sockaddr_in from;
	bzero(&from, sizeof(struct sockaddr_in));
	from.sin_family = AF_INET;
	from.sin_addr.s_addr = htonl(INADDR_ANY);
	from.sin_port = htons(6000);
	
	int sock = -1;
	if ((sock = socket(AF_INET, SOCK_DGRAM, 0)) == -1) 
	{   
		cout<<"socket error"<<endl;	
		return 0;
	}   

	const int opt = 1;
	//设置该套接字为广播类型，
	int nb = 0;
	nb = setsockopt(sock, SOL_SOCKET, SO_BROADCAST, (char *)&opt, sizeof(opt));
	if(nb == -1)
	{
		cout<<"set socket error..."<<endl;
		return false;
	}

	if(bind(sock,(struct sockaddr *)&(addrto), sizeof(struct sockaddr_in)) == -1) 
	{   
		cout<<"bind error..."<<endl;
		return false;
	}

	int len = sizeof(sockaddr_in);
  while(1){char ptn[255]={0};   
conn=mysql_init(NULL);
conn2=mysql_init(NULL);
if(!(mysql_real_connect(conn, host, user, pass, dbname, port, unix_socket,flag))){
fprintf(stderr, "\nerror: %s [%d]\n",mysql_error(conn),mysql_errno(conn));
exit(1);
};
if(!(mysql_real_connect(conn2, host, user, pass, dbname, port, unix_socket,flag))){
fprintf(stderr, "\nerror: %s [%d]\n",mysql_error(conn),mysql_errno(conn));
exit(1);
};
std::cout<<"connection successful!"<<std::endl;
mysql_query(conn,"SELECT *FROM depature");
mysql_query(conn2,"SElECT *FROM sopt");
res=mysql_store_result(conn);
res2=mysql_store_result(conn2);
	char smsg[100] = {0};

	//从广播地址接受消息
		int ret=recvfrom(sock, smsg, 100, 0, (struct sockaddr*)&from,(socklen_t*)&len);
		if(ret<=0)
		{
			cout<<"read error...."<<sock<<endl;
		}
		else
		{		
		
memcpy(ptn,smsg,strlen(smsg));


	
	}



/*while(row2=mysql_fetch_row(res2)){

char x[40]="update spot set status='0' where LP=";
const char r;
r="'";
const char *rr;
rr=row[0];
strcat(x,r);
strcat(x,rr);
strcat(x,r);
cout<<x<<endl;




}*/



while (row=mysql_fetch_row(res)){
if(strcmp(row[0],ptn)==0){
std::cout<<"the folllowing vehicle have to pay:"<<ptn<<std::endl;
arrival_time=row[1];
est_time=row[2];
email=row[3];
payment=row[4];

std::cout<<"you arrived at "<<row[2]<<" \nand supposed to leave before "<<row[2]<<std::endl;
calculate_fee(est_time,current_time,arrival_time);
cout<<"your card  "<<row[4]<<" will be charged"<<endl;
cout<<"a email will be sent to "<<row[3]<< " shortly"<<endl;

ofstream fout( "/home/xiang/history.txt",ios::app  );
if( !fout )
{
cout<< "error, no such file" << endl;
return -1;
}
fout << row[0]<< " " << row[1] <<" "<<row[2]<<" "<<row[3]<<" "<<row[4]<<endl;
fout.close();
const char* a;
a=row[0];
char x[40]="'";
const char* b;
b=strcat(x,a);
std::string s;
s= b;
const char* t;
t="'";
char c[20];
strcpy(c,s.c_str());
const char* d;
d=strcat(c,t);
char cc[40]="delete from depature where LP=";
const char* bb;
bb=strcat(cc,d);
char p[40]="update spot set status='0' where LP=";
strcat(p,t);
strcat(p,a);
strcat(p,t);
cout<<p<<endl;
mysql_query(conn2,p);
mysql_query(conn,bb);
       






std::string k;

k=char(34);
const char * e = k.c_str();
std::string l;
l=" ";
const char * o=l.c_str();
  char str[80]; 
  strcpy (str,"$echo test|mail -v -s ");
  strcat (str,e);
  strcat (str,"confirmation email from park-a-lot");
strcat(str, e);
strcat(str,o);
  strcat (str,email);
  puts (str);
system(str);










break;
}



} 
mysql_free_result(res);
mysql_close(conn);
}
return 0;

}
