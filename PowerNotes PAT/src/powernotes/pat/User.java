/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package powernotes.pat;

/**
 *
 * @author Maxwell SSD
 */
public class User
{
    private int uID;
    private String username, password;
    private boolean admin;

    public User(int uID, String username, String password, boolean admin) //accept parameters that describe user object
    {
        this.uID = uID; //initialise all of the fields
        this.username = username;
        this.password = password;
        this.admin = admin;
    }

    public int getuID() //returns the user ID.
    {
        return uID;
    }

    
    public String getUsername() //returns the username
    {
        return username;
    }


    public String getPassword() //returns the password
    {
        return password;
    }
    
    public boolean getAdmin() //returns the admin status. (true = admin)
    {
        return admin;
    }

    @Override
    public String toString() //returns the concatinated string of user's fields
    {
        return username +" "+ password + " " + admin;
    }
    
    
}
