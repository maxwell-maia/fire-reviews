/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package powernotes.pat;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Maxwell SSD
 */
public class UserArray
{
    private User[] uArray = new User[100];
    private int size = 0;
    private int uID = 0;

    public UserArray() //compile array of users by retieving data from table and adding the data to array with while loop
    {
        DB data = new DB();
        
        try
        {
            ResultSet rs = data.queryTb("Select * FROM User");
            while (rs.next())
            {
                int uID = rs.getInt("UserID");
                String u = rs.getString("username");
                String p = rs.getString("password");
                boolean a = rs.getBoolean("Admin");
                uArray[size] = new User(uID, u, p, a);
                size++;
            }
        }
        catch(SQLException se) //display any error
        {
            System.out.println(se);
        }
    }
    
    public UserArray(int uIDInput) //overloaded constructor that initialises the user's ID variable.
    {
        this.uID = uIDInput;
        DB data = new DB();
        
        //same function as above constructor except this constructor accepts User ID as a parameter, 
        //this will be used to get admin boolean for the user logged in
        try
        {
            ResultSet rs = data.queryTb("Select * FROM User");
            while (rs.next())
            {
                int uID = rs.getInt("UserID");
                String u = rs.getString("username");
                String p = rs.getString("password");
                boolean a = rs.getBoolean("Admin");
                uArray[size] = new User(uID, u, p, a);
                size++;
            }
        }
        catch(SQLException se) //display any error
        {
            System.out.println(se);
        }
    }
    
    public boolean testCredentials(String u, String p) //returns boolean that will allow the login if credentials are valid
    {
        boolean credentialsValid = false;
        for(int i = 0; i < size; i++) //runs through user array checking if the username and password of every element matches the one entered in login screen
        {
            if(u.equals(uArray[i].getUsername()) && p.equals(uArray[i].getPassword()))
            {
                uID = uArray[i].getuID();
                credentialsValid = true;
            }
        }
        return credentialsValid;
    }
    
    public boolean getAdminStatus() //returns the admin boolean for user ID
    {
        return uArray[uID-1].getAdmin(); // -1 because the user id's count 1,2,3...; but in array count from 0,1,2...
    }
    
    public int getUID() //returns the user ID.
    {
        return uID;
    }
    
    public User[] getuArray() //returns the user array.
    {
        return uArray;
    }
    
    public int getuSize() //returns the size of the user array.
    {
        return size;
    }
}