/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 
 */
public class SavingAccount extends Account {
    private static double interestRate = 0.05;
    
    public SavingAccount(int accountNumber, String name, double balance){
        super(accountNumber,name,balance);
    }
    
    //calculate the interest based on the fixed interest rate
    public double calculateInterest(){
        return Double.parseDouble(super.retrieveClientInfo()[3]) *  SavingAccount.interestRate;
    }
    
    //add the interest to the account balance
    public void addInterest(){
        super.deposit(calculateInterest());
    }
}