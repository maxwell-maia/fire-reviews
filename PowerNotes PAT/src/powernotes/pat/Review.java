/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package powernotes.pat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Maxwell SSD
 */
public class Review
{
    //variables for the review
    private int rID, uID, gID, rating;
    private DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); //get current date
    private Date dateObj = new Date();
    private String comment;

    public Review(int rID, int uID, int gID, Date dateObj, int rating, String comment) //accept parameters that describes the review object
    {
        this.rID = rID;
        this.uID = uID;
        this.gID = gID;
        this.dateObj = dateObj;
        this.rating = rating;
        this.comment = comment;
    }

    public int getrID() //returns the review id
    {
        return rID;
    }

    public int getuID() //returns the user id
    {
        return uID;
    }

    public int getgID() //returns the game id
    {
        return gID;
    }

    public int getRating() //returns the rating
    {
        return rating;
    }

    public Date getDateObj() //returns the date
    {
        return dateObj;
    }

    public String getComment() //returns the review comment
    {
        return comment;
    }

    @Override
    public String toString() //returns a string of all the review fields formatted with tabs
    {
        return rID + "\t" + uID + "\t" + gID + "\t" + dateObj + "\t" + rating + "\t" + comment;
    }
    
    
}
