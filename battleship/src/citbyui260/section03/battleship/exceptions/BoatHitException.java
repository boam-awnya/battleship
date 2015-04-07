/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui260.section03.battleship.exceptions;

/**
 *
 * @author Legion (because we are many)
 */
public class BoatHitException extends Exception{
    
    public BoatHitException (String msg){
        super(msg);
    }
    
    public BoatHitException (String msg, Throwable cause){
        super(msg, cause);
    }
    
    public BoatHitException (Throwable cause){
        super(cause);
    }
}
