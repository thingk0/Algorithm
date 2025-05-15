import java.util.Arrays;

class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        for (int n : num_list) {
            while (n != 1) {
                answer++;
                if (n % 2 == 0) n = n / 2;
                else n = (n - 1) / 2;
            }
        }
        return answer;
    }
}