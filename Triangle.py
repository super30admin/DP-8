class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        
        dp = triangle[-1]
        #print(dp)
        for i in range(len(triangle[-1])-2,-1,-1):            
            for j in range(i+1):
                dp[j] = triangle[i][j] + min(dp[j],dp[j+1])
                
        return dp[0]
        
