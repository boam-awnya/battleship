/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui260.section03.battleship.boards;

import citbyui260.section03.battleship.msgs.BattleshipError;
import citbyui260.section03.battleship.ships.Boat;
import citbyui260.section03.battleship.game.Player;
import citbyui260.section03.battleship.enums.ShipType;
import citbyui260.section03.battleship.exceptions.*;
import java.awt.Point;

/**
 *
 * @author Jeffry Simpson - BYUI CIT260 Section 03
 */


public class ShipBoard extends Board
{
    
    
    public ShipBoard()
    {
       
    }
      
    // Funciton to place the ships on the board
   
    public int shipPlacement(Boat myBoat,Point location) throws BoatException   
    {
        int flag=0; //set flag for OK
        
        try
        {
            stayOnGrid(myBoat,location.x,location.y);     
            
        }catch(BoatException be)
            {
                throw new BoatException(be.getMessage());
                //BattleshipError.displayLine(be.getMessage());
                
            }
                
        flag = checkGridLocation(myBoat,location.x,location.y);
        
        if(flag == 1)
        {
            return flag;
        }
        else
        {
            putShipinGrid(myBoat,location.x,location.y);
            return flag;
 
        }
             
    }
    
    
     // Function to randomly place ships; placed horizontally towards the right
    // of the starting point for now...   
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
            
            while(flag == 0)  //Loop until the SHip gets successfully placed
            {
               try
               {                 
                   stayOnGrid(myBoat,shipRow,shipCol);
                    flag=1; //No exception thrown, so we got a valid grid
               }catch(BoatException be)
                {
                   //Means we got an exception placing the boat, so get new Row or Col
                    if(myBoat.getDirection() == 1) //Direction is down
                        shipRow = getRandom(maxRows);  //Get new Row 
                    else //boat.diretion is RIGHT
                        shipCol = getRandom(maxCols);  //Get new Col
                }
            }   
            
            
            // tests if another ship is in the proposed grid space
            flag = checkGridLocation(myBoat,shipRow,shipCol);
            
            
        }while(flag !=0);  //If flag = 1 then get a new Row and COlumn and try again.
        
        //Fill in the grid with the current boat location
        putShipinGrid(myBoat,shipRow,shipCol);
        myBoat.setPlaced(true);

        

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
    
    // assures ship isn't placed off the grid
    private void stayOnGrid(Boat myBoat, int shipRow, int shipCol) throws BoatException
    {
        
        int maxRows = getRows();    //Used for Random and boundry checking
        int maxCols = getCols();    //Used for Random and boundry checking
        //int flag=0;  //0 = OK
        
            if(myBoat.getDirection() == 1) //Direction is down
            {
                if(shipRow+myBoat.getSize()  > maxRows ) //Makes sure starting plus size are ok.
                {
                    throw new BoatException("Row too close to the end of the grid. Starting point: " + getColStr(shipRow) + shipCol + " is an invalid starting point.");
                   // flag=1;  //error to close to edge
                }
            }   
            else //boat.diretion is Across
            {
                if(shipCol+myBoat.getSize()  > maxCols )   //Make sure starting plus size are ok
                {
                    throw new BoatException("Column too close to the end of the grid. Starting point: " + getColStr(shipRow) + shipCol + " is an invalid starting point.");
                    //flag = 1; //error too close to edge
                } 
            }
            
      // return flag;
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
                //BattleshipError.displayLine("This Boat placement conflicts with one of your other boats " + getColStr(shipRow) + colOffset);
                break;

            }           

            if(boat.getDirection() == 1)  //Increment row or column in the loop
                rowOffset++;
            else
                colOffset++;


        }
        
        return flag;  //1 = error  0 = ok
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
   
        //BattleshipError.displayLine(boat.getName() + " placed. Starting point is: " + shipRow + "," + shipCol + " direction = " + boat.getDirection() );
    
    }
   
    
    
}
