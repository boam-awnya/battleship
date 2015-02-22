/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import java.awt.Point;

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
        Board board = this.game.currentPlayer.shotBoard;    //2-16 Jeffry Create local object to point to Game object
        int flag=0;                                         //flag to determine if FireAShot is successful
        
        do
        {  
        
            Point location = getLocationView.getInput();
            if (location == null) 
            { // no location was entered?  
                flag= -1;  //we should never get this error
                break;
            }
            
            flag = board.occupyLocation(currentPlayer, location);       //Set the shot in the grid,
            
            String tempPrint =((char) (location.x + 65) + " " + location.y);

            if( flag == 1)  //Location already useed
                new BattleshipError().displayLine("You've already used " +  tempPrint + " for a shot");  //2/20 Jeffry - Temp print out of location
            else
                new BattleshipError().displayLine("Fired a Shot at " +  tempPrint);  //2/16 Jeffry - Temp print out of location
        
        }while(flag != 0);
        
        return flag;
         
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
         this.game.currentPlayer.sortScores();
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
