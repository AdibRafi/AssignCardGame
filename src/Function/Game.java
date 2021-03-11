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
    public void removeCardsQueue(){
        for (int i = 0; i < 5; i++) {
            playerCardsQueue.remove();
        }
    }
    public void removeCardsSet(String[] remove){
        playerCardsSet.removeAll(Arrays.asList(remove));
    }
    // Shuffling a cards from player
    public void shuffleQueue(){
        this.playerCardsQueue = Card.shuffleQueue(playerCardsQueue);
    }
    public void shuffleSet(){
        this.playerCardsSet = Card.shuffleSet(playerCardsSet);
    }

    // Return 5 elements
    public String[] return5Queue(){
        String[] newHand = new String[5];
        for (int i = 0; i < 5; i++) {
            newHand[i] = this.playerCardsQueue.remove();
        }
        Card.sorted5Elements(newHand);
        return newHand;
    }

    public String[] return5Set(){
        String[] newHand = new String[5];
        for (int i = 0; i < 5; i++) {
            newHand[i] = this.playerCardsSet.iterator().next();
            this.playerCardsSet.remove(this.playerCardsSet.iterator().next());
        }
        Card.sorted5Elements(newHand);
        return newHand;
    }



    // TESTING DISPLAY ONLY
    public Queue<String> displayQueue() {
        return playerCardsQueue;
    }
    public Set<String> displaySet() {
        return playerCardsSet;
    }

    public Queue<String> getPlayerCardsQueue() {
        return playerCardsQueue;
    }

    public String[] changeQueueToArray(Queue<String> cards){
        String[] result = new String[cards.size()];
        int loop = cards.size();
        for (int i = 0; i < loop; i++) {
            result[i] = cards.remove();
        }
        this.playerCardsQueue.addAll(Arrays.asList(result));
        return result;
    }
}
