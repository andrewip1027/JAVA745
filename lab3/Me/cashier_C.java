// Write an application using the classes created below in an application class called Cashier
// which can generate a bill of sale for a customer. Upon startup, the user provides the province
// code where the store is located for taxation purposes. The following items can purchased.
//  garden hose (UPC code 0001), $4.99
//  grass seed (UPC code 0002), $0.35 per kg
//  nails (UPC code 0003), $.02 per nail....sold in packages of 50 or 90
//  lawn cutting service, $100
//  professional interlock laying $44 per hour
// The program should ask the user to individually enter the item to be purchased and the quan-
// tity of that item. Only the items above can be purchased. You can assume that a maximum
// of 50 items can be in a transaction so there is no need to ask the user how many items they
// are purchasing. All the items must be stored in a single array of size 50.

import java.util.*;
import java.text.*;
import java.io.*;

public class cashier_C { 

    public static void main(String[] args) { 

        //Declare Variables here 
        double ___ = 0.0; 
        double ___ = 0.0; 
        String ___; 

        //Declare Array Shopping Cart 
        __ [] _____ = new ___ [50];

        Scanner input = new Scanner(System.in);
        boolean _____ = true; 
        String option; 
        String quantity;
        int invoiceNumber = 1;

        //Q1 Both good and hourly rate services are taxable (at fee services are not taxed), the rate depends on the province where the business is taking place.
        
        System.out.print("please enter the Province Code: ");
        provinceCode = input.nextLine();
            if(provinceCode.___().equals())   { 
                goodTax =    [0]  ;
                serviceTax =   [1] ; 
                ask = false;
            }
        while(ask);  //Ask user... 
  
    for(int ___ = 0; ___ < purchaseItem.length; ){
        
    
    }


        //Tax rates Retrieve 
//All goods and services objects must have a method which gets the object's name, object's price
// before tax, one which indicates whether the product is taxed and one which gives the price after
// tax.

    }

}