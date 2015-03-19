package battleship;

import citbyui260.section03.battleship.view.Menu;


//import battleship.Game;





/**
 *
 * @author jeremyrklein
 */


public class Battleship {
    
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
        
        Battleship battleship = new Battleship();
        battleship.display();
     
        Menu mainMenu = new Menu();
        mainMenu.getInput();
       
    }
    
        private void display() {
        System.out.println(this.welcome);
    }
    
}   
