import java.util.Set;
import java.util.HashSet;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> used = new HashSet<>();
        char expectedStart = words[0].charAt(0);

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            // 1) 시작 글자 검사
            if (word.charAt(0) != expectedStart) {
                return new int[] {(i % n) + 1, (i / n) + 1};
            }
            
            // 2) 중복 검사
            if (!used.add(word)) {
                return new int[] {(i % n) + 1, (i / n) + 1};
            }

            // 다음 예상 시작 글자 갱신
            expectedStart = word.charAt(word.length() - 1);
        }

        return new int[] {0, 0};
    }
}