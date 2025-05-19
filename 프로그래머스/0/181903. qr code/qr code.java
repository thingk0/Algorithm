class Solution {
    public String solution(int q, int r, String code) {
        StringBuilder result = new StringBuilder();
        int leng = code.length();
        for (int i = 0; i < leng; i++) {
            if (i % q == r) {
                result.append(code.charAt(i));
            }
        }
        
        return result.toString();
    }
}