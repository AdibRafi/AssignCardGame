package rjdThings;

import java.util.ArrayList;

public class CardGame {
    // properties
    Cards fullPack;
    ArrayList<Player> players;
    Score scoreCard;
    Cards[] cardsOnTable = [];
    int roundNo;
    int turnOfPlayer;

    // constructors
    public CardGame(Player p1, Player p2, Player p3) {
        players = new ArrayList<Player>();
        players.add(p1);
        players.add(p2);
        players.add(p3);
    }

    // methods
    public boolean playTurn(Player p, Card c) {


        if (!isTurnOf(p) || isGameOver()) {
            return false;
        } else {

            cardsOnTable[getTurnOfPlayerNo() - 1].addTopCard(c);

            if (roundNo % 4 == 3) {
                updateScores();
            }

            if (roundNo < 51)
                roundNo++;

            return true;
        }
    }

    private void updateScores() {
        Card max = new Card(0);

        for (int i = 0; i < scoreCard.scores.length - 1; i++) {
            if (cardsOnTable[i].cards[getRoundNo() - 1].getFaceValue() >= max.getFaceValue()) {
                max = cardsOnTable[i].cards[getRoundNo() - 1];
            }

        }

        for (int j = 0; j < scoreCard.scores.length; j++) {
            if (cardsOnTable[j].cards[getRoundNo() - 1].getFaceValue() == max.getFaceValue()) {
                scoreCard.update(j, 1);
            }
        }

    }

    public boolean isTurnOf(Player p) {
        if (players.get(roundNo % 4).getName().equals(p.getName()))
            return true;
        else
            return false;
        //
    }

    public boolean isGameOver() {
        //
        if (getRoundNo() == 13 && cardsOnTable[3].cards.length == 13)
            return true;
        else
            return false;
    }

    public int getScore(int playerNumber) {
        //
        return scoreCard.scores[playerNumber - 1];

    }

    public String getName(int playerNumber) {

        return players.get(playerNumber - 1).getName();
    }

    public int getRoundNo() {

        if (roundNo < 52)
            return (roundNo / 4) + 1;
        else
            return roundNo / 4;
    }

    public int getTurnOfPlayerNo() {

        int i;
        for (i = 0; i < players.size() && !isTurnOf(players.get(i)); i++) {

        }
        return i + 1;
    }

    public Player[] getWinners() {
        Player[] winners = new Player[scoreCard.getWinners().length];

        for (int i = 0; i < winners.length; i++) {
            winners[i] = players.get(scoreCard.getWinners()[i]);
        }

        return winners;
    }

    public void initGame() {
        if (players.size() == 4) {

            fullPack = new Cards(true);
            fullPack.shuffle();

            for (int i = 0; i < 52; i++) {
                players.get(i % 4).hand.addTopCard(fullPack.getTopCard());
            }

            scoreCard = new Score(3);

            cardsOnTable = new Cards[4];
            for (int i = 0; i < 4; i++) {
                cardsOnTable[i] = new Cards(false);
            }

            roundNo = 0;
            turnOfPlayer = 0;

        }
    }

    public String showScoreCard() {
        return scoreCard.toString();
    }

}
