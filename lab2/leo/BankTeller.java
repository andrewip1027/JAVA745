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
 * @author EDEN.BURTON
 *
 */
public class BankTeller {

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
		
		// allocate storage for account objects
		BankAccount[] account = new BankAccount[numOfAccounts];
		
		// counter that is used to generate new account
		// numbers.  Account numbers are distributed by
		// the system to ensure uniqueness.
		int currentAccNum = 7000;
		
		// iteration structure is used to  
		for (int x = 0; x < numOfAccounts; x++) {
			
			// initialize a account 
			System.out.print("name of account holder\n");
			String acctName = input.next();
			currentAccNum = currentAccNum + 1;
			account[x] = new BankAccount(acctName, currentAccNum);
			String[] accountInfo = account[x].getInfo();
			
			System.out.printf("new account created, name: %s account number %d\n"
						, accountInfo[0],  Integer.parseInt(accountInfo[1]));
			System.out.println("Account created on " + account[x].getInfo()[2] + "\n");
		}
		
		
		int choice;
		do {
			// menu options
			System.out.println("What do you want to do?");
			System.out.println("1. Deposit");
			System.out.println("2. Withdraw");
			System.out.println("3. Show Balance");
			System.out.println("4. Exit");
			choice = input.nextInt();
			
			if(choice == 1) {
				// deposit
				
				// get account number from user
				System.out.println("\nWhich account to you want to deposit to?");
				int acctNumDep = input.nextInt();
				
				// find account number
				int d = 0;
				while ((Integer.parseInt(account[d].getInfo()[1]) != acctNumDep) && (d < numOfAccounts))
					d++;
				
				// deposit money into account selected
				if (d < numOfAccounts ) {
					System.out.println("How much to deposit?"); 
					account[d].deposit(input.nextDouble());
					System.out.printf("account updated, name: %s account number %d, bal: $%.2f!\n\n"
							,account[d].getInfo()[0],  Integer.parseInt(account[d].getInfo()[1]), account[d].showBalance());
					
				} else {
					System.out.println("\nInvalid account number\n"); 
				}
			}else if(choice == 2) {
				// withdrawal
				
				// get account number from user
				System.out.println("\nWhich account to you want to withdraw from?");
				int acctNumDep = input.nextInt();
				
				// find account number
				int d = 0;
				while ((Integer.parseInt(account[d].getInfo()[1]) != acctNumDep) && (d < numOfAccounts))
					d++;
				
				// withdraw money from account selected
				if (d < numOfAccounts ) {
					System.out.println("How much to withdraw?"); 
					account[d].withdraw(input.nextDouble());
					System.out.printf("account updated, name: %s account number %d, bal: $%.2f!\n\n"
							,account[d].getInfo()[0],  Integer.parseInt(account[d].getInfo()[1]), account[d].showBalance());
					
				} else {
					System.out.println("\nInvalid account number\n"); 
				}
			}else if(choice == 3) {
				//show balance
				
				// get account number from user
				System.out.println("\nWhich account to you want to show balance from?");
				int acctNumDep = input.nextInt();
				
				// find account number
				int d = 0;
				while ((Integer.parseInt(account[d].getInfo()[1]) != acctNumDep) && (d < numOfAccounts))
					d++;
				
				//show balance from account selected
				if (d < numOfAccounts ) {
					System.out.printf("account name: %s account number %d, current balance: $%.2f!\n\n"
							,account[d].getInfo()[0],  Integer.parseInt(account[d].getInfo()[1]), account[d].showBalance());
					
				} else {
					System.out.println("\nInvalid account number\n"); 
				}
			}else if(choice == 4) {
				// exit
				
				System.out.println("\nThank you very much. Have a nice day!\n");

			}else{
				// invalid
				
				System.out.println("\nPlease select the available options.\n");
			}
		} while(choice != 4);
		
	}

}
