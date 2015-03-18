/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui260.section03.battleship.view;

import battleship.BattleshipError;
import battleship.HelpMenuControl;
import battleship.MenuSuper;
import java.util.Scanner;


/**
 *
 * @author Shatzi-Webster
 */
public class Help extends MenuSuper {
          
    private final static String[][] menuItems = {
        {"B", "The board"},
        {"C", "A computer player"}, 
        {"G", "The Battleship game"},
        {"H", "A hit"},
        {"R", "A regular player"},
        {"S", "A ship placement"},
        {"W", "How to win"},
        {"Q", "Quit Help"}        
    };
    
    
    
    public Help() {
        super(Help.menuItems);
    }
    
    // Create instance of the HelpMenuControl (action) class
    private HelpMenuControl helpMenuControl = new HelpMenuControl();
    
    public HelpMenuControl getHelpMenuControl() {
        return helpMenuControl;
    }

    public void setHelpMenuControl(HelpMenuControl helpMenuControl) {
        this.helpMenuControl = helpMenuControl;
    }
     
    // display the help menu and get the end users input selection
    
    @Override
    public void getInput() {       
              
        String command;
        Scanner inFile = new Scanner(System.in);
        
        do {
            
            this.display(); // display the menu
            
            // get commaned entered
            command = inFile.nextLine();
            command = command.trim().toUpperCase();
            
            switch (command) {
                case "B":
                    this.helpMenuControl.displayBoardHelp();
                    break;
                case "C":
                    this.helpMenuControl.displayComputerPlayerHelp();
                    break;
                case "G":
                    this.helpMenuControl.displayGameHelp();
                    break;                  
                case "S":
                    this.helpMenuControl.displayLocationHelp();
                    break;
                case "H":
                    this.helpMenuControl.displayHitHelp();
                    break;
                 case "R":
                    this.helpMenuControl.displayRealPlayerHelp();
                    break; 
                case "W":
                    this.helpMenuControl.displayWinHelp();
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

        // displays the help menu
    
    /*  commented out 3/10 
    public final void display() {
        System.out.println("\n\t===============================================================");
        System.out.println("\tEnter the letter associated with one of the following commands:");

        for (int i = 0; i < menuItems.length; i++) {
            System.out.println("\t   " + menuItems[i][0] + "\t" + menuItems[i][1]);
        }
        System.out.println("\t===============================================================\n");
    }
    */
    
    
        
    
}