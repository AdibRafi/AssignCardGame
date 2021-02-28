package AdibWorkSpace;

public class adibDeckOfCards {
    public static void start() {
        String[] logos = {
                "c", "d", "h", "s"
        };

        String[] numbers = {
                "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "J", "Q", "K", "A"
        };

        // create a new deck
        int n = logos.length * numbers.length;
        String[] deck = new String[n];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < logos.length; j++) {
                deck[logos.length*i + j] = logos[j] + numbers[i];
            }
        }

        // shuffle the deck
        for (int i = 0; i < n; i++) {
            int r = i + (int) (Math.random() * (n-i));
            String temp = deck[r];
            deck[r] = deck[i];
            deck[i] = temp;
        }

        // print shuffled deck
        for (int i = 0; i < n; i++) {
            System.out.print(deck[i]+" ");
        }
    }

}