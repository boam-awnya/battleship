/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

/**
 *
 * @author jeffrysimpson
 */
public class Board
{
    int rows = 5;
    int cols = 5;
    String boardtype;
    
    
    public Board(Boolean playerBoard)
    {
        if(playerBoard)
            boardtype = "Ship";
        else
            boardtype = "Player";
                 
    }
    
    public void display()
    {
        System.out.println("This is the " + boardtype + "'s board and it will be " + rows + " by " + cols);
    }
}
