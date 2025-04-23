'''
    Time Complexity: O(n^2)
    Space Complexity: O(n)
'''
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        n = len(triangle)
        dp = [0 for _ in range(n)]

        dp[0] = triangle[0][0]
        prevDp = dp[:]

        for i in range(1, n):
            dp[0] = prevDp[0] + triangle[i][0]
            for j in range(1, i+1):
                val = triangle[i][j]

                if j < i:
                    dp[j] = min(prevDp[j-1] + val, prevDp[j] + val)
                else:
                    dp[j] = prevDp[j-1] + val

            prevDp = dp[:]

        return min(dp)