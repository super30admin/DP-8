# Time Complexity: O (n)(Where n is total numbers in triangle) 
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# This can be solved by replacing current level's element by adding minimum of adjacent element from previous level to current element.

class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        depth = len(triangle)
#       iterating over triangle level by level
        for d in range(1, depth):
#           Handling edge cases for first and last element of each level as it does not have 2 adjacent elements in previous level.
            triangle[d][0] += triangle[d-1][0]
            triangle[d][d] += triangle[d-1][d-1]
#           Filling in all element except fisrt and last element in the level.
            for i in range(1,d):
#               Update current element by adding minimum adjacent element from previous level
                triangle[d][i] = triangle[d][i] + min(triangle[d-1][i], triangle[d-1][i-1])
#       Return min elemnt from last level.
        return min(triangle[depth - 1])
