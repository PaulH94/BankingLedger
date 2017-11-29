/**
 * Created by Paul Huynh on 11/28/2017.
 */
import java.io.*;
import java.util.*;

public class BankingLedger {

    public static void main(String[] args){
        boolean session = true;
        Scanner scan = new Scanner(System.in);
        listOfUsers Users = new listOfUsers();

        System.out.println("Welcome to the World's Greatest Banking Ledger!");

        while(session == true){
            System.out.println("Log in or Sign up?");
            System.out.println("[1] to sign in");
            System.out.println("[2] to sign up");
            System.out.println("[3] to end session");

            int option = scan.nextInt();

            switch (option){
                case 1: System.out.println("SIGNING IN");
                        System.out.print("Email: ");
                        String email = scan.next();
                        System.out.print("Password: ");
                        String password = scan.next();
                        if(Users.checkForUser(email,password)){

                        }
                        else{
                            System.out.println("Not a Valid User");
                        }
                        break;
                case 2: System.out.println("SIGNING UP");
                        User newUser = signingUp();
                        if(Users.addUser(newUser)){
                            System.out.println("Account successfully made");
                        }
                        else{
                            System.out.println("User already exist");
                        }
                        break;
                case 3: System.out.println("ENDING");
                        session = false;
                        break;
            }
        }

        System.out.println("Goodbye!");
    }

    public static void whenSignedIn(User currentUser){
        Scanner scan = new Scanner(System.in);
        boolean loggedIn = true;

        while(loggedIn) {
            System.out.println("What would you like to do?");
            System.out.println("[1] Check Balance");
            System.out.println("[2] Make a Deposit");
            System.out.println("[3] Make a withdrawal");
            System.out.println("[4] Transaction History");
            System.out.println("[5] Log Out");

            int option = scan.nextInt();

            switch (option) {
                case 1:
                    System.out.println("CHECKING BALANCE");
                    System.out.println("Balance: " + currentUser.getUserBalance());
                    break;
                case 2:
                    System.out.println("MAKING A DEPOSIT");
                    break;
                case 3:
                    System.out.println("MAKING A WITHDRAWAL");
                    break;
                case 4:
                    System.out.println("TRANSACTION HISTORY");
                    break;
                case 5:
                    System.out.println("LOGGING OUT OF USER ACCOUNT");
                    loggedIn = false;
                    break;
            }
        }
    }

    private static User signingUp(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Fullname: ");
        String fName = scan.next();
        System.out.print("Email: ");
        String email = scan.next();
        System.out.print("Password: ");
        String pw = scan.next();

        return new User(fName,email,pw,0);
    }
}
