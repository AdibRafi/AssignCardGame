package rjdThings;

import java.util.Random;

public class Cards {
    final int NoCardsInFullPack = 52;

    // properties
    Card[] cards;
    int valid; // number of cards currently in collection

    // constructors
    public Cards(boolean fullPack) {
        cards = new Card[NoCardsInFullPack];
        valid = 0;

        if (fullPack)
            createFullPackOfCards();
    }

    // methods
    public Card getTopCard() {
        Card tmp;

        if (valid <= 0)
            return null;
        else {
            valid--;
            tmp = cards[valid];
            cards[valid] = null;
            return tmp;
        }
    }

    public boolean addTopCard(Card c) {
        if (valid < cards.length) {
            cards[valid] = c;   // SHOULD THİS BE CLONED??
            valid++;
            return true;
        }
        return false;
    }

    private void createFullPackOfCards() {
        //

        for(int i = 0; i<52;i++){
            addTopCard(new Card(i));
        }
    }


    public void shuffle() {
        Random rGen = new Random();  // Random number generator

        for (int i=0; i<cards.length; i++) {
            int randomPosition = rGen.nextInt(cards.length);
            Card temp = cards[i];
            cards[i] = cards[randomPosition];
            cards[randomPosition] = temp;
        }
        //
    }

    // For testOnly...
    public void testOnlyPrint() {
        for (int i = 0; i < valid; i++) {
            System.out.println(cards[i]);
        }
    }

}