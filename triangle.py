"""
Bottom Up approach --
TC - O(N)
SC - O(1)
"""

class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        if triangle is None or len(triangle) == 0: return 0

        n = len(triangle)

        # start with n-2 row (second last row)
        for i in range(n - 2, -1, -1):
            # 0 to i so added i+1
            for j in range(0, i + 1):
                # curr element can be added to min of lower two j, j+1 elements
                # eg. in row n-2 of 1st input, 5 can access 1(triangle[i+1][j]), 8(triangle[i+1][j+1])
                triangle[i][j] = triangle[i][j] + min(triangle[i + 1][j], triangle[i + 1][j + 1])
        return triangle[0][0]
