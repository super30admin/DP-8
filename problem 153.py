# https://leetcode.com/problems/triangle/

class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        if triangle == None or len(triangle) == 0 or len(triangle[0]) == 0:
            return 0

        dp = [0] * (len(triangle[-1]))

        for i in range(len(dp)):
            dp[i] = triangle[len(dp) - 1][i]
        

        for i in range (len(triangle) - 2,-1,-1):
            for j in range(len(triangle[i])):
                dp[j] = min(dp[j],dp[j+1]) + triangle[i][j]
        
        return dp[0]

# TC: O(n^2)
# SC: O(n)