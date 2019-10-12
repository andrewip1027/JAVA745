public class BankTeller { 
    public static void main(String[]args) { 
        //create accounts

        //update accounts
    }
}

do{
    switch (choice){
        case 1:
        //deposit

        // get acct number from user
        system.out.println("Which account do you want to deposit to?");
        int acctNumDep = input.nextInt();
        
        //find acct number 
        int d = 0;
        while ((acctNumbers[d] != acctNumDep) && (d < numOfAccounts)) //while current number is not same, AND not at the end, then will...
            d++;
        if (d < numOfAccounts){
            System.out.println("how much to deposit?");
            acctBalance[d] += input.nextDouble(); //what is += 
            System.out.printf("account updated, name: %s account number %d", acctNames[d], acctNumbers[d], acctBalance[d]);            
        } else {
            system.out.println("invalid account number");
        }
            

        for (int d=0; d < numOfAccounts; d++){  //use for loop when u want to go through a loop fix number of times 
            if (acctNumbers[d] == acctNumDep)
        }
        //withdrawl

        //exit 

        //invalid 
    }
}