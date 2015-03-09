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
    public int occupyLocation(Point location) {
        
        int occupied = 1;       //Not occupied
        //this.grid = player.shotBoard.grid; // 3/5 Katie: input not needed, no longer passing in player info

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
    
    
    //Katie: commented out because we don't need it 2/3/2015
    /*public int shipLocation(Player currentPlayer, Point location)
    {
        
      this.grid[location.x][location.y]= 1;
    
      return 0;
    }
  */
    
    // Function to randomly place ships; placed horizontally towards the right
    // of the starting point for now...
   // public void shipPlacement()   *** 2/20 Jeffry
    public void shipPlacementAI(Boat boat)   //  ** Added Boat object
    {
        int flag;                   //Flag for other boats in same locaiton
        int maxRows = this.rows;    //Used for Random and boundry checking
        int maxCols = this.cols;    //Used for Random and boundry checking  
        int shipRow = 0;            //Used for starting row
        int shipCol = 0;            //Used for starting col
        
        do
        {   
            flag=0;  //Always reset
            shipRow = getRandom(maxRows);       //Get Random Startrow
            shipCol = getRandom(maxCols);       //Get Random StartCol
            boat.direction = getRandom(2)+1;
            
            // assures ship isn't placed off the grid
            if(boat.direction == 1) //Direction is down
                while(shipRow+boat.size  >= maxRows ) //Makes sure starting plus size are ok.
                {
                    new BattleshipError().displayLine("Row too close to the end. Starting point: " + shipRow + ", " + shipCol + " is an invalid starting point.");
                    shipRow = getRandom(maxRows);  //Get new Row
                }
                
            else //boat.diretion is RIGHT
            {
                while(shipCol+boat.size  >= maxCols )   //Make sure starting plus size are ok
                {
                    new BattleshipError().displayLine("Column too close to the end. Starting point: " + shipRow + "," + shipCol + " is an invalid starting point.");
                    shipCol = getRandom(maxCols);  //Get new Col
                } 
            }
            
            // tests if another ship is in the proposed grid space
            flag = checkGridLocation(boat,shipRow,shipCol);
            
            
        }while(flag !=0);  //If flag = 1 then get a new Row and COlumn and try again.
        
        //Fill in the grid with the current boat location
        putShipinGrid(boat,shipRow,shipCol);

        

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
        for(int i = 0; i < boat.size;i++)  //Loop through the boat size
        {

            if(this.grid[rowOffset][colOffset] != 0)  //See if a value is in the grid locaiton other than 0
            {
                flag= 1;  //Set the flag to repeat the loop
                new BattleshipError().displayLine("Grid Check conflict when placing a boat at " + rowOffset + "," + colOffset);
                break;

            }           

            if(boat.direction == 1)  //Increment row or column in the loop
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
        for(int i=0,rowOffset=shipRow,colOffset=shipCol;i<boat.size;i++)
        {
            this.grid[rowOffset][colOffset]= boat.size;
            if(boat.direction == 1)  //CHeck for direction
                    rowOffset++;
                else
                    colOffset++;
        }
   
        new BattleshipError().displayLine(boat.name + " placed. Starting point is: " + shipRow + "," + shipCol + " direction = " + boat.direction);
    
    }


}
