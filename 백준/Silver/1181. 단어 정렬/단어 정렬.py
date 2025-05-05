import sys

input = sys.stdin.readline
result = []

n = int(input())
for _ in range(n):
  result.append(input().strip())

result = list(set(result))
result.sort(key=lambda x: (len(x), x))
print(*result, sep='\n')