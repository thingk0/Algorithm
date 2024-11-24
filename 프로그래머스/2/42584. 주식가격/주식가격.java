import java.util.ArrayDeque;

class Solution {
    public int[] solution(int[] prices) {
        
        int n = prices.length;
        int[] durations = new int[n];
        
        ArrayDeque<Integer> stack = new ArrayDeque<>(n);
        stack.push(0);
        
        // 각 시점별로 가격이 떨어지지 않은 기간 계산
        for (int i = 1; i < n; i++) {
            // 현재 가격보다 높은 가격들은 여기서 가격이 떨어짐
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int prevTime = stack.pop();
                durations[prevTime] = i - prevTime;
            }
            stack.push(i);
        }
        
        // 마지막까지 가격이 떨어지지 않은 기간 처리
        while (!stack.isEmpty()) {
            int time = stack.pop();
            durations[time] = n - 1 - time;
        }
        
        return durations;
    }
}