#Time Complexity : O(n*m) where n is the number of rows and m is the number of columns
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes

class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        if not triangle:
            return 0

        #BOTTOM UP - TC: O(n*m) where n is the number of rows and m is the number of columns, SC: O(1)
        for r in range(len(triangle)-2, -1, -1):
            for i in range(len(triangle[r])):
                triangle[r][i] = triangle[r][i] + min(triangle[r+1][i], triangle[r+1][i+1])

        return triangle[0][0]
