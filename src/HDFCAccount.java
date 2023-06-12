import java.security.PrivateKey;
import java.util.UUID;

public class HDFCAccount implements BankAccountInterface{

    private String name;

    private String accountNumber; // random and unique ----> UUID

    private double balance;

    private String password;

    final double rateOfInterest = 6.1;

    // Default constructor i.e no argument is getting passed
    public HDFCAccount(){
    }

    // parameterised constructor i.e argument has been passed
    public HDFCAccount(String name,  double balance, String password) {
        this.name = name;
        this.accountNumber = String.valueOf(UUID.randomUUID());
        this.balance = balance;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String fetchBalance(String password) {
        if (this.password.equals(password))
            return "Your current balance is : " + this.balance;

         return "Invalid Password";
    }

    @Override
    public double addMoney(double amount) {
        this.balance += amount;
        return balance;
    }

    @Override
    public String withdrawMoney(String password, double amount) {
        if (this.password.equals(password)) {

            if (amount <= this.balance) {
                this.balance -= amount;
                return "Money has been withdrawn. The remaining balance is : " + this.balance;
            } else {
                return "Insufficient Balance";
            }
        }
            return "Invalid password";

    }

    @Override
    public String changePassword(String newPassword, String oldPassword) {
        if (this.password.equals(oldPassword)){
            this.password = newPassword;
            return "Your password is updated !!";
        }
        return "Invalid password";
    }

    @Override
    public double calculateInterest(int years) {
        // simple interest is ((p * r * t)/100)
        return ((this.balance * rateOfInterest * years)/100);
    }


}
