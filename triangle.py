class Solution:
    
    """
    Description: Given a triangle array, return the minimum path sum from top to bottom 
    
    Time Complexity: O(E^2)
    Space Complexity: O(E)
    where, E is the length of an edge of the triangle
    
    Approach: use a dp array from last item of the given list of the list
    1. make a dp using last list from the given list of the list 
    2. go one step up, and add min of items from the dp array to modify the array in a loop
    3. the first item of dp array at the end results in the min path sum
    """
    
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        
        if triangle == None: return 
        
        dp = triangle[-1]
        
        for h in range(len(triangle) - 2, -1, -1):
            for i in range(len(triangle[h])):
                dp[i] = triangle[h][i] + min(dp[i], dp[i + 1])
                
        return dp[0]
