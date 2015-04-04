/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui260.section03.battleship.view;

import citbyui260.section03.battleship.frames.HelpForm;
import citbyui260.section03.battleship.view.Menu;

import citbyui260.section03.battleship.msgs.BattleshipError;
import citbyui260.section03.battleship.control.HelpMenuControl;
import java.util.Scanner;


/**
 *
 * @author Shatzi-Webster
 */
public class Help {
    private static HelpForm helpForm;
     
    public Help() {
        
        //Emty Constructor
    }
    
    
        
    public static void help(String[] args) 
    {   
        try {
        
       Help help = new Help();
        help.display();
     

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Help.helpForm = new HelpForm();
                
                Help.helpForm.setVisible(true);
            }
        });
            } catch(Throwable ex)
            {
            BattleshipError.displayLine("Unexpected error: " + ex.getMessage());
            BattleshipError.displayLine(ex.getStackTrace().toString());
            }
              finally
        {
        
            if(Help.helpForm != null) {
                Help.helpForm.dispose();
            }
            BattleshipError.displayLine("Error!  Error!!! ");
        }
    }
          
        public void display() {
        System.out.println(helpForm);
    
    }
        
}