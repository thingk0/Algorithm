import sys

input = sys.stdin.readline

N = int(input())
nums = sorted(map(int, input().split()))

best_l, best_r = 0, N - 1
best_sum = 10 ** 10

left, right = 0, N - 1
while left < right:
  tmp = nums[left] + nums[right]
  if abs(best_sum) > abs(tmp):
    best_sum = tmp
    best_l, best_r = left, right

  if tmp > 0:
    right -= 1
  else:
    left += 1

print(nums[best_l], nums[best_r])