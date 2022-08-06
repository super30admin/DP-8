# Time Complexity : O(mn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        if len(triangle) < 2:
            return triangle[0][0]

        for i in range(len(triangle)-1, 1, -1):
            for k in range(len(triangle[i])-1):
                triangle[i-1][k] += min(triangle[i][k], triangle[i][k+1])

        return triangle[0][0] + min(triangle[1][0], triangle[1][1])
