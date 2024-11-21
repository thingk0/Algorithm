import java.util.HashMap;
import java.util.HashSet;

class Solution {
    
    private static final HashMap<Character, int[]> location = new HashMap<>();
    private static int x = 5, y = 5;
    
    static {
        location.put('U', new int[] {0, 1});
        location.put('D', new int[] {0, -1});
        location.put('L', new int[] {-1, 0});
        location.put('R', new int[] {1, 0});
    }
    
    private static boolean isValid(int nx, int ny) {
        return nx >= 0 && nx <= 10 && ny >= 0 && ny <= 10;
    }
    
    public int solution(String dirs) {
        HashSet<String> visitedPaths = new HashSet<>();
        for (char dir : dirs.toCharArray()) {
            int[] offset = location.get(dir);
            int nx = x + offset[0];
            int ny = y + offset[1];
            if (!isValid(nx, ny)) {
                continue;
            }

            visitedPaths.add(String.format("%d %d %d %d", x, y, nx, ny));
            visitedPaths.add(String.format("%d %d %d %d", nx, ny, x, y));
    
            x = nx;
            y = ny;
        }
        
        return visitedPaths.size() / 2;
    }
}
