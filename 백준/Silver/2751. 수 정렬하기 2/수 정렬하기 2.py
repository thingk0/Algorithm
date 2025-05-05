import sys

input = sys.stdin.readline

n = int(input())
result = [int(input()) for _ in range(n)]

print(*sorted(result), sep='\n')