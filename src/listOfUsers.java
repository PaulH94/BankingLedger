import java.util.HashMap;

/**
 * Created by Paul Huynh on 11/28/2017.
 * Used to create a local cache of users
 */
public class listOfUsers {

    private HashMap<String,User> Users;                     //Used a hashmap to store user accounts. They're hashed using their email
    private int numOfUsers;                                 //number of users to assign user account numbers


    //initial an empty users list
    listOfUsers(){
        Users = new HashMap<String,User>();
        numOfUsers = 0;
    }



    //function for adding new users
    public boolean addUser(User newUser){
        String userEmail = newUser.getUserEmail();          //get the user's email

        if (Users.containsKey(userEmail))                   //if already exist, send back a false
            return false;

        Users.put(userEmail,newUser);                       //else make the account
        numOfUsers += 1;                                    //increase user count
        return true;                                        //let the main function know it was a success
    }


    //Used this to make sure a user exist and if his password matches
    public boolean checkForUser(String email, String password){
        if(!Users.containsKey(email))
            return false;
        //System.out.println("LOOK: " + Users.get(email).checkPassword(password));
        return Users.get(email).checkPassword(password);
    }


    //Used this function to update a user's information
    public void editUser(String email, User editedUser){
        Users.put(email,editedUser);
    }


    //Used this to return a user by email
    public User getUser(String userEmail){
        User gUser = Users.get(userEmail);
        return gUser;
    }

    //Return back the number of users
    public int getNumOfUsers(){
        return  numOfUsers;
    }

}
