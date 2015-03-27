/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui260.section03.battleship.ships;

import citbyui260.section03.battleship.enums.ShipType;   // Inport Enum Class
import citbyui260.section03.battleship.enums.ShipCodes;   // Inport Enum Class for error codes
import citbyui260.section03.battleship.exceptions.*;
/**
 * @author Jeffry Simpson - BYUI CIT260 Section 03
 */
public class Boat 

{
    
    private int size;            //Jeff 3/10 - Removed Static as it would set size once and hold it.
    private int direction;       //Jeff 3/10 - Removed Static as it would set direction once and hold it.
    private int maxDamage;
    private int hitDamage=0;        //max damage assigned in constructor
    private boolean placed;
    private String name;            //ship name
    private ShipType shipType;      //Enum type of Ships
  
    

    public Boat(ShipType sType)    //Constructor
    {
        
        this.placed = false;
        this.maxDamage = sType.getHits();    //Max damage for this ship
        this.name = sType.name();       //Ship name
        this.size = sType.getHits();         //size of boat
        this.shipType = sType;       //commented out 3/7/15 -- same thing as the name
        
    
    }
    
   


    public int getMaxDamage()
    {
        return shipType.getHits();
    }

    public void setMaxDamage()
    {
        maxDamage = shipType.getHits();
    }

    public int getHitDamage()
    {
        return hitDamage;
    }

    public void setHitDamage(int hitDamage)
    {
        this.hitDamage = hitDamage;
    }

    public ShipType getShipType()
    {
        return shipType;
    }

    public void setShipType(ShipType shipType)
    {
        this.shipType = shipType;
    }

    public int getSize()
    {
        return size;
    }

    public void setSize(int size)
    {
        this.size = size;
    }

    public int getDirection()
    {
        return direction;
    }

    public void setDirection(int direction)
    {
        this.direction = direction;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public boolean isPlaced()
    {
        return placed;
    }

    public void setPlaced(boolean placed)
    {
        this.placed = placed;
    }
    
    
    
        /*-------------------------------------------------------------------
    Description:  Calculates Hits on a Ship, remaning hits and if the boat is sunk.
                  Also calculate the % of the ship that remains unharmed. 
    
    Author:  Awnya Boam
    Info:  Group Lesson #3 assignemnt
    
    input: HitDamage, maxDamage
    Output: 0 for OK and -1 for Error
    
    --------------------------------------------------------------------*/   
    public ShipCodes hitOrSunk(int hitDamage, int maxDamage) throws BoatException
    {
        
      int hitsRemaining;   
      double boatHitPercent, boatHitOutput;                 //Variables for typecasting
      ShipCodes sc = ShipCodes.OK;
    
        
        if(maxDamage < 2 || maxDamage > 5)   
        {
            // System.out.println("\nError: Invalid boat size.\n");  //min boat size = 2, max = 5.  Check to ensure maxHits is within those parameters.
            throw new BoatException("Wrong boat size sailor");
        }
        else if(hitDamage < 0 || (hitDamage > maxDamage))  //Check hitDamage is less than maxDamage and greater than 0
        {
            //System.out.println("\nError: Invalid number of hits. \n");
            //return sc.INVALIDNUMHITS;
            throw new BoatException("Your ship is not that big buddy");
        }
                
         else if (hitDamage == 0) // no hits yet statement
        {
            //System.out.println("\nThe " + name + " is safe.  It has no hits yet. \n");
            //return sc.NOHITS; 
            throw new BoatException("The " + name + " is safe.  It has no hits yet. ");
        }
        
        else if (hitDamage == maxDamage) // ship sunk statement 
        {
            if (maxDamage == 4) //if the boat sunk is the battleship
            {
                //System.out.println("\nThe " + name + " is sunk.  You LOSE.  Better luck next time!! \n");
                //return sc.BATTLESHIPSUNK; 
                throw new BoatException("The Battleship is sunk...GAME OVER");
            }
            
            else //for any other ship
            {
                //System.out.println("\nThe " + name + " is sunk.\n");
                //return sc.SHIPSUNK; 
                throw new BoatException("One of the ships is sunk");
            }          
        }
        
        else
        {
           hitsRemaining = maxDamage - hitDamage;               
           boatHitPercent = (double) hitDamage /maxDamage;
                         
            boatHitOutput = (boatHitPercent * 100);         
        
        
            System.out.println ("\nThe " + name + " got hit! \n\t There are " + hitsRemaining + " hit(s) on the " + name + " remaining. \n\tThe " + name + " is damaged " + (int) boatHitOutput + "%. \n"); 
              return sc.OK; //everything working correctly
        }
        
    }
    
    
}