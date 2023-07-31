/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package softwareproject;

/**
 *
 * @author sjhin
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WarCardGame {
    private Player humanPlayer;
    private Player computerPlayer;
    private DeckOfCards deck;
    
    public WarCardGame(String playerName) {
        humanPlayer = new Player(playerName);
        computerPlayer = new Player("Computer");
        deck = new DeckOfCards();
    }
    
    public void initialize() {
        deck.shuffle();
        deck.dealCards(humanPlayer, computerPlayer);
    }
    
    public void play() {
        System.out.println("Game starts in 5 seconds...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        while (!isGameOver()) {
            playRound();
        }
        
        declareWinner();
    }
    
    private void playRound() {
        System.out.println("Pick a card in 3, 2, 1...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        boolean humanReady = getYesNoInput("Pick card (yes/no)?");
        if (humanReady) {
            Card humanCard = humanPlayer.playCard();
            Card computerCard = computerPlayer.playCard();
            
            System.out.println("Your card: " + humanCard);
            System.out.println("Computer's card: " + computerCard);
            
            int result = humanCard.compareTo(computerCard);
            if (result > 0) {
                System.out.println("You win this round!");
                humanPlayer.collectCards(humanCard, computerCard);
            } else if (result < 0) {
                System.out.println("Computer wins this round!");
                computerPlayer.collectCards(humanCard, computerCard);
            } else {
                System.out.println("It's a WAR!");
                performWar();
            }
        } else {
            boolean continueGame = getYesNoInput("Do you want to continue the game (yes/no)?");
            if (!continueGame) {
                // Computer is declared as the winner
                System.out.println("Computer wins the game!");
                computerPlayer.collectRemainingCards(humanPlayer);
            }
        }
    }
    
    private void performWar() {
        List<Card> warCards = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            warCards.add(humanPlayer.playCard());
            warCards.add(computerPlayer.playCard());
        }
        
        Card humanCard = humanPlayer.playCard();
        Card computerCard = computerPlayer.playCard();
        
        System.out.println("Your war card: " + humanCard);
        System.out.println("Computer's war card: " + computerCard);
        
        int result = humanCard.compareTo(computerCard);
        if (result > 0) {
            System.out.println("You win this war!");
            humanPlayer.collectWarCards(warCards);
            humanPlayer.collectCards(humanCard, computerCard);
        } else if (result < 0) {
            System.out.println("Computer wins this war!");
            computerPlayer.collectWarCards(warCards);
            computerPlayer.collectCards(humanCard, computerCard);
        } else {
            System.out.println("Another war!");
            performWar();
        }
    }
    
    private boolean isGameOver() {
        return humanPlayer.getCardCount() == 0 || computerPlayer.getCardCount() == 0;
    }
    
    private void declareWinner() {
        int humanScore = humanPlayer.getCardCount();
        int computerScore = computerPlayer.getCardCount();
        
        if (humanScore == computerScore) {
            System.out.println("It's a draw!");
        } else if (humanScore > computerScore) {
            System.out.println(humanPlayer.getName() + " wins the game!");
        } else {
            System.out.println(computerPlayer.getName() + " wins the game!");
        }
    }
    
    private boolean getYesNoInput(String message) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(message + " ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("yes")) {
                return true;
            } else if (input.equals("no")) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            }
        }
    }
}
