# 120. Triangle
# https://leetcode.com/problems/triangle/

# DP
# Logic: Starting from the second last row, we calculate the min child 
# in the below row and add it to the parent. In the same way we iterate 
# to the top. The root will be the min and we return it.

# Time Complexity: O(n*n)
# Space Complexity: O(1)

class Solution:
    def minimumTotal(self, triangle) -> int:
        R = len(triangle)
        
        for i in range(R-2, -1, -1):
            for j in range(0, len(triangle[i])):
                triangle[i][j] += min(triangle[i+1][j], triangle[i+1][j+1])
        
        return triangle[0][0]


# Brute Force
# Logic: We make a tree and traverse the tree. At any 
# point we take the min and return it. We return parent 
# node plus min of child nodes.

# Time Complexity: O(2^n)
# Space Complexity: O(n)

class Solution:
    def _helper(self, triangle, row, col):
        # Base
        if row == len(triangle):
            return 0
        
        c1 = self._helper(triangle, row + 1, col)
        c2 = self._helper(triangle, row + 1, col + 1)
        
        return triangle[row][col] + min(c1, c2)

    def minimumTotal(self, triangle: List[List[int]]) -> int:
        return self._helper(triangle, 0, 0)