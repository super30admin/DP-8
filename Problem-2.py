class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        
        for i in range(len(triangle)-2,-1,-1):
            for j in range(len(triangle[i])):
                triangle[i][j]+=min(triangle[i+1][j],triangle[i+1][j+1])
                # if j==0:
                #     triangle[i][j]+=triangle[i-1][j]
                # elif j==len(triangle[i])-1:
                #     triangle[i][j]+=triangle[i-1][j-1]
                # else:
                #     triangle[i][j]+=min(triangle[i-1][j],triangle[i-1][j-1])
                             
        return triangle[0][0]
        