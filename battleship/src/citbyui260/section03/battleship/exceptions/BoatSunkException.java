/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui260.section03.battleship.exceptions;

/**
 *
 * @author Jeffry Simpson - BYUI CIT260 Section 03
 */
public class BoatSunkException extends BoatException
{
        public BoatSunkException (String msg){
        super(msg);
    }
    
    public BoatSunkException (String msg, Throwable cause){
        super(msg, cause);
    }
    
    public BoatSunkException (Throwable cause){
        super(cause);
    }
}
