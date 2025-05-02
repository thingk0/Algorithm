import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        // 1. 각 문자(character)에 대해 누름 횟수의 최솟값을 미리 계산
        Map<Character, Integer> minPressMap = new HashMap<>();
        for (String keySeq : keymap) {
            for (int i = 0; i < keySeq.length(); i++) {
                char ch = keySeq.charAt(i);
                int presses = i + 1;
                
                // 이미 저장된 값보다 작으면 업데이트
                minPressMap.merge(ch, presses, Math::min);
            }
        }

        // 2. 각 target 문자열별로 총 누름 횟수 계산
        int[] answer = new int[targets.length];
        
        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int totalPresses = 0;
            boolean possible = true;

            // 문자열의 각 문자마다 최소 누름 횟수를 더함
            for (char ch : target.toCharArray()) {
                Integer presses = minPressMap.get(ch);
                if (presses == null) {
                    possible = false;
                    break;
                }
                
                totalPresses += presses;
            }

            answer[i] = possible ? totalPresses : -1;
        }

        return answer;
    }
}