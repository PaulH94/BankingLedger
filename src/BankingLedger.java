/**
 * Created by Paul Huynh on 11/28/2017.
 */
import java.io.*;
import java.util.*;

public class BankingLedger {

    public static void main(String[] args){
        boolean session = true;
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcom to the World's Greatest Banking Ledger!");

        while(session == true){
            System.out.println("Log in or Sign up?");
            System.out.println("[1] to sign in");
            System.out.println("[2] to sign up");
            System.out.println("[3] to end session");

            int option = scan.nextInt();

            switch (option){
                case 1: System.out.println("SIGNED IN");
                        break;
                case 2: System.out.println("SIGNED UP");
                        break;
                case 3: System.out.println("ENDING");
                        session = false;
                        break;
            }
        }

        System.out.println("Goodbye!");
    }

    public void whenSignedIn(){

    }

    public User signingUp(){
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
