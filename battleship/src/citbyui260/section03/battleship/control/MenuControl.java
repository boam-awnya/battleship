/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui260.section03.battleship.control;

import citbyui260.section03.battleship.game.Game;
import citbyui260.section03.battleship.view.GameMenu;
import citbyui260.section03.battleship.view.Help;
import citbyui260.section03.battleship.frames.*;

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
    
    public void startGame(int numPlayers)   //2-16 Jeffry Changed x to numPlayers
    {
        Game game = new Game();
        game.start(numPlayers);       //2-16 Jeffry Call to setup Game and Players
        //game.playerB.setMarker("MyCheck");  //2-20 Jeff temp debug marker
        gameMenu = new GameMenu(game);
        gameMenu.getInput();
        
        //add stuff here
    }   
    
    
    public void displayHelpForm() 
    {
        Help helpForm = new Help();
        helpForm.display();
    }
    
    
    
}
