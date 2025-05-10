import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    
    private static int[] parent;
    
    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        
        return parent[x] = find(parent[x]);
    }
    
    private static void union(int x, int y) {
        int rx = find(x);
        int ry = find(y);
        parent[ry] = rx;
    }
    
    public int solution(int n, int[][] costs) {
        parent = IntStream.range(0, n).toArray();
        
        int ans = 0;
        int edges = 0;
        
        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));
        for (int[] edge : costs) {
            if (edges == n - 1) {
                break;
            }
            
            if (find(edge[0]) != find(edge[1])) {
                union(edge[0], edge[1]);
                ans += edge[2];
                edges++;
            }
        }
        
        return ans;
    }
}