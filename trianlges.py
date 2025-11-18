# Time Complexity : O(N^2) as we are iterating through the triangle list
# Space Complexity : O(N) as we are using extra space to store the dp array
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
# I am using a bottom-up dynamic programming approach to solve the triangle minimum path sum problem.
# I start from the second last row of the triangle and move upwards to the top.
# For each element, I update its value to be the sum of itself and the minimum of the two elements directly below it.
# This way, by the time I reach the top of the triangle, the top element will contain the minimum path sum from top to bottom.  

from typing import List
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        #TC O(N^2) SC O(N)
        n = len(triangle)
        dp = triangle[-1][:]
        for i in range(n-2,-1,-1):
            for j in range(i+1):
                dp[j] = triangle[i][j] + min(dp[j],dp[j+1])
        print(dp)
        return dp[0]