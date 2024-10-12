
# TIme complexity - O(n)
# Space Complexity - O(1)
# Start from bottom-1 row and add the values from the bottom
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int: 
        n = len(triangle)
        for i in range(n-2,-1,-1):
            for j in range(i+1):
                triangle[i][j] += min(triangle[i+1][j], triangle[i+1][j+1])
        return triangle[0][0]

# TIme complexity - O(n^2)
# Space Complexity - O(n^2)
# class Solution:
#     def minimumTotal(self, triangle: List[List[int]]) -> int:
#         memo = {}
#         def helper(i,j):
#             if i >= len(triangle):
#                 return 0
#             if (i,j) in memo:
#                 return memo[(i,j)]
#             memo[(i,j)] = triangle[i][j] + min(helper(i+1,j),helper(i+1,j+1))
#             return memo[(i,j)]
#         return helper(0,0)
