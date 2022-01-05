# Time Complexity : O(n*n / 2) where n - number of rows
# Space Complexity : O(1)
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        
        # Bottom up approach 
        # Start from the last to second row and compute the cost at the node from the next row elements.
        for i in range(len(triangle)-2, -1, -1) :
            for j in range(len(triangle[i])) :
                
                # Get the min cost in the next row from j and j+1 path 
                minVal = min( triangle[i+1][j] , triangle[i+1][j+1])
                
                # Update the node at the current row with the computed min value
                triangle[i][j] += minVal
                
        # The first node contains the total min cost of all the possible sub paths below
        return triangle[0][0]