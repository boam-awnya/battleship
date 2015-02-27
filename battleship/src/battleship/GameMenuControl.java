/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Jeffry Simpson, Vehikite-John - BYUI CIT260 Section 03
 */
public class GameMenuControl
{
    private Game game;
    //private Board board;  //2-16 jeffry Removed, not needed as we have it in game object
    private GetLocationView getLocationView;
    private Player player;

    public GameMenuControl(Game game) {
        this.game = game;
        //this.board = game.boatBoard;    // 2-16 jeffry Removed as we have it in the game object
        this.getLocationView = new GetLocationView(game);
    }

    
    public void placeShips()
    {
        Player currentPlayer = this.game.currentPlayer; 
        Board board = this.game.currentPlayer.boatBoard;
        
        new BattleshipError().displayLine("Placed a Ship");
        if(currentPlayer.playerType == "AI")  //"AI"  string is for computer players, 
        {
            board.shipPlacementAI();  //Let the AI pick all the locations
        }
        else   //Real players go here.          
        {
            Point location = getLocationView.getInput();
            if(location != null)
                board.shipLocation(currentPlayer, location);
        }
    }
    
    public int fireAShot()
    {
        Player currentPlayer = this.game.currentPlayer;     //2-16 Jeffry Create local object to point to Game object
        Player otherPlayer = this.game.otherPlayer;  //2-25 Katie Created local object for otherPlayer
        Board board = this.game.currentPlayer.shotBoard;    //2-16 Jeffry Create local object to point to Game object
        Board otherBoard = this.game.otherPlayer.shotBoard; //2-25 Katie Created local object for otherPlayer shotBoard
        int flag=0;
        int otherFlag=0;//flag to determine if FireAShot is successful
        
         Point location = getLocationView.getInput();
        
        do
        {  
       
            if (location == null) 
            { // no location was entered?  
                flag= -1;  //we should never get this error
                break;
            }
            
            flag = board.occupyLocation(currentPlayer, location);       //Set the shot in the grid,
            
            String tempPrint =((char) (location.x + 65) + " " + location.y);

            if( flag == 1)  //Location already used
                new BattleshipError().displayLine("You've already used " +  tempPrint + " for a shot");  //2/20 Jeffry - Temp print out of location
            else
                new BattleshipError().displayLine("Fired a Shot at " +  tempPrint);  //2/16 Jeffry - Temp print out of location
            

        }while(flag != 0);
        
        /* Katie 2/26/2015
        Added code to establish enhanced firing system for program.
        */
        otherFlag = board.occupyLocation (otherPlayer, location); //needed to do same for opponent shotboard
            Boat aiBoat = new Boat(4, "ship");
   
            if( otherFlag == 1){
                   int local = otherBoard.checkLocation(otherPlayer, location); //checks location of coordinates
                   aiBoat.hit(); //calls hit method in boat.java
                   aiBoat.hitOrSunk(2, 4); //calls hitOrSunk method in boat.java
            }
            else{
               this.game.switchPlayers(); //calls swtich player method in game.java
  
            }           

        return flag;
        
    }
    
    /*
    Description: Display available grid spaces for shots and calculate
    the total number of shots.
    
    Author(s): John Vehikite
    */
    
    public void availableShots() {
        Player currentPlayer = this.game.currentPlayer;
        Board board = this.game.currentPlayer.shotBoard;
        
        // String objects can be dynamically added to an array list
        ArrayList<String> availableShots = new ArrayList<String>();
        
        String temp; // temporarily hold coordinate
        int totalSpaces = 0; // keep track of number of available coordinates
        String rowValues[] = {"A","B","C","D","E","F","G","H","I","J"};
        
        for(int i = 0; i < board.rows; i++) {
            for (int j = 0; j < board.cols; j++) {
                if(board.grid[i][j] == 0) {
                    // temp will hold the oordinate string - ex: A 3
                    temp = rowValues[i] + ' ' + j; 
                    availableShots.add(temp); // add String to array list
                    totalSpaces++;
                }
            }
        }
        
        //The next block of code prints the array list and prints
        //a new line after every 10 coordinates are printed
        int count = 0; // keep track of how many coordinates there are printed on a line
        for(String temp2 : availableShots) { //for each loop
            System.out.print(temp2);
            System.out.print(", ");
            count++;
            if(count == 10) {
                System.out.println();
                count = 0;
            }
        }
        System.out.println("Total spaces available: " + totalSpaces);
    }
    
     public void displayBoard()
    {
        Board board = this.game.currentPlayer.shotBoard;    //2-16 Jeffry Create local object to point to Game object
 
        new BattleshipError().displayLine("Display the board");
        board.display();
    }
     
    public void startNewGame()
    {
         new BattleshipError().displayLine("Start a new game");
    }
   
    public void displayStatistics()
    {
         new BattleshipError().displayLine("Display Statistics");
         this.game.currentPlayer.getHitMiss();
         this.game.currentPlayer.sortScores();
         this.game.currentPlayer.averageScores();
         this.game.currentPlayer.highScoreNames();
         //player.getGameStats(hit, miss);
         System.out.println("Shots Taken: " + this.game.currentPlayer.shotsTaken());
                 
    }
    
    public void displayPreferencesMenu()
    {
        //nothing here yet
    }

    public void displayHelpMenu() 
    {
        Help helpMenu = new Help();
        helpMenu.getInput();
    }
    
}
