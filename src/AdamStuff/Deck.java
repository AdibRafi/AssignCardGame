
import java.util.Scanner;

public class Deck {
    public static void main(String[] args) {
        int CARDS_PER_PLAYER1 = 18;
        int CARDS_PER_PLAYER2 = 17;
        int CARDS_PER_PLAYER3 = 17;

        int PLAYERS1 = 1;
        int PLAYERS2AND3 = 2;



        for(int i = 0; i < PLAYERS1; i++) {
            System.out.println("Enter Player Name: ");
            Scanner input = new Scanner(System.in);
            String player1 = input.next();
        }

        for(int i = 0; i < PLAYERS2AND3; i++) {
            System.out.println("Enter Player Name: ");
            Scanner input = new Scanner(System.in);
            String player2 = input.next();
        }

        String[] SUITS = {
                "c", "d", "h", "s"
        };

        String[] RANKS = {
                "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "J", "Q", "K", "A"
        };

        int n = SUITS.length * RANKS.length;

        // initialize deck
        String[] deck = new String[n];
        for (int i = 0; i < RANKS.length; i++) {
            for (int j = 0; j < SUITS.length; j++) {
                deck[SUITS.length * i + j] = SUITS[j] + RANKS[i];
            }
        }

        // shuffle
        for (int i = 0; i < n; i++) {
            int r = i + (int) (Math.random() * (n - i));
            String temp = deck[r];
            deck[r] = deck[i];
            deck[i] = temp;
        }

        System.out.println("player 1 cards");
        for (int i = 0; i < PLAYERS1 * CARDS_PER_PLAYER1; i++) {
            System.out.println(deck[i]);
            if (i % CARDS_PER_PLAYER1 == CARDS_PER_PLAYER1 - 1)
                System.out.println();
        }

        System.out.println("player 2 cards");

        for (int j = 0; j < PLAYERS2AND3 * CARDS_PER_PLAYER2; j++) {
            System.out.println(deck[j]);
            if (j % CARDS_PER_PLAYER2 == CARDS_PER_PLAYER2 - 1)
                System.out.println();
        }
    }
}


