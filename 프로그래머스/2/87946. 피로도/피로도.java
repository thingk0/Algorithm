class Solution {
    public int solution(int k, int[][] dungeons) {
        return backtrack(k, dungeons, new boolean[dungeons.length], 0);
    }
    
    private int backtrack(int remainingPower, int[][] dungeons, boolean[] visited, int completedDungeons) {
        int maxDungeons = completedDungeons;
        
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && remainingPower >= dungeons[i][0]) {
                boolean[] newVisited = visited.clone();
                newVisited[i] = true;
                
                int currentMax = backtrack(
                    remainingPower - dungeons[i][1], 
                    dungeons, 
                    newVisited, 
                    completedDungeons + 1
                );
                
                maxDungeons = Math.max(maxDungeons, currentMax);
            }
        }
        
        return maxDungeons;
    }
}