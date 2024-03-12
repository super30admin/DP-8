#TC: O(2^m*n)
#SC: O(h)
#Time Limit exceeded

class Solution:
    global result
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        self.result=float('inf')
        self.helperFunction(0,0,0,triangle)
        return self.result
    def helperFunction(self, i, row, total,triangle):
        #Base
        if row==len(triangle):
            self.result=min(self.result, total)
            return
        #Logic:
        #Choose i
        self.helperFunction(i,row+1, total+triangle[row][i],triangle)
        #Choose i+1
        if len(triangle[row])>i+1:
            self.helperFunction(i+1,row+1, total+triangle[row][i+1],triangle)
            
            
#TC: O(n^2) [no of elements in the triangle]
#SC: O(n) [Bottom row of the triangle]
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        if len(triangle)==1:
            return min(triangle[0])
        dp=triangle[-1]
        i=len(triangle)-2
        for i in range(len(triangle)-2,-1,-1):
            for j in range(0, len(triangle[i])):
                dp[j]=min(dp[j],dp[j+1])+triangle[i][j]
                
        return dp[0]

