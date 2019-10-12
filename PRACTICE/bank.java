import java.util.Scanner;
/**
 * This is an application which models a bank teller system which
 * allows the user to create accounts and allows for withdrawal and deposits.
 * 
 * The code is partially complete and was written during the 
 * JAV 745 lecture on September 16.
 * 
 */
/**
 * @author ANDREW.IP
 * 
 *
 */
public class bank {
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
		int [] acctNumbers = new int [numOfAccounts];    //Number of Accounts 
		double [] acctBalance = new double[numOfAccounts];  //Accout Balance

		//Single array of account objects
		
		// counter that is used to generate new account
		// numbers.  Account numbers are distributed by
		// the system to ensure uniqueness.
		int currentAccNum = 7000;
		
		// iteration structure is used to  
		for (int x = 0; x < numOfAccounts; x++) {
			// initialize a account 
			System.out.print("name of account holder\n");
			acctNames[x] = input.next();
			
			acctNumbers[x] = currentAccNum;
			currentAccNum = currentAccNum + 1;
			
			acctBalance[x] = 0;
			
			System.out.printf("new account created, name: %s account number %d,\n"
						,acctNames[x],  acctNumbers[x]);
		}
		// update accounts
		System.out.println("What do you want to do?");
		System.out.println("1. Deposit");
		System.out.println("2. Withdraw");
		System.out.println("3. Exit");
		int choice = input.nextInt();
		
		do {
			
			switch (choice) {
			case 1:
				// deposit
				
				// get account number from user
				System.out.println("Which account to you want to deposit to?");
				int acctNumDep = input.nextInt();
				
				// find account number
				int d = 0;
				while ((acctNumbers[d] != acctNumDep) && (d < numOfAccounts))  //while account number not equal to accout number dep AND d < numofAccounts
					d++;
				
				// deposit money into account selected
				if (d < numOfAccounts ) {
					System.out.println("How much to deposit?"); 
					acctBalance[d] += input.nextDouble();
					System.out.printf("account updated, name: %s account number %d, bal: $%.2f!\n"
							,acctNames[d],  acctNumbers[d], acctBalance[d]);
					
				} else {
					System.out.println("Invalid account number"); 
				}
									
			case 2:
				// withdrawal
			case 3:
				// exit
				s
			default:	
				// invalid
			}
			
			
		} while(choice != 3);
		
	}

}