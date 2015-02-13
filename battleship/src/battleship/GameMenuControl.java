/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

/**
 *
 * @author Jeffry Simpson - BYUI CIT260 Section 03
 */
public class GameMenuControl
{
    private Game game;
    private Board board;

    public GameMenuControl(Game game) {
        this.game = game;
        this.board = game.boatBoard;
    }

    
    public void placeShips()
    {
         new BattleshipError().displayLine("Placed a Ship");
        //this.board.shipPlacement();
    }
    
    public void fireAShot()
    {
        new BattleshipError().displayLine("Fired a Shot");
        
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
