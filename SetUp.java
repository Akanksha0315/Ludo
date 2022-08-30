/* File Description:
 * This file contains a class to get and set number of players and their names [GUI].
 */
package ludo; //This file belongs to the source package ludo 

/**
 * NAME: Akanksha Kakar 
 * INSTRUCTOR: Seth Volpe
 * PROJECT: Project 1 - Deliverable 4 Spring 2021
 * PROJECT DESCRIPTION: Functional Ludo Game
 * DATE OF SUBMISSION: 04/27/2021
 * DATE OF COMPLETION: 04/21/2021
 * @author akku
 * class SetUp
 */

//start of class SetUp
public class SetUp {
    //initializing required variables 
    public String playerName[];
    public int playerNum;
    
    //start of constructor SetUp() containing no parameters
    public SetUp(){
        //setting default values to variables
        for (int i = 0; i < 4; i++)
        {
            playerName[i] = "";
        }
        playerNum = 0;
    }//end of constructor
    
    //start of constructor SetUp() containing parameters playerNum of int type and playerName[] of String type 
    public SetUp(int playerNum, String playerName[]){
        //setting values of variables of this class to the respective parameters passed 
        this.playerNum = playerNum;
        this.playerName = playerName; 
        //calling drawGUI() of this class 
        this.drawGUI();   
    }//end of constructor
    //start of setPlayerNum() function
    public void setPlayerNum(int playerNum){
        this.playerNum = playerNum; //setting number of Players 
    }//end of function
    //start of getPlayerNum() function
    public int getPlayerNum(){
        return this.playerNum; //returning/getting number of Players 
    }//end of function
    //start of setPlayerName() function
    public void setPlayerName(String playerName[]){
        this.playerName = playerName; //setting name of Players
    }//end of function
    //start of getPlayerName() function
    public String[] getPlayerName(){
        return this.playerName; //returning/getting name of Players 
    }//end of function
    //start of drawGUI() function
    public void drawGUI(){
        //User Management GUI to be built
        //initializing object
        PlayGame pg = new PlayGame(playerNum,playerName);
        pg.setVisible(true);
    }//end of function
    //start of mouseClick() function
    public void mouseClick(){
        //To be built 
    }//end of function
}//end of class 
