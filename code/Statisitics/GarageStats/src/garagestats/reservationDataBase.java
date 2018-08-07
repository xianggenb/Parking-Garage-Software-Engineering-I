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

import java.util.*; 
import java.util.Scanner; 

public class reservationDataBase {
    
    public reservationDataBase(){
    
    }
    
    public Reservation[] generateDataBase(int numOfRes){
        Scanner scn = new Scanner(System.in);
        Random random = new Random(); 
        

        
        Reservation[] resDataBase = new Reservation[numOfRes];  
        
        for(int i = 0; i < numOfRes; i++){
            Reservation temp = new Reservation(); 
            temp.ResID = random.nextInt(99999) + 1;
            int month = random.nextInt(12);
            int day = 0; 
            if(month == 2){
                day = random.nextInt(28)+1;
            }else{
                day = random.nextInt(31)+1;
            }
            
            temp.date = new Date(random.nextInt(6), day, month, random.nextInt(11)+2010); 
            temp.startTime = new Time(random.nextInt(24), random.nextInt(59));
            temp.rate  = 5; 
            resDataBase[i] = temp; 
        }
        
        return resDataBase; 
    }


}
