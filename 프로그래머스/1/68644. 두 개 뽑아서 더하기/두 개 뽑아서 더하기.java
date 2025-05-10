import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class Solution {
    public int[] solution(int[] numbers) {
        
        Set<Integer> sums = new HashSet<>();
        int len = numbers.length;

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                sums.add(numbers[i] + numbers[j]);
            }
        }

        return sums.stream()
                   .sorted()
                   .mapToInt(i -> i)
                   .toArray();
    }
}