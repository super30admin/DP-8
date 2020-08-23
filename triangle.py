# Top - down approach
# Keep storing the sum of elements from the top of the triangle until the last level. 
# return the minimum sum at the last level.
# Time complexity - O(n) where n is all the elements of a triangle.
# Space complexity - O(1) # modify the underlying array
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        n = len(triangle)
        
        for i in range(1, n):
            for j in range(i+1):
                triangle[i][j] += min(triangle[i-1][min(j, i-1)], triangle[i-1][max(0, j-1)])
        
        return min(triangle[-1])


# Bottom - Up approach
# Keep storing the minimum sum of elements from the bottom of the triangle until the level 0.
# return the sum at the first level.
# Time complexity - O(n) where n is all the elements of a triangle.
# Space complexity - O(1) # modify the underlying array
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        n = len(triangle)
        
        for i in range(n-2, -1, -1):
            for j in range(i+1):
                triangle[i][j] += min(triangle[i+1][j], triangle[i+1][j+1])
        
        return triangle[0][0]
        
    