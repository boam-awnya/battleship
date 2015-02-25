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
    
/*  2/20 - Jeffry   Not being used. 
    
    public void boardDisplay() {
        System.out.println("This is the " + this + "'s board after ship placement.");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
            System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
  */
    
    
    public int getRandom() {
        return random.nextInt(9);
    }
    
    public int shipLocation(Player currentPlayer, Point location)
    {
        
      this.grid[location.x][location.y]= 1;
    
      return 0;
    }
  
    
    // Function to randomly place ships; placed horizontally towards the right
    // of the starting point for now...
   // public void shipPlacement()   *** 2/20 Jeffry
    public void shipPlacementAI()
    {
        double row = 0;
        double col = 0;
        
        Boat submarine = new Boat(3,"Submarine");
        Boat battleship = new Boat(4,"Battleship");
        Boat carrier = new Boat(5,"Carrier");
        
        for(int shipType = 1; shipType < 4; shipType++) {        
            //Typecasting practice
            int shipRow = (int) row;
            int shipCol = (int) col;
            shipRow = getRandom();
            shipCol = getRandom();
            
            // Is shipRow or shipCol < 0?
            while(shipRow < 0 || shipCol < 0) {
                System.out.println(shipRow + ", " + shipCol + " is an invalid starting point. Please try again.");
                if(shipRow < 0) {
                    shipRow = getRandom();
                }
                
                if(shipCol < 0) {
                    shipCol = getRandom();
                }
            }
            
            // Is shipRow or shipCol > 9?
            while(shipRow > 9 || shipCol > 9) {
                System.out.println(shipRow + ", " + shipCol + " is an invalid starting point. Please try again.");
                if(shipRow > 9) {
                    shipRow = getRandom();
                }
                
                if(shipCol > 9) {
                    shipCol = getRandom();
                }
            }
            
            // assures ship isn't placed off the grid
            while(shipCol > (8 - shipType)) {
                System.out.println(shipRow + ", " + shipCol + " is an invalid starting point. Please try again.");
                shipCol = random.nextInt(8 - shipType);
            }

            // tests if another ship is in the proposed grid space
            // TODO: Code to check each space the ship occupies
            int check = -1;
            int count = 0;
            int max = shipType + 2;
            while(check != 0) {
                while(count < max) {
                    if(grid[shipRow][shipCol + count] > 0) {
                        System.out.println(shipRow + ", " + shipCol + " is an invalid starting point. Please try again.");
                        shipRow = getRandom();
                        break;
                    }
                    count++;
                }
                check++;
            }
            
            
            // outputs appropriate message
            if(shipType == 1) {
                System.out.print("AI Submarine \"starting point\" is: " + shipRow + ", " + shipCol + ".\n");
            }
            else if(shipType == 2) {
                System.out.print("AI Battleship \"starting point\" is: " + shipRow + ", " + shipCol + ".\n");
            }
            else if(shipType == 3) {
                System.out.print("AI Aircraft Carrier \"starting point\" is: " + shipRow + ", " + shipCol + ".\n");
            }
            
            // "draws" ship on grid
            for(int i = 0; i < (shipType + 2); i++) {
                grid[shipRow][shipCol] = shipType;
                shipCol++;
            }
        }
    }


public class Lxocation {

        public int row;
        public int column;
        public Player player;

        Lxocation() {
        }
        
    }

}