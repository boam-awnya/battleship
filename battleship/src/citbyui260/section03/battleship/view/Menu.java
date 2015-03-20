/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui260.section03.battleship.view;

import citbyui260.section03.battleship.errormsgs.BattleshipError;
import citbyui260.section03.battleship.control.MenuControl;
import citbyui260.section03.battleship.view.MenuSuper;
import java.util.Scanner;
/**
 *
 * @author Jeffry Simpson
 */
public class Menu extends MenuSuper {
   
    //Main Menu items 
    private static final String[][] menuItems = {
        {"1", "One player game"},
        {"H", "Help"},
        {"Q", "Quit Battleship"}
    }; 
    
    //New Menu Controls class
    MenuControl mainMenuControl = new MenuControl();
   
    
    public Menu()
    {
    super(Menu.menuItems);
    }
  
    public void getInput() {       

        String command;
        Scanner inFile = new Scanner(System.in);
        
        do {
            this.display(); // display the menu

            // get commaned entered, remove whitspace, and convert to upper case
            command = inFile.nextLine();
            command = command.trim().toUpperCase();
            
            switch (command) {
                case "1":
                    this.mainMenuControl.startGame(1);
                    break;
                case "2":
                    this.mainMenuControl.startGame(2);
                    break;
                case "H":
                    this.mainMenuControl.displayHelpMenu();            
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
    

    
    
//   public final void display() {
//        System.out.println("\n\t===============================================================");
//        System.out.println("\nPick a Number/Letter associated with one of the following commands:");
//
//        for (int i = 0; i < this.menuItems.length; i++) {
//            System.out.println("\t   " + menuItems[i][0] + "\t" + menuItems[i][1]);
//         
//        }
//        System.out.println("\n\t===============================================================\n");
//    }   
    
}
