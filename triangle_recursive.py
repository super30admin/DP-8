# Time Complexity : O(2*M) where m is total number of elements in a row of the triangle
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        return self.traverse(triangle, 0, 0, 0)
        
    def traverse(self, triangle, row, index, currSum):
        #base
        if row == len(triangle):
            return currSum
        
        #logic
        left = self.traverse(triangle, row+1, index, currSum +  triangle[row][index])
        if index + 1 <= len(triangle[row]):
            right = self.traverse(triangle, row+1, index + 1, currSum +  triangle[row][index])
        
        return min(left, right)