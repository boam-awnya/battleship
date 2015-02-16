/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

/**
 *
 * @author katiewalker
 */
public class playerStatistics {
    
    int highScore=0; //displays high score and name of player
    //highScore = 0;
    
    public int getScore()
    {
        
        return highScore;
    }
    
    
    /* Vehikite-John individual assignment
    TODO: use player's board instead of boardArray
    */
    
    public void getHitPercentage() {
        int hits = 0;
        int misses = 0;
        double hitPercentage;
        char[][] boardArray = new char[10][10];
        
        for(int i = 0; i < 10; i++) {
            for(int j = 0; i < 10; i++) {
                boardArray[i][j] = 'O';
            }
        }
        
        boardArray[1][2] = 'X';
        boardArray[2][5] = 'X';
        boardArray[5][7] = 'M';
        boardArray[9][9] = 'M';
        
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                if(boardArray[i][j] == 'X') {
                    hits++;
                }
                if(boardArray[i][j] == 'M') {
                    misses++;
                }
            }
        }
        if(hits == 0 && misses == 0) {
            System.out.println("No hits or misses to calculate.");
        }
        else if(hits < 0 || misses < 0) {
            System.out.println("Hit percentage calculation error.");
        }
        else {
            hitPercentage = (hits / (hits + misses)) * 100;
                if(hitPercentage > 100)
                    System.out.println("Hit percentage calculation error.");
                else {
                    System.out.println("You hit " + hits + " times.");
                    System.out.println("You missed " + misses + " times.");
                    System.out.println("Your hit percentage is: " + hitPercentage + ".");
                }
        }
    }
    
}
