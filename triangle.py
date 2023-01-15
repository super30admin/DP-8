class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        ## T.C = O(n.n)
        ## S.C = O(1)
        
        n = len(triangle) 
        print(n)
        for i in range(n-2, -1, -1):
            for j in range(0, i+1):
               triangle[i][j] = triangle[i][j] + min(triangle[i+1][j], triangle[i+1][j+1])
            
        return triangle[0][0]