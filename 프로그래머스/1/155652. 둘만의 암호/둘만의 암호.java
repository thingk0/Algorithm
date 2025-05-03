class Solution {
    public String solution(String s, String skip, int index) {
        boolean[] isSkipped = new boolean[26];
        for (char c : skip.toCharArray()) {
            isSkipped[c - 'a'] = true;
        }

        StringBuilder answer = new StringBuilder();
        for (char ch : s.toCharArray()) {
            int cnt = index;
            char cur = ch;
            while (cnt-- > 0) {
                cur = (cur == 'z') ? 'a' : (char) (cur + 1);
                if (isSkipped[cur - 'a']) {
                    cnt++;
                }
            }
            
            answer.append(cur);
        }
        
        return answer.toString();
    }
}