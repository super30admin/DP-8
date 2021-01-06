"""
Bottom up appraoch 
TC=O(N) where N is no of elements in total triangle

"""

class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        if not triangle:
            return 0
        n=len(triangle)
        for i in range(n-2,-1,-1): #start with n-2 indexed row and keep going up
            for j in range(len(triangle[i])):
                triangle[i][j]=triangle[i][j]+min(triangle[i+1][j+1],triangle[i+1][j])#row below curr row adjacent 2 elements
        return triangle[0][0]
        