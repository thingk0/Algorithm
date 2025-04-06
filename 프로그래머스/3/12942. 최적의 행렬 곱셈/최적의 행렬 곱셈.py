def solution(matrix_sizes):
    n = len(matrix_sizes)
    
    dimensions = [matrix_sizes[0][0]]
    for size in matrix_sizes:
        dimensions.append(size[1])
    
    dp = [[0] * n for _ in range(n)]
    
    for length in range(1, n):
        for i in range(n - length):
            j = i + length
            dp[i][j] = float('inf')
            
            for k in range(i, j):
                cost = dp[i][k] + dp[k+1][j] + dimensions[i] * dimensions[k+1] * dimensions[j+1]
                
                dp[i][j] = min(dp[i][j], cost)
    
    return dp[0][n-1]