
package softwareproject;

/**
 *
 * @author sjhin
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckOfCards extends GroupOfCards {
    public DeckOfCards() {
        super(52);
        for (CardRank rank : CardRank.values()) {
            for (CardSuit suit : CardSuit.values()) {
                cards.add(new Card(rank, suit));
            }
        }
    }
    
    public void shuffle() {
        Collections.shuffle(cards);
    }
    
    public void dealCards(Player player1, Player player2) {
        for (int i = 0; i < cards.size(); i += 2) {
            player1.addCard(cards.get(i));
            player2.addCard(cards.get(i + 1));
        }
    }
}
