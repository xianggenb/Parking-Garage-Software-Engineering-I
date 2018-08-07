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
public class Date{
    int dayOfWeek; 
    int day; 
    int month; 
    int year; 
    String sday; 
    String smonth; 
    
    public Date(int dow, int d, int m, int y){
        dayOfWeek = dow; 
        day = d; 
        month = m; 
        year = y; 
        
        switch(dayOfWeek){
            case 0: sday = "Mon";
                break;
            case 1: sday = "Tues";
                break;
            case 2: sday = "Wed";
                break;
            case 3: sday = "Thurs";
                break;
            case 4: sday = "Fri";
                break;    
            case 5: sday = "Sat";
                break;
            case 6: sday = "Sun";
                break;    
            default: sday = "Invalid day";
                break;   
        }
        
        switch(month){
            case 0: smonth = "Jan";
                break;
            case 1: smonth = "Feb";
                break;
            case 2: smonth = "Mar";
                break;
            case 3: smonth = "Apr";
                break;
            case 4: smonth = "May";
                break;    
            case 5: smonth = "Jun";
                break;
            case 6: smonth = "Jul";
                break;  
            case 7: smonth = "Aug";
                break;
            case 8: smonth = "Sep";
                break;
            case 9: smonth = "Oct";
                break;
            case 10: smonth = "Nov";
                break;
            case 11: smonth = "Dec";
                break;    
            default: smonth = "Invalid Month";
                break;   
        }
        
        
    }
    
    public String toStringLong(){
        return sday+" "+smonth+" "+day+", "+year;      
    }
    
    public String toStringShort(){
        return month+"/"+day+"/"+year; 
    }
    
}
