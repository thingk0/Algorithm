import sys

input = sys.stdin.readline
n = int(input())

coords = [tuple(map(int, input().split())) for _ in range(n)]
for x, y in sorted(coords, key=lambda t: (t[1], t[0])):
    print(x, y)