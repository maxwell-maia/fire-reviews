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
public class Game
{
    private int number;
    private String name, platform;

    public Game(int number, String name, String platform) //accept parameters that describes the game object
    {
        this.number = number;
        this.name = name;
        this.platform = platform;
    }

    public int getNumber() //returns the game id
    {
        return number;
    }

    public String getName() //returns the game name
    {
        return name;
    }

    public String getPlatform() //returns the game platform
    {
        return platform;
    }

    @Override
    public String toString() //returns a string that concatinates all of the fields
    {
        return number + "\t" + name + "\t" + platform;
    }
    
}
