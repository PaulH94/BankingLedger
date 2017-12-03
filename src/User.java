import java.util.ArrayList;

/**
 * Created by Paul Huynh on 11/28/2017.
 */
public class User {
    private String fullName;
    private String userEmail;
    private String userPassword;
    private int accountNumber;
    private double userBalance = 0.00;
    private ArrayList<Transactions> transactionHistory;

    User(String fName, String email, String password, int aNumber){
        this.fullName = fName;
        this.userEmail = email;
        this.userPassword = password;
        this.accountNumber = aNumber;
        this.userBalance = 0.00;
        this.transactionHistory = new ArrayList<>();
    }

    public String getFullName(){
        return fullName;
    }

    public boolean checkPassword(String password){
        //System.out.println(password.equals(userPassword));
        return password.equals(userPassword);
    }

    public void deposit(double amount){
        userBalance += amount;
        transactionHistory.add(new Transactions("Deposit",amount));
    }

    public void withdrawal(double amount){
        userBalance -= amount;
        transactionHistory.add(new Transactions("Withdrawal",amount));
    }

    public String getUserEmail(){
        return userEmail;
    }

    public double getUserBalance(){
        return userBalance;
    }



    public ArrayList<Transactions> getTransactionHistory(){return transactionHistory;}

    public void displayTransactionHistory(){
        for(Transactions t: transactionHistory){
            System.out.println(t.toString());
        }
    }

}
