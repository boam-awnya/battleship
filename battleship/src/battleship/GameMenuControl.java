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
         new BattleshipError().displayLine("Placed a Ship");
        //this.board.shipPlacement();
    }
    
    public int fireAShot()
    {
        Player currentPlayer = this.game.currentPlayer;     //2-16 Jeffry Create local object to point to Game object
        Board board = this.game.currentPlayer.shotBoard;    //2-16 Jeffry Create local object to point to Game object
        
        
        Point location = getLocationView.getInput();
        if (location == null) { // no location was entered?
            return -1;
        }
            
        board.occupyLocation(currentPlayer, location.x, location.y);  //2-16 Jeffry Put the input locaiton into the board
        new BattleshipError().displayLine("Fired a Shot at " +  (char) (location.x + 65) + " " + location.y);  //2/16 Jeffry - Temp print out of location
        return 0;
         
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
         this.game.currentPlayer.averageScores();
         this.game.currentPlayer.highScoreNames();
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
