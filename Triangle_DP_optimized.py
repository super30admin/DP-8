# Optimized DP
# Time complexity : O(n*m)
# Spae complexity : O(n)
# Leetcode : Solved and submitted

class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        # check for null case
        if not triangle:
            return 0
          
        # declare a 1-d array of size n
        n = len(triangle)
        dp = [0 for _ in range(n)]
        
        # fill the last row
        for i in range(n):
            dp[i] = triangle[n-1][i]
        
        # traverse over the triangle array and update the dp
        for i in range(n-2,-1,-1):
            for j in range(i+1):
                # update dp with the value of triangle at that index and also the minimum of the other values
                dp[j] = triangle[i][j] + min(dp[j], dp[j+1])
        
        # return the first element as we are movinf bottom up
        return dp[0]
