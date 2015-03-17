/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import java.awt.Point;

/**
 *
 * @author jeffrysimpson, Vehikite-John
 */
public class Board
{
    private static final int ROWS = 10;   // Standard board rows
    private static final int COLS = 10;   // Stardard boad columns
    private int[][] grid = new int[ROWS][COLS];
 
    
    //String boardtype;                   //Jeffry 2/20 Don't believe we need this now
    //public Player[][] boardLocations;   //Jeffry 2/14  Don't belive we need this.
   
     //Constructor
    public Board() 
    {
    
    }
    
      //Constructor
    public Board(int[][] myGrid) 
    {
        myGrid = grid;
    }
  
    public int getRows() {
        return ROWS;
    }


    public int getCols() {
        return COLS;
    }


   
    
    
    
    /**************************************************************************
     * 
    Method: ClearTheBoard
    Owner:  Jeffry Simpson
    Date:   2/16/2015
    Descpt: Method to clear the board
    * 
    ***************************************************************************/  
    public void clearTheBoard() 
    {
        for (int i = 0; i < ROWS; i++)
            for (int j = 0; j < COLS; j++) 
                grid[i][j] = 0;
    
    }
    
  
   /**************************************************************************
     * 
    Method: checkLocation (overloaded)
    Owner:  Jeffry
    Date:   2/20
    Descpt: Check if a location is occupied return 0 or 1 (No or Yes)
    * @param location
    
    * 
    ***************************************************************************/
    public int checkLocation(Point location) 
    {
        
        int occupied= checkLocation(location.x,location.y); 
         
        return occupied;   //0 = not occupied 1= occupied
    }
    
     public int checkLocation(int x, int y) 
    {
        
        int occupied = 0;       //Not occupied
        //this.grid = player.shotBoard.grid; // 3/5 Katie :input not needed, no longer passing in player

        if (this.grid[x][y] != 0) 
           occupied = this.grid[x][y];  //Get the ship
        
        return occupied;   //0 = not occupied 1= occupied
    }
    
    
    /**************************************************************************
     * 
    Method: occupyLocation
    Owner:  
    Date:   
    Descpt: Determine if a location is occupied
    Notes:  2/20-Jeffry  Changed method to return INT not void
    
    @param location
    * 
    ***************************************************************************/
    public int occupyLocation(Point location,int cellValue) 
    {
        
        int occupied = occupyLocation(location.x,location.y,cellValue);
    
        return occupied;    //return  1  = already occupied, 0 = added
        
    }
    
    public int occupyLocation(int x, int y,int cellValue) 
    {
        
        int occupied = 1;       //Not occupied
        //this.grid = player.shotBoard.grid; // 3/5 Katie: input not needed, no longer passing in player info

        if (this.grid[x][y] == 0)   //Check if the location is emppty
        { 
            this.grid[x][y] = cellValue;
            occupied = 0;
        }
        
        return occupied;    //return  1  = already occupied, 0 = added
    }



    
    public void display()
    {
        System.out.println("This is the " + this.getClass() + "'s board and it is " + ROWS + " by " + COLS + ".");
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
            //grid[i][j] = 0;                       //2-16 jeffry Commented out the line that was setting everyting to zero
            System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }


 
   
}
