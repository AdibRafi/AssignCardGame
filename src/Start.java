import Function.Card;
import Function.Player;

import java.lang.reflect.Array;
import java.util.*;

public class Start {
    public static void main(String[] args) {
        // Contoh data from slide
        //3 players
//        String[] cards1 = {"c5","s6","sK","dA","cK","h5","h3","dJ","d8","s7","cX","c2","h4","hA","d2","hJ","hX","s2"};
//        String[] cards2 = {"d4","h7","c4","cQ","sA","d5","s3","d3","h2","h8","c9","hK","d6","sJ","sX","s8","d7"};
//        String[] cards3 = {"cA","dX","h6","dQ","d9","c8","h9","hQ","sQ","cJ","dK","c6","s9","s4","c7","s5","c3"};
//        //2 players
//        String[] cards4 ={"hQ","dX","h7","c2","cX","h4","d6","c5","s5","h9","cA","c7","d7"
//                ,"d8","d9","cK","c3","dA","c6","d4","c4","s3","hA","hX","dK","dQ"};
//        String[] cards5 = {"h6","hJ","c8","sJ","hK","s4","h5","dJ","s7","sA","h3","d5","d3","sQ","c9","d2"
//                ,"s8","h8","s9","cQ","cJ","h2","s2","s6","sX","sK"};
//
//        //start loop here
//        //kerja adam to return the fiveElement from original
//        String[] fiveElement1 = {"c5","s6","sK","dA","cK"}; //card1
//        String[] fiveElement2 = {"d4","h7","c4","cQ","sA"};
//        String[] fiveElement3 = {"cA","dX","h6","dQ","d9"};


        // START 3 PLAYER PHASE (GUNA QUEUE)
        // STEP 1 (GETTING NAME)

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the game lol");
        System.out.println("Enter ur name ok?");
        System.out.println();

        System.out.println("Player 1:");
        String nameP1 = input.nextLine();

        System.out.println("Player 2:");
        String nameP2 = input.nextLine();

        System.out.println("Player 3:");
        String nameP3 = input.nextLine();


        Player p1 = new Player(nameP1);
        Player p2 = new Player(nameP2);
        Player p3 = new Player(nameP3);

        String[] fullcard = Card.getDeckOfCards();

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

        p1.distributeCardsQueue(cardsToGiveP1);
        p2.distributeCardsQueue(cardsToGiveP2);
        p3.distributeCardsQueue(cardsToGiveP3);

        System.out.println("******************");
        System.out.println("* 3-Player Phase *");
        System.out.println("******************");

        for (int i = 0; i < 3; i++) {
            // STEP 2 DISPLAY ALL CARDS YG ADA
            String userInput;
            do {
                System.out.print("ROUND ");
                System.out.println(i+1);
                System.out.println("Available Cards:");
                System.out.printf("%-8s: %s\n", p1.getPlayerName(), p1.displayQueue());
                System.out.printf("%-8s: %s\n", p2.getPlayerName(), p2.displayQueue());
                System.out.printf("%-8s: %s\n", p3.getPlayerName(), p3.displayQueue());
                System.out.println("\n");
                System.out.println("Press S to Shuffle or Enter to start");
                userInput = input.nextLine();
                if ("s".equals(userInput)) {
                    p1.shuffleQueue();
                    p2.shuffleQueue();
                    p3.shuffleQueue();
                }
            } while (!userInput.equals(""));

            // STEP 3 SHOW 5 ELEMENT
            int x,y,z,max;
            String displayX,displayY,displayZ;
            String[] fiveElementP1 = p1.return5Queue();
            String[] fiveElementP2 = p2.return5Queue();
            String[] fiveElementP3 = p3.return5Queue();

            System.out.print("ROUND ");
            System.out.println(i+1);
            System.out.println("Cards at Hand: ");
            x = Card.getValueFromCard(fiveElementP1);
            y = Card.getValueFromCard(fiveElementP2);
            z = Card.getValueFromCard(fiveElementP3);
            max = Math.max(x,Math.max(y,z));
            displayX = String.format("%-8s : %s | Point = %s",p1.getPlayerName(),
                    Arrays.toString(fiveElementP1),x);
            displayY = String.format("%-8s : %s | Point = %s",p2.getPlayerName(),
                    Arrays.toString(fiveElementP2),y);
            displayZ = String.format("%-8s : %s | Point = %s",p3.getPlayerName(),
                    Arrays.toString(fiveElementP3),z);

            if (max == x) {
                displayX += " | Win";
                p1.addValue(x);
            }
            if (max == y){
                displayY += " | Win";
                p2.addValue(y);
            }
            if (max == z) {
                displayZ += " | Win";
                p3.addValue(z);
            }

            System.out.println(displayX);
            System.out.println(displayY);
            System.out.println(displayZ);

            System.out.println("Press Enter to continue");
            input.nextLine();

            //STEP 4 BAGI SCORE
            System.out.println(p1.getPlayerName() + " = " + p1.getPlayerScore());
            System.out.println(p2.getPlayerName() + " = " + p2.getPlayerScore());
            System.out.println(p3.getPlayerName() + " = " + p3.getPlayerScore());
            System.out.println("Press Enter to continue");
            input.nextLine();
        }

        //STEP 5 cari sapa menang
        ArrayList<Integer> donePhaseScore = new ArrayList<>();
        donePhaseScore.add(p1.getPlayerScore());
        donePhaseScore.add(p2.getPlayerScore());
        donePhaseScore.add(p3.getPlayerScore());

        ArrayList<String> donePhaseName = new ArrayList<>();
        donePhaseName.add(p1.getPlayerName());
        donePhaseName.add(p2.getPlayerName());
        donePhaseName.add(p3.getPlayerName());


        int minValue=donePhaseScore.get(0);
        int index = 0;
        for (int i = 0; i < 3; i++) {
            if (donePhaseScore.get(i) < minValue) {
                minValue = donePhaseScore.get(i);
                index=i;
            }
        }
        donePhaseName.remove(index);
        donePhaseScore.remove(index);

        System.out.println(donePhaseName.get(0) +" and "+donePhaseName.get(1)+
                " proceed to 2-Player phase");
        System.out.println("Press enter to continue");
        input.nextLine();

        //START PHASE 2
        Player p4 = new Player(donePhaseName.get(0));
        Player p5 = new Player(donePhaseName.get(1));
        p4.addValue(donePhaseScore.get(0));
        p5.addValue(donePhaseScore.get(1));

        flc = new LinkedList<>(Arrays.asList(fullcard));

        flc = Card.shuffleQueue(flc);

        String[] cardsToGiveP4 = new String[26];
        String[] cardsToGiveP5 = new String[26];

        for (int i = 0; i < 26; i++) {
            cardsToGiveP4[i] = flc.remove();
        }

        for (int i = 0; i < 26; i++) {
            cardsToGiveP5[i] = flc.remove();
        }

        p4.distributeCardsSet(cardsToGiveP4);
        p5.distributeCardsSet(cardsToGiveP5);

        System.out.println("******************");
        System.out.println("* 2-Player Phase *");
        System.out.println("******************");

        for (int i = 0; i < 4; i++) {
            // STEP 2 DISPLAY ALL CARDS YG ADA
            String userInput;
            do {
                System.out.print("ROUND ");
                System.out.println(i+1);
                System.out.println("Available Cards:");
                System.out.printf("%-8s: %s\n", p4.getPlayerName(), p4.displaySet());
                System.out.printf("%-8s: %s\n", p5.getPlayerName(), p5.displaySet());
                System.out.println("\n");
                System.out.println("Press S to Shuffle or Enter to start");
                userInput = input.nextLine();
                if ("s".equals(userInput)) {
                    p4.shuffleSet();
                    p5.shuffleSet();
                }
            } while (!userInput.equals(""));

            // STEP 3 SHOW 5 ELEMENT
            int x,y,z,max;
            String displayX,displayY,displayZ;
            String[] fiveElementP4 = p4.return5Set();
            String[] fiveElementP5 = p5.return5Set();

            System.out.print("ROUND ");
            System.out.println(i+1);
            System.out.println("Cards at Hand: ");
            x = Card.getValueFromCard(fiveElementP4);
            y = Card.getValueFromCard(fiveElementP5);
            max = Math.max(x,y);
            displayX = String.format("%-8s : %s | Point = %s",p4.getPlayerName(),
                    Arrays.toString(fiveElementP4),x);
            displayY = String.format("%-8s : %s | Point = %s",p5.getPlayerName(),
                    Arrays.toString(fiveElementP5),y);

            if (max == x) {
                displayX += " | Win";
                p4.addValue(x);
            }
            if (max == y){
                displayY += " | Win";
                p5.addValue(y);
            }

            System.out.println(displayX);
            System.out.println(displayY);

            System.out.println("Press Enter to continue");
            input.nextLine();

            //STEP 4 BAGI SCORE
            System.out.println(p4.getPlayerName() + " = "+p4.getPlayerScore());
            System.out.println(p5.getPlayerName() + " = "+p5.getPlayerScore());
            System.out.println("Press Enter to continue");
            input.nextLine();
        }
        donePhaseScore = new ArrayList<>();
        donePhaseScore.add(p4.getPlayerScore());
        donePhaseScore.add(p5.getPlayerScore());

        donePhaseName = new ArrayList<>();
        donePhaseName.add(p4.getPlayerName());
        donePhaseName.add(p5.getPlayerName());

        minValue=donePhaseScore.get(0);
        index = 0;
        for (int i = 0; i < 2; i++) {
            if (donePhaseScore.get(i) < minValue) {
                minValue = donePhaseScore.get(i);
                index=i;
            }
        }
        donePhaseName.remove(index);
        donePhaseScore.remove(index);

        System.out.println("OMG");
        System.out.println(donePhaseName.get(0)+" MENANG");


//        // START 2 PLAYER (GUNA SET)
//        //contoh menang
//        String[] menang = {"adam","10","darwisy","12"};
//        Player p4 = new Player(menang[0]);
//        Player p5 = new Player(menang[2]);
//        p4.addValue(Integer.parseInt(menang[1]));
//        p5.addValue(Integer.parseInt(menang[3]));
//
//        //display available cards
//        Set<String> dispAvailableCard = new LinkedHashSet<>();
//        p4.distributeCardsSet(cards1);
//
//
//        //display cards at hand
//        x = Card.getValueFromCard(fiveElement1);
//        y = Card.getValueFromCard(fiveElement2);
//        max = Math.max(x,y);
//        displayX = String.format("%-8s : %s | Point = %s",p4.getPlayerName(),
//                Arrays.toString(fiveElement1),x);
//        displayY = String.format("%-8s : %s | Point = %s",p5.getPlayerName(),
//                Arrays.toString(fiveElement2),y);
//
//        if (max == x) {
//            displayX += " | Win";
//            p4.addValue(x);
//        }
//        if (max == y){
//            displayY += " | Win";
//            p5.addValue(y);
//        }
//
//        System.out.println(displayX);
//        System.out.println(displayY);
//
//        System.out.println("p4 value = "+p4.getPlayerScore());
//        System.out.println("p5 value = "+p5.getPlayerScore());
//
    }
}
