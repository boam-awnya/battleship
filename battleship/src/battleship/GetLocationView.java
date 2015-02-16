/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

/**
 *
 * @author Vehikite-John and Team 3
 */

import java.awt.Point;
import java.util.Scanner;

public class GetLocationView {
    private Game game;
    
    public GetLocationView(Game game) {
        this.game = game;
    }
    
    /*
     * Prompt the user to enter the location (row and column) to place their 
     * marker on the board
     * @Param game the object representing the game
     */
    public Point getInput() {

        Scanner inFile = new Scanner(System.in); // get input file      
        //String[] coordinates = new String[2];
        String[] coordinates;
        
        Point location = null;
        
        boolean valid = false;
        

        // prompt the use to enter the locaton to placeread the row and column coordinates
        while (!valid) {
            // prompt for the row and column numbers
            System.out.println("\n\n\t" + this.game.playerA.name + " it is your turn."
                + " Enter a row and column number (For example: A 3)");
            
            // get the value entered by the user 
            String strRowColumn = inFile.nextLine(); 
            
            // trim off all extra blanks from the input
            strRowColumn = strRowColumn.trim();  
            
            // replace any commas enter with blanks
            strRowColumn = strRowColumn.replace(',', ' '); 
            
            // tokenize the string into an array of words
            coordinates = strRowColumn.split("\\s"); 

            if (coordinates.length < 1) { // the value entered was not blank?
                new BattleshipError().displayError(
                        "You must enter a letter A-J and a number 1-10, "
                        + "or a \"Q\" to quit. Try again.");
                continue;
            }    

            else if (coordinates.length == 1) { // only one coordinate entered?
                if (coordinates[0].toUpperCase().equals("Q")) { // Quit?
                    return null;
                } else { // wrong number of values entered.
                    new BattleshipError().displayError(
                        "You must enter a letter A-J and a number 1-10, "
                        + "or a \"Q\" to quit. Try again.");
                    continue;
                }
            }

            //2/14 - Add this section to convert Letters Enter for Row to num of grid.
            coordinates[0] = convertRow(coordinates[0]);
            if  (coordinates[0].equals("-1"))
            { // wrong Row  values entered.
                    new BattleshipError().displayError(
                        "You must enter a letter A-J "
                        + "or a \"Q\" to quit. Try again.");
                    continue;
            }
            
            // user java regular expression to check for valid integer number 
            // for both numbers
            String regExpressionPattern = ".*\\d.*";
            if (!coordinates[0].matches(regExpressionPattern) ||
                !coordinates[1].matches(regExpressionPattern)) {
                new BattleshipError().displayError(
                        "You must enter a letter A-J and a number 1-10, "
                        + "or a \"Q\" to quit. Try again.");
                continue;
            }
            
            // convert each of the cordinates from a String type to 
            // an integer type
            int row = Integer.parseInt(coordinates[0]);
            int column = Integer.parseInt(coordinates[1]);
                     
            Board board = this.game.shotBoard; // get the game board
            
            // Check for invalid row and column entered
            //2/14 Jeffry - Mondified to be < 0 not less than 1
            if (row < 0   ||  row > board.rows ||
                column < 0  ||  column > board.cols) {
                new BattleshipError().displayError(
                        "Enter a valid letter A-J and number number 1-10. Try again.");
                continue;
            }
            
            // create a Point object to store the row and column coordinates in
            location = new Point(row, column);
          
            
 /***********    2/14 Jeffry  Commented out.  I think we should be getting the info, not checking if its valid here
  * 
          
            // check to see if the location entered is already occupied
            // if ( board.boardLocations[row-1][column-1].player != null ) {
         
            if ( board.boardLocations[row-1][column-1] != null ) {
                new BattleshipError().displayError(
                    "The current location is taken. Select another location");
                continue;
            }
*********************/   
            
            valid = true; // a valid location was entered

        }
        
        return location; 
            
    }

    /*
    Method: convertRow
    Owner:  Jeffry Simpson
    Date:   2/14/2015
    Descpt: Lesson 5 Individual programming assignment, Iterate through Valid
            row values to change it to a string value representing the number
            of the rows.
    */
    
    public String convertRow(String row)
    {
        String findRow = "-1";  //assume error until proven otherwize
        String rowValues[] = {"A","B","C","D","E","F","G","H","I","J"}; 
        
        for(int i=0;i<rowValues.length;i++)
        {
           if(row.toUpperCase().equals(rowValues[i]))   //If passed in string equals one of the Strings in our Grid
           {
                    findRow=Integer.toString(i);   //Assign the number of the Grid
                    break;  //Leave the loop
           }
        }
           
        return findRow;  //Return what we found, or -1
        
    }
    
    
}
