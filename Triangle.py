# Time Complexity : O(n^2), where n is the number of rows in the input triangle.
# Space COmplexity : O(1)
from typing import List


class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        n = len(triangle)
        
        # If the triangle has only one row
        if n == 1:
            return triangle[0][0]
        
        # Iterate from the second row from the bottom up to the top
        for i in range(n-2, -1, -1):
            # Iterate through each element in the current row
            for j in range(i+1):
                # Update the current element with the minimum of the two adjacent elements in the next row
                triangle[i][j] += min(triangle[i+1][j], triangle[i+1][j+1])
        
        # The minimum path sum is the top element of the triangle
        return triangle[0][0]