""""// Time Complexity : O(n*n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""

# Not Mutating Matrix-
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        l1 = triangle[-1]
        for i in range(len(triangle) - 2, -1, -1):
            l2 = [0] * (i + 1)
            for j in range(len(triangle[i])):
                l2[j] = min((triangle[i][j] + l1[j]), (triangle[i][j] + l1[j + 1]))
            l1 = l2
        return l1[0]

""""// Time Complexity : O(n*n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""
# Mutating Matrix-
# class Solution:
#     def minimumTotal(self, triangle: List[List[int]]) -> int:
#         n=len(triangle)
#         for i in range(n-2,-1,-1):
#             for j in range(len(triangle[i])):
#                 triangle[i][j]=min(triangle[i][j]+triangle[i+1][j],triangle[i][j]+triangle[i+1][j+1])
#         return triangle[0][0]



# Exhaustive- Recursion
# class Solution:
#     def minimumTotal(self, triangle: List[List[int]]) -> int:
#         i=0
#         j=0
#         return self.helper(triangle, i, j, 0, len(triangle))
#     def helper(self, triangle, i, j, total, n):
#         #base
#         if i==n-1:
#             return total+triangle[i][j]
#         #logic
#         x= self.helper(triangle, i+1, j, total+triangle[i][j], n)
#         y= self.helper(triangle, i+1, j+1, total+triangle[i][j], n)
#         return min(x, y)


