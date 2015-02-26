/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import java.awt.Point;
import java.util.Random;

/**
 *
 * @author jeffrysimpson, Vehikite-John
 */
public class Board
{
    int rows = 10;   // Standard board rows
    int cols = 10;   // Stardard boad columns
    int[][] grid = new int[rows][cols];
    int hits;
    int misses;
    Random random = new Random(); 
    
    //String boardtype;                   //Jeffry 2/20 Don't believe we need this now
    //public Player[][] boardLocations;   //Jeffry 2/14  Don't belive we need this.
   
     //Constructor
    public Board() {
    }
    
      //Constructor
    public Board(Boolean playerBoard)
    {
        /*if(playerBoard)
            boardtype = "Player";
        else
            boardtype = "Oponent";
          */       
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
    
    * 
    ***************************************************************************/
        public int checkLocation(Player player, Point location) 
        {
        
        int occupied = 0;       //Not occupied
        this.grid = player.shotBoard.grid;

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
    * 
    ***************************************************************************/
    public int occupyLocation(Player player, Point location) {
        
        int occupied = 1;       //Not occupied
        this.grid = player.shotBoard.grid;

        if (this.grid[location.x][location.y] == 0)   //Check if the location is emppty
        { 
            this.grid[location.x][location.y] = 1;
            occupied = 0;
        }
        
        return occupied;    //return  1  = already occupied, 0 = added
    }



    
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

    
    
    public int getRandom(int maxVal) {
        return random.nextInt(maxVal);
    }
    
    public int shipLocation(Player currentPlayer, Point location)
    {
        
      this.grid[location.x][location.y]= 1;
    
      return 0;
    }
  
    
    // Function to randomly place ships; placed horizontally towards the right
    // of the starting point for now...
   // public void shipPlacement()   *** 2/20 Jeffry
    public void shipPlacementAI(Boat boat)   //  ** Added Boat object
    {
        int flag=0;     //CHeck for other boats in same place
        int maxRows = this.rows;
        int maxCols = this.cols;      
        int shipRow = 0;
        int shipCol = 0;
        
        do
        {   
            shipRow = getRandom(maxRows);
            shipCol = getRandom(maxCols);
            boat.direction = getRandom(2)+1;
            
            // assures ship isn't placed off the grid
            if(boat.direction == 1) //Direction is down
                while(shipRow+boat.size  >= maxRows ) 
                {
                    System.out.println(shipRow + ", " + shipCol + " is an invalid starting point. Please try again.");
                    shipRow = getRandom(maxRows);
                }
                
            else //boat.diretion is RIGHT
            {
                while(shipCol+boat.size  >= maxCols ) 
                {
                    System.out.println(shipRow + ", " + shipCol + " is an invalid starting point. Please try again.");
                    shipCol = getRandom(maxCols);
                } 
            }

            // tests if another ship is in the proposed grid space
            // TODO: Code to check each space the ship occupies
            int rowOffset = shipRow;
            int colOffset = shipCol;
            for(int i = 0; i < boat.maxDamage;i++)
            {

                if(this.grid[rowOffset][colOffset] != 0)
                {
                    flag= 1;
                    System.out.println("Conflict at " + rowOffset + colOffset);
                    break;

                }           

                if(boat.direction == 1)  //CHeck 
                    rowOffset++;
                else
                    colOffset++;


            }
        }while(flag !=0);
        
        //Fill in the grid with the current boat
        for(int i=0,rowOffset=shipRow,colOffset=shipCol;i<boat.size;i++)
        {
            this.grid[rowOffset][colOffset]= boat.size;
            if(boat.direction == 1)  //CHeck 
                    rowOffset++;
                else
                    colOffset++;
        }

        System.out.println("AI " + boat.getShipType()+ " \"starting point\" is: " + shipRow + ", " + shipCol + " direction = " + boat.direction);


        }
        
    


public class Lxocation {

        public int row;
        public int column;
        public Player player;

        Lxocation() {
        }
        
    }

}
