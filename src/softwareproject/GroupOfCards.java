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

public abstract class GroupOfCards {
    protected List<Card> cards;
    protected int maxSize;

    public GroupOfCards(int maxSize) {
        this.maxSize = maxSize;
        cards = new ArrayList<>();
    }

    public int getSize() {
        return cards.size();
    }

    public int getMaxSize() {
        return maxSize;
    }

    public boolean isFull() {
        return cards.size() == maxSize;
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public void addCard(Card card) {
        if (cards.size() < maxSize) {
            cards.add(card);
        }
    }

    public void removeCard(Card card) {
        cards.remove(card);
    }

    public void clear() {
        cards.clear();
    }

    // Abstract method to shuffle the cards (to be implemented in child classes)
    public abstract void shuffle();
}

