import sys
input = sys.stdin.readline

N = int(input())
arr = list(map(int, input().split()))

comp = {v: i for i, v in enumerate(sorted(set(arr)))}
print(*(comp[x] for x in arr))