/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import java.util.Scanner;

/**
 *
 * @author Vehikite-John
 */
public class MainMenu  {
        
    private final static String[][] menuItems = {
        {"O", "One Player Game"}, 
        {"T", "Two Player Game"},
        {"H", "Help"},
        {"Q", "Quit Battleship"},
        };
    
    // Create instance of the HelpMenuControl (action) class
    private MainMenuControl mainMenuControl = new MainMenuControl();
    
    // default constructor
    public MainMenu() {
        
    } 
    
    // display the help menu and get the end users input selection
    public void getInput() {       
              
        String command;
        Scanner inFile = new Scanner(System.in);
        
        do {
            
            this.display(); // display the menu
            
            // get commaned entered
            command = inFile.nextLine();
            command = command.trim().toUpperCase();
            
            switch (command) {
                case "O":
                    this.mainMenuControl.onePlayer();
                    break;
                case "T":
                    this.mainMenuControl.twoPlayer();
                    break;
                case "H":
                    this.mainMenuControl.displayHelp();
                    break;                  
                case "Q":
                    System.exit(0);
                default: 
                    new BattleshipError().displayError("Invalid command. Please enter a valid command.");
                    continue;
            }
        } while (!command.equals("O"));  
        
         return;
    }

        // displays the help menu
    public final void display() {
        System.out.println("\n\t===============================================================");
        System.out.println("\tEnter the letter associated with one of the following commands:");

        for (int i = 0; i < MainMenu.menuItems.length; i++) {
            System.out.println("\t   " + menuItems[i][0] + "\t" + menuItems[i][1]);
        }
        System.out.println("\t===============================================================\n");
    }
  
}