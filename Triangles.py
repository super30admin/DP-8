#120. Triangle
#Time complexity: O(n)
# Space complexity: O(1)

class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        m = len(triangle)
        for i in range(m-2, -1, -1):
            for j in range(0, i+1):
                triangle[i][j] = triangle[i][j]+(min(triangle[i+1][j],triangle[i+1][j+1]))
        return triangle[0][0]
