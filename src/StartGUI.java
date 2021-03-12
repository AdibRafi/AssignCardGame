import Function.Card;
import Function.Player;
import GUI.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class StartGUI extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        // GUI STAGE 1
        String[] name = stage1.display();
        Player p1 = new Player(name[0]);
        Player p2 = new Player(name[1]);
        Player p3 = new Player(name[2]);


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
        int round = 0;
        for (int i = 0; i < 3; i++) {
            round++;
            stage2.display3Player(name,p1.changeQueueToArray(p1.getPlayerCardsQueue())
                    ,p2.changeQueueToArray(p2.getPlayerCardsQueue())
                    ,p3.changeQueueToArray(p3.getPlayerCardsQueue()),round);

            String[] fiveElementP1 = p1.return5Queue();
            String[] fiveElementP2 = p2.return5Queue();
            String[] fiveElementP3 = p3.return5Queue();

            int[] winner = stage3.display3Player(name,fiveElementP1,fiveElementP2
                    ,fiveElementP3,i+1);
            p1.addValue(winner[0]);
            p2.addValue(winner[1]);
            p3.addValue(winner[2]);

            int[] currentScore = {p1.getPlayerScore()
            , p2.getPlayerScore(), p3.getPlayerScore()};
            stage4.display3Player(name,currentScore);
        }
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
        stage5.displayProceed(donePhaseName.get(0),donePhaseName.get(1));

        Player p4 = new Player(donePhaseName.get(0));
        Player p5 = new Player(donePhaseName.get(1));
        p4.addValue(donePhaseScore.get(0));
        p5.addValue(donePhaseScore.get(1));
        name = new String[]{donePhaseName.get(0),donePhaseName.get(1)};

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
        round = 0;
        for (int i = 0; i < 4; i++) {
            round++;
            stage2.display2Player(name,p4.changeSetToArray(p4.getPlayerCardsSet())
            ,p5.changeSetToArray(p5.getPlayerCardsSet()),round);

            String[] fiveElementP4 = p4.return5Set();
            String[] fiveElementP5 = p5.return5Set();

            int[] winner = stage3.display2Player(name,fiveElementP4,fiveElementP5,round);
            p4.addValue(winner[0]);
            p5.addValue(winner[1]);

            int[] currentScore = {p4.getPlayerScore(),p5.getPlayerScore()};
            stage4.display2Player(name,currentScore);
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

        stage5.displayWinner(donePhaseName.get(0));

    }

}
