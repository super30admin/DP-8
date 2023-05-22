class Solution:
    #TC-O(n^2),SC-O(1)
    #starting from the last second row, replace each elem by the sum of itself with min of i and i+1 elem in the next row.the first row and first col elem gives the answer
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        n=len(triangle)
        for i in range(n-2,-1,-1):
            for j in range(0,i+1):
                triangle[i][j]=triangle[i][j]+min(triangle[i+1][j],triangle[i+1][j+1])
        return triangle[0][0]