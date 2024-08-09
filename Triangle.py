# Time Complexity : O(n^2)
# Space Complexity : O(n)
class Solution:
    def minimumTotal(self, triangle: list[list[int]]) -> int:
        n = len(triangle)
        dp = triangle[-1][:]

        # Bottom-up calculation
        for i in range(n - 2, -1, -1):
            for j in range(i + 1):
                dp[j] = triangle[i][j] + min(dp[j], dp[j + 1])

        return dp[0]

# Examples

# Example 1
solution = Solution()
triangle = [[2],
    [3, 4],
    [6, 5, 7],
    [4, 1, 8, 3]]
result = solution.minimumTotal(triangle)
print(result)  # Output: 11

# Example 2
solution = Solution()
triangle = [[-10]]
result = solution.minimumTotal(triangle)
print(result)  # Output: -10

# Example 3
solution = Solution()
triangle = [[1],
    [2, 3],
    [4, 5, 6],
    [7, 8, 9, 10]]
result = solution.minimumTotal(triangle)
print(result)  # Output: 14