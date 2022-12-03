#Time: O(n * k)
#Space: O(1)
#Program ran on leetcode successfully

class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        if triangle is None or len(triangle) == 0 or len(triangle[0]) == 0:
            return 0
        
        n = len(triangle)
        
        for i in reversed(range(n-1)):
            level = triangle[i]
            for j in range(len(level)):
                triangle[i][j] = triangle[i][j] + min(triangle[i+1][j], triangle[i+1][j+1])
        
        return triangle[0][0]
        