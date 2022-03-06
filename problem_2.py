# TC:O(n^2)
# SC:O(1)

class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        if triangle is None or len(triangle) == 0:
            return 0

        n = len(triangle)

        for i in range(1, n):
            for j in range(0, i + 1):
                if j == 0:
                    triangle[i][j] += triangle[i - 1][j]
                elif j == i:
                    triangle[i][j] += triangle[i - 1][j - 1]
                else:
                    triangle[i][j] += min(triangle[i - 1][j], triangle[i - 1][j - 1])

        _min = sys.maxsize

        for num in triangle[-1]:
            _min = _min if _min < num else num

        return _min
