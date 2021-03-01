package rjdThings;

import java.util.Scanner;
import rjdThings.*;


public class GameTest
{
    public static void main( String[] args)
    {
        Scanner scan = new Scanner( System.in);

        System.out.println( "Start of CardGameTest\n");

        // CONSTANTS

        // VARIABLES
        Card       c;
        Cards      cards;
        Score  scores;
        Player     p;
        CardGame   game;

        // PROGRAM CODE

        // test Card class
        c = new Card( 1);
        System.out.println( c);
        System.out.println();

        // test Cards class
        cards = new Cards( true);
        cards.addTopCard( c);
        //cards.testOnlyPrint();

        // test ScoreCard class
        scores = new Score( 3);
        scores.update( 2, 1);
        scores.update( 1, 2);
        System.out.println( "\n" + scores );

        // test Player class
        p= new Player("rjd");
        p.add(c);
        System.out.println(p.getName().toUpperCase());
        System.out.println(p.playCard());


        System.out.println( "\nEnd of CardGameTest\n" );
    }

}
