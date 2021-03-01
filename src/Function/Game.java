package Function;

import java.util.Set;

public class Game{
    Set<String> playerCards;
    public Game(){}
    public Game(Set<String> playerCards){
        this.playerCards = playerCards;
    }
    public void removeCardsFromPlayers
            (Set<String> original, Set<String> remove){
        original.removeAll(remove);
    }

    public Set<String> PlayerCards(){
        return playerCards;
    }
}
