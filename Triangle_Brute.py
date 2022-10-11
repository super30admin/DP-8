# Time complexity : O(n*m)
# Space complexity : O(1)
# Leetcode : Solved and submitted

class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        # check for null case
        if not triangle:
            return 0
          
        # find the length of the triangle
        n = len(triangle)
        
        # traverse over the triangle starting from the last but 2 row
        for i in range(n-2,-1,-1):
            # traverse over the triangle column wise starting from 0th index till i + 1, as we have one more element in the column in row below
            for j in range(i+1):
                # sum up the value at the index with the current value + the minimum of the other two
                triangle[i][j] = triangle[i][j] + min(triangle[i+1][j+1], triangle[i+1][j])
        
        return triangle[0][0]
