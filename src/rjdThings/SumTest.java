/*
package rjdThings;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SumTest {

    public static final int NUM_CARDS = 4;

    public static void main(String[] args) {
        Deck deck = new Deck();
        List<Card> hand = new ArrayList<>();
        int score = 0;
        for (int i = 0; i < NUM_CARDS; ++i) {
            Card card = deck.deal();
            hand.add(card);
            score += card.getRank().getValue();
        }
        System.out.println(hand);
        System.out.println(score);
    }
}


enum SUIT {
    CLUB, DIAMOND, HEART, SPADE;
}

enum RANK {
    ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13);

    private final int value;

    RANK(int value) { this.value = value; }

    public int getValue() {
        return value;
    }
}

class Card implements Comparable<Card> {
    private final SUIT suit;
    private final RANK rank;

    public Card(SUIT suit, RANK rank) {
        if (suit == null) throw new IllegalArgumentException("suit cannot be null");
        if (rank == null) throw new IllegalArgumentException("rank cannot be null");
        this.suit = suit;
        this.rank = rank;
    }

    public SUIT getSuit() {
        return suit;
    }

    public RANK getRank() {
        return rank;
    }

    @Override
    public int compareTo(Card other) {
        if (this.getRank().equals(other.getRank())) {
            return this.getSuit().compareTo(other.getSuit());
        } else {
            return this.getRank().getValue() - other.getRank().getValue();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        return suit == card.suit && rank == card.rank;
    }

    @Override
    public int hashCode() {
        int result = suit.hashCode();
        result = 31 * result + rank.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Card{");
        sb.append("suit=").append(suit);
        sb.append(", rank=").append(rank);
        sb.append('}');
        return sb.toString();
    }
}

class Deck {
    private List<Card> deck;
    private Random random;

    public Deck() {
        this.init();
        this.random = new Random();
    }

    public Deck(long seed) {
        this.init();
        this.random = new Random(seed);
    }

    private void init() {
        this.deck = new ArrayList<Card>();
        for (SUIT suit: SUIT.values()) {
            for (RANK rank: RANK.values()) {
                this.deck.add(new Card(suit, rank));
            }
        }
    }

    public Card deal() { return this.deal(true); }

    public Card deal(boolean removeCard) {
        int value = this.random.nextInt(this.deck.size());
        return removeCard ? this.deck.remove(value) : this.deck.get(value);
    }

}
*/
