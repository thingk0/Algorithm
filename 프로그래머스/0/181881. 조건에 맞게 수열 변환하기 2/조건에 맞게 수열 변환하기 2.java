import java.util.Arrays;

public class Solution {
    public int solution(int[] arr) {
        int count = 0;
        while (true) {
            int[] next = Arrays.stream(arr)
                    .map(n -> {
                        if (n >= 50 && n % 2 == 0) return n / 2;
                        else if (n < 50 && n % 2 == 1) return n * 2 + 1;
                        else return n;
                    })
                    .toArray();

            if (Arrays.equals(arr, next)) break;

            arr = next;
            count++;
        }

        return count;
    }
}