# Time Complexity: O(n2)
# Space Complexity: O(1)
from typing import List


class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:

        m = len(triangle)  # row

        for r in range(1, m):
            for c in range(r + 1):

                small_value = float('inf')

                if c > 0:
                    small_value = triangle[r - 1][c - 1]

                if c < r:
                    small_value = min(small_value, triangle[r - 1][c])

                triangle[r][c] += small_value

        return min(triangle[-1])

