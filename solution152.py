#Time Complexity:O(mn)
#Space Complexity:O(m)
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        if len(triangle)==0:
            return 0
        dp=[0 for i in range(len(triangle))]
        dp=triangle[-1]                                         #append into dp the last level of the triangle
        for i in reversed(range(len(dp)-1)):                    # starting from the last second level of the triangle
            for j in range(i+1):                                #for every element in that level of the triangle, 
                dp[j]=min(dp[j],dp[j+1])+triangle[i][j]         #add the element to the minimum between two elements in dp array and update the dp array with same
        return dp[0]                                            #return first element of dp array