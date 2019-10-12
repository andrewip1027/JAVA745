public class Account{  //parent class

	//method
/*Instance variables are made private to force the users of those class to use methods to access them. In most cases there are plain getters and setters but other methods might be used as well.
Using methods would allow you, for instance, to restrict access to read only, i.e. a field might be read but not written, if there's no setter. That would not be possible if the field was public.
*/
	private int accountNumber;
	private String customerName;

	//Constructor
	public Account(int a, String c){
		this.accountNumber = a;  
		this.customerName = c;
	}
	//
	public int getAccountNumber(){
		return accountNumber;
	}

}
//extend 
public class ChequingAccount extends Account{

	
	private static double transactionFee;
	private int freeTransaction;

	public ChequingAccount(double fee, int t, int a, String c){
		super(a, c);
		this.transactionFee = fee;
		this.freeTransaction = t;
	}

	public int getAccountNumber(){
		super.accountNumber;
		return super.getAccountNumber();
	}
}

//Poly
Account a = new Account();
System.out.println(a.getAccountNumber());
a = new ChequingAccount();
System.out.println(a.getAccountNumber());