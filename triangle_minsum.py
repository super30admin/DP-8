"""
TC: O(n*m)  where n is the total number of rows in the triangle, m is number of columns
SP: O(1), No additional space
iterate from bottom to top, at each level take min of current index and neighbor index
Modify given triangel list itself 
"""
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        n = len(triangle)
        for i in range(n - 2, -1, -1):
            for j in range(i + 1):
                triangle[i][j] += min(triangle[i + 1][j], triangle[i + 1][j + 1])
        return triangle[0][0]
