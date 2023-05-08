/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package powernotes.pat;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Maxwell SSD
 */
public class Help
{
    private int helpID = 1; //help id is set to 1 for debugging.
    private String message = "Error: No help returned.";
    DB data = new DB();

    public Help(int hID) //accept the id of the help message
    {
        this.helpID = hID;
        
        try //fetches the help message from database that has the ID: "hID".
            //hID is hardcoded in each help button.
        {
            ResultSet rs = data.queryTb("SELECT Message FROM Help WHERE HelpID = "+helpID); //SQL Statement to find help message that related to help ID
            while(rs.next())
            {
                message = rs.getString("Message"); //sets the message the one from the database
                new HelpScreen(message).setVisible(true); //sends message to HelpScreen constructor
            }
        }
        catch(SQLException se) //display any error
        {
            System.out.println(se);
        }
    }
}
