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

import java.util.Arrays;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.CategoryAxis;
import javafx.collections.FXCollections; 
import javafx.geometry.Insets;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;


public class makeChart  extends Application{
    
    String targetDay;
    String targetMonth;
    String targetYear;
    Scene back; 
    Reservation[] resDataBase;
    
    public void showchart(Stage stage, Scene scene, String day, String month, String year, Reservation[] resDB){
        targetDay = day;
        targetMonth = month;
        targetYear = year;
        back = scene;
        //System.out.println("Test"); 
        resDataBase = resDB; 
        start(stage); 
    }
    
    @Override public void start(Stage stage) {
        
        if(targetDay.equals("") && targetMonth.equals("")){
            System.out.println("yearInMonths1");
            yearInMonths(stage, back);
        }else if(targetDay.equals("") && !targetMonth.equals("")){
            monthOfYear(stage, back);
        }else if(!targetDay.equals("") && !targetMonth.equals("")){
                            
             weekOfDay(stage, back); 
        }  
        
    }

    public void weekOfDay(Stage stage, Scene back){
        /*
        //Ask use for target month
        //System.out.println("Please enter your target year:");
        String tday = targetDay;
        int day =  Integer.parseInt(tday); 
        String tmonth = targetMonth;
        int month =  Integer.parseInt(tmonth.substring(4,6)); 
        String tyear = targetYear; 
        int year =  Integer.parseInt(tyear); 
        
        //System.out.println(day+" month: "+month+"\nyear: "+year);
        //System.out.println("Please enter your target month:");
        
        stage.setTitle("Reservations in month X");

        //Declair axis 
        final CategoryAxis xAxis = new CategoryAxis(); 
        final NumberAxis yAxis = new NumberAxis();

        //Define yAxis
        yAxis.setLabel("Reservation Count");
        //yAxis.setAutoRanging(false);

        //Define xAxis
        String[] categories = new String[1];// = new ArrayList<String>(); 
        if(month > 12 || month < 1){
            System.out.println("Invalid date");
        }else if(month == 2){
            categories = new String[28]; 
            for(int i = 1; i <= 28; i++){categories[i-1]=Integer.toString(i);}
        }else{
            categories = new String[31]; 
            for(int i = 1; i <= 31; i++){categories[i-1]=Integer.toString(i);}

        }
        xAxis.setLabel("Date");
        xAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList(categories))); 

        //Define Chart
        final LineChart<String,Number> lineChart = new LineChart<String,Number>(xAxis,yAxis);
        lineChart.setTitle("Reservation in month of "+month+"/"+year);
        XYChart.Series series = new XYChart.Series();
        series.setName("Reservation Spread");

        //Produce Data
        int[] days = new int[7];

        Arrays.fill(days,0);
        
        int i = 0;
        while(i < resDataBase.length){
            //System.out.println("Entry "+(i+1)+": Month-"+resDataBase[i].date.smonth+", Year-"+resDataBase[i].date.year);
            if(resDataBase[i].date.day == day && resDataBase[i].date.month == month && resDataBase[i].date.year == year){
                days[resDataBase[i].date.day - 1] += 1; 
            }
            i++; 
            //series.getData().add(new XYChart.Data(Integer.toString(resDataBase[i].date.day), resDataBase[i].date.year));
        }

        //for(int i = 0; i < days.length; i++){
        //    series.getData().add(new XYChart.Data(Integer.toString(i+1), days[i]));
        //}
        
        VBox layout = new VBox(10);
        
            
         //backbutton
        Button backbutton = new Button("Back to start");
        backbutton.setOnAction(e->stage.setScene(back)); 
        
        
        lineChart.getData().add(series);
        
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(lineChart, backbutton); 
        
        Scene scene  = new Scene(layout,800,600);
        //return scene; 
        stage.setScene(scene);
        stage.show();  
        */
    }
    
    public void monthOfYear(Stage stage, Scene back) {

        int month; 
        int year; 

        //Ask use for target month
        //System.out.println("Please enter your target year:");
        String tmonth = targetMonth;
        month =  Integer.parseInt(tmonth.substring(4,6)); 
        String tyear = targetYear; 
        year =  Integer.parseInt(tyear); 
        
        //System.out.println("month: "+month+"\nyear: "+year);
        //System.out.println("Please enter your target month:");
        
        stage.setTitle("Reservations in month X");

        //Declair axis 
        final CategoryAxis xAxis = new CategoryAxis(); 
        final NumberAxis yAxis = new NumberAxis();

        //Define yAxis
        yAxis.setLabel("Reservation Count");
        //yAxis.setAutoRanging(false);

        //Define xAxis
        String[] categories = new String[1];// = new ArrayList<String>(); 
        if(month > 12 || month < 1){
            System.out.println("Invalid date");
        }else if(month == 2){
            categories = new String[28]; 
            for(int i = 1; i <= 28; i++){categories[i-1]=Integer.toString(i);}
        }else{
            categories = new String[31]; 
            for(int i = 1; i <= 31; i++){categories[i-1]=Integer.toString(i);}

        }
        xAxis.setLabel("Date");
        xAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList(categories))); 

        //Define Chart
        final LineChart<String,Number> lineChart = new LineChart<String,Number>(xAxis,yAxis);
        lineChart.setTitle("Reservation in month of "+month+"/"+year);
        XYChart.Series series = new XYChart.Series();
        series.setName("Reservation Spread");

        //Produce Data
        int[] days;
        if(month == 2){
            days = new int[28];
        }else{
            days = new int[31];
        }
        Arrays.fill(days,0);

        for(int i = 0; i < resDataBase.length; i++){
            //System.out.println("Entry "+(i+1)+": Month-"+resDataBase[i].date.smonth+", Year-"+resDataBase[i].date.year);
            if(resDataBase[i].date.month == month && resDataBase[i].date.year == year){
                days[resDataBase[i].date.day - 1] += 1; 
            }
            //series.getData().add(new XYChart.Data(Integer.toString(resDataBase[i].date.day), resDataBase[i].date.year));
        }

        for(int i = 0; i < days.length; i++){
            series.getData().add(new XYChart.Data(Integer.toString(i+1), days[i]));
        }
        
        VBox layout = new VBox(10);
        
            
         //backbutton
        Button backbutton = new Button("Back to start");
        backbutton.setOnAction(e->stage.setScene(back)); 
        
        
        lineChart.getData().add(series);
        
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(lineChart, backbutton); 
        
        Scene scene  = new Scene(layout,800,600);
        //return scene; 
        stage.setScene(scene);
        stage.show(); 
    }
    
    public void yearInMonths(Stage stage, Scene back) {
                System.out.println("yearInMonths");
        //Ask use for target month
        //System.out.println("Please enter your target year:");
        String tyear = targetYear; 
        int year =  Integer.parseInt(tyear); 
        
        //System.out.println("month: "+month+"\nyear: "+year);
        //System.out.println("Please enter your target month:");
        
        stage.setTitle("Reservations in "+year);

        //Declair axis 
        final CategoryAxis xAxis = new CategoryAxis(); 
        final NumberAxis yAxis = new NumberAxis();

        //Define yAxis
        yAxis.setLabel("Reservation Count");
        //yAxis.setAutoRanging(false);
        
        String[] monthnames = {"Jan(01)", "Feb(02)", "Mar(03)", "Apl(04)", "May(05)", "Jun(06)", "Jul(07)", "Aug(08)", "Sept(09)", "Oct(10)", "Nov(11)", "Dec(12)"};
        
        xAxis.setLabel("Date");
        xAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList(monthnames))); 

        //Define Chart
        final LineChart<String,Number> lineChart = new LineChart<String,Number>(xAxis,yAxis);
        lineChart.setTitle("Reservations in per month in "+year);
        XYChart.Series series = new XYChart.Series();
        series.setName("Reservation Spread");

        //Produce Data
        int[] months = new int[12];

        Arrays.fill(months,0);

        for(int i = 0; i < resDataBase.length; i++){
            //System.out.println("Entry "+(i+1)+": Month-"+resDataBase[i].date.smonth+", Year-"+resDataBase[i].date.year);
            
            
            if(resDataBase[i].date.year == year){
                int month = resDataBase[i].date.month; 
                months[month] += 1; 
            }
            //series.getData().add(new XYChart.Data(Integer.toString(resDataBase[i].date.day), resDataBase[i].date.year));
        }

        for(int i = 0; i < months.length; i++){
            
            series.getData().add(new XYChart.Data(monthnames[i], months[i]));
        }
        
        VBox layout = new VBox(10);
        
            
         //backbutton
        Button backbutton = new Button("Back to start");
        backbutton.setOnAction(e->stage.setScene(back)); 
        
        
        lineChart.getData().add(series);
        
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(lineChart, backbutton); 
        
        Scene scene  = new Scene(layout,800,600);
        //return scene; 
        stage.setScene(scene);
        stage.show(); 
    }
}
