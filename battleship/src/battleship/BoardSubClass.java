/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;


public class BoardSubClass extends Board {

    /**
     *
     */
    public BoardSubClass() {
    }
    
    
     public void shipPlacementAI(Boat myBoat) // ** Added Boat object
{
int flag; //Flag for other boats in same locaiton
int maxRows = getRows(); //Used for Random and boundry checking
int maxCols = getCols(); //Used for Random and boundry checking
int shipRow = 0; //Used for starting row
int shipCol = 0; //Used for starting col
do
{

shipRow = getRandom(maxRows); //Get Random Startrow
shipCol = getRandom(maxCols); //Get Random StartCol
myBoat.setDirection(getRandom(2)+1);
// assures ship isn't placed off the grid
if(myBoat.getDirection() == 1) //Direction is down
while(shipRow+myBoat.getSize() >= maxRows ) //Makes sure starting plus size are ok.
{
new BattleshipError().displayLine("Row too close to the end. Starting point: " + shipRow + ", " + shipCol + " is an invalid starting point.");
shipRow = getRandom(maxRows); //Get new Row
}
else //boat.diretion is RIGHT
{
while(shipCol+myBoat.getSize() >= maxCols ) //Make sure starting plus size are ok
{
new BattleshipError().displayLine("Column too close to the end. Starting point: " + shipRow + "," + shipCol + " is an invalid starting point.");
shipCol = getRandom(maxCols); //Get new Col
}
}
// tests if another ship is in the proposed grid space
flag = checkGridLocation(myBoat,shipRow,shipCol);
}while(flag !=0); //If flag = 1 then get a new Row and COlumn and try again.
//Fill in the grid with the current boat location
putShipinGrid(myBoat,shipRow,shipCol);



    /**
     *
     * @param player
     * @param shipType
     * @return
     */
    public Boat getShip(Player player,int shipType)
{
return player.submarine;
}

    private int getRandom(int maxRows) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private int checkGridLocation(Boat myBoat, int shipRow, int shipCol) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void putShipinGrid(Boat myBoat, int shipRow, int shipCol) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}

