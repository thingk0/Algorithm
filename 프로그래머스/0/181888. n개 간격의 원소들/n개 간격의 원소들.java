import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] num_list, int n) {
        return IntStream.iterate(0, i -> i + n)
                        .limit((num_list.length + n - 1) / n)
                        .map(i -> num_list[i])
                        .toArray();
    }
}