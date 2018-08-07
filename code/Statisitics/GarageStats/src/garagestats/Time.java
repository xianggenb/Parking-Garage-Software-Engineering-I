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
class Time{
    int hour; 
    int minute; 
    int period; 
    
    public Time(int h, int m){
          hour = h; 
          minute = m; 
          if(hour < 12 || hour == 24 || hour == 0){ 
            period = 0; 
          }else if(hour >= 12){
            period = 1;   
          }
    }
    
    public String toString(){
        if(hour < 12 || hour == 24 || hour == 0)return hour+":"+minute+"a.m.";
        else if(hour >= 12)return (hour-12)+":"+minute+"p.m.";
        else return "Invalid time"; 
    } 
}
