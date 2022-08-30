/* File Description:
 * This file contains a class to run the main() method.
 */
package ludo; //This file belongs to the source package ludo  

//importing required Classes from their respective packages 
import java.awt.Graphics; 
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * NAME: Akanksha Kakar 
 * INSTRUCTOR: Seth Volpe
 * PROJECT: Project 1 - Deliverable 4 Spring 2021
 * PROJECT DESCRIPTION: Functional Ludo Game
 * DATE OF SUBMISSION: 04/27/2021
 * DATE OF COMPLETION: 04/24/2021
 * @author akku
 * class Ludo
 */

//start of class Ludo
public class Ludo extends JFrame{ //Ludo extends JFrame to launch a main Window and display the GUI
    //TEST RUN
    //storing the names of PLayers 
    static String p[] = {"Akanksha", "Player 2", "Playe 3", "Player 4"};
    //number of players accounted for (i.e. array size = 2)
    static int num = 4;
   
    //start of main method
    public static void main(String[] args) {
        //SetUp object to set up a new session of the Game
        //SetUp s = new SetUp(num,p);
        SetUpGUI s = new SetUpGUI();
        s.setTitle("Ludo Game by Akanksha Kakar");
        s.setVisible(true);
    }//end of main method  
}//end of class 

/** User Management 
 * Handled 2 players diagonally opposite positioning by writing specific if statements across various classes
 */