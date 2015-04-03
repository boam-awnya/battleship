/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui260.section03.battleship.view;

import citbyui260.section03.battleship.msgs.BattleshipError;
import citbyui260.section03.battleship.control.HelpMenuControl;
import citbyui260.section03.battleship.frames.HelpFrame;
import java.util.Scanner;


/**
 *
 * @author Shatzi-Webster
 */
public class Help extends MenuSuper {
    public static HelpFrame helpFrame;
          
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
                    BattleshipError.displayError("Invalid command. Please enter a valid command.");
                    continue;
            }
        } while (!command.equals("Q"));  
        
         return;
    }
   
        
    
}