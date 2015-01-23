package battleship;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */




public class Game {

     String gameType;
     Player playerA;
     Player playerB;
     //Player currentPlayer;
     //Player otherPlayer;
     Player winner;
     Player loser;
     String status;
     Board boardA;
     Board boardB;
   

    public Game() {
   
       this.playerA = new Player();
       this.playerA.name = "Captain Bemax";
       this.playerB = new Player();
       this.playerB.name = "AI";
       
    }


    public void displayWinningMessage () {
        System.out.println(
             "\n\t*******************************************************************************"
             + "\n\t Congratulations " + this.winner.name + "! You won the game."
             + "\n\t Sorry " + this.loser.name + ", You are the loser." 
             + "\n\t*******************************************************************************");
    }
    
    public void displayPlayers() {
        System.out.println("\n\tHere are the two default players in the game of Battleship.");
        this.playerA.displayName();
        this.playerB.displayName();
                              
    }
}