import java.util.ArrayDeque;

class Solution {
    public int solution(String s) {
        
        int sum = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        String[] tokens = s.split(" ");
        for (String token : tokens) {
            if (token.equals("Z")) {
                if (!stack.isEmpty()) {
                    int last = stack.pop();
                    sum -= last;
                }
            } else {
                int num = Integer.parseInt(token);
                stack.push(num);
                sum += num;
            }
        }
        
        return sum;
    }
}