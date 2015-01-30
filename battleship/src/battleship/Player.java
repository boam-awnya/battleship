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
           
    
     /*-------------------------------------------------------------------
    Description:  Calculates Hit and Miss Percentage from Hit and Miss info
    
    Author(s):  Jeffry Simpson
    Info:  Group Lesson #3 assignemnt
    
    input: Hit and Miss
    Output: 0 for OK and -1 for Error
    
    --------------------------------------------------------------------*/
    
    
    int getGameStats(int hit, int miss)
    {
        double totalShots,hitPercent,missPercent;   //Local Variables
        int hitOutput, missOutput;                  //Variables for typecasting
        
        if(hit == 0 && miss == 0)   //check if both Hit and miss are zero
        {
            System.out.println("\nError: You can't divide by 0\n");
            return -1;
        }
        else if(hit < 0 || miss < 0) 
        {
            System.out.println("\nError: Invalid value in \"Hit\" or \"Miss\"\n");
            return -1;
        }
        else
        {
             totalShots = hit + miss;
             hitPercent = hit/totalShots;
             missPercent = miss/totalShots;
             
             hitOutput = (int) (hitPercent * 100);
             missOutput = (int) (missPercent * 100);
            
             
             System.out.println("\nYou statistics:\n\tTotal shots: " + (int) totalShots + "\n\tHits:" + hit +" Percentage: " +hitOutput + "%\n\tMiss:" + miss +" Percentage: " +missOutput+"%");
                 
            return 0;
         }
        
    }
   
    
}
