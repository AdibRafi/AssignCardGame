package Function;

import java.util.*;

public class Game{
    Queue<String> playerCardsQueue = new LinkedList<>();
    Set<String> playerCardsSet = new LinkedHashSet<>();

    public Game(){}
    // Distribute cards
    public void distributeCardsQueue(String[] cards){
        playerCardsQueue.addAll(Arrays.asList(cards));
    }
    public void distributeCardsSet(String[] cards){
        playerCardsSet.addAll(Arrays.asList(cards));
    }
    //remove cards from ori
    public void removeCardsQueue(Queue<String> remove){
        int loop = remove.size();
        for (int i = 0; i < loop; i++) {
            playerCardsQueue.remove();
        }
    }
    public void removeCardsSet(Set<String> remove){
        playerCardsSet.removeAll(remove);
    }
    // Shuffling a cards from player
    public void shuffleQueue(){
        this.playerCardsQueue = Card.shuffleQueue(playerCardsQueue);
    }
    public void shuffleSet(){
        this.playerCardsSet = Card.shuffleSet(playerCardsSet);
    }

    // TESTING DISPLAY ONLY
    public String displayQueue() {
        return "Game{" +
                "playerCardsQueue=" + playerCardsQueue +
                '}';
    }
    public String displaySet() {
        return "Game{" +
                "playerCardsSet=" + playerCardsSet +
                '}';
    }
}
