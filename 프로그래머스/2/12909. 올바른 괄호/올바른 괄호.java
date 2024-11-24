import java.util.ArrayDeque;

class Solution {
    public boolean solution(String s) {
        
        // 길이가 홀수면 항상 false
        if (s.length() % 2 != 0) {
            return false;
        }

        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(':
                    stack.push(c);
                    break;
                case ')':
                    // 스택이 비어있거나 짝이 맞지 않으면 false
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
            }
        }
        
        return stack.isEmpty();
    }
}