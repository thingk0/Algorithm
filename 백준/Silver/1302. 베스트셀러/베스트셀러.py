import sys
from collections import Counter

input = sys.stdin.readline

N = int(input())
books = [input().strip() for _ in range(N)]

best_select = Counter(books)
max_count = max(best_select.values())

candidates = [title for title, cnt in best_select.items() if cnt == max_count]
result = min(candidates)

print(result)