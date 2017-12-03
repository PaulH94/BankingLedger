import java.util.HashMap;

/**
 * Created by Paul Huynh on 11/28/2017.
 */
public class listOfUsers {
    private HashMap<String,User> Users;
    private int numOfUsers;

    listOfUsers(){
        Users = new HashMap<String,User>();
        numOfUsers = 0;
    }

    public boolean addUser(User newUser){
        String userEmail = newUser.getUserEmail();

        if (Users.containsKey(userEmail))
            return false;

        Users.put(userEmail,newUser);
        numOfUsers += 1;
        return true;
    }

    public boolean checkForUser(String email, String password){
        if(!Users.containsKey(email))
            return false;
        //System.out.println("LOOK: " + Users.get(email).checkPassword(password));
        return Users.get(email).checkPassword(password);
    }

    public void editUser(String email, User editedUser){
        Users.put(email,editedUser);
    }

    public User getUser(String userEmail){
        User gUser = Users.get(userEmail);
        return gUser;
    }

    public int getNumOfUsers(){
        return  numOfUsers;
    }

}