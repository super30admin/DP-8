class Solution:    
    
    """
        
        Name : Shahreen Shahjahan Psyche
        Time : O(N*(N+1)/2)
        Space: O(N*(N+1)/2)
        
        Passed All Test Cases in LC : Yes
        
        Approach : # Its a bottom up DP 1-D DP.
                   # Initilize a dp array of the full length of the triangle array
                   # Start populating dp array from the last row of the triangle
                   # if its is last row, copy the values directly in the dp array
                   # if not, then take the sum of the current triangle value and the minimum value of the dp array's - > dp[curr_pos - length(previous_row)] and
                     dp[curr_pos - length(previous_row)-1]
                   # Finally, return the last index value of the dp array
        
    """
    
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        if not triangle:
            return 0
        
        n = len(triangle)
        size = (n*(n+1))//2
        
        track = [0 for _ in range(size)]
        pos = 0
        
        for i in range(n-1, -1, -1):
            for j in range(i+1):
                if i == n-1:
                    track[pos] = triangle[i][j]
                else:
                    track[pos] = triangle[i][j] + min(track[pos - (i + 2)], track[pos - (i+1)]) # Here we are deducting the previous row's length's size
                pos += 1
        return track[size-1]
        
        
