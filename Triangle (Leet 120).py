'''
Using Bottom up dp
modifying same array
Time: (O(mn))
Space: O(1)
'''

class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        
        n = len(triangle)
        
        for i in range(n-2,-1,-1):
            
            for j in range(i+1):
                triangle[i][j] = triangle[i][j] + min(triangle[i+1][j],triangle[i+1][j+1])
                
        return triangle[0][0]


# Using dp array Space: O(mn)
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        
        n = len(triangle)
        dp = [[0 for j in range(_+1)] for _ in range(len(triangle))]
        
        for i in range(len(triangle[-1])):
            dp[-1][i] = triangle[-1][i]
        for i in range(n-2,-1,-1):
            
            for j in range(i+1):
                dp[i][j] = triangle[i][j] + min(dp[i+1][j],dp[i+1][j+1])
                
        return dp[0][0]


# using O(m) space
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        
        n = len(triangle)
        dp = [0 for _ in range(len(triangle[-1]))]
        
        for i in range(len(triangle[-1])):
            dp[i] = triangle[-1][i]
        print(dp)    
        
        for i in range(n-2,-1,-1):
            for j in range(i+1):
                dp[j] = triangle[i][j] + min(dp[j],dp[j+1])
                
        return dp[0]


# if question asks for the path

class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        
        n = len(triangle)
        dp = [[0 for j in range(_+1)] for _ in range(len(triangle))]
        path = [[0 for j in range(_+1)] for _ in range(len(triangle))]
        
        for i in range(len(triangle[-1])):
            dp[-1][i] = triangle[-1][i]
        for i in range(n-2,-1,-1):
            
            for j in range(i+1):
                if dp[i+1][j] < dp[i+1][j+1]:
                    path[i][j] = j
                else:
                    path[i][j] = j+1
                dp[i][j] = triangle[i][j] + min(dp[i+1][j],dp[i+1][j+1])
        print(path) 
        return dp[0][0]


'''
Using Top Down DP
'''

class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        
        n = len(triangle)
        
        for i in range(1, len(triangle)):
            for j in range(i+1):
                if j == 0:
                    triangle[i][j] += triangle[i-1][j]
                elif j == i:
                    triangle[i][j] += triangle[i-1][j-1]
                else:
                    triangle[i][j] += min(triangle[i-1][j],triangle[i-1][j-1])
        mi = float('inf')
        for i in range(len(triangle)):
            mi = min(mi, triangle[-1][i])
        return mi
        
        



'''
Using dfs
Time: Exponential (Time limit exceeded)
'''
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        if triangle is None:
            return 0
        
        self.min = float('inf')
        self.helper(triangle,0,0,0)
        
        return self.min
    
    def helper(self, triangle, i,j, currSum):
        if i >= len(triangle):
            return
        
        if i == len(triangle)-1:
            self.min = min(currSum + triangle[i][j], self.min)
        
        self.helper(triangle, i+1,j,currSum+triangle[i][j])
        self.helper(triangle, i+1,j+1,currSum+triangle[i][j])
        