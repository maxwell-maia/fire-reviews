/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package powernotes.pat;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Maxwell SSD
 */
public class SQLSTatements {
    DB data = new DB();
    
    //get the current date
    private Date dateObj = new Date();
    private DateFormat df = new SimpleDateFormat("#MM/dd/yyyy#");
    
    public void ReadToLogin(String u, String p) //accepts username and password parameter.
    {
            try
            {
                //Add the username and password to the User table
                data.updateTbl("INSERT INTO User (username, password)"
                    + " VALUES ('"+u+"', '"+p+"')");
                JOptionPane.showMessageDialog(null, "Your account has been successfully created. You may now log in.");
            }
            catch(SQLException se)
            {
                //display any error
                JOptionPane.showMessageDialog(null, se);
            }
    }
    
    public void InsertReview(int userID, int gameID, int rating, String comment) //accept the parameters for fields needed to add review to table
    {
        try
        {
            //SQL statment that adds the review to the Review table in the database
            data.updateTbl("INSERT INTO Reviews (UserID, GameID, uploadDate, Rating, Comment)"
                + "VALUES ('"+userID+"', '"+gameID+"', ("+df.format(dateObj)+"), '"+rating+"', '"+comment+"')");
            JOptionPane.showMessageDialog(null, "Review added successfully.");

        }
        catch (SQLException se)
        {
            //display any errors
            System.out.println(se);
            ErrorMsg er = new ErrorMsg("Critical failure! Failed to add review to the database.");
            er.showErrorMsg();
        }
    }
    
    public void AddGame(String gameName, String platform) //accepts the paramters for fields needed to add new game to table
    {
            try
            {
                //SQL Statement that adds the new game to the Game table in database
                data.updateTbl("INSERT INTO Games (GameName, Platform)"
                    + " VALUES ('"+gameName+"', '"+platform+"')");
                JOptionPane.showMessageDialog(null, "Game added successfully.");

            }
            catch(SQLException se)
            {
                //display errors
                System.out.println(se);
                ErrorMsg er = new ErrorMsg("Critical failure! Failed to add game to the database.");
                er.showErrorMsg();
            }
    }
    
    public void deleteGame(String gameToDeleteInput, int gameToDeleteID) //accepts the parameters for fields needed to delete a game from table
    {
        try
        {
            //delete the game from the Games table in the database
            data.updateTbl("DELETE FROM Games WHERE GameName = '"+gameToDeleteInput+"'");
            
            //delete all reviews of the game from Reviews table in the database
            data.updateTbl("DELETE FROM Reviews WHERE GameID = "+gameToDeleteID);
            JOptionPane.showMessageDialog(null, "Game deleted successfully.");
        }
        catch(SQLException se)
        {
            //display any error
            System.out.println(se);
            ErrorMsg er = new ErrorMsg("Critical failure! Failed to delete game from the database.");
            er.showErrorMsg();
        }
    }
}