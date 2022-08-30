/* File Description:
 * This file contains a class to initiate/create number of players based on input.
 */

package ludo; //This file belongs to the source package ludo 

//importing required Class from its respective package
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * NAME: Akanksha Kakar 
 * INSTRUCTOR: Seth Volpe
 * PROJECT: Project 1 - Deliverable 4 Spring 2021
 * PROJECT DESCRIPTION: Functional Ludo Game
 * DATE OF SUBMISSION: 04/27/2021
 * DATE OF COMPLETION: 04/24/2021
 * @author akku
 * class CreatePlayer
 */

//start of class CreatePlayer
public class CreatePlayer {
    
    //initializing required variables 
    public String playerName[];
    public int playerNum;
    //initializing required objects 
    Path pth = new Path();
    Player[] plyr = new Player[4];
    
    //start of constructor CreatePlayer() containing no parameters
    public CreatePlayer(){
        //setting default values to variables
        for (int i = 0; i < 4; i++)
        {
            playerName[i] = "";
        }
        playerNum = 0;       
    }//end of constructor
    
    //start of constructor CreatePlayer() containing parameters playerNum of int type and playerName[] of String type 
    public CreatePlayer(int playerNum, String playerName[]){
        //setting values of variables of this class to the respective parameters passed 
        this.playerNum = playerNum;
        this.playerName = playerName; 
        for (int i = 0; i < this.playerNum; i++)
        {
            if(this.playerNum == 2 && i == 1){
                this.playerName[i+1] = this.playerName[i];
                this.playerName[i] = "";
                plyr[i] = new Player(this.playerName[i+1], pth.playerColor[i+1]); 
            } else {
                plyr[i] = new Player(this.playerName[i], pth.playerColor[i]); 
            }
        }
    }//end of constructor
    //start of drawGUI() function
    public void drawGUI(Graphics2D g2d){
        int x = (int) pth.offset.getX();
        int y = (int) pth.offset.getY();
        int scale = pth.scaleFactor;
        //GUI to write names of all Players on the Ludo board above/below their respective color
        g2d.setColor(Color.black);
        g2d.drawString(this.playerName[0], x+(2*scale), y-(scale/2));
        g2d.drawString(this.playerName[1], x+(11*scale), y-(scale/2));
        g2d.drawString(this.playerName[2], x+(11*scale), y+(16*scale));
        g2d.drawString(this.playerName[3], x+(2*scale), y+(16*scale));
        //calling drawGUI function for each player. 
        for (int i = 0; i < this.playerNum; i++)
        {
            if(this.playerNum == 2 && i == 1){
                plyr[i].drawGUI(g2d,2);
            } else {
                plyr[i].drawGUI(g2d,i);
            }
        }
    }//end of function    
}//end of class 
