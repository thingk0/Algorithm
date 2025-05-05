import sys

input = sys.stdin.readline

input()
targets = set(map(int, input().split()))

input()
queries = list(map(int, input().split()))

result = [1 if n in targets else 0 for n in queries]
print(*result, sep='\n')