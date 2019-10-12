import java.util.Scanner;
import java.util.Date;
/**
 * This is an application which models a bank teller system which
 * allows the user to create accounts and allows for withdrawal and deposits.
 * 
 * 
 * 
 */
/**
 * @author ANDREW.IP
 * 
 *
 */
public class bank {
	public static class Account {  //instance variables  //CLASS - THE DEFINITION 
		private String accountName;             //
		private int accountNumber;
		private double accountBalance;    //private mostly cannot change, with exception 
		private Date openingDate = new Date();
		private Date lastTransactionTime = null;
	
		public void setName(String name) {   //public can change and use
			this.accountName = name;
		}

		public String getName () { 
			return this.accountName;  //return accoutName String for function use 
		}
		
		public void setNumber (int number) {
			this.accountNumber = number;
		}
 
		public int getNumber () {
			return this.accountNumber;
		}
		public void setBalance (double balance) {
			this.accountBalance = balance;
			this.lastTransactionTime = new Date();
		}
 
		public double getBalance () {
			return this.accountBalance;
		}

		public Date getOpeningDate() {
			return this.openingDate;
		}

		public Date getLastTransactionTime() {
			return this.lastTransactionTime;
		}
	}
	/**
	 *  Main execution thread of the program
	 *  
	 * @param args , not used in this application
	 * 
	 */
	public static void main(String[] args) {
		// create accounts
		
		// ask for number of accounts
		Scanner input = new Scanner(System.in);
		System.out.println("How many accounts would you like to create?");
		int numOfAccounts = input.nextInt();
		// allocate storage for accounts
		//"Question 1: To use OBJECTS instead of multiple arrays to store account information."
		//Make it to one array

		//these "class" can be called a type; except int and double
		Account[] accounts = new Account[numOfAccounts];  //Account is a type  //Q1
		
	// (b) a "show balance" choice should be added to the application and implemented.
		// Single array of account objects    counter that is used to generate new account numbers.  Account numbers are distributed by the system to ensure uniqueness.
		int currentAccNum = 7000;
		// accounts => [null, null, null, ...]    // accounts => [Account, Account, Account, ....]
		
		// iteration structure is used to  
		for (int x = 0; x < numOfAccounts; x++) {
			// initialize a account
			accounts[x] = new Account();  
			System.out.print("name of account holder\n");
//set Name  accounts is The public class Account in line 17
			// accounts[x] => the x-th Account in the "accounts" array
			// x -> 0, 1, 2, 3, ....
			// accounts[0] => first Account in the "accounts" array
			// accounts => [ first Account, second Account, .... ]
			// accounts[0] => first Account
			// set name in the x-th Account in the "accounts" array
			// set name in the first Acccount in the "accounts array" 
			accounts[x].setName(input.next());  //account x  - input.next  
			
			//set Number 
			accounts[x].setNumber(currentAccNum);  //which is 7000  ; and set it to cyrrebtAccNum
			currentAccNum = currentAccNum + 1;  //7000 + 1 each loops
			
			//set balance
			accounts[x].setBalance(0);
			
			//get name
			System.out.printf("new account created, name: %s account number %d,\n"
						,accounts[x].getName(),accounts[x].getNumber());
		}
		
		int choice;
		do {
			// update accounts
			//this must be inside while loop
			System.out.println("What do you want to do?");
			System.out.println("1. Deposit");
			System.out.println("2. Withdraw");
			System.out.println("3. Show Balance");
			System.out.println("4. Exit");
			choice = input.nextInt();
			int d = 0;

			switch (choice) {
			case 1:
				// deposit
				// get account number from user
				System.out.println("Which account do you want to deposit to?");
				int acctNumDep = input.nextInt();
				
				// find account number		
				d = 0;
				while ((d < numOfAccounts) && (accounts[d].getNumber() != acctNumDep))  //while account number not equal to accout number dep AND d < numofAccounts
					d++;
				
				// deposit money into account selected
				if (d < numOfAccounts ) {
					System.out.println("How much to deposit?");
					double amount = input.nextDouble();
					if(amount >= 0) {   
						accounts[d].setBalance(accounts[d].getBalance()+amount);
						System.out.printf("account name: %s, account number: %d, opening date: %tF, bal: $%.2f, updated at %tT!\n", 
							accounts[d].getName(),
							accounts[d].getNumber(),
							accounts[d].getOpeningDate(),
							accounts[d].getBalance(),
							accounts[d].getLastTransactionTime());
					}
					else {
						System.out.println("Cannot deposit negative amount");
					}
				} else {
					System.out.println("Invalid account number"); 
				}

				break;

			case 2:
			// get account number from user
			System.out.println("Which account do you want to withdraw from?");
			int acctNumWithdraw = input.nextInt();
			
			// find account number		
			d = 0;		
			while ((d < numOfAccounts) && (accounts[d].getNumber() != acctNumWithdraw))  //while account number not equal to accout number dep AND d < numofAccounts
				d++;

			if (d < numOfAccounts ) {
				System.out.println("How much do you want to withdraw");
				double amount = input.nextDouble();
				if(amount >= 0) {
					if(amount<=accounts[d].getBalance()){
						accounts[d].setBalance(accounts[d].getBalance()-amount);
				
						System.out.printf("account name: %s, account number: %d, opening date: %tF, bal: $%.2f, updated at %tT!\n", 
							accounts[d].getName(),
							accounts[d].getNumber(),
							accounts[d].getOpeningDate(),
							accounts[d].getBalance(),
							accounts[d].getLastTransactionTime());;
					}else{
						System.out.println("Not enough funds");
					}
				}
				else {
					System.out.println("Cannot withdraw negative amount");
				}
			} else {
				System.out.println("Invalid account number"); 
			}
				

// if  withdraw > balance  
// not enough funds to withdraw
// else  //the person can withdraw
break;

// (c) account balance should never go below zero. Transactions that cause this should be rejected

			case 3:
// Show balance (b) a \show balance" choice should be added to the application and implemented.
				//ask user which account show balance 
				System.out.println("Which account you want to show balance?");
				int acctNumShowBal= input.nextInt();
				
				// find account number		
				d = 0;		
				while ((d < numOfAccounts) && (accounts[d].getNumber() != acctNumShowBal))  //while account number not equal to accout number dep AND d < numofAccounts
					d++;

				if (d < numOfAccounts ) {
					//same as above but no transaction time!4
					System.out.printf("account name: %s, account number: %d, opening date: %tF, bal: $%.2f!\n", 
							accounts[d].getName(),
							accounts[d].getNumber(),
							accounts[d].getOpeningDate(),
							accounts[d].getBalance());
				} else {
					System.out.println("Invalid account number"); 
				}
				break;

			case 4:
				// exit

				break;

			default:	
				// invalid
			}			
		} while(choice != 4);
		
	}

}