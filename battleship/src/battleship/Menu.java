/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import java.util.Scanner;
/**
 *
 * @author Vehikite-John
 */
public class Menu {
    
    String playerName;
    /* TODO
    *  Make PlayerA name as user string
    */
    
    public void enterName() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        playerName = scanner.nextLine();
        
        // Code to test scanner functionality
        System.out.println("Prepare your Battleship " + playerName);
    }
}
