import sys
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().split())
maze = [list(map(int, input().strip())) for _ in range(N)]

dist = [[0] * M for _ in range(N)]

dq = deque()
dq.append((0, 0))
dist[0][0] = 1

while dq:
  r, c = dq.popleft()
  for dr, dc in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
    nr, nc = r + dr, c + dc
    if 0 <= nr < N and 0 <= nc < M:
      if maze[nr][nc] == 1 and dist[nr][nc] == 0:
        dist[nr][nc] = dist[r][c] + 1
        dq.append((nr, nc))

print(dist[N - 1][M - 1])