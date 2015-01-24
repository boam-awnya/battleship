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
    int[][] grid = new int[rows][cols];
    String boardtype;
    
    
    public Board(Boolean playerBoard)
    {
        if(playerBoard)
            boardtype = "Player";
        else
            boardtype = "Opponent";
                 
    }
    
    public void display()
    {
        System.out.println("This is the " + boardtype + "'s board and it is " + rows + " by " + cols + ".");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
            System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
}
