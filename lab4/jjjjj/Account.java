/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 
 */
public class Account {
   private double balance;
   private String name;
   private int accountNumber;
   
   public Account(int accountNumber, String name, double balance){
       this.accountNumber = accountNumber;
       this.balance = balance;
       this.name = name;
   }


   //deposit will be processed if the amount is greater than zero
   public void deposit(double depositAmount){
       if(depositAmount > 0){
            this.balance = this.balance + depositAmount;
       }
   }
   
   //withdrawal will be processed if the withdrawing amount is greater than zero
   public double withdraw(double withdrawAmount){
       if(withdrawAmount > 0){
           this.balance = this.balance - withdrawAmount;
       }       
       return withdrawAmount;
   }
   
    //return information about account number, current balance and client's name
    public String[] retrieveClientInfo(){
        String[] clientInfo = new String[3];
        clientInfo[0] = String.valueOf(this.accountNumber);
        clientInfo[1] = this.name;
        clientInfo[2] = String.valueOf(this.balance);
        return clientInfo;
    }   
    }
