class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        if triangle == None or len(triangle) == 0 or len(triangle[0]) == 0:
            return 0
        n = len(triangle)
        dp = [0] * n
        
        for i in range(n):
            dp[i] = triangle[n-1][i]
            
        for i in range(n-2, -1, -1):
            for j in range(i+1):
                dp[j] = triangle[i][j] + min(dp[j], dp[j+1])
                
        return dp[0]

# Time Complexity : O(n^2)
# Space Complexity: O(n)


class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        if triangle == None or len(triangle) == 0 or len(triangle[0]) == 0:
            return 0
        n = len(triangle)
        
            
        for i in range(n-2, -1, -1):
            for j in range(i+1):
                triangle[i][j] = triangle[i][j] + min(triangle[i+1][j], triangle[i+1][j+1])
                
        return triangle[0][0]

# Time Complexity : O(n^2)
# Space Complexity: O(1)
            
