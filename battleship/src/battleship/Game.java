package battleship;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */




public class Game {
     String PLAYER_A__HIT__MARKER = "X";
     String PLAYER_A_MISS_MARKER = "O";
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

public Game(String gameType) {
        this();

        this.gameType = gameType;
        this.board = new Board(10, 10);
        
    }


    public void start() {

        this.setPlayingOrder(playerA, playerB);

        // clear the board
        this.board.clearTheBoard();
        this.status = Game.NEW_GAME;
    }

    public void setPlayingOrder(Player player1, Player player2) {

        double randomValue = Math.random();

        if (randomValue < 0.5) {
            this.currentPlayer = player1;
            this.otherPlayer = player2;
        } else {
            this.otherPlayer = player2;
            this.currentPlayer = player1;
        }

    }

    public void recordWinner() {
        if (this.currentPlayer == this.playerA) {
            this.winner = this.playerA;
            this.loser = this.playerB;
        } else {
            this.winner = this.playerB;
            this.loser = this.playerA;
        }

        long noWins = this.winner.getWins();
        noWins++;
        this.winner.setWins(noWins);
        long noLosses = this.loser.getLosses();
        noLosses++;
        this.loser.setLosses(noLosses);

        this.status = Game.WINNER;
        
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
