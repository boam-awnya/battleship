/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author jeffrysimpson, Vehikite-John
 */
public abstract class Board
{
    private static int rows = 10;   // Standard board rows
    private static int cols = 10;   // Stardard boad columns
    private int[][] grid = new int[rows][cols];
    private int hits=0;
    private int misses=0;
    Random random = new Random(); 
   
     //Constructor
    public Board() {
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
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++) 
                grid[i][j] = 0;
    
    }
    
  
   /**************************************************************************
     * 
    Method: checkLocation
    Owner:  Jeffry
    Date:   2/20
    Descpt: Check if a location is occupied return 0 or 1 (No or Yes)
    * @param location
    
    * 
    ***************************************************************************/
    public int checkLocation(Point location) 
    {
        
        int occupied = 0;       //Not occupied
        //this.grid = player.shotBoard.grid; // 3/5 Katie :input not needed, no longer passing in player

        if (this.grid[location.x][location.y] != 0) 
           occupied = this.grid[location.x][location.y];  //Get the ship
        
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
 
    public void display()
    {
        System.out.println("This is the " + this + "'s board and it is " + rows + " by " + cols + ".");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
            //grid[i][j] = 0;                       //2-16 jeffry Commented out the line that was setting everyting to zero
            System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }

    
    
    private int getRandom(int maxVal) {
        return random.nextInt(maxVal);
    }
    


    
 
     
     /**************************************************************************
     * 
    Method: checkGridLocation
    Owner:  Jeffry
    Date:   2/26
    Descpt: Get if a boat will conflict with another ship already on the board.
    
    * 
    ***************************************************************************/
    private int checkGridLocation(Boat boat, int shipRow, int shipCol)
    {
        // tests if another ship is in the proposed grid space
        int flag= 0;
        int rowOffset = shipRow;  //Start at begining
        int colOffset = shipCol;
        for(int i = 0; i < boat.getSize();i++)  //Loop through the boat size
        {

            if(this.grid[rowOffset][colOffset] != 0)  //See if a value is in the grid locaiton other than 0
            {
                flag= 1;  //Set the flag to repeat the loop
                new BattleshipError().displayLine("Grid Check conflict when placing a boat at " + rowOffset + "," + colOffset);
                break;

            }           

            if(boat.getDirection() == 1)  //Increment row or column in the loop
                rowOffset++;
            else
                colOffset++;


        }
        
        return flag;
    }
   
     /**************************************************************************
     * 
    Method: putShipinGrid
    Owner:  Jeffry
    Date:   2/20
    Descpt: Fill the grid locations with a ship
    
    * 
    ***************************************************************************/
    private void putShipinGrid(Boat boat,int shipRow, int shipCol)
    {
         //Fill in the grid with the current boat location
        for(int i=0,rowOffset=shipRow,colOffset=shipCol;i < boat.getSize() ;i++)
        {
            this.grid[rowOffset][colOffset]= boat.getSize();
            if(boat.getDirection() == 1)  //CHeck for direction
                    rowOffset++;
                else
                    colOffset++;
        }
   
        new BattleshipError().displayLine(boat.getName() + " placed. Starting point is: " + shipRow + "," + shipCol + " direction = " + boat.getDirection() );
    
    }

  /**************************************************************************
     * 
    Method: getShip()
    Owner:  Jeffry
    Date:   2/20
    Descpt: Fill the grid locations with a ship
    
    * 
    ***************************************************************************/    
    public Boat getShip(Player player,int shipType)
    {
        return player.submarine;
    }
    

}
