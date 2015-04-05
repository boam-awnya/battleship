/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui260.section03.battleship.view;
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
    
    @Override
    public final void display() {
        System.out.println("\n\t===============================================================");
        System.out.println("\tEnter the letter associated with one of the following commands:");

        for (String[] menuItem : menuItems)
        {
            System.out.println("\t   " + menuItem[0] + "\t" + menuItem[1]);
        }
        System.out.println("\t===============================================================\n");
    }
  
    @Override
   public void getInput(){
   
   }
   
   public void displayAnyKey()
   {
       System.out.println("Press any key to continue");
   }
   
}
