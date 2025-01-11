# The minimumTotal method calculates the minimum path sum from the top to the bottom of a triangle.

# Dynamic Programming Approach:
# - Start from the bottom row and move upwards.
# - Use a 1D `dp` array to store the minimum path sum for each position.
# - For each element, update `dp[col]` as the current value plus the minimum of the two possible paths below.

# Return the top element of `dp` as the result.

# TC: O(n^2) - Process each element in the triangle.
# SC: O(n) - Space for the DP array.


from typing import List


class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        n = len(triangle)
        dp = triangle[-1][:]

        for row in range(n - 2, -1, -1):
            for col in range(len(triangle[row])):
                dp[col] = triangle[row][col] + min(dp[col], dp[col + 1])
        
        return dp[0]