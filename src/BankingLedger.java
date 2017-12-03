/**
 * Created by Paul Huynh on 11/28/2017.
 * This program is an interview assignment.
 * The mission is to create a banking ledger
 */
import java.io.*;
import java.util.*;

public class BankingLedger {

    //Main function of program
    public static void main(String[] args){

        boolean session = true;                                 //This is to check if the session is still going on
        Scanner scan = new Scanner(System.in);                  //For user input
        listOfUsers Users = new listOfUsers();                  //Create a local list of users instead of an actual database

        System.out.println("Welcome to the World's Greatest Banking Ledger!");

        while(session == true){                                 //While the session is still live
            System.out.println("-------------------------");
            System.out.println("Log in or Sign up?");           //prompt the user
            System.out.println("[1] to sign in");
            System.out.println("[2] to sign up");
            System.out.println("[3] to end session");

            int option = scan.nextInt();                        //Get the User's input

            switch (option){                                    //switch statement
                case 1: System.out.println("SIGNING IN");       //First option is to sign in
                        System.out.print("Email: ");
                        String email = scan.next();
                        System.out.print("Password: ");
                        String password = scan.next();          //asked for email and password
                        if(Users.checkForUser(email,password)){                     //check to see if user exist
                            User currentUser = Users.getUser(email);                //if they do receive their data
                            System.out.println("Log in success");
                            Users.editUser(email,whenSignedIn(currentUser));        //update the user information, usually their transactions
                        }
                        else{                                                       //if the user does not exist, loop back
                            System.out.println("Not a Valid User");
                        }
                        break;
                case 2: System.out.println("SIGNING UP");                           //option two is to create an account
                        User newUser = signingUp();
                        if(Users.addUser(newUser)){                                 //if the account doesnt exit, a new account is made
                            System.out.println("Account successfully made");
                        }
                        else{                                                       //else, tell the user that they already have an account
                            System.out.println("User already exist");
                        }
                        break;
                case 3: System.out.println("ENDING");                               //option three, end the session
                        session = false;
                        break;
            }
        }

        System.out.println("Goodbye!");
    }


    //This is the function where the user will be making transactions
    public static User whenSignedIn(User currentUser){
        Scanner scan = new Scanner(System.in);
        boolean loggedIn = true;                                                    //This works the same way that session is used above

        while(loggedIn) {                                                           //continue to prompt user until they are done
            System.out.println("What would you like to do?");
            System.out.println("[1] Check Balance");
            System.out.println("[2] Make a Deposit");
            System.out.println("[3] Make a withdrawal");
            System.out.println("[4] Transaction History");
            System.out.println("[5] Log Out");

            int option = scan.nextInt();
            double amount;                                                          //The amount that is deposited or withdrawn

            switch (option) {
                case 1:                                                             //First option is to check the balance;
                    System.out.println("CHECKING BALANCE");
                    System.out.println("Balance: " + currentUser.getUserBalance()); //Run the function to check the balance
                    break;
                case 2:                                                             //Second option is to make deposits
                    System.out.println("MAKING A DEPOSIT");
                    System.out.println("How much?");
                    amount = scan.nextDouble();
                    currentUser.deposit(amount);                                    //function to deposit that amount
                    break;
                case 3:                                                             //Third option is to withdraw
                    System.out.println("MAKING A WITHDRAWAL");
                    System.out.println("How much?");
                    amount = scan.nextDouble();
                    currentUser.withdrawal(amount);                                 //run the function to make a withdrawal
                    break;
                case 4:                                                             //the forth option is to show the transaction history
                    System.out.println("TRANSACTION HISTORY");
                    currentUser.displayTransactionHistory();                        //display the history
                    break;
                case 5:                                                             //The fifth option is to log out
                    System.out.println("LOGGING OUT OF USER ACCOUNT");
                    loggedIn = false;
                    break;
            }
        }

        return currentUser;                                                         //return the new user data
    }


    //This function is for when the user is signing up for an account
    private static User signingUp(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Fullname: ");                 //get their name
        String fName = scan.nextLine();
        System.out.println("Email: ");                    //get their email
        String email = scan.next();
        System.out.println("Password: ");                 //get their password
        String pw = scan.next();

        return new User(fName,email,pw,0);       //make the account
    }
}
