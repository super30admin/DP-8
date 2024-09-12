'''
Accepted on leetcode(120)
time - O(N) -> N - no. of elements in Triangle.
space - O(1)
Iterative approach.
'''
class Solution:
    def minimumTotal(self, triangle) -> int:
        # edge case
        if len(triangle) == 0:
            return 0

        # logic - Iterate over all the elements in the triangle from second last row and take the minimum from next row neighbors and add to current row.
        for i in range(len(triangle) - 2, -1, -1):
            for j in range(0, i + 1):
                # At 6, 6 + min(4,1) -> changing the value in place.
                triangle[i][j] = triangle[i][j] + min(triangle[i + 1][j], triangle[i + 1][j + 1])

        return triangle[0][0]



'''
Accepted on leetcode(120)
time - O(N) -> N - no. of elements in Triangle.
space - O(1)
DP array approach.
'''
class Solution2:
    def minimumTotal(self, triangle) -> int:
        # edge case
        if len(triangle) == 0:
            return 0
        # initialize dp array
        dp = []

        # fill dp array
        for i in range(len(triangle)):
            dp.append(triangle[len(triangle) - 1][i])

        # logic - Iterate over all the elements in the triangle from second last row and take the minimum from next row neighbors and add to current row using dp.
        for i in range(len(triangle) - 2, -1, -1):
            for j in range(0, i + 1):
                # At 6, 6 + min(4,1) -> changing the value in place for dp array.
                dp[j] = triangle[i][j] + min(dp[j], dp[j + 1])

        return dp[0]