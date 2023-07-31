/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package softwareproject;

import java.util.Scanner;

/**
 *
 * @author sjhin
 */
public class WarGame {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Welcome message and player name input
        System.out.println("Welcome to the WAR card game!");
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();
        
        // Create the game and players
        WarCardGame game = new WarCardGame(playerName);
        game.initialize();
        
        // Start the game
        game.play();
        
        scanner.close();
    }
}
