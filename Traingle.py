# Time Complexity: O(n^2)
# Space Complexity: O(1)
# Inplace from top to bottom Approach
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        n = len(triangle)
        for i in range(1, n):
            for j in range(i + 1):
                if j == 0:
                    triangle[i][j] += triangle[i - 1][0]
                elif j == i:
                    triangle[i][j] += triangle[i - 1][j - 1]
                else:
                    triangle[i][j] += min(triangle[i - 1][j], triangle[i - 1][j - 1])
        return min(triangle[n - 1])

# Time Complexity: O(n^2)
# Space Complexity: O(1)
# DP Approach
# class Solution:
#     def minimumTotal(self, triangle: List[List[int]]) -> int:
#         n = len(triangle)
#         dp = [[0] * n for _ in range(n)]
#         dp[0][0] = triangle[0][0]

#         for i in range(1, n):
#             for j in range(i + 1):
#                 if j == 0:
#                     dp[i][j] = triangle[i][j] + dp[i-1][0]
#                 elif j == i:
#                     dp[i][j] = triangle[i][j] + dp[i-1][j-1]
#                 else:
#                     dp[i][j] = triangle[i][j] + min(dp[i-1][j], dp[i-1][j-1])

#         return min(dp[n-1])