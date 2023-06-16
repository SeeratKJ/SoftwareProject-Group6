package softwareproject;

/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your Seerat as an author and the date 15.6.23!
 */


/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 *
 * @author dancye
 */
public abstract class Card {
    //default modifier for child classes
    
    public enum Suit{
        HEARTS, CLUBS, SPADES, DIAMONDS
    }
    
    public enum Value{
        ACE, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, KING, QUEEN, JACK
    }
    //instance variables
    private Suit suit;
    private Value value;
    
    //constructor methods
    public Card(){
        
    }

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }
    
    //getters and setters

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }
    
    

    /**
     * Students should implement this method for their specific children classes
     *
     * @return a String representation of a card. Could be an UNO card, a regular playing card etc.
     */
    @Override
    public abstract String toString();

	

}
