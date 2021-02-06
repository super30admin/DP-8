class Solution(object):
    def minimumTotal(self, triangle):
        """
        :type triangle: List[List[int]]
        :rtype: int
        """
        #O(size of triangle)
        #O(1)
        #bottom to top
        #keep last row untouched
        #start checking from 2nd last row all the way to top
        if not triangle:
            return 0
        rows=len(triangle)
        for i in range(rows-2,-1,-1):
            for j in range(len(triangle[i])):
                first=triangle[i+1][j]+triangle[i][j]
                second=triangle[i+1][j+1]+triangle[i][j]
                triangle[i][j]=min(first,second)
        return triangle[0][0]
        
        
                
                
        
    
                