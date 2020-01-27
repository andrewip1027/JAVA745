import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.charset.Charset;
import java.io.IOException;
import java.util.List;

public class Bank {

    private static Account[] createAccounts(String inputFile) throws IOException {
        // 1 read file You must use Java’s new NIO package to do the file processing.
        // Use nio here to read csv file (in commas)

        Path path = Paths.get(inputFile);
        Charset charset = StandardCharsets.ISO_8859_1;
        // read all lines in file to a List of String
        List<String> lines = Files.readAllLines(path, charset);

        // make an array of accounts
        // with array size being the number of lines read from file
        Account[] accounts = new Account[lines.size()];

        for(int i = 0; i < lines.size(); ++i) {
            String line = lines.get(i);
            String[] info = line.split(",");

            // check to make sure there are at least 3 fields
            if(info.length < 3) {
                System.err.println("incorrect number of fields at row " + i);
                continue;
            }

            // customer name
            String customerName = info[1];

            // account num
            int accountNum;
            try {
                accountNum = Integer.parseInt(info[2]);
            } catch (NumberFormatException e) {
                System.err.println("Account number incorrect format at row " + i);
                continue;
            }

            // check to make sure no duplicate account num
            boolean hasDuplicateAccountNum = false;
            for(Account account : accounts) {
                if(account == null) continue;
                if(account.getAccountNum() == accountNum) {
                    hasDuplicateAccountNum = true;
                    break;
                }
            }
            if(hasDuplicateAccountNum) {
                System.err.println("Duplicated account number at row " + i);
                continue;
            }

            // balance
            double balance = 0;
            if(info.length >= 4) {
                try {
                    // round to 2 decimal places
                    BigDecimal val = new BigDecimal(info[3]);
                    balance = val.setScale(2, RoundingMode.DOWN).doubleValue();
                } catch (NumberFormatException e) {
                    System.err.println("Balance incorrect format at row " + i);
                    continue;
                }
            }

            // make account according to account type
            String accountType = info[0].toUpperCase();
            if(accountType.equals("C")) {
                // check to make sure account num is between 7000 to 7999 inclusive
                if(accountNum < 7000 || accountNum > 7999) {
                    System.err.println("Account number out of range at row " + i);
                    continue;
                }

                ChequingAccount account = new ChequingAccount(customerName, accountNum, balance);
                accounts[i] = account;
            }
            else if(accountType.equals("S")) {
                // check to make sure account num is between 8000 to 8999 inclusive
                if(accountNum < 8000 || accountNum > 8999) {
                    System.err.println("Account number out of range at row " + i);
                    continue;
                }

                // check to make sure balance is not negative
                if(balance < 0)  {
                    System.err.println("Balance cannot be negative at row " + i);
                    continue;
                }

                SavingAccount account = new SavingAccount(customerName, accountNum, balance);
                accounts[i] = account;
            }
            else {
                System.err.println("Incorrect account type at row " + i);
            }
        }

        return accounts;
    }

    public static void main(String[] args) {
        Account[] accounts;
        try {
            accounts = Bank.createAccounts(args[0]);
        } catch (IOException e) {
            System.err.println("Failed to open or read file");
            return;
        }

        int count = 0;
        for(Account account : accounts) {
            if(account == null) continue;
            if (account instanceof ChequingAccount) {
                System.out.println("Account Type: Chequing\n" + 
                    "Account Number: " + account.getAccountNum() + "\n" +
                    "Customer Name: " + account.getCustomerName() + "\n" + 
                    "Current Balance: " + account.getBalance());
                count += 1;
            } else if (account instanceof SavingAccount) {
                System.out.println("Account Type: Saving\n" + 
                    "Account Number: " + account.getAccountNum() + "\n" +
                    "Customer Name: " + account.getCustomerName() + "\n" + 
                    "Current Balance: " + account.getBalance());
                count += 1;
            }
        }

        System.err.println("Number of successfully created accounts = " + count);
    }

}

