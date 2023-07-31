package softwareproject;




/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game.
 *
 * @author seerat
 */
/**
 *
 * @author sjhin
 */
public class Card implements Comparable<Card> {
    private CardRank rank;
    private CardSuit suit;
    
    public Card(CardRank rank, CardSuit suit) {
        this.rank = rank;
        this.suit = suit;
    }
    
    public CardRank getRank() {
        return rank;
    }
    
    public CardSuit getSuit() {
        return suit;
    }
    
    @Override
    public String toString() {
        return rank + " of " + suit;
    }
    
    @Override
    public int compareTo(Card other) {
        return this.rank.getValue() - other.rank.getValue();
    }
}
