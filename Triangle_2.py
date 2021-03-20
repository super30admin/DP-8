# Created by Aashish Adhikari at 2:48 PM 3/20/2021

# Top-down Approach

'''
Time Complexity:
O(n)

Space Complexity:
O(1)
'''

class Solution(object):
    def minimumTotal(self, triangle):


        """
        :type triangle: List[List[int]]
        :rtype: int
        """


        for level in range(1, len(triangle)):

            for col in range(0, len(triangle[level])):

                if col == 0:
                    # first col in the level
                    triangle[level][col] += triangle[level-1][col]
                elif col == len(triangle[level])-1:
                    # last col in the level
                    triangle[level][col] = triangle[level][col] + triangle[level-1][col-1]
                else:
                    triangle[level][col] = triangle[level][col] + min(triangle[level-1][col-1], triangle[level-1][col])

        return min(triangle[-1])

