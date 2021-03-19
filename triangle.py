# Approach 1 - In place solution
# Similar to house robber/paint house 

# Optimize - when we cant mutate array
# Bottom Up approach
# Time - O(N^ 2)
# Space - O(N)

class Solution:

    def minimumTotal(self, triangle: List[List[int]]) -> int:
        
        dp = triangle[-1]
        
        for i in range(len(triangle) - 2, -1, -1):
            for j in range(len(triangle[i])):
                print(dp[j])
                dp[j] = min(dp[j], dp[j+1]) + triangle[i][j]
                           
                           
        return dp[0]