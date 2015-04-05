/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui260.section03.battleship.control;

import citbyui260.section03.battleship.msgs.BattleshipError;
import citbyui260.section03.battleship.game.Game;
import citbyui260.section03.battleship.game.Player;
import citbyui260.section03.battleship.boards.Board;
import citbyui260.section03.battleship.ships.Boat;
import citbyui260.section03.battleship.view.GetLocationView;
import citbyui260.section03.battleship.view.Help;
import java.awt.Point;
import java.util.Scanner;

/**
 *
 * @author John
 */
public class PlaceShipMenuControl {
    private Game game;
    private GetLocationView getLocationView;
    private Player player;
    private Board board;
    private Boat boat;
    
    public PlaceShipMenuControl(Game game) {
        this.game = game;
        this.getLocationView = new GetLocationView(game);
        player = this.game.currentPlayer;
    }
    
    public void placeSub() {
       boat = player.submarine;
       placeYourShip(player,boat);
    }
    
    public void placeBattleship() {
       boat = player.battleship; 
       placeYourShip(player,boat);
    }
    
    public void placeCarrier() {
       boat = player.carrier; 
       placeYourShip(player,boat);
    }
    
    public void resetBoard() {
        
        this.game.currentPlayer.boatBoard.clearTheBoard();      //Clear the board 
        this.game.currentPlayer.ClearShips();                   //remove "Placed flag from ships
        BattleshipError.displayLine("Your board has been reset.");
    }
    
    public void displayBoard() {
        
        board = this.game.currentPlayer.boatBoard;
        board.display();
        
    }
    
    public void displayHelp() {
        Help helpMenu = new Help();
        helpMenu.getInput();
    }
    
    private void placeYourShip(Player player,Boat boat) 
    {
       Point location;
     
       if(boat.isPlaced())
            BattleshipError.displayError("Your " + boat.getName() + " is already placed");
       else
       {
       
           BattleshipError.displayLine("Placing " + boat.getName());
           do
           {
                location = getLocationView.getInput();
                System.out.print(location);
                pickDirection(boat);
                System.out.println(boat.getDirection());

           }while(player.boatBoard.shipPlacement(boat,location)== 1);  //1 means there was an error  0 means success placing ship
           
           boat.setPlaced(true);

       }
    }
    
    private void pickDirection(Boat pickedBoat)
    {
        Scanner inFile = new Scanner(System.in); // get input file 
        this.boat = pickedBoat;
        boolean flag=true;
        
        do
        {
            System.out.println("Please choose a direction for your ship to be placed\n " 
                    + "type: 1 for Down or 2 for across");

             // get the value entered by the user 
             String strDirection = inFile.nextLine();

             switch(strDirection.charAt(0))
             {
                 case '1':
                     boat.setDirection(1);
                     flag=false; //end do/while
                     break;
                 case '2':
                     boat.setDirection(2);
                     flag=false; //end do/while
                     break;
                 default:
                     System.out.println("Invalid entry:  Please try again.");
             }
         }while(flag);
                
    }
    
}
