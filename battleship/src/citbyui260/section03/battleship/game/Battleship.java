package citbyui260.section03.battleship.game;

import citbyui260.section03.battleship.frames.MainFrame;
import citbyui260.section03.battleship.msgs.BattleshipError;
import citbyui260.section03.battleship.view.Menu;
import citbyui260.section03.battleship.frames.MainFrame;

//import battleship.Game;





/**
 *
 * @author jeremyrklein
 */


public class Battleship {
    private static MainFrame mainFrame;
    String welcome = 
              "\n\t***********************************************************************"
            + "\n\t* Prepare your fleet. A battle is about to begin!                     *"                            
            + "\n\t* You will be playing against the computer. The object of the game    *"
            + "\n\t* is to find and destroy your opponent's Battleship before yours is   *"
            + "\n\t* destroyed.                                                          *" 
            + "\n\t*                                                                     *"
            + "\n\t* Good Luck!!!!                                                       *"
            + "\n\t***********************************************************************"
            + "\n";

    
    public Battleship() {
        
        //Emty Constructor
    }
    
    
        
    public static void main(String[] args) 
    {   
        try {
        
        Battleship battleship = new Battleship();
        battleship.display();
     
//        Menu mainMenu = new Menu();
//        mainMenu.getInput();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Battleship.mainFrame = new MainFrame();
                
                Battleship.mainFrame.setVisible(true);
            }
        });
            } catch(Throwable ex)
            {
            BattleshipError.displayLine("Unexpected error: " + ex.getMessage());
            BattleshipError.displayLine(ex.getStackTrace().toString());
            }
              finally
        {
        
            if(Battleship.mainFrame != null) {
                Battleship.mainFrame.dispose();
            }
            BattleshipError.displayLine("Dust thou art, unto dust thou shalt become");
        }
    }
    
        private void display() {
        System.out.println(this.welcome);
        
        
    }
    
}   
