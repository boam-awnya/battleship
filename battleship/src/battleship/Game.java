package battleship;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */




public class Game {
     public static final String PLAYER_A__HIT__MARKER = "X";
     public static final String PLAYER_A_MISS_MARKER = "O";
     public static final String PLAYER_B__HIT__MARKER = "X";
     public static final String PLAYER_B_MISS_MARKER = "O";
     public static final String CONTINUE = "CONTINUE";
     public static final String NEW_GAME = "NEW_GAME";
     public static final String PLAYING = "PLAYING"; 
     public static final String WINNER = "WINNER"; 
     public static final String AIPLAYER = "AI";        //2/20 Jeffry added AI player string
     
     //String gameType; --  2/14 Jeffry, this is not being used anywhere
     Player playerA;
     Player playerB;
     Player currentPlayer;
     Player otherPlayer;
     Player winner;
     Player loser;
     String status;
     //Board boatBoard;    2/16 - Jeffry Removed to move under player
     //Board shotBoard;   2/16 - Jeffry Removed to move under player
   

    public Game() {
   
        
       this.playerA = new Player();
       this.playerA.name = "Captain Baymax";
       this.playerB = new Player();
       this.playerB.name = "AI";
     //  this.boatBoard = new Board(true);        //2-16 Jeffry remove - 2-14  added to remove NPE
     //  this.shotBoard = new Board(false);       //2-16 Jeffry remove - 2-14  added to remove NPE
       
    }

/**************   2/14 Jeffry - this is not currently being used.
 
    public Game(String gameType) {
        this();

        this.gameType = gameType;
        this.boatBoard = new Board(true);
        this.shotBoard = new Board(false);
    }

*/
    public void start(int numPlayers) {


        // clear the board for both players  (2/16 Jeffry added Player. )
        playerA.boatBoard.clearTheBoard();
        playerA.shotBoard.clearTheBoard();
        playerB.boatBoard.clearTheBoard();
        playerB.shotBoard.clearTheBoard();
        this.status = Game.NEW_GAME;
        
        this.setPlayingOrder(numPlayers);   //2-16 Jeffry Added NumPlayers, removed Player1 and Player2 variables

        if(numPlayers == 1)  //Setup AI ships
        {
            playerB.boatBoard.shipPlacementAI(playerB.submarine);  //Let the AI pick all the locations
            playerB.boatBoard.shipPlacementAI(playerB.battleship);  //Let the AI pick all the locations
            playerB.boatBoard.shipPlacementAI(playerB.carrier);  //Let the AI pick all the locations
           
            playerB.boatBoard.display();
        }
    }

    public void setPlayingOrder(int numPlayers) {  //2-16 Jeffry Added NumPLayers, removed Player 1 and Player2 variables

        if(numPlayers == 1)   //2-16 Jeffry -  One Player Game, Real Player always starts
        {
            this.currentPlayer = playerA;
            this.otherPlayer = playerB;
            this.playerB.setPlayerType(AIPLAYER);       //2-20 added AIPlayer String in 1 player game
        }
        else    // Else for two player game, randomly choose which one goes first
        {   
            this.playerA.setPlayerType("");     //2-20 Jeffry Set player types to real
            this.playerB.setPlayerType("");
            
            double randomValue = Math.random();
            
            if (randomValue < 0.5) {
                this.currentPlayer = playerA;
                this.otherPlayer = playerB;
            } else {
                this.currentPlayer = playerB;
                this.otherPlayer = playerA;
            }
        }

    }
    
        /*
    Method: SwtichPlayers
    Owner:  Jeffry Simpson
    Date:   2/16/2015
    Descpt: Method to switch current and other Player.
    */
    public void switchPlayers()
    {
        Player tempPlayer;  //temp place holder
        
        tempPlayer = this.currentPlayer;
        this.currentPlayer = this.otherPlayer;
        this.otherPlayer = tempPlayer;
        
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
