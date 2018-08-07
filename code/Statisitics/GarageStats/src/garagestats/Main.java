/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garagestats;

/**
 *
 * @author B. Dunlap
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.CategoryAxis;
import javafx.collections.FXCollections; 
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import javafx.scene.chart.BarChart;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage; 


import java.util.*;
import javafx.geometry.Insets;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class Main extends Application{// implements EventHandler<ActionEvent>{
    
    Button button1, button2, backbutton; 
    Stage window; 
    Scene startScene, monthscene, yearscene; 
    ComboBox<String> comboBox;
    String targetyear;
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override public void start(Stage primaryStage) throws Exception {
        
        //reservationsPerDay chart = new reservationsPerDay();
        reservationDataBase rdb = new reservationDataBase();
        Reservation[] resDataBase = rdb.generateDataBase(50000);
        
        window = primaryStage;
        window.setTitle("Reservation Stats");
        Button button = new Button("Submit");
        ChoiceBox<String> choiceDay = new ChoiceBox<>(); 
        ChoiceBox<String> choiceMonth = new ChoiceBox<>(); 
        ChoiceBox<String> choiceYear = new ChoiceBox<>(); 
        
        //Add items to choice boxes
        choiceDay.getItems().add("");
        for(int i = 1; i <= 31; i++){
            choiceDay.getItems().add(i+"");
        }
        choiceDay.setValue("");
        
        choiceMonth.getItems().addAll("","Jan(01)", "Feb(02)", "Mar(03)", "Apl(04)", "May(05)", "Jun(06)", "Jul(07)", "Aug(08)", "Sept(09)", "Oct(10)", "Nov(11)", "Dec(12)");
        choiceMonth.setValue("");
        
        for(int i = 2010; i <= 2020; i++){
            choiceYear.getItems().add(i+"");
        }
        choiceYear.setValue("2010");
        
        //button.setOnAction(e -> getChoice(choiceBox)); 
        
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().addAll(choiceDay, choiceMonth, choiceYear, button);
        
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10); 
        

        
        //Month label
        Label monthLabel = new Label(" Month: ");
        GridPane.setConstraints(monthLabel, 1, 0); 
        
        //Month input
        GridPane.setConstraints(choiceMonth, 2, 0); 
        
        //Year label
        Label yearLabel = new Label(" Year: ");
        GridPane.setConstraints(yearLabel, 3, 0); 
        
        //Year input
        GridPane.setConstraints(choiceYear, 4, 0); 
        
        //Submit button
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e ->{
                //targetmonth = month.getText();
                makeChart chart = new makeChart();
                chart.showchart(window, startScene, choiceDay.getValue(), choiceMonth.getValue(), choiceYear.getValue(), resDataBase);
                //window.setScene(monthscene);
            } ); 
        GridPane.setConstraints(submitButton, 1, 1);
        
        grid.getChildren().addAll(monthLabel, choiceMonth, yearLabel, choiceYear, submitButton); 
        
        startScene = new Scene(grid, 400, 200);
        submitButton.setOnAction(e ->{
                //targetmonth = month.getText();
                makeChart chart = new makeChart();
                chart.showchart(window, startScene, choiceDay.getValue(), choiceMonth.getValue(), choiceYear.getValue(), resDataBase);
                //window.setScene(monthscene);
            } ); 
        
        window.setScene(startScene);
        window.show(); 
        /*
        //Password label
        Label passLabel = new Label("Password");
        GridPane.setConstraints(passLabel, 0, 1); 
        
        //Password input
        TextField passInput = new TextField();
        passInput.setPromptText("password"); 
        GridPane.setConstraints(passInput, 1, 1);
        
        
        Button loginButton = new Button("Log In");
        GridPane.setConstraints(loginButton, 1, 2);
        */
        
        
        
        //Form
        //TextField day = new TextField(); 
       // TextField month = new TextField(); 
        //TextField year = new TextField(); 
        
        
        //reservationsPerDay chart = new reservationsPerDay();
        //reservationDataBase rdb = new reservationDataBase();
        //Reservation[] resDataBase = rdb.generateDataBase(20000);
        
        /*
        //Layout1
            VBox startlayout = new VBox(10);
            Label label1 = new Label("Produce Graph :");
            
            //Reservations by Day
            Label label2 = new Label("Reservations of X month:");
            button1 = new Button("Generate Month Graph");
            button1.setOnAction(e ->{
                //targetmonth = month.getText();
                chart.showchart(window, startscene, month.getText(), resDataBase);
                //window.setScene(monthscene);
            } ); 
            
            Label label3 = new Label("Reservations of X year:");
            button2 = new Button("Generate Year Graph");
            button2.setOnAction(e -> {
                //targetyear = year.getText(); 
                window.setScene(yearscene);
            } );  
            
            Button closeButton = new Button("Close");
            closeButton.setOnAction(e-> closeProgram());

            window.setOnCloseRequest(e->{
                e.consume(); 
                closeProgram();
            });

            startlayout.setPadding(new Insets(20, 20, 20, 20));
            startlayout.getChildren().addAll(label1, label2, month, button1, /*label3, year, button2, closeButton); 
            startscene = new Scene(startlayout, 200,600); 
        //end Layout1
        
        //backbutton
        backbutton = new Button("Back to start");
        backbutton.setOnAction(e->window.setScene(startscene)); 
        
        //Layout2
            StackPane monthlayout = new StackPane(); 
            monthlayout.getChildren().add(backbutton); 
            monthscene = new Scene(monthlayout, 600, 300);
        //end Layout2
        
        //Layout3
            StackPane yearlayout = new StackPane(); 
            yearlayout.getChildren().add(backbutton); 
            yearscene = new Scene(yearlayout, 600, 300);
        //end Layout3
        

        window.setScene(startscene);
        window.show(); 

         */
    }
        

    
    private void closeProgram(){
        Boolean answer = ConfirmBox.display("Close", "Are you sure?"); 
        if(answer)window.close(); 
    }

}