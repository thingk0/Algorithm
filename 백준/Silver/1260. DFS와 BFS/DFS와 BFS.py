import sys
from collections import deque

input = sys.stdin.readline

N, M, V = map(int, input().split())
adj_list = [[] for _ in range(N + 1)]

for _ in range(M):
  a, b = map(int, input().split())
  adj_list[a].append(b)
  adj_list[b].append(a)

for i in range(1, N + 1):
  adj_list[i].sort()


def dfs(start):
  visited = [False] * (N + 1)
  result = []

  def _dfs(node):
    visited[node] = True
    result.append(node)

    for neighbor in adj_list[node]:
      if not visited[neighbor]:
        _dfs(neighbor)

  _dfs(start)
  return result


def bfs(start):
  visited = [False] * (N + 1)
  result = []

  queue = deque([start])
  visited[start] = True
  result.append(start)

  while queue:
    node = queue.popleft()

    for neighbor in adj_list[node]:
      if not visited[neighbor]:
        visited[neighbor] = True
        result.append(neighbor)
        queue.append(neighbor)

  return result


print(*dfs(V))
print(*bfs(V))
