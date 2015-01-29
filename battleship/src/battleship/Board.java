/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import java.awt.Point;

/**
 *
 * @author jeffrysimpson
 */
public class Board
{
    int rows = 10;
    int cols = 10;
    int[][] grid = new int[rows][cols];
    String boardtype;
    
    public Board() {
    }
    
      
    public void clearTheBoard() {
        // TODO
    }
    
    
    public Board(Boolean playerBoard)
    {
        if(playerBoard)
            boardtype = "My Board";
        else
            boardtype = "Oponent's board";
                 
    }

    public void occupyLocation(Player player, int row, int column) {
        Player playerAtLocation = this.boardLocations[row][column];

        if (playerAtLocation != null) { // location already occupied
            new BattleshipError().displayError("This location is already occupied. "
                    + "Try a different location.");
        }
        this.boardLocations[row][column] = player;
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

    public class Location {

        public int row;
        public int column;
        public Player player;

        Location() {
        }
        
    }

}