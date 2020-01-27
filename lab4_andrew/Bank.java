public class Bank {

    public static void main() {
        Account account1 = new Account("John", 1234, 10.00);
        Account account2 = new Account();
        
        // get account's customer name
        String accountCustomerName = account.getCustomerName();
        int accountNumber = account.getAccountNum();

        account.setBalance(10);

        account.setBalance(100);
    }
}

