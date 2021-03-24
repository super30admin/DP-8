"""
Time Complexity : O(m*n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Explaination
use bottom up approach
go from last second last row. for each element in this row look for min element out of j]th element and j+1]th element in the next row
i.e. min (arr[i+1][j], arr[i+1][j+1]). 
add this min elemement to the arr[i][j]
go in upper rows at last return arr[0][0]
"""

class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        row = len(triangle)
        for i in range(row-2, -1, -1):
            for j in range(len(triangle[i])):
                triangle[i][j] = triangle[i][j] + min(triangle[i+1][j], triangle[i+1][j+1])
        return triangle[0][0]
        