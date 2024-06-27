def solution(nums):        
    rst = []
    for i in range(len(nums)):
        for j in range(i + 1, len(nums)):
            rst.append(nums[i] + nums[j])
    return sorted(set(rst))