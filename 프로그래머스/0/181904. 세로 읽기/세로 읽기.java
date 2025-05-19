class Solution {
    public String solution(String my_string, int m, int c) {
        StringBuilder sb = new StringBuilder();
        int n = my_string.length();
        int col = c - 1;

        for (int i = 0; i < n / m; i++) {
            sb.append(my_string.charAt(i * m + col));
        }

        return sb.toString();
    }
}