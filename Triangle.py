# Time:- i*j i:- the number of rows in the triangle, j=the number of columns in the triangle
# Space:- i*j
# Approach:- at every point we have two option we can take the element directly below the element, or the element adjacent to it in below row.
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        @lru_cache(maxsize=None)
        def mt(i,j):
            # j can go out of bounds doesnt mean we have nothing to explore
            if j==len(triangle[i]):
                return sys.maxsize
            # i should stay in the bounds we are at the last row in the triangle
            if i==len(triangle)-1:
                return triangle[i][j]
            return triangle[i][j]+min(mt(i+1,j),mt(i+1,j+1))
        return mt(0,0)