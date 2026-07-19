import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();

        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    // Shuffle the deck
    public void shuffle() {
        Collections.shuffle(cards);
    }

    // Pop top card
    public Card popCard() {
        if (cards.isEmpty())
            throw new RuntimeException("Deck is empty");

        return cards.remove(0);
    }

    // Remaining cards
    public int size() {
        return cards.size();
    }

    // Distribute cards equally
    public void distribute(List<Player> players, int cardsPerPlayer) {

        for (int i = 0; i < cardsPerPlayer; i++) {

            for (Player player : players) {

                if (cards.isEmpty())
                    return;

                player.addCard(popCard());
            }
        }
    }
}
