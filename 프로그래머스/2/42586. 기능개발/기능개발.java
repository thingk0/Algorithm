import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        int n = progresses.length;
        int[] remainingDays = new int[n];

        for (int i = 0; i < n; i++) {
            remainingDays[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
        }


        ArrayList<Integer> result = new ArrayList<>();
        
        int currentMaxDay = remainingDays[0];
        int count = 1;

        for (int i = 1; i < n; i++) {
            if (remainingDays[i] <= currentMaxDay) {
                count++;
            } else {
                result.add(count);
                count = 1;
                currentMaxDay = remainingDays[i];
            }
        }

        result.add(count);

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
