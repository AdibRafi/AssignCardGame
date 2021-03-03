package AdamStuff;

import java.util.Comparator;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import Function.Player;
import Function.Card;

public class test1{
    public static void main(String[] args) {

//        // 2 Player Phase
//        String[] fullcard = Dealer.getDeckOfCards();
//
//        Player P4 = new Player("Adam");
//        Player P5 = new Player("Adib");
//
//        Queue<String> flc = new LinkedList<>(Arrays.asList(fullcard));
//
//        flc = Card.shuffleQueue(flc);
//
//        String[] cardsToGiveP4 = new String[26];
//        String[] cardsToGiveP5 = new String[26];
//
//        for (int i = 0; i < 26; i++) {
//            cardsToGiveP4[i] = flc.remove();
//        }
//
//        for (int i = 0; i < 26; i++) {
//            cardsToGiveP5[i] = flc.remove();
//        }
//
//        P4.distributeCardsSet(cardsToGiveP4);
//        P5.distributeCardsSet(cardsToGiveP5);
//
//        System.out.println(P4.displaySet());
//        System.out.println(P5.displaySet());
//
//
//        String[] test1 = P4.return5Set();
//        System.out.println(Arrays.toString(test1));
//
//        String[] test2 = P5.return5Set();
//        System.out.println(Arrays.toString(test2));
//
//        System.out.println(P4.displaySet());
//        System.out.println(P5.displaySet());

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

        String[] test1 = P1.return5Queue();
        System.out.println(Arrays.toString(test1));

        String[] test2 = P2.return5Queue();
        System.out.println(Arrays.toString(test2));

        String[] test3 = P3.return5Queue();
        System.out.println(Arrays.toString(test3));

        System.out.println(P1.displayQueue());
        System.out.println(P2.displayQueue());
        System.out.println(P3.displayQueue());

//        // 2 Player Phase
//        fullcard = Dealer.getDeckOfCards();
//
//        Player P4 = new Player("Adib");
//        Player P5 = new Player("Adam");
//
//        flc = new LinkedList<>(Arrays.asList(fullcard));
//        String[] cardsToGiveP4 = new String[26];
//        String[] cardsToGiveP5 = new String[26];
//
//
//        flc = Card.shuffleQueue(flc);
//
//        for (int i = 0; i < 26; i++) {
//            cardsToGiveP4[i] = flc.remove();
//        }
//
//        for (int i = 0; i < 26; i++) {
//            cardsToGiveP5[i] = flc.remove();
//        }
//
//        P4.distributeCardsSet(cardsToGiveP4);
//        P5.distributeCardsSet(cardsToGiveP5);
//
//        System.out.println(P4.displaySet());
//        System.out.println(P5.displaySet());
//
//        String[] test1 = P1.return5Queue();
//        System.out.println(Arrays.toString(test1));
//
//        String[] test2 = P2.return5Queue();
//        System.out.println(Arrays.toString(test2));
//
//        String[] test3 = P3.return5Queue();
//        System.out.println(Arrays.toString(test3));

//        String[] testje = {"sK","sX","d5","c4","s9"};
//        int result = Card.getValueFromCard(testje);
//        System.out.println(result);

//        String[] newHandP1 = new String[5];
//        String[] newHandP2 = new String[5];
//        String[] newHandP3 = new String[5];

//        for (int i = 0; i < 5; i++) {
//            newHandP1[i] = P1.getPlayerCardsQueue().remove();
//        }
//        Arrays.sort(newHandP1, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareTo(o2);
//            }
//        });
//
//        String[] first5ElementP1 = new String[5];
//        for(int i = 0; i < 5; i++){
//            first5ElementP1[i] = newHandP1[i];
//        }
//        System.out.println(Arrays.toString(first5ElementP1));

//        for (int i = 0; i < 5; i++) {
//            newHandP2[i] = P2.getPlayerCardsQueue().remove();
//        }
//        Arrays.sort(newHandP2, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareTo(o2);
//            }
//        });
//
//        for(String str:newHandP2){
//            System.out.println(str);
//        }
//
//        for (int i = 0; i < 5; i++) {
//            newHandP3[i] = P3.getPlayerCardsQueue().remove();
//        }
//        Arrays.sort(newHandP3, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareTo(o2);
//            }
//        });
//
//        for(String str:newHandP3){
//            System.out.println(str);
//        }
    }
}
