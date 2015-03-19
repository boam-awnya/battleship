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
public enum ShipType
{
    SUBMARINE(3),
    BATTLESHIP(4),
    CARRIER(5); 
 
    private final int maxHits;
    
    //Constructor;
    ShipType(int hits)
    {
        maxHits = hits;
    }
    
    //Return MaxHits
    int getHits()
    {
        return maxHits;
    }
}
