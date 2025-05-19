class Solution {
    public String solution(String my_string, int s, int e) {
        String prefix = my_string.substring(0, s);       // 앞부분
        String mid = my_string.substring(s, e + 1);      // 뒤집을 부분
        String suffix = my_string.substring(e + 1);      // 뒷부분

        String reversed = new StringBuilder(mid).reverse().toString();
        return prefix + reversed + suffix;
    }
}