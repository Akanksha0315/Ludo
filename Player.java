/* File Description:
 * This file contains a class to initialize players; to associate colors and tokens with players.
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
 * class Player
 */

//start of class Player
public class Player {
    //initializing required variables 
    int status, home, base;
    String name;
    Color clr;
    //initializing required objects 
    Token[] tkn = new Token[4];
    
    //start of constructor Player() containing no parameters
    public Player(){
        //setting default values to variables
        status = -1;
        home = 0;
        base = 4;
        name = "";
    }//end of constructor
    //start of constructor Player() containing parameters name of String type and clr of Color type 
    public Player(String name, Color clr){
        //setting default values to variables
        status = -1;
        home = 0;
        base = 4;
        //setting values of variables of this class to the respective parameters passed 
        this.name = name;
        this.clr = clr;
        for (int i = 0; i < 4; i++){
            tkn[i] = new Token(this.clr);
        }//end of for loop
    }//end of constructor
    //start of drawGUI() function
    public void drawGUI(Graphics2D g2d, int i){
        //drawing the GUI for information of each player
        g2d.drawString(this.name, 550, 250+(i*60));
        g2d.drawString("Tokens at Base: " + String.valueOf(base), 550, 270+(i*60));
        g2d.drawString("Tokens at Home: " + String.valueOf(home), 550, 290+(i*60));
        //calling the drawGUI for each of the 4 tokens for a single player
        for(int j = 0; j < 4; j++){
            tkn[j].drawGUI(g2d, i, j, i); //where 'i' is the index of the player and 'j' is the index of the token
        }//end of for loop
    }//end of function
}//end of class 
