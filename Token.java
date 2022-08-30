/* File Description:
 * This file contains a class to associate tokens to players; to locate positions of each token.
 */
package ludo; //This file belongs to the source package ludo 

//importing required Classes from their respective packages
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * NAME: Akanksha Kakar 
 * INSTRUCTOR: Seth Volpe
 * PROJECT: Project 1 - Deliverable 4 Spring 2021
 * PROJECT DESCRIPTION: Functional Ludo Game
 * DATE OF SUBMISSION: 04/27/2021
 * DATE OF COMPLETION: 04/21/2021
 * @author akku
 * class Token
 */

//start of class Token
public class Token {

    //initializing required variables 
    int pl_index, tk_index;
    int pos; //stores numeric value position of the token. When token is at base then value is -1. Else, value lies between 0 to 57.
    //coordinates of the token can be retrieved from pth.path[i][pos] (where, 'i' is the player number)
    Color clr;
    Path pth = new Path();

    //start of constructor Token() containing no parameters
    public Token() {
        //setting default values to variables
        this.clr = Color.WHITE;
        pos = -1;
    }//end of constructor
    //start of constructor Token() containing parameter clr of Color type 

    public Token(Color clr) {
        //setting values of variables of this class to the respective parameters passed 
        this.clr = clr;
        //setting default values to variables
        pos = -1;
    }//end of constructor

    //start of drawGUI() function
    public void drawGUI(Graphics2D g2d, int i, int j, int play) {
        int pos_x;
        int pos_y;
        //Board is offset by 60 pixels in both X and Y directions from origin of main window 
        int x = (int) pth.offset.getX();
        int y = (int) pth.offset.getY();
        //setting scale to 30 pixels 
        int scale = pth.scaleFactor;
        //this draws the tokens for a player in their respective color
        //when pos = -1, token is at the base, array of Point coordinates are picked up from class Path in the "start" array. - start[pl_index][tk_index]
        if (pos == -1) {
            pl_index = i;
            tk_index = j;
            g2d.setColor(clr);
            //getting  x and y coordinates of the point
            pos_x = x + ((int) pth.start[pl_index][tk_index].getX() * scale);
            pos_y = y + ((int) pth.start[pl_index][tk_index].getY() * scale);
            //drawing the token
            g2d.fillOval(pos_x, pos_y, scale, scale);
            g2d.setColor(Color.BLACK);
            g2d.drawOval(pos_x, pos_y, scale, scale);
        } else {
            //when pos > -1, token is in play, array of Point coordinates are picked up from class Path in the "path" array. - path[pl_index][pos]
            pl_index = i;
            tk_index = j;
            g2d.setColor(clr);
            //getting  x and y coordinates of the point
            pos_x = x + ((int) pth.path[pl_index][pos].getX() * scale);
            pos_y = y + ((int) pth.path[pl_index][pos].getY() * scale);
            //drawing the token
            g2d.fillOval(pos_x, pos_y, scale, scale);
            g2d.setColor(Color.BLACK);
            g2d.drawOval(pos_x, pos_y, scale, scale);
        }//end of if-else statement 
    }//end of function
}//end of class 
