//Made by Paul Huynh
//ListOfUser class

using System;
using System.Collections;
using System.Collections.Generic;
using System.Text;

namespace BankingLedger
{
    class ListOfUsers
    {
        private Hashtable Users;                        //Hash Table of users, hashed by email
        private int numOfUsers = 0;                     //number of users is used to assign account numbers

        //constructor
        public ListOfUsers()
        {
            numOfUsers = 0;
            Users = new Hashtable();
        }

        //deconstructor
        ~ListOfUsers()
        {
            Users.Clear();
            Users = null;
        }

        //function for adding new users
        public Boolean AddUser(User newUser)
        {
            String userEmail = newUser.GetUserEmail();          //get the user's email

            if (Users.ContainsKey(userEmail))                   //if already exist, send back a false
                return false;

            Users.Add(userEmail, newUser);                       //else make the account
            numOfUsers += 1;                                    //increase user count

            return true;
        }

        //Used this to make sure a user exist and if his password matches
        public Boolean CheckForUser(String email, String password)
        {
            if (!Users.ContainsKey(email))
                return false;
            User u = (User)Users[email];
            return u.CheckPassword(password);
        }

        //Used this function to update a user's information
        public void EditUser(String email, User editedUser)
        {
            Users.Remove(email);
            Users.Add(email, editedUser);
        }

        //Used this to return a user by email
        public User GetUser(String userEmail)
        {
            return (User)Users[userEmail];
        }

        //Return back the number of users
        public int GetNumOfUsers()
        {
            return numOfUsers;
        }

    }
}
