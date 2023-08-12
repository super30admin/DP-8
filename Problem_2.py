"""
Problem : 2

Time Complexity : O(n^2)
Space Complexity : O(n)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""

# Triangle

# Approach - 1
# Recursive

class Solution(object):
    def __init__(self):
        self.psum=float('inf')
    def minimumTotal(self, triangle):
        """
        :type triangle: List[List[int]]
        :rtype: int
        """
        self.helper(triangle,0,0,0)
        return self.psum

    def helper(self,triangle,idx,row,pathsum):
        if row>=len(triangle) or row<0 or idx>=len(triangle[row]) or idx<0:
            return

        pathsum+=triangle[row][idx]
        
        if row==len(triangle)-1:
            self.psum=min(self.psum,pathsum)
        self.helper(triangle,idx,row+1,pathsum)

        self.helper(triangle,idx+1,row+1,pathsum)

# Approach - 2
# Bottom up DP - Mutating the input matrix

class Solution(object):
    def minimumTotal(self, triangle):
        """
        :type triangle: List[List[int]]
        :rtype: int
        """
        n=len(triangle)
        # dp=[0 for _ in range(len(triangle[-1]))
        for i in range(n-2,-1,-1):
            li=triangle[i]
            for j in range(len(li)):
                triangle[i][j]=triangle[i][j]+min(triangle[i+1][j],triangle[i+1][j+1])
        return triangle[0][0]
    
# Approach - 3
# Bottom up DP Array with path

class Solution(object):
    def minimumTotal(self, triangle):
        """
        :type triangle: List[List[int]]
        :rtype: int
        """
        n=len(triangle)
        dp=[triangle[n-1][i] for i in range(len(triangle[n-1]))]
        path=[[0 for _ in range(n)] for _ in range(n)]
        for i in range(n-2,-1,-1):

            for j in range(len(triangle[i])):
                if dp[j]<dp[j+1]:
                    path[i][j]=j
                else:
                    path[i][j]=j+1
                dp[j]=triangle[i][j]+min(dp[j],dp[j+1])
        print(path)
        return dp[0]


# Approach - 4
# Top Down DP Array with path

class Solution(object):
    def minimumTotal(self, triangle):
        """
        :type triangle: List[List[int]]
        :rtype: int
        """
        n=len(triangle)
        for i in range(1,n):
            for j in range(len(triangle[i])):
                if j==0:
                    triangle[i][j]+=triangle[i-1][j]
                elif j==len(triangle[i])-1:
                    triangle[i][j]+=triangle[i-1][j-1]
                else:
                    triangle[i][j]+=min(triangle[i-1][j],triangle[i-1][j-1])
        return min(triangle[n-1])
    
# Approach - 5
# Memoization

class Solution(object):
    def __init_(self):
        self.memo=None
    def minimumTotal(self, triangle):
        """
        :type triangle: List[List[int]]
        :rtype: int
        """
        m=len(triangle)
        n=len(triangle[m-1])
        self.memo=[[float('inf') for _ in range(n)] for _ in range(n)]
        return self.helper(triangle,0,0,m,n)
        
    def helper(self,triangle,i,j,m,n):

        if i==len(triangle)-1:
            return triangle[i][j]

        case1=0
        case2=0

        # case 1
        if i<n-1 and self.memo[i+1][j]==float('inf'):
            self.memo[i+1][j]=self.helper(triangle,i+1,j,m,n)
        case1=self.memo[i+1][j]


        # case 2
        if i<n-1 and self.memo[i+1][j+1]==float('inf'):
            self.memo[i+1][j+1]=self.helper(triangle,i+1,j+1,m,n)
        case2=self.memo[i+1][j+1]
        return triangle[i][j]+min(case1,case2)