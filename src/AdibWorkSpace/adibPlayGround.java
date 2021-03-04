package AdibWorkSpace;

// import benda dlm package Function
import Function.Card;
import Function.Game;
import Function.Player;

import java.util.*;


public class adibPlayGround {
    public static void main(String[] args) {
        Player p1 = new Player("adib");
        Player p2 = new Player("adam");
        Player p3 = new Player("darwisy");

        String[] cards1 = {"c5","s6","sK","dA","cK","h5","h3","dJ","d8","s7","cX","c2","h4","hA","d2","hJ","hX","s2"};
        String[] cards2 = {"d4","h7","c4","cQ","sA","d5","s3","d3","h2","h8","c9","hK","d6","sJ","sX","s8","d7"};
        String[] cards3 = {"cA","dX","h6","dQ","d9","c8","h9","hQ","sQ","cJ","dK","c6","s9","s4","c7","s5","c3"};
        String[] fiveElement1 = {"c5","s6","sK","dA","cK"};
        String[] fiveElement2 = {"d4","h7","c4","cQ","sA"};
        String[] fiveElement3 = {"cA","dX","h6","dQ","d9"};

        int index = 0;
        int[] test = {12,3,4};
        int min = test[0];

        for (int i = 0; i < 3; i++) {
            if (test[i] < min) {
                min = test[i];
                index=i;
            }
        }
        System.out.println(min);
        System.out.println(index);

//        Set<String> x = new LinkedHashSet<>(Arrays.asList(fiveElement1));
//        String[] nice = new String[5];
//        for (int i = 0; i < 5; i++) {
//            nice[i] = x.iterator().next();
//            x.remove(x.iterator().next());
//        }
//        System.out.println(Arrays.toString(nice));
//        System.out.println(x);






//        String[] testje = getDeckOfCards();
//        Queue<String> l = new LinkedList<>(Arrays.asList(testje));
//        String[] cardsToGiveForP1 = new String[18];
//        String[] cardsToGiveForP2 = new String[17];
//        String[] cardsToGiveForP3 = new String[17];
//
//        for (int i = 0; i < 18; i++) {
//            cardsToGiveForP1[i] = l.remove();
//        }
//        for (int i = 0; i < 17; i++) {
//            cardsToGiveForP2[i] = l.remove();
//        }
//        for (int i = 0; i < 17; i++) {
//            cardsToGiveForP3[i] = l.remove();
//        }
//        p1.distributeCardsQueue(cardsToGiveForP1);
//        p1.distributeCardsQueue(cardsToGiveForP2);
//        p1.distributeCardsQueue(cardsToGiveForP3);

//        p1.distributeCardsQueue(cards1);
//        p1.shuffleQueue();
//        System.out.println(p1.displayQueue());
//        p1.removeCardsQueue();
//        System.out.println(p1.displayQueue());
//
//        p2.distributeCardsSet(cards2);
//        p2.shuffleSet();
//        System.out.println(p2.displaySet());
//        p2.removeCardsSet(fiveElement2);
//        System.out.println(p2.displaySet());

// ARCHIVE
//        String[] test = {"c2","c3","d4","dA","sK","cA"};
//        String[] deleteTest = {"c3","dA","sK"};
//        Set<String> x = new HashSet<>(Arrays.asList(test));
//        Set<String> y = new HashSet<>(Arrays.asList(deleteTest));
//        Queue<String> a = new LinkedList<>(Arrays.asList(test));
//        Queue<String> b = new LinkedList<>(Arrays.asList(deleteTest));
//        System.out.println(x);
//        x = Card.shuffleSet(x);
//        System.out.println(x);



//        System.out.println(a);
//        a = Card.shuffleQueue(a);
//        System.out.println(a);

    }
    private static String[] getDeckOfCards() {
        ArrayList<String> deckOfCards = new ArrayList<>();

        String[] suits = {"d", "c", "h", "s"};
        String[] ranks = {"K", "Q", "J", "X", "9", "8", "7", "6", "5", "4", "3", "2", "A"};

        for (String suit : suits) {
            for (String rank : ranks) {
                deckOfCards.add(suit + rank);
            }
        }
        String[] result = new String[deckOfCards.size()];
        for (int i = 0; i < deckOfCards.size(); i++) {
            result[i] = deckOfCards.get(i);
        }
        return result;
    }
}


