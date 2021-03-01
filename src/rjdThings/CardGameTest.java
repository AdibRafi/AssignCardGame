package rjdThings;


import java.util.Scanner;
import rjdThings.*;

public class CardGameTest
{
    public static void main( String[] args)
    {
        Scanner scan = new Scanner( System.in);

        System.out.println( "Start of CardGame\n");

        // CONSTANTS
        final int MENU_EXIT    = 0;
        final int MENU_PLAY_P1 = 1;
        final int MENU_PLAY_P2 = 2;
        final int MENU_PLAY_P3 = 3;
        final int MENU_SCORES  = 5;

        // VARIABLES
        Player     p1, p2, p3;
        CardGame   game;
        int        selection;

        // PROGRAM CODE

        // create players...
        p1 = new Player( "p1");
        p2 = new Player( "p2");
        p3 = new Player( "p3");

        // create game with the 4 players...
        game = new CardGame( p1, p2, p3);

        game.initGame();

        // display menu, get and process selection, until exit
        do
        {
            // display menu
            System.out.println();
            System.out.println( "CardGame   Round: " + game.getRoundNo()
                    + "\t TurnOfPlayer: " + game.getTurnOfPlayerNo() );
            System.out.println();
            System.out.println( MENU_PLAY_P1 + " - Player " + MENU_PLAY_P1 + " plays" );
            System.out.println( MENU_PLAY_P2 + " - Player " + MENU_PLAY_P2 + " plays" );
            System.out.println( MENU_PLAY_P3 + " - Player " + MENU_PLAY_P3 + " plays" );
            System.out.println( MENU_SCORES  + " - Show scores" );

            // ask for and get selection
            System.out.println();
            System.out.println( "Selection (" + MENU_EXIT + " to exit): ");
            selection = scan.nextInt();

            // process selection
            if ( selection == MENU_PLAY_P1 )
                play( p1, game);

            else if ( selection == MENU_PLAY_P2 )
                play( p2, game);

            else if ( selection == MENU_PLAY_P3 )
                play( p3, game);

            else if ( selection == MENU_SCORES ){
                System.out.println( game.showScoreCard() );
                System.out.println( "ToDo..." );
            }
            else if ( selection != MENU_EXIT)
                System.out.println( "Invalid selection! \n" );

        } while ( selection != MENU_EXIT);

        // display winners...
        System.out.println("Winner");
        for(int i=0; i<game.getWinners().length;i++){
            System.out.println( game.getWinners()[0] );
        }


        System.out.println( "\nEnd of MyCardGame\n" );
    }

    // get the card, c, that player p wants to play
    // pass c to the game, see if it accepted c from p
    // if game didn't accept the card, give c back to the player!
    // return accepted.
    static boolean play( Player p, CardGame game)
    {
        Card       c;
        boolean    accepted;

        c = p.playCard();

        accepted = game.playTurn(p, c);

        if(accepted == false){
            p.hand.addTopCard(c);
        }

        //

        return accepted;
    }



}