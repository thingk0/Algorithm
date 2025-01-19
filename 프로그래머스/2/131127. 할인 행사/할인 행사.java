import java.util.HashMap;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        HashMap<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; ++i) {
            wantMap.put(want[i], number[i]);
        }
        
        int answer = 0;
        int windowSize = 10;
        
        if (discount.length < windowSize) {
            return 0;
        }
        
        HashMap<String, Integer> windowMap = new HashMap<>();
        for (int j = 0; j < windowSize; ++j) {
            if (wantMap.containsKey(discount[j])) {
                windowMap.merge(discount[j], 1, Integer::sum);
            }
        }
        
        if (windowMap.equals(wantMap)) {
            answer++;
        }
        
        for (int i = 1; i <= discount.length - windowSize; ++i) {
            String itemToRemove = discount[i - 1];
            String itemToAdd = discount[i + windowSize - 1];
            
            if (wantMap.containsKey(itemToRemove)) {
                int count = windowMap.getOrDefault(itemToRemove, 0);
                if (count <= 1) {
                    windowMap.remove(itemToRemove);
                } else {
                    windowMap.put(itemToRemove, count - 1);
                }
            }
            
            if (wantMap.containsKey(itemToAdd)) {
                windowMap.merge(itemToAdd, 1, Integer::sum);
            }
            
            if (windowMap.equals(wantMap)) {
                answer++;
            }
        }
        
        return answer;
    }
}