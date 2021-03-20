# Created by Aashish Adhikari at 1:54 PM 3/20/2021

# DP Bottom-Up

'''
Time Complexity:


Space Complexity:

'''

class Solution(object):
    def minimumTotal(self, triangle):
        """
        :type triangle: List[List[int]]
        :rtype: int
        """


        dp = triangle[-1]

        for level in range(len(triangle)-2, -1, -1):


            cols_in_level = len(triangle[level])

            for col in range(0, cols_in_level):

                dp[col] =  triangle[level][col] + min(dp[col], dp[col+1])


        return dp[0]