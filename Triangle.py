"""
Time Complexity : O(n^2) where n is the length of last row in the triangle
Space Complexity : O(n) where n is the length of last row in the triangle
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        if len(triangle) == None or len(triangle) == 0:
            return 0
        n = len(triangle)
        # Storing the last row of the triangle
        dp = triangle[-1]
        # We traverse through the last second row and caluclate the minimum at every
        # point and add it to the current value. We return the first element as we 
        # compute the minimum sum backwards
        for i in range(n-2, -1, -1):
            for j in range(i+1):
                dp[j] = triangle[i][j] + min(dp[j] , dp[j + 1])
        return dp[0]