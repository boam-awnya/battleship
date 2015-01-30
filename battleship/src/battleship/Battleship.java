package battleship;


//import battleship.Game;





/**
 *
 * @author jeremyrklein
 */


public class Battleship {
    
    String help = 
              "\n\t***********************************************************************"
            + "\n\t* Prepare to meet your worst nightmare!                               *"                            
            + "\n\t* You will be playing against a partner. The object of the game       *"
            + "\n\t* is to find and destroy your opponent's Battleship before yours is   *"
            + "\n\t* destroyed.                                                          *" 
            + "\n\t*                                                                     *"
            + "\n\t* Good Luck!!!                                                        *"
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
        mainMenu.enterName();
        
        Board boardA = new Board(true);
        boardA.display();
        
        Board boardB = new Board(false);
        boardB.display();
        
        Game game = new Game();
        game.displayPlayers();
        
        Boat myBattleship = new Boat(4, "Battleship");
       
        //Lession 3 Group assigment 
        Player player1 = new Player();
        
        player1.getGameStats(10, 10);   //Testcase 1 - Happy Path
        player1.getGameStats(0, 0);     //Testcase 2 - Divid by zero
        player1.getGameStats(-1, -4);   //Testcase 3 - invalid values
        player1.getGameStats(0, 10);    //Testcase 4 - All Miss no Hits
        player1.getGameStats(10, 0);    //Testcase 5 - All Hits no Miss
        
    }
  
    private void display() {
        System.out.println(this.help);
    }
    

}