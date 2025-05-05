import sys

input = sys.stdin.readline
n = int(input())

result = [tuple(map(int, input().split())) for _ in range(n)]
result.sort(key=lambda x: (x[0], x[1]))

for x, y in result:
  print(x, y)