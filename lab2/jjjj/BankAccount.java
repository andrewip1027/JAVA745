import java.util.*;

public class BankAccount {
	
	private String acctName = "";
	private int acctNumber = 0;
	private double acctBalance = 0.0;
	private Date transactionDate = null;
	
	private void checkBalance(double balance, String transactionType) {
		double currentBalance = this.acctBalance;
		
		if(transactionType == "deposit") {
			currentBalance = currentBalance + balance;
		}else if(transactionType == "withdraw") {
			currentBalance = currentBalance - balance;
		}
		
		if(currentBalance < 0) { //balance below zero
			System.out.println("Transaction rejected. Resulting balance is below zero.");  
		}else { //
			this.acctBalance = currentBalance;
			System.out.println("Transaction completed on " + this.transactionDate + ".");
		}
	}
	
	public BankAccount(String acctName, int acctNumber) {
		this.acctName = acctName;
		this.acctNumber = acctNumber;
		this.transactionDate = new Date();
	}
	
	public String[] getInfo(){
		String[] info = new String[3];
		info[0] = this.acctName;
		info[1] = Integer.toString(this.acctNumber);
		info[2] = this.transactionDate + "";
		return info;
	}
	
	public void deposit(double acctBalance) {
		checkBalance(acctBalance, "deposit");
		this.transactionDate = new Date();
	}
	
	public void withdraw(double acctBalance) {
		checkBalance(acctBalance, "withdraw");
		this.transactionDate = new Date();
	}
	
	public double showBalance() {
		return this.acctBalance;
	}

}