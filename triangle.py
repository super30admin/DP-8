'''
TC: O(n)
SC: O(n)
'''
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        rlen = len(triangle)
        if not rlen:
            return 0
        clen = len(triangle[-1])
        dp =[triangle[rlen - 1][i] for i in range(clen)]
        
        for i in range(rlen - 2, -1, -1):
            clen -= 1
            for j in range(clen):
                dp[j]= min(dp[j], dp[j+1]) + triangle[i][j]
        
        return dp[0]

                
        