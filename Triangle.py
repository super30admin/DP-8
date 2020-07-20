#Time Complexity : O(N*M) where N is Number of rows and M is number of Columns
#Space Complexity : O(N) Number of elements stored in dp
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        if (triangle == None or len(triangle) == 0):
            return 0
        rows = len(triangle)
        cols = len(triangle[rows-1])

        dp = triangle[rows - 1]
        for row in range(rows - 2, -1, -1):
            for col in range(0,row+1):
                dp[col] = triangle[row][col] + min(dp[col], dp[col + 1])
        return dp[0] 
==============================================================================================
#Time Complexity : O(N*M) where N is Number of rows and M is number of Columns
#Space Complexity : O(1) 
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        if (triangle == None or len(triangle) == 0):
            return 0
        rows = len(triangle)
        cols = len(triangle[rows-1])
        for row in range(rows - 2, -1, -1):
            for col in range(0,row+1):
                triangle[row][col] = triangle[row][col] + min(triangle[row+1][col], triangle[row+1][col + 1])
        return triangle[0][0] 