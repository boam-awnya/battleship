/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

/**
 *
 * @author Shatzi-Webster
 */
public class Shot {
    
    int hit;
    
    
        public Shot ()
    {
       if (hit == 1){
           System.out.println("You have hit my Battleship!");
       }                 
       else if (hit == 2) {
           System.out.println("You have hit my Aircraft Carrier!");
    }
       else if (hit == 3) {
           System.out.println("You have hit my Submarine!");
       }
       else {
           System.out.println("You have missed!");
       }
    
    }
    
}
