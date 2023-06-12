import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // create first account of Hdfc
        HDFCAccount hdfcAccount1 = new HDFCAccount("Ram", 1000 , "abc@123" );
        System.out.println("congrats !! "+hdfcAccount1.getName()+
                " your account has been created with account no. "
                +hdfcAccount1.getAccountNumber());

        // create second account of Hdfc
        HDFCAccount hdfcAccount2 = new HDFCAccount("Shyam", 2000 , "abc@123" );
        System.out.println("congrats !! "+hdfcAccount2.getName()+
                " your account has been created with account no. "
                +hdfcAccount2.getAccountNumber());

        System.out.println("The amount has been added to your account "+
                hdfcAccount1.addMoney(5000)+
                " The current balance is "+hdfcAccount1.getBalance());

        // withdraw money from account
        System.out.println(hdfcAccount1.withdrawMoney("xyzp" , 800));
        System.out.println(hdfcAccount1.withdrawMoney("abc@123" , 900));

        // fetch balance from account
        System.out.println(hdfcAccount1.fetchBalance("abc@123"));

        // change password of the account
        System.out.println(hdfcAccount1.changePassword( "bro@523", "abc@123"));

        // calculate interest
        System.out.println("Enter the Number of years to calculate the Interest ");
        int years = sc.nextInt();
        System.out.println("Your interest for "+years+" the years is : "
                + hdfcAccount1.calculateInterest(years));
    }
}