class Solution {
    public long[] solution(int n, long left, long right) {
        long[] answer = new long[(int)(right - left + 1)];
        
        for (long i = left; i <= right; i++) {
            long row = i / n;
            long col = i % n;
            answer[(int)(i - left)] = Math.max(row, col) + 1;
        }
        
        return answer;
    }
}