/* File Description:
 * This file contains a class to draw the Ludo Board Design[GUI]
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
 * class LudoBoard
 */

//start of class LudoBoard
public class LudoBoard {
    //initializing required variables 
    int x,y,scale;
    //initializing required objects 
    Path pth = new Path();
    
    //start of constructor LudoBoard() containing no parameters
    public LudoBoard(){ //empty constructor               
    }//end of constructor

    //start of drawGUI() method
    public void drawGUI(Graphics2D g2d){ //to draw the Ludo Board 
        //setting color to white 
        g2d.setColor(Color.WHITE);
        //Board is offset by 60 pixels in both X and Y directions from origin of main window 
        x = (int) pth.offset.getX();
        y = (int) pth.offset.getY();
        //setting scale to 30 pixels 
        scale = pth.scaleFactor;
        //Creating Game Board boundary
        g2d.fillRect(x, y, 15*scale, 15*scale);
        
        //Red Home Location
        g2d.setColor(pth.playerColor[0]);
        int[] xPoints = {(x+(6*scale)), (x+(6*scale)), (x+(7*scale)+(scale/2))};
        int[] yPoints = {(y+(6*scale)), (y+(9*scale)), (y+(7*scale)+(scale/2))};
        g2d.fillPolygon(xPoints, yPoints, 3);
        g2d.drawPolygon(xPoints, yPoints, 3);
        
        //Green Home Location
        g2d.setColor(pth.playerColor[1]);
        xPoints = new int[]{(x+(6*scale)), (x+(9*scale)), (x+(7*scale)+(scale/2))} ;
        yPoints = new int[]{(y+(6*scale)), (y+(6*scale)), (y+(7*scale)+(scale/2))} ;
        g2d.fillPolygon(xPoints, yPoints, 3);
        g2d.drawPolygon(xPoints, yPoints, 3);
        
        //Blue Home Location
        g2d.setColor(pth.playerColor[2]);
        xPoints = new int[]{(x+(9*scale)), (x+(9*scale)), (x+(7*scale)+(scale/2))} ;
        yPoints = new int[]{(y+(6*scale)), (y+(9*scale)), (y+(7*scale)+(scale/2))} ;
        g2d.fillPolygon(xPoints, yPoints, 3);
        g2d.drawPolygon(xPoints, yPoints, 3);
        
        //Yellow Home Location
        g2d.setColor(pth.playerColor[3]);
        xPoints = new int[]{(x+(6*scale)), (x+(9*scale)), (x+(7*scale)+(scale/2))} ;
        yPoints = new int[]{(y+(9*scale)), (y+(9*scale)), (y+(7*scale)+(scale/2))} ;
        g2d.fillPolygon(xPoints, yPoints, 3);
        g2d.drawPolygon(xPoints, yPoints, 3);
        
        //Created base area for each Player
        for(int i = 0; i < 4; i++){
            //Base Area filled in respective color 
            g2d.setColor(pth.playerColor[i]);
            g2d.fillRect(x+((int)pth.base[i].getX()*scale), y+((int)pth.base[i].getY()*scale), 6*scale, 6*scale);
            g2d.fillRect(x+((int)pth.path[i][0].getX()*scale), y+((int)pth.path[i][0].getY()*scale), scale, scale);
            
            //White space in each "Base" 
            g2d.setColor(Color.WHITE);
            g2d.fillRect(x+(((int)pth.base[i].getX()+1)*scale), y+(((int)pth.base[i].getY()+1)*scale), 4*scale, 4*scale);
            
            //Outlining 
            g2d.setColor(Color.BLACK);
            g2d.drawRect(x+((int)pth.base[i].getX()*scale), y+((int)pth.base[i].getY()*scale), 6*scale, 6*scale);
            g2d.drawRect(x+(((int)pth.base[i].getX()+1)*scale), y+(((int)pth.base[i].getY()+1)*scale), 4*scale, 4*scale);
            //Drawing "Safe Points" 
            g2d.drawOval(x+((int)pth.safe[i].getX()*scale), y+((int)pth.safe[i].getY()*scale), scale, scale);
            g2d.setColor(Color.LIGHT_GRAY);
            g2d.fillOval(x+((int)pth.safe[i].getX()*scale), y+((int)pth.safe[i].getY()*scale), scale, scale);
            //creating home divisions
            //g2d.drawLine(x+(6*scale), y+(6*scale), x+(9*scale), y+(9*scale));
            //g2d.drawLine(x+(6*scale), y+(9*scale), x+(9*scale), y+(6*scale));
        }//end of for loop
        //Start base token positions
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                g2d.setColor(pth.playerColor[i]);
                g2d.drawRect(x+((int)pth.start[i][j].getX()*scale), y+((int)pth.start[i][j].getY()*scale), scale, scale);
            }//end of for loop          
        }//end of for loop    
        //Home columns for each color 
        for(int i = 0; i < 4; i++){
            for(int j = 51; j < 56; j++){
                g2d.setColor(pth.playerColor[i]);
                g2d.fillRect(x+((int)pth.path[i][j].getX()*scale), y+((int)pth.path[i][j].getY()*scale), scale, scale);
            }//end of for loop          
        }//end of for loop    
        //Outlining 
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 56; j++){
                g2d.setColor(Color.BLACK);
                g2d.drawRect(x+((int)pth.path[i][j].getX()*scale), y+((int)pth.path[i][j].getY()*scale), scale, scale);  
            }//end of for loop
        }//end of for loop          
    }//end of function
}//end of class 
