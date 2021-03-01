package Function;

import java.util.Set;

public class Player extends Game{
    int playerScore = 0;
    String playerName;

    public Player(){
    }
    public Player(String name){
        this.playerName = name;
    }
    public Player(String name, Set<String> cards){
        super(cards);
        this.playerName = name;
    }


    public void restartScore(){
        playerScore = 0;
    }
    public void addValue(int value){
        playerScore += value;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerCards=" + playerCards +
                '}';
    }
}
