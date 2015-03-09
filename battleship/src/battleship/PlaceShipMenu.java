/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;
import java.util.Scanner;
/**
 *
 * @author John
 */
public class PlaceShipMenu {
    private Game game;
    private PlaceShipMenuControl menu;
    
    private final String[][] menuItems = {
        {"S", "Place your Submarine"},
        {"B", "Place your Battleship"},
        {"C", "Place your Carrier"},
        {"R", "Reset all"},
        {"H", "Help"},
        {"Q", "Quit"} 
    };
    
    public PlaceShipMenu(Game game) {
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
                case "H":
                    menu.displayHelp();
                    break;
                case "Q":
                    break;
                default: 
                    new BattleshipError().displayError("Invalid command. Please enter a valid command.");
                    continue;
                    
            }
        } while (!command.equals("Q"));
        
        return;
    }
    
    public final void display() 
    {
        System.out.println("\n\t===============================================================");
        System.out.println("\tEnter the letter associated with one of the following commands:");

        for (int i = 0; i < this.menuItems.length; i++) {
            System.out.println("\t   " + menuItems[i][0] + "\t" + menuItems[i][1]);
        }
        System.out.println("\t===============================================================\n");
    }
    
}
