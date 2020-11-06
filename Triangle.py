class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        #Time: O(N)
        #Space: O(N)
        if not triangle:
            return 0
        if len(triangle)==1:
            return triangle[0][0]
        sol = triangle[-1]
        for i in range(len(triangle)-2,-1,-1):
            for j in range(i+1):
                if j==0:
                    sol[j]=triangle[i][j]+min(sol[0],sol[1])
                elif j==i:
                    sol[j]=triangle[i][j]+min(sol[j],sol[j+1])
                else:
                    sol[j]=triangle[i][j]+min(sol[j],sol[j+1])
            sol.pop()
        return min(sol)
                    