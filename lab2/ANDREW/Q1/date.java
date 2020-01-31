/*
JAVA 745
Date:
Author: 
*/
import java.util.Scanner;

public class date {
    /*SECTION  3.14 (Date Class) Create a class called Date that includes three instance variables - a month (type int),a day (type int) and a year (type int). */
    private int month; //month
    private int day; //day 
    private int year; //year
    /*NOTE Variables which are defined without the STATIC keyword and are Outside any method declaration are Object-specific and are known as instance variables*/
    
    /*SUB-SECTION -Provide a constructor that iniitializes the three instance variables and assumes that the values provided are correct */
    //!constructor initilize instance variables
    public date(int month, int day, int year){        
        this.month = month;
        this.day = day;
        this.year = year;
    }
//NOTE Access Modifiers = public or private
    /*SECTION  -Provide a set and get method for each instance variable.*/ //!REMEMBER SET METHOD have () Inside have to specify the instance variable
        //set method - month
    private void setMonth(int month){
        this.month = month;
    }  
        //get method - month
    private int getMonth(){ //return Month      
        return this.month;
    }
        //set method - day
    private void setDay(int day){
        this.day = day;
    }
        //get method - day
    private int getDay(){
        return this.day;
    }
        //set method - year 
    private void setYear(int year){
        this.year = year;
    }
        //get method - year
    private int getYear(){
        return this.year;
    }
    
    /*SECTION -Provide a method displayDate that displays the month, day and year separated by forward slashes (/) */ 
        //create method 
    public void displayDate (int month, int day, int year){
        System.out.println(this.month + "/" + this.day + "/" + this.year);
    }

// -Write a test app named DateTest that demonstrates class Date's capabilities.

