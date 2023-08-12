# Time Complexity : O(n**2)
# Space Complexity :O(n)
# Passed on Leetcode: yes

class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        n = len(triangle)

        dp = [i for i in triangle[n-1]]

        for i in range(n-2, -1, -1):
            for j in range(len(triangle[i])):
                dp[j] = triangle[i][j] + min(dp[j], dp[j+1])


        return dp[0]