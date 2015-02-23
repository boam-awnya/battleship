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
            
        board.occupyLocation(currentPlayer, location.x, location.y);  //2-16 Jeffry Put the input location into the board
        new BattleshipError().displayLine("Fired a Shot at " +  (char) (location.x + 65) + " " + location.y);  //2/16 Jeffry - Temp print out of location
        return 0;
         
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
