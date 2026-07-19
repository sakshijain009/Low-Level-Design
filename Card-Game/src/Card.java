public class Card {
    private final Suit suit;
    private final Rank rank;
    private final Color color;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;

        if (suit == Suit.HEARTS || suit == Suit.DIAMONDS)
            this.color = Color.RED;
        else
            this.color = Color.BLACK;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
