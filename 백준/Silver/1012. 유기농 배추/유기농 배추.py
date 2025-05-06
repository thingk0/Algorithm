import sys
from collections import deque

input = sys.stdin.readline
dirs = [(1, 0), (-1, 0), (0, 1), (0, -1)]


def bfs(field, visited, start_r, start_c, N, M):
  queue = deque([(start_r, start_c)])
  visited[start_r][start_c] = True

  while queue:
    r, c = queue.popleft()
    for dr, dc in dirs:
      nr, nc = r + dr, c + dc
      if 0 <= nr < N and 0 <= nc < M and field[nr][nc] == 1 and not visited[nr][nc]:
        visited[nr][nc] = True
        queue.append((nr, nc))


def count_connected_components(field, N, M):
  visited = [[False] * M for _ in range(N)]
  count = 0

  for r in range(N):
    for c in range(M):
      if field[r][c] == 1 and not visited[r][c]:
        bfs(field, visited, r, c, N, M)
        count += 1

  return count


def main():
  T = int(input())
  results = []

  for _ in range(T):
    M, N, K = map(int, input().split())
    field = [[0] * M for _ in range(N)]

    for _ in range(K):
      x, y = map(int, input().split())
      field[y][x] = 1

    results.append(count_connected_components(field, N, M))

  for res in results:
    print(res)


if __name__ == "__main__":
  main()
