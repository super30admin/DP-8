# Time Complexity : O(m*n)
# Space Complexity : O(1) inplace
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# similar to house coloring problem
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        
        for i in range(len(triangle)-2,-1,-1):
            
            ele = len(triangle[i])
            
            j = 0
            
            while j < ele:
                triangle[i][j]+= min(triangle[i+1][j],triangle[i+1][j+1])
                j += 1
        
        return triangle[0][0]
        