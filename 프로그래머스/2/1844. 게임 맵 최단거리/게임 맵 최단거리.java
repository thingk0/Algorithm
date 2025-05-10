import java.util.Arrays;
import java.util.ArrayDeque;

class Solution {
    
    private static int N, M;
    private static final int[][] DIRS = {{-1,0}, {1,0}, {0,1}, {0,-1}};
    
    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
        
        int[][] dist = new int[N][M];
        for (int[] row : dist) {
            Arrays.fill(row, -1);
        }
        
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{0, 0});
        dist[0][0] = 1;
        
        while (!dq.isEmpty()) {
            int[] now = dq.poll();
            int r = now[0];
            int c = now[1];
            
            for (int[] d : DIRS) {
                int nr = r + d[0];
                int nc = c + d[1];
                
                if (!inBounds(nr, nc) || maps[nr][nc] == 0 || dist[nr][nc] != -1) {
                    continue;
                }
                
                dist[nr][nc] = dist[r][c] + 1;
                dq.add(new int[] {nr, nc});
            }
        }
        
        return dist[N - 1][M - 1];
    }
    
    private boolean inBounds(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }
}