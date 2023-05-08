
package powernotes.pat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DB 
{
    private Connection conn = null;
    private Statement stmt = null;
    
    public DB()
    {
        try 
        {
            String host = "jdbc:ucanaccess://"+System.getProperty("user.dir") //get the database
			+ "//Users.accdb";
            conn = DriverManager.getConnection(host);
        }
        catch(SQLException err) //catch the error
        {
            JOptionPane.showMessageDialog(null, err.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public ResultSet queryTb (String sqlStmt) throws SQLException //select; Accepts the SQL statement as parameter.
                                                                  //Returns ResultSet of the result of SQL statement
    {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sqlStmt);
        return rs;
    }
    
    public void updateTbl (String update) throws SQLException //delete, update or insert; Accepts the SQL statement as parameter.
                                                              //Makes change to table
    {
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(update);
        stmt.close();
    }
}
