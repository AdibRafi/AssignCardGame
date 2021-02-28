package Function;

public class Player {
    int playerScore = 0;
    String playerName;

    public Player(){}
    public Player(String name){
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
                "playerScore=" + playerScore +
                '}';
    }
}
