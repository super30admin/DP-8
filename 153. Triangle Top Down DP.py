class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        if triangle is None or len(triangle) == 0:
            return 0

        n = len(triangle)
        minimum = float("inf")
        for i in range(1, n):
            for j in range(i + 1):
                if j == 0:
                    triangle[i][j] = triangle[i][j] + triangle[i - 1][0]
                elif j == i:
                    triangle[i][j] = triangle[i][j] + triangle[i - 1][-1]
                else:
                    triangle[i][j] = triangle[i][j] + min(triangle[i - 1][j - 1], triangle[i - 1][j])

        for i in range(len(triangle[-1])):
            minimum = min(minimum, triangle[-1][i])
        return minimum

# Top Down DP
# Time Complexity: O(m * n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
