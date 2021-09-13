


class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        #Time Complexity: O(N^2)

        #Space Complexity: O(N) 
        if len(triangle) ==0:
            return 0
        n = len(triangle)
        dp = triangle[n-1]
        for i in range(n-2,-1,-1):
            sz = i+1
            for j in range(0,sz):
                dp[j] = triangle[i][j]+min(dp[j],dp[j+1])
        return dp[0]
        

class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        #Time Complexity: O(N^2)

        #Space Complexity: O(1) 
        if len(triangle) ==0:
            return 0
        n = len(triangle)
       
        for i in range(n-2,-1,-1):
            sz = i+1
            for j in range(0,sz):
                triangle[i][j] = triangle[i][j]+min(triangle[i+1][j],triangle[i+1][j+1])
        return triangle[0][0] 
        