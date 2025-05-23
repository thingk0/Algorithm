import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int[] query) {
        int start = 0;
        int end = arr.length;

        for (int i = 0; i < query.length; i++) {
            int q = query[i];
            if (i % 2 == 0) {
                end = start + q + 1;
            } else {
                start = start + q;
            }
        }

        return Arrays.copyOfRange(arr, start, end);
    }
}