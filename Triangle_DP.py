# Bottom Up DP
# Time complexity : O(n*n)
# Space complexity : O(n*n)
# Leetcode : Solved and submitted

class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        # check for null case
        if not triangle:
            return 0
          
        # declare a dp array of size n*n
        n = len(triangle)
        dp = [[0 for _ in range(n)] for _ in range(n)]
        
        # fill the last row
        for i in range(n):
            dp[n-1][i] = triangle[n-1][i]
        
        # traverse over the whole of triangle and fill the dp matrix with values of current index plus the mimum of the next row
        for i in range(n-2,-1,-1):
            for j in range(i+1):
                dp[i][j] = triangle[i][j] + min(dp[i+1][j+1], dp[i+1][j])
        
        # return the final answer as the first value in dp matrix
        return dp[0][0]
