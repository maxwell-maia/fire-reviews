/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package powernotes.pat;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Maxwell SSD
 */
public class ReviewArray
{
    private Review[] rArray = new Review[1000]; //create array of Review objects
    private int rSize = 0;
    private Date dateObj = new Date(); //get the current date
    private DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); //format the date to the way that the database program accepts date inputs
    
    //get the array of games
    private GameArray ga = new GameArray();
    private int gSize = ga.getSize(); //get the size of the full array
    private Game[] fullgArray = ga.getgArray();
    
    //get the array of users
    private UserArray ua = new UserArray();
    private int uSize = ua.getuSize(); //get the size of the user array
    private User[] uArray = ua.getuArray();
    
    private String username, gameName, platform;
    
    DB data = new DB();

    public ReviewArray() //compile array of reviews by retieving data from table and adding the data to array with while loop
    {
        try
        {
            ResultSet rs = data.queryTb("SELECT * FROM Reviews"); //SQL statement to retrieve data from Reviews table
            while(rs.next())
            {
                int rID = rs.getInt("ReviewID");
                int uID = rs.getInt("UserID");
                int gID = rs.getInt("GameID");
                df.format(dateObj);
                dateObj = rs.getDate("uploadDate");
                int rating = rs.getInt("Rating");
                String comment = rs.getString("Comment");
                rArray[rSize] = new Review(rID, uID, gID, dateObj, rating, comment);
                rSize++;
            }
        }
        catch(SQLException se) //display error
        {
            System.out.println(se);
            ErrorMsg er = new ErrorMsg(""+se); //Error message with output of SQLException
            er.showErrorMsg();
        }
    }
    
    public int getSize() //returns the size of the review array
    {
        return rSize;
    }
    
    public Review[] getrArray() //returns the review array
    {
        return rArray;
    }
    
    
    //returns a string of spaces that will add to to the desiredSpaces character length(input + spaces = desiredSpaces).
    //The point of this is to make the total length of a set of strings all the same.
    //desiredSpaces is the amount of total characters there should be. 
    public String addSpaces(String input, int desiredSpaces)
    {
        int l = input.length();
        String spacesString = "";
        for(int i = 0; i<desiredSpaces-l; i++)
        {
            spacesString += " ";
        }
        return spacesString;
    }
    
    public String toString() //used to print out the reviews on the main screen
    {
        String temp = "Username    Game                                Platform\tUpload Date\tRating\tComment\n\n\n";
        
        
        for(int i = 0; i<rSize; i++) //for every review in the review array...
        {
            
            for(int k = 0; k<uSize; k++) //finds the username using the userID
            {
                if(rArray[i].getuID() == uArray[k].getuID())
                    username = uArray[k].getUsername();
            }
            
            for(int h = 0; h<gSize; h++) //finds the game info using the game ID
            {
                if(rArray[i].getgID() == fullgArray[h].getNumber())
                {
                    gameName = fullgArray[h].getName();
                    platform = fullgArray[h].getPlatform();
                }
            }
            
            temp += username+addSpaces(username, 12)+gameName+addSpaces(gameName, 36)+platform+addSpaces(platform, 12) + "\t"+ rArray[i].getDateObj() + "\t"+rArray[i].getRating() +
                    "\t"+rArray[i].getComment()+ "\n\n";
        }
        return temp;
    }
    
    //the parameters of method below are the filter parameters get by the user
    public String toStringSort(String gameIn, String platformIn, String usernameIn) //used to print out the SORTED reviews on the main screen
    {
        String temp = "Username    Game                                Platform\tUpload Date\tRating\tComment\n\n\n";
        
        
        for(int i = 0; i<rSize; i++) //for every review in the review array... go through the review array checking if the filter options enetered match the data in the review array.
                                                                             //Do this for the 8 possible combinations of filters
        {
            
            for(int k = 0; k<uSize; k++) //finds the username using the userID
            {
                if(rArray[i].getuID() == uArray[k].getuID())
                    username = uArray[k].getUsername();
            }
            
            for(int h = 0; h<gSize; h++) //finds the game info using the game ID
            {
                if(rArray[i].getgID() == fullgArray[h].getNumber())
                {
                    gameName = fullgArray[h].getName();
                    platform = fullgArray[h].getPlatform();
                }
            }
            
            
            //8 combinations of sort
            //only game sort
            if(gameIn.equals(gameName) && platformIn.equals("") && usernameIn.equals(""))
            {
                temp += username+addSpaces(username, 12)+gameName+addSpaces(gameName, 36)+platform+addSpaces(platform, 12) + "\t"+ rArray[i].getDateObj() + "\t"+rArray[i].getRating() +
                        "\t"+rArray[i].getComment()+ "\n\n";
            }
            
            //only platform sort
            if(gameIn.equals("") && platformIn.equals(platform) && usernameIn.equals(""))
            {
                temp += username+addSpaces(username, 12)+gameName+addSpaces(gameName, 36)+platform+addSpaces(platform, 12) + "\t"+ rArray[i].getDateObj() + "\t"+rArray[i].getRating() +
                        "\t"+rArray[i].getComment()+ "\n\n";
            }
            
            //only username sort
            if(gameIn.equals("") && platformIn.equals("") && usernameIn.equals(username))
            {
                temp += username+addSpaces(username, 12)+gameName+addSpaces(gameName, 36)+platform+addSpaces(platform, 12) + "\t"+ rArray[i].getDateObj() + "\t"+rArray[i].getRating() +
                        "\t"+rArray[i].getComment()+ "\n\n";
            }
            
            //game and platform sort
            if(gameIn.equals(gameName) && platformIn.equals(platform) && usernameIn.equals(""))
            {
                temp += username+addSpaces(username, 12)+gameName+addSpaces(gameName, 36)+platform+addSpaces(platform, 12) + "\t"+ rArray[i].getDateObj() + "\t"+rArray[i].getRating() +
                        "\t"+rArray[i].getComment()+ "\n\n";
            }
            
            //platform and username sort
            if(gameIn.equals("") && platformIn.equals(platform) && usernameIn.equals(username))
            {
                temp += username+addSpaces(username, 12)+gameName+addSpaces(gameName, 36)+platform+addSpaces(platform, 12) + "\t"+ rArray[i].getDateObj() + "\t"+rArray[i].getRating() +
                        "\t"+rArray[i].getComment()+ "\n\n";
            }
            
            //game and username sort
            if(gameIn.equals(gameName) && platformIn.equals("") && usernameIn.equals(username))
            {
                temp += username+addSpaces(username, 12)+gameName+addSpaces(gameName, 36)+platform+addSpaces(platform, 12) + "\t"+ rArray[i].getDateObj() + "\t"+rArray[i].getRating() +
                        "\t"+rArray[i].getComment()+ "\n\n";
            }
            
            //game, platform and username sort
            if(gameIn.equals(gameName) && platformIn.equals(platform) && usernameIn.equals(username))
            {
                temp += username+addSpaces(username, 12)+gameName+addSpaces(gameName, 36)+platform+addSpaces(platform, 12) + "\t"+ rArray[i].getDateObj() + "\t"+rArray[i].getRating() +
                        "\t"+rArray[i].getComment()+ "\n\n";
            }
            
            //no sort
            if(gameIn.equals("") && platformIn.equals("") && usernameIn.equals(""))
            {
                temp += username+addSpaces(username, 12)+gameName+addSpaces(gameName, 36)+platform+addSpaces(platform, 12) + "\t"+ rArray[i].getDateObj() + "\t"+rArray[i].getRating() +
                        "\t"+rArray[i].getComment()+ "\n\n";
            }
        }
        return temp; //return the string of all the reviews that apply to filter. (String fomatted for text area)
    }
}
