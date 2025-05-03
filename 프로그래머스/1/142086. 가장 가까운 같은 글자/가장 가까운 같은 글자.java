import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] lastIdx = IntStream.generate(() -> -1).limit(26).toArray();

        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            int last = lastIdx[idx];
            answer[i] = (last == -1) ? -1 : (i - last);
            lastIdx[idx] = i;
        }
        
        return answer;
    }
}