#Approach
#The triange can have path to doen or down left for every path from ends check the minand update


#Complexities
#Time: O(n*m)
#Sapce : O(n*m)


from typing import List


class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        dp = [[0] * len(triangle) for _ in range(len(triangle))]

        for j in range(len(triangle)):
            dp[len(triangle) - 1][j] = triangle[len(triangle) - 1][j]
        for i in range(len(triangle) - 2, -1, -1):
            for j in range(len(triangle[i])):
                print(i, j, triangle[i][j])
                dp[i][j] = min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle[i][j]

        return dp[0][0]
