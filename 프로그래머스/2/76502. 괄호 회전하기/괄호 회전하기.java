import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

class Solution {
    private static final Map<Character, Character> BRACKET_PAIRS = Map.of(
        ')', '(',
        '}', '{',
        ']', '['
    );
    
    public int solution(String s) {
        
        // 길이가 홀수면 항상 0
        final int n = s.length();
        if (n % 2 != 0) {
            return 0;
        }
        
        // 문자열 회전을 위한 두 배 길이 문자열 생성
        String rotated = s + s;
        int validRotations = 0;
        
        // 각 회전에 대해 유효성 검사
        for (int i = 0; i < n; i++) {
            if (isValidBracketSequence(rotated, i, n)) {
                validRotations++;
            }
        }
        
        return validRotations;
    }
    
    private boolean isValidBracketSequence(String s, int start, int length) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        for (int i = start; i < start + length; i++) {
            char c = s.charAt(i);
            
            if (!BRACKET_PAIRS.containsKey(c)) {
                // 여는 괄호인 경우
                stack.push(c);
            } else if (stack.isEmpty() || stack.pop() != BRACKET_PAIRS.get(c)) {
                // 닫는 괄호인데 매칭되는 여는 괄호가 없는 경우
                return false;
            }
        }
        
        return stack.isEmpty();
    }
}