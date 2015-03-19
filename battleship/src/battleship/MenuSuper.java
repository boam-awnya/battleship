/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;
import citbyui260.section03.battleship.interfaces.*;

/**
 *
 * @author Jeremy
 */
public class MenuSuper implements DisplayInfo, EnterInfo {

    public MenuSuper(String [][]menuItemsSub) {
        menuItems = menuItemsSub;
    }
    
    private String[][] menuItems = null;
    
    public final void display() {
        System.out.println("\n\t===============================================================");
        System.out.println("\tEnter the letter associated with one of the following commands:");

        for (int i = 0; i < menuItems.length; i++) {
            System.out.println("\t   " + menuItems[i][0] + "\t" + menuItems[i][1]);
        }
        System.out.println("\t===============================================================\n");
    }
  
   public void getInput(){
   
   }
    
}
