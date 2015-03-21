/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui260.section03.battleship.game;
import citbyui260.section03.battleship.ships.Boat;
import citbyui260.section03.battleship.boards.ShotBoard;
import citbyui260.section03.battleship.boards.ShipBoard;
import citbyui260.section03.battleship.boards.Board;
import citbyui260.section03.battleship.enums.*;  //Inport ENUM Class

/**
 *
 * @author jeffrysimpson, awnyaboam
 */
public class Player
{
    String name;
    private PlayerType playerType;
    private String marker;
    private long wins = 0;
    private long losses = 0;
    public ShotBoard shotBoard;    //Jeffry - 2/16 added
    public ShipBoard boatBoard;    //Jeffry - 2/16 added
    public Boat submarine;
    public Boat battleship;
    public Boat carrier;
 
    
    public Player()
    {
       
       shotBoard = new ShotBoard();    //Jeffry - Player board to show shots
       boatBoard = new ShipBoard();    //Jeffry - Player board to show boats
       submarine = new Boat(ShipType.SUBMARINE);     //Jeremy - 2/24
       battleship = new Boat(ShipType.BATTLESHIP);  //Jeremy - 2/24 
       carrier = new Boat(ShipType.CARRIER);
        
    }

    public String getName()
    {
        return name;
    }
    
    
   public void setName(String name) {
       this.name = name;
   }
    
   
    public PlayerType getPlayerType() {
        return playerType;
    }
    
    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public String getMarker()
    {
        return marker;
    }

    public void setMarker(String marker)
    {
        this.marker = marker;
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
    Description:  Count number of shots taken
    
    Author(s):  Jeffry Simpson
    Info:  indivudal Lesson #6 assignemnt
    
    input: N/A
    Output: int sum of shots
    
    --------------------------------------------------------------------*/
    public int shotsTaken()
    {  
        int sum = this.shotBoard.getHits() + this.shotBoard.getMisses();
        
        return sum;              
    }
    

    
    /*-------------------------------------------------------------------
    Description:  Calculates Hit and Miss Percentage from Hit and Miss info
    
    Author(s):  Jeffry Simpson
    Info:  Group Lesson #3 assignemnt
    
    input: Hit and Miss
    Output: 0 for OK and -1 for Error
    
    --------------------------------------------------------------------*/
    
    
     public int getGameStats(int hit, int miss)
    {
        double totalShots,hitPercent,missPercent;   //Requirement 1 - Two or more primitive Variables
        int hitOutput, missOutput;                  //Variables for typecasting
        
        if(hit == 0 && miss == 0)   //Requirement 3 - At least one Relational operator 
        {
            System.out.println("\nError: You have taken no shots yet.  Try harder.");  //Check for 0 and print error
            return -1;
        }
        else if(hit < 0 || miss < 0)  //CHeck if Hit or miss are less than 0
        {
            System.out.println("\nError: Invalid value in \"Hit\" or \"Miss\"\n");
            return -1;
        }
        else
        {
            
            
             totalShots = hit + miss;               //Requirement 2 - Two or More Mathmatical Operators
             hitPercent = hit/totalShots;
             missPercent = miss/totalShots;
             
             hitOutput = (int) (hitPercent * 100);   //Requirement 4 - A type conversion using type casting
             missOutput = (int) (missPercent * 100);
            
             // Requirement 5 - at least two character escape sequences
             System.out.println(getName() + " Your statistics:\n\tTotal shots: " + (int) totalShots + "\n\tHits:" + hit +" Percentage: " +hitOutput + "%\n\tMiss:" + miss +" Percentage: " +missOutput+"%");
             
            //Additional scoring functions here
            //averageScores();
            //sortScores();
            //highScoreNames();
            
             
             return 0;  //Exit all is well
         }
        
    }
    
    //Group Programming Assignment 2-19-15
    //The exchange sort compares the first element with each following element of the array, making any necessary swaps.
    
    public void sortScores () 
    {
        
        int[] scores = {10, 90, 60, 40, 20, 90, 50};
        int temp;
        
        for(int i=0; i<scores.length-1; i++) 
        {
            for (int j=i+1; j < scores.length; j++)
            {
                if(scores[i] < scores[j])
                {
                    temp=scores[i];
                    scores[i]=scores[j];
                    scores[j]=temp;
                }
            }
       } 
        for (int i = 0; i<scores.length; i++)
            System.out.println(scores[i]);
            
    }
    
    //for-each loop to calculate the average of the scores. By Shatzi for the Individual Assignment lesson6
    
   
    public void averageScores() 
    {
        int[] scores = {50, 90, 60, 40, 20, 90, 10};
        double result = 0; //average will have decimal point
        int average = 0;
    
        for (int i = 0; i<scores.length; ++i)
        {
            average++;

        }
        
        for(int i=0; i < scores.length; i++)
        {
            result += scores[i];
        }
        System.out.println("The average score is: " + result/average);
        
    }
        
    //For-each loop to associate name with score--authored by Colby 2/21/15

    
    
 public void highScoreNames()
    {
                System.out.print("\n");
                System.out.println ("Names of players with current high scores:");
		String [] titles = {"James", "Baymax", "AI", "Kim", "Baymax", "Matt", "Amber"};
				
	for( String name : titles ) 
	{
		System.out.println( name );
		
	}
    }    
}
        
 
 
   
    

