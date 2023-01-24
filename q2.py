# Time Complexity : O(n*n), Where n is length of the triangle array
# Space Complexity : O(n*n), Where n is length of the triangle array
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nothing specific

from typing import List

class Solution:    
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        dp=[[None for i in range(len(triangle))] for j in range(len(triangle))] 
        n=len(triangle)
        for i in range(n-1,-1,-1):
            for j in range(0,i+1):
                if(i==n-1):
                    dp[i][j]=triangle[i][j]
                else:
                    dp[i][j]=triangle[i][j]+min(dp[i+1][j],dp[i+1][j+1])
        #print(dp)
        return dp[0][0]
        