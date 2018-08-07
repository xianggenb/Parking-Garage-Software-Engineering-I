/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garagestats;

/**
 *
 * @author BCDunlap
 */
public class Reservation {
    //int CustomerID; 
    int ResID; 
    Date date; 
    Time startTime, endTime; 
    int rate; 
    
    public Reservation(){
    
    }
    
    public Reservation(int id, Date d, Time st, Time et, int r){
        ResID = id; 
        date = d; 
        startTime = st; 
        endTime = et; 
        rate = r; 
    }
    
    public int provideTotalTime(char a){
        int hours = 0; 
        int mins = 0;
        int total = 0;
        
        mins = endTime.minute + startTime.minute; 
        if(endTime.period == 0 && startTime.period == 1){ //if reservation takes place over the course of two days 
            hours = 24 - startTime.hour + endTime.hour;           
        }else{
            hours = startTime.hour + endTime.hour;
        }
        
        return 60*(endTime.hour - startTime.hour); 
    }
}
