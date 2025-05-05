import sys

input = sys.stdin.readline

N = int(input())
students = [tuple(input().split()) for _ in range(N)]
students = [(name, int(kor), int(eng), int(math)) for name, kor, eng, math in students]
students.sort(key=lambda x: (-x[1], x[2], -x[3], x[0]))

for student in students:
  print(student[0])