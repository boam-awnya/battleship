/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui260.section03.battleship.view;
import citbyui260.section03.battleship.msgs.BattleshipError;
import citbyui260.section03.battleship.game.Game;
import citbyui260.section03.battleship.control.PlaceShipMenuControl;
import java.util.Scanner;
/**
 *
 * @author John
 */
public class PlaceShipMenu extends MenuSuper {
    private Game game;
    private PlaceShipMenuControl menu;
    
    private final static String[][] menuItems = {
        {"S", "Place your Submarine"},
        {"B", "Place your Battleship"},
        {"C", "Place your Carrier"},
        {"V", "View your Board"},
        {"R", "Reset all"},
        {"H", "Help"},
        {"Q", "Quit"} 
    };
    
    public PlaceShipMenu(Game game) {
        super(PlaceShipMenu.menuItems);
        this.game = game;
        this.menu = new PlaceShipMenuControl(game);
    }
    
    public void getInput() {
        String command;
        Scanner inFile = new Scanner(System.in);
        
        do {
            this.display();
            command = inFile.nextLine();
            command = command.trim().toUpperCase();
            
            switch(command) {
                case "S":
                    menu.placeSub();
                    break;
                case "B":
                    menu.placeBattleship();
                    break;
                case "C":
                    menu.placeCarrier();
                    break;
                case "R":
                    menu.resetBoard();
                    break;
                case "V":
                    menu.displayBoard();
                    break;
                case "H":
                    menu.displayHelpForm();
                    break;
                case "Q":
                    break;
                default: 
                    BattleshipError.displayError("Invalid command. Please enter a valid command.");
                    continue;
                    
            }
        } while (!command.equals("Q"));
        
        return;
    }
    
}
