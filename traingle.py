# SC:O(n)
# TC: O(n^2)

class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        dp=[0]*(len(triangle)+1)

        for row in triangle[::-1]:
            #print(row)
            for i,n in enumerate(row):
                dp[i]=n+min(dp[i],dp[i+1])


        return dp[0]