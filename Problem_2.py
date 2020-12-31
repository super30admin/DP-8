"""
Time Complexity : O(m*n)- length of last row
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : no

This is kind of minimum falling sum problem. here, we will start from second last row and every value will add the value of minimum
from beneath and one right. Keep on repeating until we reach top. and return the highest one. This is a bottom up approach. 
"""


class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        if not triangle or triangle == None:
            return 0
        m = len(triangle)
        for i in range(m-2, -1, -1):
            n = len(triangle[i])
            for j in range(n):
                triangle[i][j] += min(triangle[i+1][j], triangle[i+1][j+1])
        return(triangle[0][0])
