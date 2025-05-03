from collections import deque

def solution(maps):
    n, m = len(maps), len(maps[0])
    visited = [[[False for _ in range(2)] for _ in range(m)] for _ in range(n)]
    q = deque()
    
    start_y, start_x = -1, -1
    end_y, end_x = -1, -1
    
    for i in range(n):
        for j in range(m):
            if maps[i][j] == 'S':
                start_y, start_x = i, j
            elif maps[i][j] == 'E':
                end_y, end_x = i, j

    if start_y == -1 or end_y == -1:
        return -1

    q.append((start_y, start_x, 0, 0))
    visited[start_y][start_x][0] = True
    
    while q:
        y, x, lever_state, time = q.popleft()
        
        if y == end_y and x == end_x and lever_state == 1:
            return time
        
        for dy, dx in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
            ny, nx = y + dy, x + dx
            
            if not (0 <= ny < n and 0 <= nx < m) or maps[ny][nx] == 'X':
                continue
            
            next_lever_state = 1 if maps[ny][nx] == 'L' or lever_state == 1 else 0
            
            if not visited[ny][nx][next_lever_state]:
                visited[ny][nx][next_lever_state] = True
                q.append((ny, nx, next_lever_state, time + 1))
    
    return -1