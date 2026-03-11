# Time Complexity : O(N^2)  # We process each element once
# Space Complexity : O(N)   # DP array storing minimum path for each row
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# Start from the bottom row and move upward.
# Each element becomes its value plus the minimum of its two children.
# The top element finally stores the minimum path sum.

class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        dp = triangle[-1][:]

        for i in range(len(triangle)-2, -1, -1):
            for j in range(len(triangle[i])):
                dp[j] = triangle[i][j] + min(dp[j], dp[j+1])

        return dp[0]