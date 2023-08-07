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

public class Player {
    private String name;
    private List<Card> cards;
    
    public Player(String name) {
        this.name = name;
        cards = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }
    
    public void addCard(Card card) {
        cards.add(card);
    }
    
    public Card playCard() {
        if (cards.isEmpty()) {
            return null;
        }
        return cards.remove(0);
    }
    
    public int getCardCount() {
        return cards.size();
    }
    
    public void collectCards(Card... newCards) {
        for (Card card : newCards) {
            cards.add(card);
        }
    }
    
    public void collectWarCards(List<Card> warCards) {
        cards.addAll(warCards);
    }
    
    public void collectRemainingCards(Player otherPlayer) {
        cards.addAll(otherPlayer.cards);
        otherPlayer.cards.clear();
    }
}
