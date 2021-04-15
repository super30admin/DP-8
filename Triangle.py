# Time Complexity : O(N^2)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using DP Memoization. We are not mutating the array instead taking a separate array having only last row of triangle


class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        if not triangle:
            return None

        dp = [0] * len(triangle)

        #populating last row
        for i in range(len(dp)):
            dp[i] = triangle[len(triangle) - 1][i]

        #bottom up
        for i in range(len(triangle) - 2, -1, -1):
            for j in range(i + 1):
                dp[j] = min(dp[j], dp[j + 1]) + triangle[i][j]
        return dp[0]
