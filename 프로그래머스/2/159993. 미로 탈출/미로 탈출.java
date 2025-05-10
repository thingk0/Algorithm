import java.util.Arrays;
import java.util.ArrayDeque;

class Solution {
    
    private static final int[][] DIRS = {{0, -1},{0, 1},{-1, 0},{1, 0}};
    private static class Point {
        int x, y;
        Point(int x, int y) { this.x = x; this.y = y; }
    }

    public int solution(String[] maps) {
        int N = maps.length;
        int M = maps[0].length();
        char[][] grid = toCharGrid(maps, N, M);
        
        Point start = findPoint(grid, 'S');
        Point lever = findPoint(grid, 'L');
        Point end = findPoint(grid, 'E');

        int dist1 = bfs(grid, N, M, start, lever);
        if (dist1 < 0) {
            return -1;
        }
        
        int dist2 = bfs(grid, N, M, lever, end);
        return dist2 < 0 ? -1 : dist1 + dist2;
    }

    private char[][] toCharGrid(String[] maps, int N, int M) {
        char[][] grid = new char[N][M];
        for (int i = 0; i < N; i++) {
            grid[i] = maps[i].toCharArray();
        }
        
        return grid;
    }

    private Point findPoint(char[][] grid, char target) {
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (grid[y][x] == target) {
                    return new Point(x, y);
                }
            }
        }
        
        return null;
    }

    private int bfs(char[][] grid, int N, int M, Point start, Point end) {
        int[][] dist = new int[N][M];
        for (int[] row : dist) {
            Arrays.fill(row, -1);
        }
        
        ArrayDeque<Point> q = new ArrayDeque<>();
        
        q.add(start); 
        dist[start.y][start.x] = 0;

        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int[] d : DIRS) {
                int nx = p.x + d[0];
                int ny = p.y + d[1];
                
                if (nx < 0||nx>=M||ny<0||ny>=N) {
                    continue;
                }
                
                if (grid[ny][nx] == 'X' || dist[ny][nx] != -1) {
                    continue;
                }
                
                dist[ny][nx] = dist[p.y][p.x] + 1;
                
                if (nx == end.x && ny == end.y) {
                    return dist[ny][nx];
                }
                
                q.add(new Point(nx, ny));
            }
        }
        
        return -1;
    }

}