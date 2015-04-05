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
public class BattleshipSunkException extends BoatException
{
        public BattleshipSunkException (String msg){
        super(msg);
    }
    
    public BattleshipSunkException (String msg, Throwable cause){
        super(msg, cause);
    }
    
    public BattleshipSunkException (Throwable cause){
        super(cause);
    }
}
