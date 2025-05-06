import sys
from collections import deque

input = sys.stdin.readline
M, N = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(N)]

dq = deque()
dist = [[-1] * M for _ in range(N)]
for r in range(N):
  for c in range(M):
    if grid[r][c] == 1:
      dq.append((r, c))
      dist[r][c] = 0

dirs = [(1, 0), (-1, 0), (0, 1), (0, -1)]
while dq:
  r, c = dq.popleft()
  for dr, dc in dirs:
    nr, nc = r + dr, c + dc
    if 0 <= nr < N and 0 <= nc < M:
      if grid[nr][nc] == 0 and dist[nr][nc] == -1:
        grid[nr][nc] = 1
        dist[nr][nc] = dist[r][c] + 1
        dq.append((nr, nc))

ans = 0
for r in range(N):
  for c in range(M):
    if grid[r][c] == 0:
      print(-1)
      sys.exit(0)
    ans = max(ans, dist[r][c])

print(ans)