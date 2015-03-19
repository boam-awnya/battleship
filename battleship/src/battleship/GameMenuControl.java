/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import citbyui260.section03.battleship.boards.Board;
import citbyui260.section03.battleship.view.GetLocationView;
import citbyui260.section03.battleship.view.Help;
import java.awt.Point;


/**
 *
 * @author Jeffry Simpson, Vehikite-John - BYUI CIT260 Section 03
 */
public class GameMenuControl
{
    private Game game;
    private GetLocationView getLocationView;
    private Player player;
    private PlaceShipMenu placeShipMenu;

    public GameMenuControl(Game game) {
        this.game = game;
        this.getLocationView = new GetLocationView(game);
    }

    /* 3/7 Katie: Changed placeShips() for Lesson 8...change back after assignment completed.
    public void placeShips()
    {
       
        placeShipMenu = new PlaceShipMenu(game);
        placeShipMenu.getInput();
    
    }
    */
    
    public void placeShips()
    {
       
        placeShipMenu = new PlaceShipMenu(game);
        placeShipMenu.getInput();
    
    }

    public GetLocationView getGetLocationView() {
        return getLocationView;
    }

    public void setGetLocationView(GetLocationView getLocationView) {
        this.getLocationView = getLocationView;
    }

    public PlaceShipMenu getPlaceShipMenu() {
        return placeShipMenu;
    }

    public void setPlaceShipMenu(PlaceShipMenu placeShipMenu) {
        this.placeShipMenu = placeShipMenu;
    }
    //end of change 3/7
    public int fireAShot()
    {
        Point location;
       // Player currentPlayer = this.game.currentPlayer.shotBoard;     //2-16 Jeffry Create local object to point to Game object
       // Player otherPlayer = this.game.otherPlayer.boatBoard;  //2-25 Katie Created local object for otherPlayer
       // Board board = this.game.currentPlayer.shotBoard;    //2-16 Jeffry Create local object to point to Game object
        //Board otherBoard = this.game.otherPlayer.shotBoard; //2-25 Katie Created local object for otherPlayer shotBoard
        
        int flag=0;
        int otherFlag=0;//flag to determine if FireAShot is successful
        
         
        
        do
        {  
            location = getLocationView.getInput();  //input a coordinate for a shot 
            
            if (location == null) 
            { // no location was entered?  
                flag= -1;  //we should never get this error
                break;
            }
            
            flag = this.game.currentPlayer.shotBoard.occupyLocation(location,1);       //Set the shot in the grid,
            
            String tempPrint =((char) (location.x + 65) + " " + location.y);

            if( flag == 1)  //Location already used
                new BattleshipError().displayLine("You've already used " +  tempPrint + " for a shot");  //2/20 Jeffry - Temp print out of location
            else
                new BattleshipError().displayLine("Fired a Shot at " +  tempPrint);  //2/16 Jeffry - Temp print out of location
            

        }while(flag != 0);
        
        /* Katie 2/26/2015
        Added code to establish enhanced firing system for program.
        */

        //Check to see if the other player has a ship here.   Otherflag = 1 (Yes)  = 0 (No)
        otherFlag = this.game.otherPlayer.boatBoard.checkLocation(location);
        
        if(otherFlag != 0)  //Means there is a boat at this locaiton.
        {
            Boat hitBoat;  //new local varable to get ship information   
            int typeShip = this.game.otherPlayer.boatBoard.checkLocation(location); //Get ship type location of coordinates
           
            hitBoat = this.game.otherPlayer.boatBoard.getShip(this.game.otherPlayer, typeShip);
            hitBoat.setHitDamage(hitBoat.getHitDamage()+1);  //Increase damage by one
            hitBoat.hitOrSunk(hitBoat.getHitDamage(), hitBoat.getMaxDamage()); //calls hitOrSunk method in boat.java   
            
        }
        else{
            new BattleshipError().displayLine("Sorry your shot missed");
            //this.game.switchPlayers(); //calls swtich player method in game.java

        }           

        return flag;
        
    }
    
    /*
    Description: Display available grid spaces for shots and calculate
    the total number of shots.
    
    Author(s): John Vehikite
    */
    
    
     public void displayBoard()
    {
        Board board = this.game.currentPlayer.shotBoard;    //2-16 Jeffry Create local object to point to Game object
 
        new BattleshipError().displayLine("Display the board");
        board.display();
    }
     
    public void startNewGame()
    {
         new BattleshipError().displayLine("Start a new game");
    }
   
    public void displayStatistics()
    {
         new BattleshipError().displayLine("Display Statistics");
         this.game.currentPlayer.sortScores();
         this.game.currentPlayer.averageScores();
         this.game.currentPlayer.highScoreNames();
         this.game.currentPlayer.getGameStats(this.game.currentPlayer.shotBoard.getHits(), this.game.currentPlayer.shotBoard.getMisses());
        
         System.out.println("Shots Taken: " + this.game.currentPlayer.shotsTaken());
                 
    }
    
    public void displayPreferencesMenu()
    {
        //nothing here yet
    }

    public void displayHelpMenu() 
    {
        Help helpMenu = new Help();
        helpMenu.getInput();
    }
    
}
