import sys

input = sys.stdin.readline

n = int(input())
meetings = []
for _ in range(n):
  s, e = map(int, input().split())
  meetings.append((e, s))

meetings.sort()

last_end = 0
count = 0

for end, start in meetings:
  if start >= last_end:
    count += 1
    last_end = end

print(count)