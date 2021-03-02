package AdamStuff;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import Function.Player;

public class test {
    public static void main(String[] args) {

        Player P1 = new Player("");

        Scanner input = new Scanner(System.in);
        Players[] players = new Players[3];
        //Card[] deck = Dealer.getDeckOfCards();

//        System.out.println("Un-shuffled Cards.");
//        Dealer.showCards(deck);
//        Card[] shuffledCards = Dealer.shuffleCards(deck);
//        System.out.println("Shuffled Cards.");
//        Dealer.showCards(shuffledCards);

        for(int i = 0; i < players.length; i++) {
            System.out.println("Enter Player Name: ");
            players[i] = new Players(input.nextLine());
        }
        //todo adam what u can do is
        // - pergi ambik 1 array and put all cards dlm tu soo
        //   should be 1 array got 52 element
        // - then use for loop n letak element dari tadi
        //   p1,p2,p3 kat dlm tu.
        //   contoh
        //   allCards[] = {c1,c2,c3,c4,etc}
        //   for loop{
        //    p1 = allcards[i]
        //    p2 = allcards[i+1]
        //    p3 = allcards[i+2]
        //    }
        // lebih kurang gitu la
        // -adib

        //Players[] playersWithCards = Dealer.dealCards(players, shuffledCards);

        //for(Players player : playersWithCards) {
        //    System.out.println(player.getName() + " : ");
        //    player.showPlayerCards();
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
    public static String[] getDeckOfCards() {
        ArrayList<String> deckOfCards = new ArrayList<>();

        String[] suits = {"d", "c", "h", "s"};
        String[] ranks = {"K", "Q", "J", "X", "9", "8", "7", "6", "5", "4", "3", "2", "A"};

        for (String suit : suits) {
            for (String rank : ranks) {
                deckOfCards.add(suit + rank);
            }
        }
        String[] result = new String[deckOfCards.size()];
        for (int i = 0; i < deckOfCards.size(); i++) {
            result[i] = deckOfCards.get(i);
        }
        return result;
    }

    static Card[] shuffleCards(Card[] deckOfCards) {
        Random rand = new Random();
        int j;
//        for (int i = 0; i < SIZE; i++) {
//            j = rand.nextInt(SIZE);
//            Card temp = deckOfCards[i];
//            deckOfCards[i] = deckOfCards[j];
//            deckOfCards[j] = temp;
//        }
        return deckOfCards;
    }

    static void showCards(Card[] deckOfCards) {
        System.out.println("---------------------------------------------");
        int count = 0;
        for (Card card : deckOfCards) {
            System.out.printf("%s%s\t", card.suit, card.rank);
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

