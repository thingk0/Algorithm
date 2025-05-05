import sys

input = sys.stdin.readline

N, M = map(int, input().split())
nums = list(map(int, input().split())) + list(map(int, input().split()))

print(*sorted(nums))