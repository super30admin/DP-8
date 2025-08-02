class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        n = len(triangle)
        dp = [[0 for i in range(n)]for j in range(n)]
        dp[0][0] = triangle[0][0]
        for i in range(1, n):
            for j in range(i+1):
                if j == 0:
                    dp[i][j] = triangle[i][j] + dp[i-1][j]
                elif j == i:
                    dp[i][j] = triangle[i][j] + dp[i - 1][j - 1]
                else:
                    dp[i][j] = triangle[i][j] + min(dp[i - 1][j - 1], dp[i - 1][j])
        return min(dp[n - 1])