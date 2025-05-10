import java.util.PriorityQueue;
import java.util.Comparator;

class Solution {
    private static class Node {
        int x, y, direction, cost;
        
        Node(int x, int y, int direction, int cost) {
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.cost = cost;
        }
    }
    
    // 상, 좌, 하, 우 (0, 1, 2, 3)
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, -1, 0, 1};
    private static int N;
    
    private static boolean isValid(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }
    
    private static int calculateCost(int newDirection, int prevDirection, int currentCost) {
        // 처음 이동하거나 같은 방향으로 이동
        if (prevDirection == -1 || prevDirection == newDirection) {
            return currentCost + 100;
        } 
        // 직각으로 방향 전환 (코너)
        else {
            return currentCost + 600;  // 직선 비용(100) + 코너 비용(500)
        }
    }
    
    public int solution(int[][] board) {
        N = board.length;
        
        // 방문 배열: [x][y][방향] = 해당 위치와 방향으로 도달한 최소 비용
        int[][][] costs = new int[N][N][4];
        
        // 모든 비용을 무한대로 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 4; k++) {
                    costs[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        pq.add(new Node(0, 0, -1, 0));
        
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            
            // 목적지에 도달한 경우
            if (current.x == N - 1 && current.y == N - 1) {
                return current.cost;
            }
            
            // 현재 상태가 이미 더 비용이 적은 경로로 방문된 경우 스킵
            if (current.direction != -1 && costs[current.x][current.y][current.direction] < current.cost) {
                continue;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                
                // 유효한 위치인지, 벽이 아닌지 확인
                if (!isValid(nx, ny) || board[nx][ny] == 1) {
                    continue;
                }
                
                // 새로운 비용 계산
                int newCost = calculateCost(i, current.direction, current.cost);
                
                // 더 저렴한 비용으로 도달할 수 있는 경우 업데이트
                if (newCost < costs[nx][ny][i]) {
                    costs[nx][ny][i] = newCost;
                    pq.add(new Node(nx, ny, i, newCost));
                }
            }
        }
        
        return -1;
    }
}