import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> completionMap = new HashMap<>();
        
        for (String runner : completion) {
            completionMap.merge(runner, 1, Integer::sum);
        }
        
        for (String runner : participant) {
            int remaining = completionMap.merge(runner, -1, Integer::sum);
            if (remaining < 0) {
                return runner;
            }
        }
        
        return null;
    }
}