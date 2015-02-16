/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import java.awt.Point;
import java.util.Random;

/**
 *
 * @author jeffrysimpson, Vehikite-John
 */
public class Board
{
    int rows = 10;
    int cols = 10;
    int[][] grid = new int[rows][cols];
    String boardtype;
    public Player[][] boardLocations;
    Random random = new Random();
    
    public Board() {
    }
    
      
    public void clearTheBoard() {
        // TODO
    }
    
    
    public Board(Boolean playerBoard)
    {
        if(playerBoard)
            boardtype = "Player";
        else
            boardtype = "Oponent";
                 
    }

    public void occupyLocation(Player player, int row, int column) {
        Player playerAtLocation = this.boardLocations[row][column];

        if (playerAtLocation != null) { // location already occupied
            new BattleshipError().displayError("This location is already occupied. "
                    + "Try a different location.");
        }
        this.boardLocations[row][column] = player;
    }


    
    public void display()
    {
        System.out.println("This is the " + boardtype + "'s board and it is " + rows + " by " + cols + ".");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
            grid[i][j] = 0;
            System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
    
    public void boardDisplay() {
        System.out.println("This is the " + boardtype + "'s board after ship placement.");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
            System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
    
    public int getRandom() {
        return random.nextInt(9);
    }
    
  
    
    // Function to randomly place ships; placed horizontally towards the right
    // of the starting point for now...
    public void shipPlacement() {
        double row = 0;
        double col = 0;
        
        for(int shipType = 1; shipType < 4; shipType++) {        
            //Typecasting practice
            int shipRow = (int) row;
            int shipCol = (int) col;
            shipRow = getRandom();
            shipCol = getRandom();
            
            // Is shipRow or shipCol < 0?
            while(shipRow < 0 || shipCol < 0) {
                System.out.println(shipRow + ", " + shipCol + " is an invalid starting point. Please try again.");
                if(shipRow < 0) {
                    shipRow = getRandom();
                }
                
                if(shipCol < 0) {
                    shipCol = getRandom();
                }
            }
            
            // Is shipRow or shipCol > 9?
            while(shipRow > 9 || shipCol > 9) {
                System.out.println(shipRow + ", " + shipCol + " is an invalid starting point. Please try again.");
                if(shipRow > 9) {
                    shipRow = getRandom();
                }
                
                if(shipCol > 9) {
                    shipCol = getRandom();
                }
            }
            
            // assures ship isn't placed off the grid
            while(shipCol > (8 - shipType)) {
                System.out.println(shipRow + ", " + shipCol + " is an invalid starting point. Please try again.");
                shipCol = random.nextInt(8 - shipType);
            }

            // tests if another ship is in the proposed grid space
            // TODO: Code to check each space the ship occupies
            int check = -1;
            int count = 0;
            int max = shipType + 2;
            while(check != 0) {
                while(count < max) {
                    if(grid[shipRow][shipCol + count] > 0) {
                        System.out.println(shipRow + ", " + shipCol + " is an invalid starting point. Please try again.");
                        shipRow = getRandom();
                        break;
                    }
                    count++;
                }
                check++;
            }
            
            
            // outputs appropriate message
            if(shipType == 1) {
                System.out.print("AI Submarine \"starting point\" is: " + shipRow + ", " + shipCol + ".\n");
            }
            else if(shipType == 2) {
                System.out.print("AI Battleship \"starting point\" is: " + shipRow + ", " + shipCol + ".\n");
            }
            else if(shipType == 3) {
                System.out.print("AI Aircraft Carrier \"starting point\" is: " + shipRow + ", " + shipCol + ".\n");
            }
            
            // "draws" ship on grid
            for(int i = 0; i < (shipType + 2); i++) {
                grid[shipRow][shipCol] = shipType;
                shipCol++;
            }
        }
    }

    public class Location {

        public int row;
        public int column;
        public Player player;

        Location() {
        }
        
    }

}