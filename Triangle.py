#Time complexity: O(n^2)
#Space complexity: O(1)
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        res = 0
        n = len(triangle)
        
        for i in range(n-2, -1, -1):
            for j in range(i+1):
                triangle[i][j] += min(triangle[i+1][j], triangle[i+1][j+1])
        
        return triangle[0][0]
#Time complexity: O(n^2)
#Space complexity: O(n^2)
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        res = 0
        n = len(triangle)
        dp = [[0 for _ in range(n)] for _ in range(n)]
        for j in range(n):
            dp[n-1][j] = triangle[n-1][j]
        for i in range(n-2, -1, -1):
            for j in range(i+1):
                dp[i][j] = triangle[i][j] + min(dp[i+1][j], dp[i+1][j+1])
        
        return dp[0][0]
                
              
#Time complexity: O(n^2)
#Space complexity: O(n)
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        res = 0
        n = len(triangle)
        dp = [0 for _ in range(n)]
        for j in range(n):
            dp[j] = triangle[n-1][j]
        for i in range(n-2, -1, -1):
            for j in range(i+1):
                dp[j] = triangle[i][j] + min(dp[j], dp[j+1])
        
        return dp[0]
                
        
