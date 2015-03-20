/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui260.section03.battleship.boards;

import battleship.BattleshipError;
import citbyui260.section03.battleship.ships.Boat;
import battleship.Player;
import java.util.Random;
import citbyui260.section03.battleship.ships.ShipType;

/**
 *
 * @author Jeffry Simpson - BYUI CIT260 Section 03
 */


public class ShipBoard extends Board
{
    
    
    public ShipBoard()
    {
       
    }
      
    // Function to randomly place ships; placed horizontally towards the right
    // of the starting point for now...
   // public void shipPlacement()   *** 2/20 Jeffry
    public void shipPlacementAI(Boat myBoat)   //  ** Added Boat object
    {
        int flag;                   //Flag for other boats in same locaiton
        int maxRows = getRows();    //Used for Random and boundry checking
        int maxCols = getCols();    //Used for Random and boundry checking  
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
        
       switch(shipType)
       {
           case 3:
               return player.submarine;
           case 4:
               return player.battleship;
           case 5:
               return player.carrier;
           default:
               return null;
               
       }
        
   
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

            if(this.checkLocation(rowOffset,colOffset) != 0)  //See if a value is in the grid locaiton other than 0
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
    
    /*************************************************************************** 
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
            this.occupyLocation(rowOffset,colOffset,boat.getSize());
            if(boat.getDirection() == 1)  //CHeck for direction
                    rowOffset++;
                else
                    colOffset++;
        }
   
        new BattleshipError().displayLine(boat.getName() + " placed. Starting point is: " + shipRow + "," + shipCol + " direction = " + boat.getDirection() );
    
    }
    
    
    
    private int getRandom(int maxVal) {
        Random random = new Random();
        return random.nextInt(maxVal);
    }
    
    
    
}
