# Approach - top down dp with memoization
# O(m * n) time and space where m is len of triangle and n is largest width

class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:

        def rec(i, j, cache):

            if i == len(triangle):
                return 0
            if (i, j) in cache:
                return cache[(i, j)]

            left_val = rec(i + 1, j, cache)
            right_val = rec(i + 1, j + 1, cache)

            cache[(i, j)] = triangle[i][j] + min(left_val, right_val)
            return triangle[i][j] + min(left_val, right_val)

        cache = {}
        return rec(0, 0, cache)