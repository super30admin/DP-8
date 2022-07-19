# Time Complexity : O(N*N) where N is avg number of elements in a row of the triangle
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        for i in range(len(triangle) - 2, -1, -1):
            for j in range(len(triangle[i])):
                triangle[i][j] = min(triangle[i][j] + triangle[i+1][j], triangle[i][j] + triangle[i+1][j+1])
        
        return triangle[0][0]