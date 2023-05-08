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
public class GameArray
{
    private Game[] gArray = new Game[1000]; //create array of Game objects
    private int size = 0;
    private int distSize = 0;
    DB data = new DB();
    
    public GameArray() //compile array of games by retieving data from table and adding the data to array with while loop
    {        
        try
        {
            ResultSet rs = data.queryTb("SELECT * FROM Games"); //SQL statement to retrieve data from Games table
            while (rs.next())
            {
                int id = rs.getInt("GameID");
                String g = rs.getString("GameName");
                String p = rs.getString("Platform");
                gArray[size] = new Game(id, g, p);
                size++;
            }
        }
        catch(SQLException se) //display error
        {
            System.out.println(se);
        }
    }
    
    public Game[] distinctNames()
    {
        Game[] temp = new Game[size]; //create a temporary array the size of the full array
        
        //Use while loop to compile an array of Games objects with the distinct (non-duplicated) Game names found in the Games table
        try
        {
            ResultSet rs = data.queryTb("SELECT DISTINCT GameName FROM Games"); //SQL statement that retrieves the distinct game names
            while(rs.next())
            {
                String name = rs.getString("GameName");
                temp[distSize] = new Game(0, name, "");
                distSize++;
            }
        }
        catch(SQLException se) //display error
        {
            System.out.println(se);
        }
        return temp;
    }
    
    public Game[] getgArray() //returns the full array
    {
        return gArray;
    }
    
    public Game[] getDistArray() //returns the array of distinct names
    {
        return distinctNames();
    }
    
    public int getSize() //returns the size of the full array
    {
        return size;
    }
    
    public int getDistSize() //returns the size of the distinct names array
    {
        return distSize;
    }
    
    public String toString() //returns a string of the games and platforms formatted for a text area. This was not used in the final version of the program.
    {
        String temp = "ID\tGame\t\t\tPlatform\n\n";
        
        for(int i = 0; i<size; i++)
            temp += gArray[i].getNumber()+"\t"+gArray[i].getName()+"\t\t\t"
                    +gArray[i].getPlatform() + "\n\n";
        return temp;
    }
}
