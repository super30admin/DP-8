class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        
        ######### DP O(m*n) time and O(n) space
        
        dp = [0 for _ in range(len(triangle[-1])) ]
        for i in range(len(triangle[-1])):
            dp[i] = triangle[-1][i]
        for i in range(len(triangle)-2,-1,-1):
            for j in range(len(triangle[i])):
                dp[j] = triangle[i][j] + min(dp[j],dp[j+1])
                
        return dp[0]
        
        ####### DP O(m*n) time in-place modification solution, O(1) space
        ######## If in-place modification is not allowed, create a 2D DP array (which can be further oprimized to 1D DP array)
#         for i in range(1,len(triangle)):
#             for j in range(len(triangle[i])):
#                 if j == 0:
#                     triangle[i][j] += triangle[i-1][j]
#                 elif j == len(triangle[i])-1:
#                     triangle[i][j] += triangle[i-1][j-1]
#                 else:
#                     triangle[i][j] += min(triangle[i-1][j],triangle[i-1][j-1])
        
#         return min(triangle[len(triangle)-1]) # This line takes O(n)
                