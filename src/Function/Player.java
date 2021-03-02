package Function;

public class Player extends Game{
    int playerScore = 0;
    String playerName;

    public Player(){
    }
    public Player(String name){
        this.playerName = name;
    }

    public void restartScore(){
        playerScore = 0;
    }
    public void addValue(int value){
        playerScore += value;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerScore() {
        return playerScore;
    }
}
