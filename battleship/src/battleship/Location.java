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
int row;
int column;
Player player;
public Location() {
}
public void occupyLocation(Player player) {
this.player = player;
}
public void displayMarker() {
if (this.player != null) {
    System.out.println(this.player.marker);
    }
    else {
        System.out.println(" ");
    }
}
}