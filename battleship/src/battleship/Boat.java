/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import battleship.ShipType;   // Inport Enum Class

/**
 * @author Jeffry Simpson - BYUI CIT260 Section 03
 */
public class Boat 

{
    
    private int size;            //Jeff 3/10 - Removed Static as it would set size once and hold it.
    private int direction;       //Jeff 3/10 - Removed Static as it would set direction once and hold it.
    private int maxDamage;
    private int hitDamage=0;        //max damage assigned in constructor
    private String name;            //ship name
    private ShipType shipType;      //Enum type of Ships
    

    public Boat(ShipType sType)    //Constructor
    {
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
    
    
    
        /*-------------------------------------------------------------------
    Description:  Calculates Hits on a Ship, remaning hits and if the boat is sunk.
                  Also calculate the % of the ship that remains unharmed. 
    
    Author:  Awnya Boam
    Info:  Group Lesson #3 assignemnt
    
    input: HitDamage, maxDamage
    Output: 0 for OK and -1 for Error
    
    --------------------------------------------------------------------*/   
    public int hitOrSunk(int hitDamage, int maxDamage)
    {
      //this.hitDamage++;    //Removed after we added get and set Damage
        
      int hitsRemaining;   
      double boatHitPercent, boatHitOutput;                 //Variables for typecasting
        
        if(maxDamage < 2 || maxDamage > 5)   
        {
            System.out.println("\nError: Invalid boat size.\n");  //min boat size = 2, max = 5.  Check to ensure maxHits is within those parameters.
            return -1;
        }
        else if(hitDamage < 0 || (hitDamage > maxDamage))  //Check hitDamage is less than maxDamage and greater than 0
        {
            System.out.println("\nError: Invalid number of hits. \n");
            return -1;
        }
                
         else if (hitDamage == 0) // no hits yet statement
        {
            System.out.println("\nYour " + name + " is safe.  It has no hits yet. \n");
            return 0; 
        }
        
        else if (hitDamage == maxDamage) // ship sunk statement 
        {
            if (maxDamage == 4) //if the boat sunk is the battleship
            {
                System.out.println("\nYour " + name + " is sunk.  You LOSE.  Better luck next time!! \n");
                return 0; 
            }
            
            else //for any other ship
            {
                System.out.println("\nYour " + name + " is sunk.\n");
                return 0; 
            }          
        }
        
        else
        {
            hitsRemaining = maxDamage - hitDamage;               
           boatHitPercent = (double) hitDamage /maxDamage;
                         
            boatHitOutput = (boatHitPercent * 100);         
        
        
            System.out.println ("\nYour " + name + " got hit! \n\t You have " + hitsRemaining + " hits on your " + name + " remaining. \n\tYour " + name + " is damaged " + (int) boatHitOutput + "%. \n"); 
              return 0; //everything working correctly
        }
        
    }
}