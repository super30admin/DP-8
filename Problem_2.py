# Time Complexity: O(n^2)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution(object):
    def minimumTotal(self, triangle):
        """
        :type triangle: List[List[int]]
        :rtype: int
        """
        for i in reversed(range(len(triangle) - 1)):
            for j in range(i + 1):
                triangle[i][j] += (min(triangle[i + 1][j], triangle[i + 1][j + 1]))
        return triangle[0][0]