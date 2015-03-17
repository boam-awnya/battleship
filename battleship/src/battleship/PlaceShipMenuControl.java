/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import java.awt.Point;

/**
 *
 * @author John
 */
public class PlaceShipMenuControl {
    private Game game;
    private GetLocationView getLocationView;
    private Player player;
    private Board board;
    
    public PlaceShipMenuControl(Game game) {
        this.game = game;
        this.getLocationView = new GetLocationView(game);
    }
    
    public void placeSub() {
        new BattleshipError().displayLine("Placed submarine.");
    }
    
    public void placeBattleship() {
        new BattleshipError().displayLine("Placed battleship.");
    }
    
    public void placeCarrier() {
        new BattleshipError().displayLine("Placed carrier.");
    }
    
    public void resetBoard() {
        
        board = this.game.currentPlayer.boatBoard;
        board.clearTheBoard();
        new BattleshipError().displayLine("Your board has been reset.");
    }
    
    public void displayBoard() {
        
        board = this.game.currentPlayer.boatBoard;
        board.display();
        
    }
    
    public void displayHelp() {
        Help helpMenu = new Help();
        helpMenu.getInput();
    }
}
