#Time complexity is O(n*n)
#Space complexity is O(1)
#No issues faced while coding
#Code ran successfully on leetcode
class Solution(object):
    def minimumTotal(self, triangle):
        """
        :type triangle: List[List[int]]
        :rtype: int
        """
        #Taking length of the triangle
        n=len(triangle)
        #Iterating from last but one row
        for i in range(n-2,-1,-1):
            for j in range(0,i+1):
                #Updating the values with the minimum value
                triangle[i][j]=triangle[i][j]+min(triangle[i+1][j],triangle[i+1][j+1])
        #FInally we are returning the top most value
        return triangle[0][0]
        
        