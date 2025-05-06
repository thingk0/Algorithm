import sys
from collections import defaultdict

input = sys.stdin.readline

N = int(input())
grid = [input().rstrip() for _ in range(N)]

parent = list(range(N * N))
size = [1] * (N * N)


def find(x):
  if parent[x] != x:
    parent[x] = find(parent[x])
  return parent[x]


def union(a, b):
  ra, rb = find(a), find(b)

  if ra == rb:
    return

  if size[ra] < size[rb]:
    ra, rb = rb, ra

  parent[rb] = ra
  size[ra] += size[rb]


dirs = [(1, 0), (-1, 0), (0, 1), (0, -1)]

for r in range(N):
  for c in range(N):
    if grid[r][c] == '1':
      idx = r * N + c
      for dr, dc in dirs:
        nr, nc = r + dr, c + dc
        if 0 <= nr < N and 0 <= nc < N and grid[nr][nc] == '1':
          nidx = nr * N + nc
          union(idx, nidx)

islands = defaultdict(int)
for r in range(N):
  for c in range(N):
    if grid[r][c] == '1':
      root = find(r * N + c)
      islands[root] += 1

island_sizes = sorted(islands.values())

print(len(island_sizes))
for size in island_sizes:
  print(size)