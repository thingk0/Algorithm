import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] result = IntStream.of(arr)
                                .filter(n -> n % divisor == 0)
                                .sorted()
                                .toArray();
        return result.length == 0 ? new int[]{-1} : result;
    }
}