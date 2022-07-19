# Time Complexity : O(N*N) where N is max number of elements in a row of the triangle
# Space Complexity : O(N) where N is max number of elements in a row of the triangle
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        n = len(triangle) - 1
        dp = [triangle[n][i] for i in range(len(triangle))]
        for i in range(len(triangle) - 2, -1, -1):
            for j in range(len(triangle[i])):
                dp[j] = min(triangle[i][j] + dp[j], triangle[i][j] + dp[j+1])
        return dp[0]