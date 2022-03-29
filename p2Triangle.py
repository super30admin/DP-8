"""
  time:  (O(M+N))
  space: O(1)
""" 
    
class Solution:

    def minimumTotal(self, triangle: list[list[int]]):
        if len(triangle) == 1: return triangle[0][0]

        for row in range(len(triangle)-1, 0, -1 ):
            for col in range(len(triangle[row])-1):
                triangle[row-1][col] += min(triangle[row][col],triangle[row][col+1])

        return triangle[0][0]