# Time Complexity: O(n^2), where n is the number of rows in the triangle
# Space Complexity: O(1) — done in-place modifying the input triangle

class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        if not triangle or not triangle[0]:
            return 0

        n = len(triangle)
        if n == 1:
            return triangle[0][0]

        # Bottom-up DP
        for i in range(n - 2, -1, -1):
            for j in range(len(triangle[i])):
                triangle[i][j] += min(triangle[i + 1][j], triangle[i + 1][j + 1])

        return triangle[0][0]
