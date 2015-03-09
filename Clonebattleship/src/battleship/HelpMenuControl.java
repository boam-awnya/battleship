/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

/**
 *
 * @author katiewalker
 */
public class HelpMenuControl  {
    
    public HelpMenuControl() {
        
    } 

    public void displayBoardHelp() {
        System.out.println();
        this.displayHelpBorder();             
        System.out.println( 
                "\tThe game board for Battleship. It consist of a grid of "
                + "\n\tlocations. Players place their ships on various locations "
                + "\n\ton the board. The default board is 10 rows by 10 columns.");
        displayHelpBorder();
    }
    
    
        
    public void displayGameHelp() {
        System.out.println();
        displayHelpBorder();     
        System.out.println( 
                 "\tThe objective of the game is to be the first player sink "
                + "\n\tthe other player's Battleship.");
        displayHelpBorder();
    }
            
    public void displayRealPlayerHelp() {
        System.out.println();
        displayHelpBorder();     
        System.out.println( 
                "\tA real player manually takes their turn by choosing a "
              + "\n\tlocation within the grid to attempt to hit and sink the other "
              + "\n\tplayer's Battleship."); 
        displayHelpBorder();
    }
    
    public void displayWinHelp() {
        System.out.println();
        displayHelpBorder();     
        System.out.println( 
                "\tA player wins by sinking the opponent's Battleship. The Battleship"
              + "\n\thas 4 hits before it is sunk...thus it is sink or be sunk."); 
        displayHelpBorder();
    }
                 
    public void displayComputerPlayerHelp() {
        System.out.println();
        displayHelpBorder();     
        System.out.println( 
                "\tA computer based player automatically takes its turn "
                + "\n\timmediatly after a real player in a single player game."
                ); 
        displayHelpBorder();
    }
             
    public void displayLocationHelp() {
        System.out.println();
        displayHelpBorder();     
        System.out.println( 
               "\tPlayer will choose a row and column (ex. A1, D5)"
             + "\n\tas well as the orientation of the ship down or right."); 
        displayHelpBorder();
    }
                 
    public void displayHitHelp() {
        System.out.println();
        displayHelpBorder();     
        System.out.println( 
               "\tA symbol that \"marks\" the locations in the board that have "
                + "\n\tbeen hit or missed by a player. "
                + "\n\tThe default markers are \"X\" for hit, \"M\" for miss, and \"O\" untried areas."
                ); 
        displayHelpBorder();
    }
    
    
    public void displayHelpBorder() {       
        System.out.println(
        "\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
    
  
}
