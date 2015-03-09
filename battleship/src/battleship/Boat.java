/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

/**
 * @author Jeffry Simpson - BYUI CIT260 Section 03
 */
public class Boat 

{
    private ShipType shipType;  //Enum type of Ships
    
    public static int size;
    public static int direction;
    private int maxDamage;
    private int hitDamage=0;   //max damage assigned in constructor
    public static String name;                   //ship name

    public Boat(int damage, String shipname, ShipType type)    //Constructor
    {
        this.maxDamage = damage;    //Max damage for this ship
        this.name = shipname;       //Ship name
        this.size = damage;         //size of boat
       // this.shipType = type;       //commented out 3/7/15 -- same thing as the name
    }
    
    /*
    
    Use to print out type of Ship   //commented out 3/7/15  -- unnecessary code
     public ShipType getShipType()
    {
        return this.shipType;
    }
    
       
     ---commented out 3/7/15 -- redundent code - HitorSunk function does this same thing
    
    public void hit()       function if the ship is hit
    {
         this.hitDamage++;
         System.out.println("You hit my " + this.name);
         
         if(this.hitDamage== this.maxDamage)
               System.out.println("You sunk my " + this.name);
    }
    
    */
    
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
        //this.hitDamage++;  --->  We will need to add this in at a later date
        
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