import java.util.Scanner;

public class ATM_Machine{
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
         
        System.out.println("Amount is in Rupees.");
        System.out.println("Card Inserted");
        System.out.print("Enter the Initial Balance(in INR): ");

       double balance =  sc.nextDouble();

       if(balance > 0){
        BankAccount user = new BankAccount(balance);
        boolean isRunning = true;

        while(isRunning){
            System.out.println("Given Operations and their Number to Enter in order to Execute the respected Operation.");
            System.out.println(" 1. Deposit Amount \n 2. Withdraw Amount \n 3. Check Available Balance \n 4.Exit");
            System.out.print("Enter your Choice(1/2/3/4) in number: ");
            int choice = sc.nextInt();
        

            switch (choice) {
                case 1:
                    
                     System.out.print("Enter the amount to Deposit: ");
                double amt = sc.nextDouble();
               String depositonStatus = (user.depositAmount(amt)) ? "Sucessfull!!!" : "Unsuccessfull";
                System.out.println("Deposition " + depositonStatus);
                
                    break;
                case 2:

                      System.out.print("Enter the amount to Withdraw: ");
                 amt = sc.nextDouble();
                String withdrawalStatus = (user.withdrawAmount(amt)) ? "Sucessfull!!!" : "Unsuccessfull";
                System.out.println("Withdrawal " + withdrawalStatus);

                    break;
                case 3:

                     System.out.println("Your Account's Status is as follows.");
                double currBalance = user.checkBalance();
                System.out.println("Your Account Currently have INR " + currBalance);
                
                    break;
                case 4:

                     isRunning = false;
                System.out.println("Successfully Exited");
                    break;
            
                default:
                System.out.println("Invalid Option please select from the Above mentioned.");
                    break;
            }
            
        }
       }else{
        System.out.println("Invalid Balance.");
       }
       sc.close();
   

    }
}