//Made by Paul Huynh
//This is the main class.
//Goal is to build a bank ledger
//The program need to be able to Create a new account, login, record a deposit,
//record a withdrawal, check balance, See transaction history, and log out
using System;
using System.Net.Mail;

namespace BankingLedger
{
    class Program
    {
        static void Main(string[] args)
        {

            Boolean session = true;
            ListOfUsers Users = new ListOfUsers();                  //Create a local list of users instead of an actual database

            Console.WriteLine("Welcome to the world's greatest bank ledger!");

            while(session == true)
            {
                Console.WriteLine("-------------------------");
                Console.WriteLine("Log in or Sign up?");                                        //prompt the user
                Console.WriteLine("[1] to sign in");
                Console.WriteLine("[2] to sign up");
                Console.WriteLine("[3] to end session");

                int option = Convert.ToInt32(Console.ReadLine());                               //Read the user's input

                switch (option)
                {
                    case 1:                                                                     //First option: Sign in
                        Console.WriteLine("SIGNING IN");
                        Console.WriteLine("Email: ");
                        String email = Console.ReadLine();                                      //Get email and password
                        Console.WriteLine("Password: ");
                        String password = Console.ReadLine();

                        if (Users.CheckForUser(email, password))                                //see if email and password match
                        {
                            Console.WriteLine("Log in successful");                             
                            User currentUser = Users.GetUser(email);
                            Users.EditUser(email, WhenSignedIn(currentUser));
                        }
                        else
                        {
                            Console.WriteLine("Not a valid user, incorrect email or password"); //if not, tell user
                        }
                        break;
                    case 2:                                                                     //Second option: Sign Up
                        Console.WriteLine("SIGNING UP");
                        User newUser = SigningUp(Users.GetNumOfUsers());
                        if (Users.AddUser(newUser))                                             //check to see if user exists
                        {
                            Console.WriteLine("Account Successfully Made!");                    //if not, create
                        }
                        else
                        {
                            Console.WriteLine("User already exist");                            //else: prompt user
                        }
                        break;
                    case 3:                                                                     //Third option: end session
                        Console.WriteLine("ENDING SESSION");
                        session = false;
                        break;
                    default:                                                                    //any other input
                        Console.WriteLine("INVALID INPUT");
                        break;
                }
            }



            Console.WriteLine("Press any key to exit.");
            Console.ReadKey();
        }


        //This is the function for when the user is signed in.
        public static User WhenSignedIn(User currentUser)
        {
            Boolean loggedIn = true;

            
            while (loggedIn)                                                            //While the user is still logged in
            {
                Console.WriteLine("------------------------------");
                Console.WriteLine("What would you like to do?");                        //prompt user
                Console.WriteLine("[1] Check Balance");
                Console.WriteLine("[2] Make a Deposit");
                Console.WriteLine("[3] Make a withdrawal");
                Console.WriteLine("[4] Transaction History");
                Console.WriteLine("[5] Log Out");

                int option = Convert.ToInt32(Console.ReadLine());                       //get user input
                double amount;

                switch (option)
                {
                    case 1:                                                             //option 1: check balance
                        Console.WriteLine("CHECKING BALANCE");
                        Console.WriteLine("Balance: " + currentUser.GetUserBalance());  //display balance
                        break;
                    case 2:                                                             //option 2: deposit
                        Console.WriteLine("MAKING A DEPOSIT");
                        Console.WriteLine("How much?");
                        amount = Convert.ToDouble(Console.ReadLine());
                        currentUser.Deposit(amount);                                    //deposit
                        break;
                    case 3:                                                             //option 3: withdraw
                        Console.WriteLine("MAKING A WITHDRAWAL");
                        Console.WriteLine("How much?");
                        amount = Convert.ToDouble(Console.ReadLine());
                        currentUser.Withdrawal(amount);
                        break;
                    case 4:                                                             //option 4: display transactions
                        Console.WriteLine("TRANSACTION HISTORY");
                        currentUser.DisplayTransactionHistory();
                        break;
                    case 5:                                                             //option 5: log out
                        Console.WriteLine("LOGGING OUT OF USER'S ACCOUNT");
                        loggedIn = false;
                        break;
                    default:                                                            //any other input
                        Console.WriteLine("INVALID INPUT");
                        break;
                }

            }
            return currentUser;                                                         //return the user's new info
        }


        //Function to sign up new users
        public static User SigningUp(int accountNumber)
        {
            Boolean validEmail = false;

            Console.WriteLine("Full name: ");                 //get their name
            String fName = Console.ReadLine();
            String email = "";
            while (validEmail == false)                      //Keep asking until a valid email is given
            {
                Console.WriteLine("Email: ");                //get their email
                email = Console.ReadLine();
                validEmail = IsValid(email);
                if (validEmail == false)
                    Console.WriteLine("Invalid Email");
            }
            Console.WriteLine("Password: ");                //get their email
            String password = Console.ReadLine();

            return new User(fName,email,password,accountNumber);    //return the new user's info

        }


        //Function to validate emails
        public static bool IsValid(string emailaddress)
        {
            try
            {
                MailAddress m = new MailAddress(emailaddress);
                return true;
            }
            catch (FormatException)
            {
                return false;
            }
        }
    }
 
}
