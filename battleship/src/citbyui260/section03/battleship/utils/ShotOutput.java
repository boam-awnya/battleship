/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui260.section03.battleship.utils;

import citbyui260.section03.battleship.interfaces.*;
import citbyui260.section03.battleship.enums.ShipCodes;


/**
 *
 * @author Jeffry Simpson - BYUI CIT260 Section 03
 */
public class ShotOutput extends BattleshipError
{
    private Class<? extends Object> ShipCodes;
    public ShotOutput()
    {
        
    }
  
       public void displayError(ShipCodes shipErr) {

           
            switch(shipErr)
            {
                case OK:
                    System.out.print("I got here display error");
                    break;
                case INVALIDSIZE:
                    System.out.println(shipErr.name());
                    break;
                default:
                    System.out.println(shipErr.name() + " " + shipErr.ordinal());
                  
               
            }    
        }
  
}
