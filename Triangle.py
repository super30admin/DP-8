# TimeComplexity:O(m+n)
# SpaceComplexity:O(n*n)
# Approach:
# Very much similar to falling path sum problem tricky part is ranges for loop range for [idx][.] is either len(that part) or tracking with k each level range decreases by 1


#--------------------
# DP
#--------------------
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        
        dp=[[float('inf') for k in range(len(triangle))] for _ in range(len(triangle))]
        
        n=len(triangle)
        k=n-2
        if len(triangle)==1:return min(triangle[0])
        for i in range(len(triangle)):
            dp[-1][i]=triangle[-1][i]
        for i in range(n-2,-1,-1):
            for j in range(k+1):
                dp[i][j]=min(dp[i+1][j],dp[i+1][j+1])+triangle[i][j]
            k-=1
        # for p in dp:
        #     print(p)
        #     print()
        return dp[0][0]




#--------------------
# Mmeo
#--------------------

class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        #recursion
        memo=[[float('inf') for k in range(len(triangle))] for _ in range(len(triangle))]
        # memo[0][0]=triangle[0][0]
        def helper(i,j,ans,n):
            if i==n:return 0
            if memo[i][j]!=float('inf'):return memo[i][j]
            choice1=triangle[i][j]+helper(i+1,j,ans,n)
            choice2=triangle[i][j]+helper(i+1,j+1,ans,n)
            memo[i][j]=min(choice1,choice2)

            return min(choice1,choice2)
        return helper(0,0,0,len(triangle))


#--------------------
# Recursion
#--------------------
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        #recursion
        def helper(i,j,ans,n):
            if i==n:return 0
            choice1=triangle[i][j]+helper(i+1,j,ans,n)
            choice2=triangle[i][j]+helper(i+1,j+1,ans,n)
            return min(choice1,choice2)
        return helper(0,0,0,len(triangle))
