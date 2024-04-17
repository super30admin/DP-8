"""
Time Complexity : O(m*n) where m is the row and n is the column of the triangle list
Space Complexity : O(m*n) where m is the row and n is the column of the triangle list

If changing the original array is not allowed
"""


class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        if len(triangle) == 0:
            return 0
        n = len(triangle)
        dp = [0 for _ in range(n)]

        for j in range(n):
            dp[j] = triangle[n-1][j]
        for i in range(n-2, -1, -1):
            for j in range(i+1):
                dp[j] = triangle[i][j] + min(dp[j], dp[j+1])

        return dp[0]
