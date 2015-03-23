/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

/**
 *
 * @author Jeffry Simpson - BYUI CIT260 Section 03
 */
public class Boat
{
    int maxDamage, hitDamage=0;   //max ddamage assigned in constructor
    String name;                   //ship name

    Boat(int damage, String shipname)    //Constructor
    {
        this.maxDamage=damage;    //Max damage for this ship
        this.name = shipname;       //Ship name
    }
    
    public void hit()       //function if the ship is hit
    {
         this.hitDamage++;
         System.out.println("You hit my " + this.name);
         
         if(this.hitDamage== this.maxDamage)
               System.out.println("You sunk my " + this.name);
    }
}