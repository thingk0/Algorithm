import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        ArrayDeque<String> cardsDeque1 = new ArrayDeque<>(Arrays.asList(cards1));
        ArrayDeque<String> cardsDeque2 = new ArrayDeque<>(Arrays.asList(cards2));

        for (String target : goal) {
            if (!cardsDeque1.isEmpty() && cardsDeque1.peekFirst().equals(target)) {
                cardsDeque1.pollFirst();
            } else if (!cardsDeque2.isEmpty() && cardsDeque2.peekFirst().equals(target)) {
                cardsDeque2.pollFirst();
            } else {
                return "No";
            }
        }

        return "Yes";
    }
}
