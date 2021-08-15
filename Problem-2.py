from copy import deepcopy
class Solution:
    #Approach: DP - bottom up, space optimized
    """
    TC: O(n) where n-> all elements in triangle
    SC: O(k) where n -> levels/steps in triangle
    """
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        n = len(triangle)
        dp = deepcopy(triangle[-1])
        
        for i in range(n-2,-1,-1):
            for j in range(len(dp)):
                if not len(triangle[i]) > j >= 0: continue # keep triangel co-ordinates inbound
                dp[j] = triangle[i][j] + min(dp[j], dp[j+1])
        return dp[0]