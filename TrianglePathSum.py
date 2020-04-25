'''
Solution:
1. Perform DP as there are repeated subproblems.

Recursive equation:
For each cell in current row => path to current cell towards down = min(two attached bottom cells)

Time Complexity:    O(n x n) #  n^2 / 2 in actual
Space Complexity:   O(n x n) #  n^2 / 2 in actual

--- Passed all testcases successfully on leetcode.
'''


class TrianglePathSum:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        
        #   edge case check
        if (triangle == None or len(triangle) == 0):
            return 0
        
        #   initializations
        rows = len(triangle)
        cols = len(triangle[rows-1])
        
        output = triangle[rows - 1]
        cols -= 1
        
        #   for each row from bottom
        for row in range(rows - 2, -1, -1):
            
            #   each cell = current cell value + min(bottom two attached cells)
            for col in range(cols):
                output[col] = triangle[row][col] + min(output[col], output[col + 1])
            
            #   decrement number of cols to be iterated by 1
            cols -= 1
        
        #   return the first cell value   
        return output[0]