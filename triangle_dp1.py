"""
Time Complexity : O(m*n) where m is the row and n is the column of the triangle list
Space Complexity : O(1) as no auxillary data structure is use
"""


class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        if len(triangle) == 0:
            return 0
        n = len(triangle)

        for i in range(n-2, -1, -1):
            for j in range(i+1):
                triangle[i][j] = triangle[i][j] + \
                    min(triangle[i+1][j], triangle[i+1][j+1])

        return triangle[0][0]
