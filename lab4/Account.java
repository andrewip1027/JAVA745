
public class Account {

    // 1 customer name
    private String customerName;
    // 2 acct num
    private int accountNum;
    // 3 balances
    private double balance;

    // Constructor --> set the variables when creating new Account
    public Account(String customerName, int accountNum, double balance) {
        this.customerName = customerName;
        this.accountNum = accountNum;
        this.balance = balance;
    }

    // customer Name Getter
    public String getCustomerName() {
        return this.customerName;
    }

    // customer Name Setter
    public void setCustomerName(String name) {
        this.customerName = name;`
    }

    // Account number getter
    public int getAccountNum() {
        return this.accountNum;
    }

    // Account number Setter
    public void setAccountNum(int number) { // it is void bvecause you are not returning anything
        this.accountNum = number;
    }

    // Balance getter
    public double getBalance() {
        return this.balance;
    }

    // balance setter
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // if the bank amount is greater than zero, deposit will be processed
    public void deposit(double depositAmount) {
        if (depositAmount > 0) {
            this.balance = this.balance + depositAmount;
        }
    }

    // if the withdrawing amount is greater than zero, continue withdraw
    public double withdraw(double withdrawAmount) {
        if (withdrawAmount > 0) {
            this.balance = this.balance - withdrawAmount;
        }
        return withdrawAmount;
    }

    // return information about account number, current balance and client's name
    public String[] retrieveClientInfo() {
        String[] clientInfo = new String[3];
        clientInfo[0] = String.valueOf(this.accountNum);
        clientInfo[1] = this.customerName;
        clientInfo[2] = String.valueOf(this.balance);
        return clientInfo;
    }
}
