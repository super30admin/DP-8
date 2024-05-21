# Time Complexity : O(n*n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
from typing import List
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        n = len(triangle)

        for i in range(1, n):
            for j in range(i+1):
                if(j==0):
                    triangle[i][j] = triangle[i][j] + triangle[i-1][j]
                elif(j==i):
                    triangle[i][j] = triangle[i][j] + triangle[i-1][j-1]
                else:
                    triangle[i][j] = triangle[i][j] + min(triangle[i-1][j], triangle[i-1][j-1])

        result = float('inf')
        for num in triangle[n-1]:
            result = min(result, num)
        
        return result