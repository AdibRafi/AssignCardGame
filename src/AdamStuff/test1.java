package AdamStuff;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import Function.Player;
import Function.Card;

public class test1 {
    public static void main(String[] args) {

        //3 Player Phase
        String[] fullcard = Dealer.getDeckOfCards();

        Player P1 = new Player("Adib");
        Player P2 = new Player("Adam");
        Player P3 = new Player("Hensem");

        Queue<String> flc = new LinkedList<>(Arrays.asList(fullcard));
        String[] cardsToGiveP1 = new String[18];
        String[] cardsToGiveP2 = new String[17];
        String[] cardsToGiveP3 = new String[17];

        flc = Card.shuffleQueue(flc);

        for (int i = 0; i < 18; i++) {
            cardsToGiveP1[i] = flc.remove();
        }

        for (int i = 0; i < 17; i++) {
            cardsToGiveP2[i] = flc.remove();
        }

        for (int i = 0; i < 17; i++) {
            cardsToGiveP3[i] = flc.remove();
        }

        P1.distributeCardsQueue(cardsToGiveP1);
        P2.distributeCardsQueue(cardsToGiveP2);
        P3.distributeCardsQueue(cardsToGiveP3);

        System.out.println(P1.displayQueue());
        System.out.println(P2.displayQueue());
        System.out.println(P3.displayQueue());

        // 2 Player Phase
        fullcard = Dealer.getDeckOfCards();

        Player P4 = new Player("Adib");
        Player P5 = new Player("Adam");

        flc = new LinkedList<>(Arrays.asList(fullcard));
        String[] cardsToGiveP4 = new String[26];
        String[] cardsToGiveP5 = new String[26];


        flc = Card.shuffleQueue(flc);

        for (int i = 0; i < 26; i++) {
            cardsToGiveP4[i] = flc.remove();
        }

        for (int i = 0; i < 26; i++) {
            cardsToGiveP5[i] = flc.remove();
        }

        P4.distributeCardsSet(cardsToGiveP4);
        P5.distributeCardsSet(cardsToGiveP5);

        System.out.println(P4.displaySet());
        System.out.println(P5.displaySet());

        String[] testje = {"sK","sX","d5","c4","s9"};
        int result = Card.getValueFromCard(testje);
        System.out.println(result);
    }
}
