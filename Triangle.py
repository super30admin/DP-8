# Time Complexity : O(n^2)
# Space Complexity : O(n^2)
# The code ran on LeetCode
# Bottom-up DP to keep track of the minimum path seen at every node

class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        n = len(triangle)
        dp = [[0 for _ in range(n)] for _ in range(n)]
        path = [[float('inf') for _ in range(n)] for _ in range(n)]

        path[-1] = [0]*n
        dp[-1] = triangle[-1]
        
        for i in range(n-2, -1, -1):
            for j in range(i+1):
                dp[i][j] = triangle[i][j] + min(dp[i+1][j], dp[i+1][j+1])
                path[i][j] = j if dp[i+1][j] < dp[i+1][j+1] else j+1
        res = []; nxt = path[0][0]
        res.append(triangle[0][0])
        for i in range(1, n):
            res.append(triangle[i][nxt])
            nxt = path[i][nxt]
        return dp[0][0]