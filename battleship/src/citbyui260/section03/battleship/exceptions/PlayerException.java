/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui260.section03.battleship.exceptions;

/**
 *
 * @author ShatziWebster
 */
public class PlayerException extends Exception {
    
    public PlayerException (String msg){
        super(msg);
    }
    
    public PlayerException (String msg, Throwable cause){
        super(msg, cause);
    }
    
    public PlayerException (Throwable cause){
        super(cause);
    }
    
}
