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
public class BoatException extends Exception{
    
    public BoatException (String msg){
        super(msg);
    }
    
    public BoatException (String msg, Throwable cause){
        super(msg, cause);
    }
    
    public BoatException (Throwable cause){
        super(cause);
    }
}
