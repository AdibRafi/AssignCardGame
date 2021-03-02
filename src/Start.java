import Function.Card;
import Function.Player;

import java.util.Arrays;

public class Start {
    public static void main(String[] args) {
        // Contoh data from slide
        //3 players
        String[] cards1 = {"c5","s6","sK","dA","cK","h5","h3","dJ","d8","s7","cX","c2","h4","hA","d2","hJ","hX","s2"};
        String[] cards2 = {"d4","h7","c4","cQ","sA","d5","s3","d3","h2","h8","c9","hK","d6","sJ","sX","s8","d7"};
        String[] cards3 = {"cA","dX","h6","dQ","d9","c8","h9","hQ","sQ","cJ","dK","c6","s9","s4","c7","s5","c3"};
        //2 players
        String[] cards4 ={"hQ","dX","h7","c2","cX","h4","d6","c5","s5","h9","cA","c7","d7"
                ,"d8","d9","cK","c3","dA","c6","d4","c4","s3","hA","hX","dK","dQ"};
        String[] cards5 = {"h6","hJ","c8","sJ","hK","s4","h5","dJ","s7","sA","h3","d5","d3","sQ","c9","d2"
                ,"s8","h8","s9","cQ","cJ","h2","s2","s6","sX","sK"};

        //start loop here
        //kerja adam to return the fiveElement from original
        String[] fiveElement1 = {"c5","s6","sK","dA","cK"}; //card1
        String[] fiveElement2 = {"d4","h7","c4","cQ","sA"};
        String[] fiveElement3 = {"cA","dX","h6","dQ","d9"};


        // START 3 PLAYER PHASE (GUNA QUEUE)
        Player p1 = new Player("adib");
        Player p2 = new Player("adam");
        Player p3 = new Player("darwisy");
        //display Available cards 3 Player


        //display cards in hand
        int x = Card.getValueFromCard(fiveElement1);
        int y = Card.getValueFromCard(fiveElement2);
        int z = Card.getValueFromCard(fiveElement3);
        int max = Math.max(x,Math.max(y,z));
        String displayX = String.format("%-8s : %s | Point = %s",p1.getPlayerName(),
                Arrays.toString(fiveElement1),x);
        String displayY = String.format("%-8s : %s | Point = %s",p2.getPlayerName(),
                Arrays.toString(fiveElement2),y);
        String displayZ = String.format("%-8s : %s | Point = %s",p3.getPlayerName(),
                Arrays.toString(fiveElement3),z);

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

        System.out.println("p1 value = "+p1.getPlayerScore());
        System.out.println("p2 value = "+p2.getPlayerScore());
        System.out.println("p3 value = "+p3.getPlayerScore());

        // START 2 PLAYER (GUNA SET)
        //contoh menang
        String[] menang = {"adam","10","darwisy","12"};
        Player p4 = new Player(menang[0]);
        Player p5 = new Player(menang[2]);
        p4.addValue(Integer.parseInt(menang[1]));
        p5.addValue(Integer.parseInt(menang[3]));
        //display available cards

        //display cards at hand
        x = Card.getValueFromCard(fiveElement1);
        y = Card.getValueFromCard(fiveElement2);
        max = Math.max(x,y);
        displayX = String.format("%-8s : %s | Point = %s",p4.getPlayerName(),
                Arrays.toString(fiveElement1),x);
        displayY = String.format("%-8s : %s | Point = %s",p5.getPlayerName(),
                Arrays.toString(fiveElement2),y);

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

        System.out.println("p4 value = "+p4.getPlayerScore());
        System.out.println("p5 value = "+p5.getPlayerScore());

    }
}
