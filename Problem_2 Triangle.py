# // Time Complexity : O(mn)
# // Space Complexity : O(row of triangle)
# // Did this code successfully run on Leetcode :
# // Any problem you faced while coding this :
#
#
# // Your code here along with comments explaining your approach
#DP Approach
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        if triangle == None or len(triangle) == 0 or len(triangle[0]) == 0:
            return 0
        n = len(triangle)
        dp = [[0] for i in range(n)]
        for i in range(n):
            dp[i] = triangle[n - 1][i]
        for i in range(n - 2, -1, -1):
            for j in range(i + 1):
                dp[j] = triangle[i][j] + min(dp[j], dp[j + 1])
            print(dp[i])
        return dp[0]

