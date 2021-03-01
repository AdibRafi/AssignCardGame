package rjdThings;

public class Card {
    final String[] SUITS = { "Hearts", "Diamonds", "Spades", "Clubs" };
    final String[] FACES = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };

    final int NoCardsInSuit = 13;

    // properties
    int cardNo;

    // constructors
    public Card(int faceValue, int suit) {
        cardNo = faceValue + suit * NoCardsInSuit;
    }

    public Card(int cardNumber) {
        cardNo = cardNumber;
    }

    public int getFaceValue() {
        return cardNo % NoCardsInSuit;
    }

    public int getSuit() {
        return cardNo / NoCardsInSuit;
    }

    public String toString() {
        return FACES[getFaceValue()] + " of " + SUITS[getSuit()];
    }

    public boolean equals(Card c) {
        boolean res;
        if (getFaceValue() == c.getFaceValue() && getSuit() == c.getSuit()) {
            res = true;
        } else
            res = false;
        return res;
    }

    public int compareTo(Card c) {
        if(getFaceValue()==c.getFaceValue())
            return 0;
        else if (getFaceValue()>c.getFaceValue())
            return 1;
        else
            return 2;
    }
}
