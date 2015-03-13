/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import java.awt.Point;

/**
 *
 * @author katiewalker
 */
public class BoatBoard extends Board{
    
     public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }
    
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
   // Function to randomly place ships; placed horizontally towards the right
    // of the starting point for now...
   // public void shipPlacement()   *** 2/20 Jeffry
    public void shipPlacementAI(Boat myBoat)   //  ** Added Boat object
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
            myBoat.setDirection(getRandom(2)+1);
            
            // assures ship isn't placed off the grid
            if(myBoat.getDirection() == 1) //Direction is down
                while(shipRow+myBoat.getSize()  >= maxRows ) //Makes sure starting plus size are ok.
                {
                    new BattleshipError().displayLine("Row too close to the end. Starting point: " + shipRow + ", " + shipCol + " is an invalid starting point.");
                    shipRow = getRandom(maxRows);  //Get new Row
                }
                
            else //boat.diretion is RIGHT
            {
                while(shipCol+myBoat.getSize()  >= maxCols )   //Make sure starting plus size are ok
                {
                    new BattleshipError().displayLine("Column too close to the end. Starting point: " + shipRow + "," + shipCol + " is an invalid starting point.");
                    shipCol = getRandom(maxCols);  //Get new Col
                } 
            }
            
            // tests if another ship is in the proposed grid space
            flag = checkGridLocation(myBoat,shipRow,shipCol);
            
            
        }while(flag !=0);  //If flag = 1 then get a new Row and COlumn and try again.
        
        //Fill in the grid with the current boat location
        putShipinGrid(myBoat,shipRow,shipCol);

        }
    
}
