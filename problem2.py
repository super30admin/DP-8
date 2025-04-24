class Solution:
    def __init__(self):
        self.min_sum = float("inf")

    def minimumTotal(self, triangle: List[List[int]]) -> int:
        # top down recursion with memoization method
        n = len(triangle)
        dp = triangle[-1]

        for i in range(n - 2, -1, -1):
            for j in range(i + 1):
                dp[j] = triangle[i][j] + min(dp[j], dp[j + 1])

        return dp[0]


class Solution:
    def __init__(self):
        self.min_sum = float("inf")

    def minimumTotal(self, triangle: List[List[int]]) -> int:
        self.helper(triangle, 0, 0, 0)
        return self.min_sum

    def helper(self, triangle, r, c, currSum):
        # base case
        if r == len(triangle):
            self.min_sum = min(self.min_sum, currSum)
            return

        # logic
        self.helper(triangle, r + 1, c, currSum + triangle[r][c])
        self.helper(triangle, r + 1, c + 1, currSum + triangle[r][c])


# #time complexity is O(n^2)
# #space complexity is O(n^2)