package AdamStuff;

import java.util.Random;
import java.util.Scanner;
import Function.Player;

public class test {
    public static void main(String[] args) {

        Player P1 = new Player("");

        Scanner input = new Scanner(System.in);
        Players[] players = new Players[3];
        Card[] deck = Dealer.getDeckOfCards();

        System.out.println("Un-shuffled Cards.");
        Dealer.showCards(deck);
        Card[] shuffledCards = Dealer.shuffleCards(deck);
        System.out.println("Shuffled Cards.");
        Dealer.showCards(shuffledCards);

        for(int i = 0; i < players.length; i++) {
            System.out.println("Enter Player Name: ");
            players[i] = new Players(input.nextLine());
        }

        Players[] playersWithCards = Dealer.dealCards(players, shuffledCards);

        for(Players player : playersWithCards) {
            System.out.println(player.getName() + " : ");
            player.showPlayerCards();
        }
    }
}

class Card {
    String suit;
    String rank;

    Card (String cardSuit, String cardRank){
        this.suit = cardSuit;
        this.rank = cardRank;
    }
}

class Players {

    private String name;
    private Card[] cards = new Card[17];

    Players(String name){
        this.name = name;
    }
    void showPlayerCards(){
        for (Card card : cards){
            System.out.printf("%s%s ", card.suit, card.rank);
        }
        System.out.println("\n");
    }
    void receiveCard(Card card, int position){
        cards[position] = card;
    }
    String getName(){
        return name;
    }
}

class Dealer {
    private static final int SIZE = 52;
    private static Card[] deckOfCards = new Card[SIZE];

    static Card[] getDeckOfCards() {

        int count = 0;

        String[] suits = {"d", "c", "h", "s"};
        String[] ranks = {"K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3", "2", "A"};

        for (String s : suits) {
            for (String r : ranks) {

                Card card = new Card(s, r);
                deckOfCards[count] = card;
                count++;
            }
        }
        return deckOfCards;
    }

    static Card[] shuffleCards(Card[] deckOfCards) {
        Random rand = new Random();
        int j;
        for (int i = 0; i < SIZE; i++) {
            j = rand.nextInt(SIZE);
            Card temp = deckOfCards[i];
            deckOfCards[i] = deckOfCards[j];
            deckOfCards[j] = temp;
        }
        return deckOfCards;
    }

    static void showCards(Card[] deckOfCards) {
        System.out.println("---------------------------------------------");
        int count = 0;
        for (Card card : deckOfCards) {
            System.out.printf("%s%s\t", card.suit, card.rank); //use print f with \t (tab character)
            count++;
            if (count % 4 == 0)
                System.out.println();
        }
        System.out.println("---------------------------------------------");
    }

    static Players[] dealCards(Players[] players, Card[] deck) {
        int numOfCardsPerPlayer = deck.length / players.length;
        for (int i = 0; i < deck.length; i++) {
            int positionInHand = i % numOfCardsPerPlayer;
            players[i % players.length].receiveCard(deck[i], positionInHand);
        }
        return players;
    }
}

