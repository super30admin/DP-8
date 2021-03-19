# Time Complexity : O(N)
# Space Complexity : O(N) N = len(triangle)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        if not triangle:
            return 0
        
        dp = [0 for i in range(len(triangle))]
        
        for i in range(len(dp)):
            dp[i] = triangle[len(dp)-1][i]
            
            
        for i in range(len(dp)-2, -1, -1):
            for j in range(i+1):
                dp[j] = min(dp[j], dp[j+1]) + triangle[i][j]

        return dp[0]