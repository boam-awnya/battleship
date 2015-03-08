/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import java.util.Scanner;

/**
 *
 * @author Jeffry Simpson - BYUI CIT260 Section 03
 */
public class GameMenu
{
    private Game game;
    private GameMenuControl gameMenuControl ; 

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public GameMenuControl getGameMenuControl() {
        return gameMenuControl;
    }

    public void setGameMenuControl(GameMenuControl gameMenuControl) {
        this.gameMenuControl = gameMenuControl;
    }


    private final static String[][] menuItems = {
        {"P", "Place your ships"},
        {"F", "Fire a shot"},
        {"A", "Show available shot coordinates"},
        {"D", "Display the board"},
        {"S", "Start a new game"},
        {"R", "Report stastics"},
        {"C", "Change game preferences"},
        {"H", "Help"},
        {"Q", "QUIT"}
    };
    
    
    public GameMenu(Game game) 
    {
        this.game = game;  //2-16 Jeffry Added
        this.gameMenuControl = new GameMenuControl(game);
        
    }
    
    public void getInput() 
    {
   
        String command;
        Scanner inFile = new Scanner(System.in);

        do {    
            this.display(); // display the menu

            // get commaned entered
            command = inFile.nextLine();
            command = command.trim().toUpperCase();
            
            switch (command) {
                case "P":
                    this.gameMenuControl.placeShips();
                    break;
                case "F":
                    this.gameMenuControl.fireAShot();  
                    break;
                case "A":
                    this.gameMenuControl.availableShots();
                    break;
                case "D":
                    gameMenuControl.displayBoard();
                    break;
                case "S":
                    gameMenuControl.startNewGame();
                    break;
                case "R":
                    gameMenuControl.displayStatistics();
                    break;
                case "C":
                    gameMenuControl.displayPreferencesMenu();
                    break;
                case "H":
                    gameMenuControl.displayHelpMenu();
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
