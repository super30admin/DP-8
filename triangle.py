# Time Complexity : O(N) N -> Height of triangle
# Space Complexity : Not sure ?? I just store the last row and keep updating the same 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        
        dp = []
        
        m = len(triangle)
        for i in range(len(triangle[m-1])):
            dp.append(triangle[m-1][i])
            
        for i in reversed(range(m-1)):
            for j in range(len(triangle[i])):
                dp[j] = triangle[i][j]+min(dp[j],dp[j+1])
                
        return dp[0]
            
        