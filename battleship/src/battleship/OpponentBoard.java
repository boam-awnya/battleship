/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package battleship;


/**
*
* @author griffithsC
*/
public class OpponentBoard {
int rowCount = 10;
int columnCount = 10;
Location[][] boardLocations;
public OpponentBoard() {
}
public void displaySize() {
System.out.println("\n\tThe board is " + this.rowCount + " by "
+ this.columnCount + " in size.");
}

}