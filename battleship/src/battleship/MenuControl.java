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
public class MenuControl
{
    private GameMenu gameMenu;
 
    
    public MenuControl()
    {
        
    }
    
    public void startGame(int x)
    {
        Game game = new Game();
        gameMenu = new GameMenu(game);
        gameMenu.getInput();
        
        //add stuff here
    }
    
    
    public void displayHelpMenu() 
    {
        Help helpMenu = new Help();
        helpMenu.getInput();
    }
    
    
    
}
