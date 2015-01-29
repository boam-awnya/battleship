/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

/**
 *
 * @author jeffrysimpson, awnyaboam
 */
public class Player
{
    String name;
    String playerType;
    private long wins = 0;
    private long losses = 0;
    
    
    public Player(){
        
    }
    
   public void setName(String name) {
       this.name = name;
   }
    
   
    public String getPlayerType() {
        return playerType;
    }
    
    public void setPlayerType(String playerType) {
        this.playerType = playerType;
    }
    
    public long getWins() {
        return wins;
    }
    
    public void setWins(long wins) {
        this.wins = wins;
    }
    
    public long getLosses() {
        return losses;
    }
    
    public void setLosses (long losses) {
        this.losses = losses;    
    }
    
    
    public void displayName()
    {
        System.out.println("My name is " + this.name);
    }
           
    
}
