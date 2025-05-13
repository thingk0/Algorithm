import java.util.stream.IntStream;

class Solution {
    public int solution(int[] num_list) {
        int[] sums = IntStream.range(0, num_list.length)
            .collect(
                () -> new int[2],
                (acc, i) -> acc[i % 2] += num_list[i],
                (acc1, acc2) -> {
                    acc1[0] += acc2[0];
                    acc1[1] += acc2[1];
                }
            );

        return Math.max(sums[0], sums[1]);
    }
}