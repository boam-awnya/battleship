/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui260.section03.battleship.view;

import citbyui260.section03.battleship.msgs.BattleshipError;
import citbyui260.section03.battleship.game.Game;
import citbyui260.section03.battleship.control.GameMenuControl;
import citbyui260.section03.battleship.enums.PlayerType;
import citbyui260.section03.battleship.view.MenuSuper;
import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author Jeffry Simpson - BYUI CIT260 Section 03
 */
public class GameMenu extends MenuSuper
{
    private Game game;
    private GameMenuControl gameMenuControl; 

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public GameMenuControl getGameMenuControl() {
        return gameMenuControl;
    }

    public void setGameMenuControl(GameMenuControl gameMenuControl) {
        this.gameMenuControl = gameMenuControl;
    }


    private final static String[][] menuItems = {
        {"P", "Place your ships"},
        {"F", "Fire a shot"},
        {"A", "Show available shot coordinates"},
        {"D", "Display the board"},
        {"S", "Start a new game"},
        {"R", "Report stastics"},
 //     {"C", "Change game preferences"},
        {"H", "Help"},
        {"Q", "QUIT"}
    };
    
    
    public GameMenu(Game game) 
    {
        super(GameMenu.menuItems);
        
        this.game = game;  //2-16 Jeffry Added
        this.gameMenuControl = new GameMenuControl(game);
        
    }
    
    @Override
    public void getInput() 
    {
   
        String command;
        Scanner inFile = new Scanner(System.in);

        do {    
            
            if(this.game.currentPlayer.getPlayerType()  == PlayerType.HUMAN)
            {
                this.display(); // display the menu
                    // get commaned entered
                command = inFile.nextLine();
                command = command.trim().toUpperCase();
            }
            else
                //add IF/Else for Game Won/Lost
                command = "F";
            
            
            switch (command) {
                case "P":
                    this.gameMenuControl.placeShips();
                    break;
                case "F":
                        if(this.game.currentPlayer.checkReadyToPlay())
                        {
                            this.gameMenuControl.fireAShot();
                            this.game.switchPlayers();
                        }
                        else
                        {
                            BattleshipError.displayError("You must place your ships before you fire a shot at your opponent!");
                        }
                    break;
                case "A":
                    this.game.currentPlayer.shotBoard.availableShots();
                    break;
                case "D":
                    gameMenuControl.displayBoard();
                    break;
                case "S":
                    gameMenuControl.startNewGame();
                    command = "Q"; 
                    break;
                case "R":
                    gameMenuControl.displayStatistics();
                    break;
//                case "C":
//                    gameMenuControl.displayPreferencesMenu();
//                    break;
                case "H":
                    gameMenuControl.displayHelpForm();
                    break;
                case "Q":                   
                    break;
                default: 
                    BattleshipError.displayError("Invalid command. Please enter a valid command.");
                    continue;                              
            }
        } while (!command.equals("Q"));

        return;
    }
    

  
    
}
