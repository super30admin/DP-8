# Time Complexity: O(n) - n is dimentions of triangle
# Space Complexity: O(1) - modify grid in-place
class Solution(object):
    def minimumTotal(self, triangle):
        """
        :type triangle: List[List[int]]
        :rtype: int
        """
        n = len(triangle)
        
        # Base cases
        for row in range(1, n):
            # Left side
            triangle[row][0] = triangle[row-1][0] + triangle[row][0]
            # Right side
            triangle[row][row] = triangle[row-1][row-1] + triangle[row][row]
        
        for row in range(2, n):
            for col in range(1, row):
                triangle[row][col] = triangle[row][col] + min(triangle[row-1][col], triangle[row-1][col-1])
        return min(triangle[-1])
        