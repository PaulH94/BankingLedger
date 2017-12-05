import java.util.ArrayList;

/**
 * Created by Paul Huynh on 11/28/2017.
 * User class
 */
public class User {
    private String fullName;                                            //User's fullname
    private String userEmail;                                           //User's email
    private String userPassword;                                        //user's password
    private int accountNumber;                                          //Account number
    private double userBalance = 0.00;                                  //User's balance is set to 0 dollars
    private ArrayList<Transactions> transactionHistory;                 //An array list of transactions
    private int key = 6;

    //initialize the user data that us fed in
    User(String fName, String email, String password, int aNumber){
        this.fullName = fName;
        this.userEmail = email;
        this.userPassword = encode(password,key);
        this.accountNumber = aNumber;
        this.userBalance = 0.00;
        this.transactionHistory = new ArrayList<>();
    }

    //returns the user's name, but probably wont need this
    public String getFullName(){
        return fullName;
    }

    //returns the user's email
    public String getUserEmail(){
        return userEmail;
    }

    //returns the user's balance
    public double getUserBalance(){
        return userBalance;
    }

    //returns the user's transaction history
    public ArrayList<Transactions> getTransactionHistory(){return transactionHistory;}

    //this checks if the password matches that is inputted matches the account's password
    public boolean checkPassword(String password){
        return encode(password,key).equals(userPassword);
    }


    //function to use when depositing money
    public void deposit(double amount){
        userBalance += amount;
        transactionHistory.add(new Transactions("Deposit",amount));         //Add the transaction to history
    }


    //function to use when withdrawing money
    public void withdrawal(double amount){
        if(amount > userBalance){
            System.out.println("INSUFFICIENT FUNDS");
            return;
        }
        userBalance -= amount;
        transactionHistory.add(new Transactions("Withdrawal",amount));      //Add the transaction to history
    }


    //SUPER SIMPLE ENCRYPTION
    private String encode(String password, int pwKey){
        StringBuilder encodedPassword = new StringBuilder();

        for(int i = 0; i<password.length();++i){
            encodedPassword.append(password.charAt(i) + pwKey);
        }

        return encodedPassword.toString();
    }

    private String decode(String password, int pwKey){
        StringBuilder decodedPassword = new StringBuilder();

        for(int i = 0; i<password.length();++i){
            decodedPassword.append(password.charAt(i) - pwKey);
        }

        return decodedPassword.toString();
    }


    //this is to display the transaction history
    public void displayTransactionHistory(){
        for(Transactions t: transactionHistory){
            System.out.println(t.toString());
        }
    }

}
