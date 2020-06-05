"""
// Time Complexity : O(M*N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
Algorithm Explanation
Given below
"""
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        """
        Idea (Following the similar paradigm of paint house and minimum failing path sum)
        Algo
        - Iterate from penultimate row up towards 0
        - Update the value at jth column in the given row using min of row+1's j-1th column and row+1's j+1th column
        - Return row[0]
        """
        n = len(triangle)
        for i in range(n-2,-1,-1):
            for j in range(i+1):
                triangle[i][j] = min(triangle[i][j]+triangle[i+1][j],
                                     triangle[i][j]+triangle[i+1][j+1])
        return triangle[0][0]