import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.List;
import java.nio.charset.Charset;
import java.io.IOException;

public class Bank {
    
    private static String[] errorType; //track error types under different circumstances
    
        //determine if the string is a number or not
        private static boolean isNumeric(String strNum) {
            try {
                double d = Double.parseDouble(strNum);
            } catch (NumberFormatException | NullPointerException nfe) {
            return false;
            }
            return true;
        }   
        
	public static Account[] createAccounts(String inputFile) throws IOException{   //Question 1
            //read from file to retrieve information line by line
            Path path = Paths.get(inputFile);      
            Charset charset = Charset.forName("ISO-8859-1");
            List<String> lines = Files.readAllLines(path, charset);
            Account[] account = new Account[lines.size()];
            errorType = new String[lines.size()];
            int x = 0;
            int y = 0;
            boolean check = false;
            
            for(String line : lines){
                String info[] = line.split(",");
                check = false;
                
		if(info.length >= 3){
            	   for(int i = 0; i < account.length; i++){
		      if(account[i] != null && info[2] != null){
			if(info[2].equals(account[i].retrieveClientInfo()[0])){
                            errorType[x] = "Account Duplication.";
                            account[y] = null;
                            x++;
                            check = true;
            		}
		      }
            }
        }

                if(!check){
                    if(info.length == 4){
                        if(info[0].toUpperCase().equals("C")){
                            if(!isNumeric(info[2])){
                                errorType[x] = "Invalid account number.";
                                account[y] = null;
                                x++;
                            }else if(!isNumeric(info[3])){
                                errorType[x] = "Invalid value for balance.";
                                account[y] = null;
                                x++;                                
                            }else if(!(Integer.parseInt(info[2]) >= 7000 && Integer.parseInt(info[2]) < 8000)){
                                errorType[x] = "Account number is not between 7000 - 7999 inclusively.";
                                account[y] = null;
                                x++;
                            }else if(Double.parseDouble(info[3]) < 0){
                                errorType[x] = "Account balance cannot be negative.";
                                account[y] = null;
                                x++; 
                            }else{
                                account[y] = new ChequingAccount(Integer.parseInt(info[2]),info[1],Double.parseDouble(info[3]));
                            }
                        }else if(info[0].toUpperCase().equals("S")){
                            if(!isNumeric(info[2])){
                                errorType[x] = "Invalid account number.";
                                account[y] = null;
                                x++;
                            }else if(!isNumeric(info[3])){
                                errorType[x] = "Invalid value for balance.";
                                account[y] = null;
                                x++;                                
                            }else if(!(Integer.parseInt(info[2]) >= 8000 && Integer.parseInt(info[2]) < 9000)){
                                errorType[x] = "Account number is not between 8000 - 8999 inclusively.";
                                account[y] = null;
                                x++;
                            }else if(Double.parseDouble(info[3]) < 0){
                                errorType[x] = "Account balance cannot be negative.";
                                account[y] = null;
                                x++; 
                            }else{
                                account[y] = new SavingAccount(Integer.parseInt(info[2]),info[1],Double.parseDouble(info[3]));
                            }
                        }else if(info[0] == null){
                            errorType[x] = "Incorrect number of columns.";
                            account[y] = null;
                            x++;
                        }else{
                            errorType[x] = "Input is neither 'C' nor 'S'.";
                            account[y] = null;
                            x++;
                        }
                    }else if(info.length == 3){
                        if(info[0].toUpperCase().equals("C")){
                            if(!isNumeric(info[2])){
                                errorType[x] = "Invalid account number.";
                                account[y] = null;
                                x++;
                            }else if(!(Integer.parseInt(info[2]) >= 7000 && Integer.parseInt(info[2]) < 8000)){
                                errorType[x] = "Account number is not between 7000 - 7999 inclusively.";
                                account[y] = null;
                                x++;
                            }else{
                                account[y] = new ChequingAccount(Integer.parseInt(info[2]),info[1],0);
                            }                            
                        }else if(info[0].toUpperCase().equals("S")){
                            if(!isNumeric(info[2])){
                                errorType[x] = "Invalid account number.";
                                account[y] = null;
                                x++;
                            }else if(!(Integer.parseInt(info[2]) >= 8000 && Integer.parseInt(info[2]) < 9000)){
                                errorType[x] = "Account number is not between 8000 - 8999 inclusively.";
                                account[y] = null;
                                x++;
                            }else{
                                account[y] = new SavingAccount(Integer.parseInt(info[2]),info[1],0);
                            }                            
                        }else if(info[0] == null){
                            errorType[x] = "Incorrect number of columns.";
                            account[y] = null;
                            x++;
                        }else{
                            errorType[x] = "Input is neither 'C' nor 'S'.";
                            account[y] = null;
                            x++;
                        }
                    }else{
                        errorType[x] = "Incorrect number of columns.";
                        account[y] = null;
                        x++;
                    }
                }
                y++;
            }
            
            return account;
	}
	
	/**
	 * @param args, String array passed into
	 * the program from the command line.  Input 
	 * file will be passed in as the first parameter
	 */
	public static void main(String[] args) {
            try{
		Account[] aArray = Bank.createAccounts(args[0]);
                int x = 0;
		int count = 0;                

                //print out information about each account read from the file
                for(Account a : aArray){
                    if(a instanceof ChequingAccount){
                        System.out.println("Account Type: Chequing\nAccount Number: " + a.retrieveClientInfo()[0] + "\nClient Name: " + a.retrieveClientInfo()[1] +
                            "\nCurrent Balance: " + a.retrieveClientInfo()[2] + "\n");
			count += 1;
                    }else if(a instanceof SavingAccount){
                        System.out.println("Account Type: Saving\nAccount Number: " + a.retrieveClientInfo()[0] + "\nClient Name: " + a.retrieveClientInfo()[1] +
                            "\nCurrent Balance: " + a.retrieveClientInfo()[2] + "\n");
			count += 1;
                    }else if(a == null){
                        System.err.println("Account cannot be created.\nError: " + Bank.errorType[x] + "\n");
                        x++;
                    }
                }

		System.err.println(count + " accounts have been successfully created.");
            }catch(IOException | ArrayIndexOutOfBoundsException iae){
                System.err.println("File cannot be found."); 
            }
	}
	
}
