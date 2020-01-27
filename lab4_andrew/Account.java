/**
 * Describes what is an account:
 *  - what it contains (member variables)
 *  - what it can do (member functions)
 */
public class Account {
    /**
     * Define member variables.
     */
    private int accountNum;
    private double balance;
    private String customerName;

    // Constructor
    public Account(String a, int b, double c) {
        this.customerName = a;
        this.balance = c;
    }

    //Member function: Giving the variables to Bank.java
    public String getCustomerName() {
         //accout -> bank
        return customerName;
    }

//    int accountNumber = account.getAccountNum();
    public int getAccountNum() {
        return accountNum;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double b) {
        this.balance = b;
    }
}