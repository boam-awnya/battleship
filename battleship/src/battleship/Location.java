/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package battleship;
/**
*
* @author griffithsC
*/

public class Location {

private int row;
private int column;
private Player player;
public static String position = 
        "Some text there right?";

    public Location() {
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    
public void occupyLocation(Player player) {
    displayMarker();
}

private void displayMarker() {
if (this.player != null) {
    System.out.println(this.player.marker);
    }
    else {
        System.out.println(" ");
    }
}
//This is a work in progress for nested class for lesson 8.
class Spot{
    public Spot() {
    }
    
    public int Xmarks(){
        int X;
        X = (row + column);
        return X;    
    }
}
}