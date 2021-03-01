package AdibWorkSpace;

// import benda dlm package Function
import Function.Card;
import Function.Game;
import Function.Player;

import java.util.*;

public class adibPlayGround {
    public static void main(String[] args) {
        //todo tukar the main array into set<String>

        //todo from array adam of all cards -> masuk dlm playerCards
        // in Game (kena guna Set<String>)

        String[] test = {"c2","c3","d4","dA","sK","cA"};
        String[] deleteTest = {"c3","dA","sK"};
        Set<String> s = new TreeSet<>(Arrays.asList(test));
        Set<String> d = new HashSet<>(Arrays.asList(deleteTest));
        Player p1 = new Player("adib",s);
        p1.removeCardsFromPlayers(p1.PlayerCards(),d);
        System.out.println(p1);
    }
}
