package rjdThings;

import java.util.ArrayList;

public class Score {
    // properties
    int[] scores;

    // constructors
    public Score(int noOfPlayers) {
        scores = new int[noOfPlayers];

        // init all scores to zero
        for (int i = 0; i < scores.length; i++)
            scores[i] = 0;
    }

    // methods
    public int getScore(int playerNo) {
        return scores[playerNo];
    }

    public void update(int playerNo, int amount) {
        scores[playerNo] += amount;
    }

    public String toString() {
        String s;
        s = "\n" + "_____________\n" + "\nPlayer\tScore\n" + "_____________\n";

        for (int playerNo = 0; playerNo < scores.length; playerNo++) {
            s = s + (playerNo+1) + "\t" + scores[playerNo] + "\n";
        }

        s += "_____________\n";
        return s;
    }

    public int[] getWinners() {
        //
        int maxScore = 0;
        int[] winners;
        ArrayList<Integer> win = new ArrayList<Integer>();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] > maxScore) {
                maxScore = scores[i];
            }

        }

        for (int j = 0; j < scores.length; j++) {
            if (maxScore == scores[j]) {
                win.add(j);
            }
        }

        winners = new int[win.size()];
        for (int i = 0; i < winners.length; i++) {
            winners[i] = win.get(i);
        }

        return winners;

    }

}
