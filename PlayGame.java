/* File Description:
 * This file contains a class to implement rules of the game. Main logic of the game and user interaction is in this file.
 */

package ludo; //This file belongs to the source package ludo 

//importing required Classes from their respective packages
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * NAME: Akanksha Kakar 
 * INSTRUCTOR: Seth Volpe
 * PROJECT: Project 1 - Deliverable 4 Spring 2021
 * PROJECT DESCRIPTION: Functional Ludo Game
 * DATE OF SUBMISSION: 04/27/2021
 * DATE OF COMPLETION: 04/26/2021
 * @author akku
 * class PlayGame
 */

//start of class PlayGame
public class PlayGame extends JFrame { //PlayGame extends JFrame to launch a main Window and display the GUI 
    
    //initializing required variables 
    public String playerName[];
    public int playerNum;
    public int rolled, cur_player, t_pos = 0;
    
    public int[][] relativePos = new int[4][4];
    
    Path pth = new Path();
    //Board is offset by 60 pixels in both X and Y directions from origin of main window 
    int bx = (int) pth.offset.getX();
    int by = (int) pth.offset.getY();
    //setting scale to 30 pixels 
    int scale = pth.scaleFactor;
    //controlling where a player can click based on a valid/invalid roll of a die or a valid/invalid move
    boolean dClickable = true, lbClickable = false; 
    //providing messages about the player's turns and actions
    String message = "", message2 = "", message3 = "";
    //initializing required objects 
    LudoBoard lb;
    CreatePlayer plyrs;
    //creating a button to generate random values between 1-6 to simulate a dice roll
    JButton dice = new JButton("Roll Dice");
    
    //start of constructor PlayGame() containing no parameters 
    public PlayGame(){
        //setting default values to variables 
        for (int i = 0; i < 4; i++)
        {
            playerName[i] = "";
        }
        playerNum = 0;       
    }//end of constructor 
    
    //start of constructor PlayGame() containing parameters playerNum of int type and playerName[] of String type 
    public PlayGame(int playerNum, String playerName[]){
        //setting values of variables of this class to the respective parameters passed  
        this.playerNum = playerNum;
        this.playerName = playerName;
        //creating new objects 
        lb = new LudoBoard();
        plyrs = new CreatePlayer(this.playerNum,this.playerName);
        //calling initComponents()
        initComponents();
    }//end of constructor 
    
    //start of initComponents() function
    private void initComponents(){
        testing();
        message = plyrs.plyr[cur_player].name + "'s turn";
        //designing main window 
        this.setTitle("Ludo Game by Akanksha Kakar");
        this.setVisible(true);
        this.setSize(800, 700);
        this.setExtendedState(4);
        this.setDefaultCloseOperation(3);
        this.setLayout(null);
        //drawing and displaying the dice button on the JFrame
        dice.setBounds(550, 100, 100, 50);
        this.add(dice);
        //creating the mouse click event for the dice button
        dice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                diceMouseClicked(evt);
            }
        });
        //creating the mouse click event for the JFrame to capture valid moves
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbClicked(evt);
            }
        });
        
        for (int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                relativePos[i][j] = -1;
            }
        }
        
    }//end of function
    public void testing(){
        System.out.println("Number of players: " + playerNum);
        for (int i = 0; i < playerNum; i++){
            if (playerNum == 2 && i == 1){
                System.out.println("Player: " + playerName[i+1]);
                for (int j = 0; j < 4; j++){
                System.out.println("Token " + (j+1) + " position: " + plyrs.plyr[i].tkn[j].pos);
            }
            } else {
                System.out.println("Player: " + playerName[i]);
                for (int j = 0; j < 4; j++){
                System.out.println("Token " + (j+1) + " position: " + plyrs.plyr[i].tkn[j].pos);
                }
            }
        }
    }//end of function
   
    //start of paint() function
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        //calling  the paint functions of various classes to create the GUI
        super.paint(g2d);  
        lb.drawGUI(g2d);
        plyrs.drawGUI(g2d);
        //Displaying Instructions and messages
        g2d.drawString("Instructions: ", 540, 70);
        if (dClickable){
            g2d.drawString(message, 540, 90);
        } else if (lbClickable){
            g2d.drawString(message, 540, 90);
        } 
        g2d.drawString(message2, 540, 110);
        g2d.drawString(message3, 540, 200);
    }//end of function
    //start of validRoll() function
    /** What is a Valid Roll?
     * If Player has rolled 6 AND if any token is present at the player's base 
     * If Player has rolled any value between 1-6 AND token is in play AND position of token + rolled value is <= 56 (home value)
     */
    public boolean validRoll(){
        for(int j = 0; j < 4; j++){
            if ((rolled == 6 && plyrs.plyr[cur_player].tkn[j].pos == -1) || (rolled <=6 && plyrs.plyr[cur_player].tkn[j].pos > -1 && plyrs.plyr[cur_player].tkn[j].pos+rolled <= 56)){
                return true;
            }
        }
        return false; 
    }//end of function
    //start of diceClicked() function
    private void diceMouseClicked(java.awt.event.MouseEvent evt){
        if(dClickable){
            rolled = 1+(int)(Math.random()*((6-1)+1)); //simulate the rolls of a dice
            //System.out.println(rolled);
            message = plyrs.plyr[cur_player].name + " rolled " + rolled;
            if (validRoll()){
                //player is now permitted to move token
                dClickable = false;
                lbClickable = true;
                message2 = plyrs.plyr[cur_player].name + ", click token to move";
            } else {
                //focus shifts to next player
                cur_player = (cur_player+1)%playerNum;
                message2 = plyrs.plyr[cur_player].name + "'s turn";
            }
            repaint();
        }
        
    }//end of function
    //start of validMove() function
    // accepts the coordinates of the point "clicked" in the lbClicked() function
    /** What is a Valid Move?
     * If Player has rolled 6 AND if any token is present at the player's base AND player clicked on that token. 
       In this case, set position of token to zero (start point of play which is the first array value in path[][] for that player)
     * If Player has rolled any value between 1-6 AND token is in play AND position of token + rolled value is <= 56 (home value)
     */
    private int validMove(Point click){
        int position, player;
        if(playerNum == 2 && cur_player == 1){
            player = cur_player + 1;
        } else {
            player = cur_player;
        }
        for (int j = 0; j < 4; j++){
            position = plyrs.plyr[cur_player].tkn[j].pos;
            if (position == -1){
                if (rolled == 6 && click.equals(pth.start[player][j])){
                    return j+60; //returning a high value to distinguish b/w start and in play tokens
                } else {
                    if (rolled < 6 && click.equals(pth.start[player][j])){
                        return -1;
                    }
                }
            } else {
                if(click.equals(pth.path[player][position]) && position+rolled <=56){
                    return j;
                }
            }
        }    
        return -1;
    }//end of function
    //start of lbClicked() function
    private void lbClicked(java.awt.event.MouseEvent evt){
        int x,y;
        if(lbClickable){
            //captures the point clicked by the user
            x = evt.getX()/scale - bx/scale;
            y = evt.getY()/scale - by/scale;
            //System.out.println(x + " " + y);
            Point clicked = new Point(x,y);
            //checks for validity of click/move
            if(validMove(clicked) > -1){
                int temp = validMove(clicked);
                if (temp > 59){ //specifically to check if the clicked token was at the base
                    temp = temp%15; //returns token index, sets position to start of play and reduces token at base by 1
                    plyrs.plyr[cur_player].tkn[temp].pos = 0;
                    if(playerNum == 2 && cur_player==1){
                        relativePos[cur_player][temp] = (cur_player+1)*13;
                    } else {
                        relativePos[cur_player][temp] = cur_player*13;
                    }
                    
                    
                    System.out.println(relativePos[cur_player][temp]);
                    --plyrs.plyr[cur_player].base;
                } else { //update position fo the token by adding the rolled value 
                    plyrs.plyr[cur_player].tkn[temp].pos += rolled;
                    t_pos = plyrs.plyr[cur_player].tkn[temp].pos;
                    if(playerNum == 2 && cur_player==1){
                        if(t_pos < 51){
                            relativePos[cur_player][temp] = (t_pos + ((cur_player+1)*13))%52;
                        } else {
                            relativePos[cur_player][temp] = -1;
                        }
                    } else {
                        if(t_pos < 51){
                            relativePos[cur_player][temp] = (t_pos + (cur_player*13))%52;
                        } else {
                            relativePos[cur_player][temp] = -1;
                        }
                    }
                    
                    System.out.println("Relative Postion of token for capture: " + relativePos[cur_player][temp]);
                    testing();
                    if (t_pos%13 != 0 && t_pos!= 8 && t_pos!= 21 && t_pos!= 34 && t_pos!= 47 && t_pos < 51){  
                        capture(temp);
                    }
                    //condition for when token has reached "home"
                    if (plyrs.plyr[cur_player].tkn[temp].pos == 56){
                        plyrs.plyr[cur_player].home++;
                        if(plyrs.plyr[cur_player].home == 4){
                            //adding player to Players table in DB titled Ludo
                            addToDB(cur_player);
                            JOptionPane.showMessageDialog(new JFrame(), plyrs.plyr[cur_player].name + " WON !!"); 
                        }
                    }
                }
                message3 = "";
                if (rolled == 6){ //player gets a chance to roll again if they get a 6
                    message2 = plyrs.plyr[cur_player].name + "'s turn again";
                } else { //focus shifts to next player
                    cur_player = (cur_player+1)%playerNum;
                    message2 = plyrs.plyr[cur_player].name + "'s turn";
                }
                lbClickable = false;
                dClickable = true;
            } else {
                message3 = "Invalid Click";
            }
        }//end of if statement 
        repaint();
    }//end of function
    //start of capture() function
    private void capture(int temp){
        int store_i = 0;
        int store_j = 0;
        int count  = 0;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(cur_player != i){
                    if(relativePos[cur_player][temp] == relativePos[i][j]){
                        store_i = i;
                        store_j = j;
                        count++;
                    }
                }
            } 
            if (count == 1){
                relativePos[store_i][store_j] = -1;
                plyrs.plyr[store_i].tkn[store_j].pos = -1;
                ++plyrs.plyr[store_i].base;
                count =0 ;
                store_i = 0;
                store_j=0;
            }
        }
        repaint();
    }//end of function
    //SQL Database integration
    private void addToDB(int c_player){
        try {
            //adding sql connection titled 'Ludo' with username 'Akanksha' and password 'Akanksha'
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Ludo", "Akanksha", "Akanksha");
            Statement stmt = con.createStatement(); //to execute the query statement
            //adding String to draft sql statement 
            String s_stmt = "select * from Players where player_name = '" + playerName[c_player] + "'";
            //executing query
            ResultSet rSet = stmt.executeQuery(s_stmt);
            //adding player to Players table in database 
            if(!rSet.next()){
                s_stmt = "insert into Players values ((select count(*) from Players)+1, '" + playerName[c_player] + "', 1)";
                System.out.println(s_stmt);
                stmt.executeUpdate(s_stmt);
            } else {
                s_stmt = "update Players set number_wins = number_wins+1 where player_name = '" + playerName[c_player] + "'";
                System.out.println(s_stmt);
                stmt.executeUpdate(s_stmt);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PlayGame.class.getName()).log(Level.SEVERE, null, ex);
        } //end of try-catch exception statements   
    }//end of function
}//end of class 