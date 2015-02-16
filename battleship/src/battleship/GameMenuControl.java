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
    private Board board;
    private GetLocationView getLocationView;
    private Player player;

    public GameMenuControl(Game game) {
        this.game = game;
        this.board = game.boatBoard;
        this.getLocationView = new GetLocationView(game);
    }

    
    public void placeShips()
    {
         new BattleshipError().displayLine("Placed a Ship");
        //this.board.shipPlacement();
    }
    
    public int fireAShot()
    {
        
        Point location = getLocationView.getInput();
        if (location == null) { // no location was entered?
            return -1;
        }
            
        this.game.shotBoard.occupyLocation(player, location.x, location.y);
        new BattleshipError().displayLine("Fired a Shot");
        return 0;
         
    }
    
     public void displayBoard()
    {
        new BattleshipError().displayLine("Display the board");
        //this.board.display();
    }
     
    public void startNewGame()
    {
         new BattleshipError().displayLine("Start a new game");
    }
   
    public void displayStatistics()
    {
         new BattleshipError().displayLine("Display Statistics");
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
