/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui260.section03.battleship.control;

import citbyui260.section03.battleship.game.Game;
import citbyui260.section03.battleship.msgs.BattleshipError;
import citbyui260.section03.battleship.view.GameMenu;
import citbyui260.section03.battleship.view.Help;
import citbyui260.section03.battleship.frames.HelpFrame;
/**
 *
 * @author Jeffry Simpson - BYUI CIT260 Section 03
 */
public class MenuControl
{
    private GameMenu gameMenu;
   // private static HelpFrame helpFrame;
 
    
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
    
    
    public void displayHelpMenu() 
    {
        final Help help = null;
        
        try {
                        
            /*Create and display help GUI */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    help.helpFrame = new HelpFrame();
                    help.helpFrame.setVisible(true);
                }
            });
        }
        
        catch (Throwable ex) {
            BattleshipError.displayError("Unexpected error: " + ex.getMessage());
            BattleshipError.displayError(ex.getStackTrace().toString());
        }
        
        finally {
            if (help.helpFrame != null) {
                help.helpFrame.dispose();
            }
        }
        //helpMenu.getInput();
    }
    
    
    
}
