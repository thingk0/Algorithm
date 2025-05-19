import java.util.stream.*;

class Solution {
    public int[] solution(int start_num, int end_num) {
        return IntStream.rangeClosed(0, start_num - end_num)
                .map(i -> start_num - i)
                .toArray();
    }
}