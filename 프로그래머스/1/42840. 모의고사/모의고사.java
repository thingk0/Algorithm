import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    private static final int[][] PATTERNS = {
        {1, 2, 3, 4, 5},
        {2, 1, 2, 3, 2, 4, 2, 5},
        {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
    };

    public int[] solution(int[] answers) {
        int[] scores = new int[3];
        
        // 채점
        for (int i = 0; i < answers.length; i++) {
            int answer = answers[i];
            for (int j = 0; j < PATTERNS.length; j++) {
                if (answer == PATTERNS[j][i % PATTERNS[j].length]) {
                    scores[j]++;
                }
            }
        }

        // 최대 점수 계산
        int maxScore = Math.max(scores[0], Math.max(scores[1], scores[2]));

        // 결과
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxScore) {
                result.add(i + 1);
            }
        }

        return result.stream()
                     .sorted()
                     .mapToInt(i -> i)
                     .toArray();
    }
}