# Time Complexity : O(N^2)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        #mutate same triangle -  bottom up
        
        n = len(triangle) #height of the triangle
        
        for i in range(n-2,-1,-1): #start from last but one row
            for j in range(0,i+1):
                triangle[i][j]+=min(triangle[i+1][j],triangle[i+1][j+1])
        
        
        return triangle[0][0]
    
        
                
            