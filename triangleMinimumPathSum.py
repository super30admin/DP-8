'''
Linear Solution
Time Complexity: O(n)
Space Complexity: O(1)
Did this code successfully run on Leetcode : Yes
Explanation: Add the last row to the output matrix, there are 2 choices to choose an index in the n-1th row take the min
of the 2 by taking the values from the output list ie min(output[j], output[j + 1]) and add the current weight ie triangle[i][j]
and overwrite the value in the output array.
the first element of the output array would be the answer as its the root node.
Eg.
4 1 8 3
7 6 10|3   | -> anything after bar is garbage collected
9 10 | 10
11 | 12
Answer - 11

'''

class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        n = len(triangle)

        output = [0 for i in range(len(triangle))]

        i = len(triangle) - 1

        for j in range(0, n):
            output[j] = triangle[i][j]

        cols = n - 1
        for i in range(n - 2, -1, -1):
            for j in range(0, cols):
                # min of 2 lower nodes + current cost
                # eg: min(4,1) + 6
                # overrides 4 with 6
                output[j] = min(output[j], output[j + 1]) + triangle[i][j]
            cols -= 1

        return output[0]