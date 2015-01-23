package battleship;


import battleship.Game;





/**
 *
 * @author jeremyrklein
 */


public class Battleship {
    
    String help = 
              "\n\t***********************************************************************"
            + "\n\t* Prepare to meet your worst nightmare!                               *"                            
            + "\n\t* You will be playing against a partner. The object of the game       *"
            + "\n\t* is to mark three adjacent squares either horizontally, vertically   *"
            + "\n\t* with your marker before your opponent does.                         *" 
            + "\n\t*                                                                     *"
            + "\n\t* Good Luck!!!                                                        *"
            + "\n\t***********************************************************************"
            + "\n";

    
    public Battleship() {
        
    }
    
    
        
    public static void main(String[] args) {
        Battleship battleship = new Battleship();
        battleship.display();
        
        Board boardA = new Board(true);
        boardA.display();
        
        Board boardB = new Board(false);
        boardB.display();
        
        Game game = new Game();
        game.displayPlayers();
        
        
    }
    
    private void display() {
        System.out.println(this.help);
    }
    

}