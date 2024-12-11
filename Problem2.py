# Problem 2: Triangle
from typing import List
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        n = len(triangle)

        def helper(i,j):
            if i == n: return 0
            if dp[i][j] != float("inf"): return dp[i][j]

            currSum = triangle[i][j]
            left = helper(i+1,j)
            right = helper(i+1,j+1)

            dp[i][j] = currSum + min(left,right)
            return currSum + min(left,right)

        dp = [[float("inf") for _ in range(n)] for _ in range(n)]
        return helper(0,0)
        
        