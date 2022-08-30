/* File Description:
 * This file contains a class to store valid paths for tokens, starting point, base, safe points.
 */
package ludo; //This file belongs to the source package ludo 

//importing required Classes from their respective packages
import java.awt.Color;
import java.awt.Point;

/**
 * NAME: Akanksha Kakar 
 * INSTRUCTOR: Seth Volpe
 * PROJECT: Project 1 - Deliverable 4 Spring 2021
 * PROJECT DESCRIPTION: Functional Ludo Game
 * DATE OF SUBMISSION: 04/27/2021
 * DATE OF COMPLETION: 04/24/2021
 * @author akku
 * class Path
 */

//start of class Path
public class Path {
    //initializing required variable 
    static int scaleFactor = 30; //length of squares on ludo board
    
    //initializing required objects using classes Point and Color from the awt package 
    static Color playerColor[] = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW};
    static Point offset = new Point(60, 60); //used to offset position of the ludo board in JFrame 
    
    //This Array stores the top left corner of the base for each of the 4 colors  
    //base[i] - 'i' is the player number 
    static Point[] base = {
        new Point(0, 0),
        new Point(9, 0),
        new Point(9, 9),
        new Point(0, 9)
    };
    
    //This 2D Array stores all the possible positions where each token of each of the 4 colors is kept when in base 
    //start[i][j] - 'i' is the player number, 'j' is the token number 
    static Point[][] start = {
        {new Point(2, 2), new Point(2, 3), new Point(3, 2), new Point(3, 3)},
        {new Point(11, 2), new Point(11, 3), new Point(12, 2), new Point(12, 3)},
        {new Point(11, 11), new Point(11, 12), new Point(12, 11), new Point(12, 12)},
        {new Point(2, 11), new Point(3, 11), new Point(2, 12), new Point(3, 12)}
    };
    
    //This 2D Array stores all (57) possible positions each token of each of the 4 colors can move when in Play 
    /* consider, Array size is denoted by [i][j] consisting of 4*57 elements
     * for (j = 0; j < 57; j++)
     * Path for all Player 1 tokens is A[0][j]
     * Path for all Player 2 tokens is A[1][j]
     * Path for all Player 3 tokens is A[2][j]
     * Path for all Player 4 tokens is A[3][j]
    */
    static Point[][] path = {
        {new Point(1, 6), new Point(2, 6), new Point(3, 6), new Point(4, 6), new Point(5, 6), new Point(6, 5), new Point(6, 4), new Point(6, 3), new Point(6, 2), new Point(6, 1), new Point(6, 0), new Point(7, 0), new Point(8, 0), new Point(8, 1), new Point(8, 2), new Point(8, 3), new Point(8, 4), new Point(8, 5), new Point(9, 6), new Point(10, 6), new Point(11, 6), new Point(12, 6), new Point(13, 6), new Point(14, 6), new Point(14, 7), new Point(14, 8), new Point(13, 8), new Point(12, 8), new Point(11, 8), new Point(10, 8), new Point(9, 8), new Point(8, 9), new Point(8, 10), new Point(8, 11), new Point(8, 12), new Point(8, 13), new Point(8, 14), new Point(7, 14), new Point(6, 14), new Point(6, 13), new Point(6, 12), new Point(6, 11), new Point(6, 10), new Point(6, 9), new Point(5, 8), new Point(4, 8), new Point(3, 8), new Point(2, 8), new Point(1, 8), new Point(0, 8), new Point(0, 7), new Point(1, 7), new Point(2, 7), new Point(3, 7), new Point(4, 7), new Point(5, 7), new Point(6, 7)},
        {new Point(8, 1), new Point(8, 2), new Point(8, 3), new Point(8, 4), new Point(8, 5), new Point(9, 6), new Point(10, 6), new Point(11, 6), new Point(12, 6), new Point(13, 6), new Point(14, 6), new Point(14, 7), new Point(14, 8), new Point(13, 8), new Point(12, 8), new Point(11, 8), new Point(10, 8), new Point(9, 8), new Point(8, 9), new Point(8, 10), new Point(8, 11), new Point(8, 12), new Point(8, 13), new Point(8, 14), new Point(7, 14), new Point(6, 14), new Point(6, 13), new Point(6, 12), new Point(6, 11), new Point(6, 10), new Point(6, 9), new Point(5, 8), new Point(4, 8), new Point(3, 8), new Point(2, 8), new Point(1, 8), new Point(0, 8), new Point(0, 7), new Point(0, 6), new Point(1, 6), new Point(2, 6), new Point(3, 6), new Point(4, 6), new Point(5, 6), new Point(6, 5), new Point(6, 4), new Point(6, 3), new Point(6, 2), new Point(6, 1), new Point(6, 0), new Point(7, 0), new Point(7, 1), new Point(7, 2), new Point(7, 3), new Point(7, 4), new Point(7, 5), new Point(7, 6)},
        {new Point(13, 8), new Point(12, 8), new Point(11, 8), new Point(10, 8), new Point(9, 8), new Point(8, 9), new Point(8, 10), new Point(8, 11), new Point(8, 12), new Point(8, 13), new Point(8, 14), new Point(7, 14), new Point(6, 14), new Point(6, 13), new Point(6, 12), new Point(6, 11), new Point(6, 10), new Point(6, 9), new Point(5, 8), new Point(4, 8), new Point(3, 8), new Point(2, 8), new Point(1, 8), new Point(0, 8), new Point(0, 7), new Point(0, 6), new Point(1, 6), new Point(2, 6), new Point(3, 6), new Point(4, 6), new Point(5, 6), new Point(6, 5), new Point(6, 4), new Point(6, 3), new Point(6, 2), new Point(6, 1), new Point(6, 0), new Point(7, 0), new Point(8, 0), new Point(8, 1), new Point(8, 2), new Point(8, 3), new Point(8, 4), new Point(8, 5), new Point(9, 6), new Point(10, 6), new Point(11, 6), new Point(12, 6), new Point(13, 6), new Point(14, 6), new Point(14, 7), new Point(13, 7), new Point(12, 7), new Point(11, 7), new Point(10, 7), new Point(9, 7), new Point(8, 7)},
        {new Point(6, 13), new Point(6, 12), new Point(6, 11), new Point(6, 10), new Point(6, 9), new Point(5, 8), new Point(4, 8), new Point(3, 8), new Point(2, 8), new Point(1, 8), new Point(0, 8), new Point(0, 7), new Point(0, 6), new Point(1, 6), new Point(2, 6), new Point(3, 6), new Point(4, 6), new Point(5, 6), new Point(6, 5), new Point(6, 4), new Point(6, 3), new Point(6, 2), new Point(6, 1), new Point(6, 0), new Point(7, 0), new Point(8, 0), new Point(8, 1), new Point(8, 2), new Point(8, 3), new Point(8, 4), new Point(8, 5), new Point(9, 6), new Point(10, 6), new Point(11, 6), new Point(12, 6), new Point(13, 6), new Point(14, 6), new Point(14, 7), new Point(14, 8), new Point(13, 8), new Point(12, 8), new Point(11, 8), new Point(10, 8), new Point(9, 8), new Point(8, 9), new Point(8, 10), new Point(8, 11), new Point(8, 12), new Point(8, 13), new Point(8, 14), new Point(7, 14), new Point(7, 13), new Point(7, 12), new Point(7, 11), new Point(7, 10), new Point(7, 9), new Point(7, 8)}
    };
    
    //This Array stores all (4)  positions allocated as safe spots where a token cannot be "captured"
    static Point[] safe = {
        new Point(6, 2),
        new Point(12, 6),
        new Point(8, 12),
        new Point(2, 8)
    };

}//end of class 