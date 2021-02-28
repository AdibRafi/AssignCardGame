package Function;

public class Card {
    public static String[] shuffleCards(String[] cards){
        for (int i = 0; i < cards.length; i++) {
            int r = i + (int) (Math.random() * (cards.length-i));
            String temp = cards[r];
            cards[r] = cards[i];
            cards[i] = temp;
        }
        return cards;
    }
}
