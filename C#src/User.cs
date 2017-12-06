//By Paul Huynh
//THis is the user class where all the user's info and methods are stored.

using System;
using System.Collections;
using System.Collections.Generic;
using System.Text;

namespace BankingLedger
{
    class User
    {
        private String fullName;                                            //User's fullname
        private String userEmail;                                           //User's email
        private String userPassword;                                        //user's password
        private int accountNumber;                                          //Account number
        private double userBalance = 0.00;                                  //User's balance is set to 0 dollars
        private ArrayList transactionHistory;                               //An array list of transactions
        private int key = 6;

        //initialize the user data that us fed in
        public User(String fName, String email, String password, int aNumber)
        {
            this.fullName = fName;
            this.userEmail = email;
            this.userPassword = Encode(password, key);
            this.accountNumber = aNumber;
            this.userBalance = 0.00;
            this.transactionHistory = new ArrayList();
        }

        ~User()
        {
            transactionHistory.Clear();
            transactionHistory = null;
        }

        //returns the user's name, but probably wont need this
        public String GetFullName()
        {
            return fullName;
        }

        //returns the user's email
        public String GetUserEmail()
        {
            return userEmail;
        }

        //returns the user's balance
        public double GetUserBalance()
        {
            return userBalance;
        }

        //returns the user's transaction history
        public ArrayList GetTransactionHistory() { return transactionHistory; }

        //this checks if the password matches that is inputted matches the account's password
        public Boolean CheckPassword(String password)
        {
            return Encode(password, key).Equals(userPassword);
        }

        //function to use when depositing money
        public void Deposit(double amount)
        {
            userBalance += amount;
            transactionHistory.Add(new Transactions("Deposit", amount));         //Add the transaction to history
        }

        //function to use when withdrawing money
        public void Withdrawal(double amount)
        {
            if (amount > userBalance)
            {
                Console.WriteLine("INSUFFICIENT FUNDS");
                return;
            }
            userBalance -= amount;
            transactionHistory.Add(new Transactions("Withdrawal", amount));      //Add the transaction to history
        }

        //SUPER SIMPLE ENCRYPTION
        private String Encode(String password, int pwKey)
        {
            String encodedPassword = "";

            //Shift each char by 6 according to ascii
            for (int i = 0; i < password.Length; ++i)
            {
                int ascii = (int)password[i] + pwKey;
                char current = (char)ascii;
                encodedPassword += current;
            }

            return encodedPassword;
        }

        //this is to display the transaction history
        public void DisplayTransactionHistory()
        {
            foreach (Transactions t in transactionHistory)
            {
                Console.WriteLine(t.ToString());
            }
        }

    }
}
