/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class ChequingAccount extends Account {
    private int numberOfFreeWithdrawal = 5;
    private static double withdrawalFee = 3.95;
    
    public ChequingAccount(int accountNumber, String name, double balance){
        super(accountNumber,name,balance);
    }
    
    //withdrawal fee will be charged after 5 times withdrawal
    public double withdraw(double withdrawAmount){
        if(numberOfFreeWithdrawal > 0){
            numberOfFreeWithdrawal--;
        }else{
            super.withdraw(withdrawalFee);
        }
        return super.withdraw(withdrawAmount);
    }
}
