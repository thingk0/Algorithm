class Solution {
    public long solution(int n, int[] times) {
        long left = 1;
        long right = getMaxValue(times) * (long) n;
        long answer = right; // 초기값은 최대값으로 설정
        
        while (left <= right) {
            long mid = (left + right) / 2;
            long processedPeople = calculateProcessedPeople(mid, times);
            
            // mid 시간 내에 n명 이상 처리 가능하면
            if (processedPeople >= n) {
                answer = Math.min(answer, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
    
    // 주어진 시간 동안 모든 심사관이 처리할 수 있는 총 사람 수 계산
    private long calculateProcessedPeople(long time, int[] times) {
        long total = 0;
        for (int t : times) {
            total += time / t;
            if (total >= 1_000_000_000) {
                return total;
            }
        }
        
        return total;
    }
    
    private long getMaxValue(int[] arr) {
        long max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}