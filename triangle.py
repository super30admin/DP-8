# O(n^2) time, O(1) space
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        # [ [2],
        #  [5,6],
       # [11,10,13],
    #r  [15,11,18,16]]r=3,c=3
        for row in range(1,len(triangle)):
            for col in range(row+1): # row 1 has 2 columns, row 2 has 3 columns, etc
                smallestAbove = float('inf') 
                # Left edge
                if col == 0:
                    smallestAbove = triangle[row-1][col]
                # right edge
                elif col == row:
                    smallestAbove = triangle[row-1][col-1]
                # not and edge, check both
                else:
                    leftAbove = triangle[row-1][col-1]
                    rightAbove = triangle[row-1][col]
                    smallestAbove=min(leftAbove,rightAbove)
                triangle[row][col]+=smallestAbove
  
        return min(triangle[-1])
