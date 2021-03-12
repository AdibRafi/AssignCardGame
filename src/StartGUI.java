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

        stage2.display3Player(name,p1.changeQueueToArray(p1.getPlayerCardsQueue())
                ,p2.changeQueueToArray(p2.getPlayerCardsQueue())
                ,p3.changeQueueToArray(p3.getPlayerCardsQueue()));
    }
}
