/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package powernotes.pat;

import javax.swing.JOptionPane;

/**
 *
 * @author Maxwell SSD
 */
public class ErrorMsg
{
    private String message = "No error message";

    public ErrorMsg(String m) //Sets the message to the error message in the constructor parameter.
    {
        this.message = m;
    }
    
    public void showErrorMsg() //Displays an information box with the error message.
    {
        JOptionPane.showMessageDialog(null, message, "Error dialog", JOptionPane.INFORMATION_MESSAGE);
    }
}