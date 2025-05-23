import java.util.Arrays;

class Solution {
    public int solution(int[] num_list) {
        if (num_list.length >= 11) {
            return Arrays.stream(num_list).sum();
        } else {
            return Arrays.stream(num_list).reduce(1, (a, b) -> a * b);
        }
    }
}