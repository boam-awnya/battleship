/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

/**
 *
 * @author Vehikite-John
 */
public class MainMenuControl  {
    
    public MainMenuControl() {
        
    } 
    
    private Help helpMenu = new Help();

    public void onePlayer() {
        System.out.println();
        this.displayHelpBorder();             
        System.out.println( 
                "\tYou selected a One Player Game. Good luck!");
        displayHelpBorder();
        return;
    }
    
    
        
    public void twoPlayer() {
        System.out.println();
        displayHelpBorder();     
        System.out.println( 
                 "\tTwo player is not available at this time. Please make another selection.");
        displayHelpBorder();
    }
            
    public void displayHelp() {
        helpMenu.getInput();
    }
    
        
    public void displayHelpBorder() {       
        System.out.println(
        "\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
    
  
}
