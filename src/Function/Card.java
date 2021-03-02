package Function;

import java.beans.PropertyEditorSupport;
import java.util.*;

public class Card {
    public static Queue<String> shuffleQueue(Queue<String> cards){
        // change queue to arrayList
        int loop = cards.size();
        List<String> arrays = new ArrayList<>();
        for (int i = 0; i < loop; i++) {
            arrays.add(cards.remove());
        }
        Collections.shuffle(arrays);
        return new LinkedList<>(arrays);
    }
    public static Set<String> shuffleSet(Set<String> cards){
        //change set to ArrayList
        int loop = cards.size();
        ArrayList<String> arrays = new ArrayList<>();
        for (int i = 0; i < loop; i++) {
            arrays.add(cards.iterator().next());
            cards.remove(arrays.get(i));
        }
        Collections.shuffle(arrays);
        return new LinkedHashSet<>(arrays);
    }

    public static int getValueFromCard(String[] fiveElementArray){
        ArrayList<String> result = new ArrayList<>();
        int c=0,d=0,h=0,s=0;
        for (String value : fiveElementArray) {
            String[] x = value.split("");
            result.add(x[0]);
            result.add(x[1]);
        }
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).equals("c"))
                c += checkValue(result.get(i+1));
            if (result.get(i).equals("d"))
                d += checkValue(result.get(i+1));
            if (result.get(i).equals("h"))
                h += checkValue(result.get(i+1));
            if (result.get(i).equals("s"))
                s += checkValue(result.get(i+1));
        }
        int[] finalArray = {c,d,h,s};

        int maxValue=0;
        for (int j : finalArray) {
            if (j > maxValue)
                maxValue = j;
        }
        return maxValue;
    }
    private static int checkValue(String value){
        try{
            int test =0;
            test += Integer.parseInt(value);
            return test;
        }catch (NumberFormatException e){
            int result;
            if (value.equals("A"))
                return result = 1;
            else
                return result=10;
        }
    }

}
