class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        m= len(triangle)
        for i in range(m-2,-1,-1):
            n= len(triangle[i])
            for j in range(n):
                triangle[i][j]+= min(triangle[i+1][j],triangle[i+1][j+1])
        return triangle[0][0]   
