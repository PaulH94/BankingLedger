/**
 * Created by Paul Huynh on 11/28/2017.
 */
public class User {
    private String fullName;
    private String userEmail;
    private String userPassword;
    private int accountNumber;
    private double userBalance = 0.00;

    User(String fName, String email, String password, int aNumber){
        this.fullName = fName;
        this.userEmail = email;
        this.userPassword = password;
        this.accountNumber = aNumber;
        this.userBalance = 0.00;
    }

    public String getFullName(){
        return fullName;
    }

    public String getUserEmail(){
        return userEmail;
    }

    public double getUserBalance(){
        return userBalance;
    }


}
