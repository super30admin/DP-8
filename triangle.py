class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        # T: O(n ** 2), S: O(n)
        n = len(triangle)
        dp = triangle[-1][:]  # Copy the last row

        for row in range(n - 2, -1, -1):  # Start from second last row
            for col in range(row + 1):
                dp[col] = triangle[row][col] + min(dp[col], dp[col + 1])

        return dp[0]
