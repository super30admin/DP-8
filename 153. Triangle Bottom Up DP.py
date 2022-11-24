class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        if triangle is None or len(triangle) == 0:
            return 0

        n = len(triangle)

        for i in range(n - 2, -1, -1):
            print(i)
            for j in range(i + 1):
                triangle[i][j] = triangle[i][j] + min(triangle[i + 1][j], triangle[i + 1][j + 1])

        return triangle[0][0]

# Bottom Up DP
# Time Complexity: O(m * n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
