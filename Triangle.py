import sys
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        """Top Down DP Approach
        Time complexity-O(2*m*n)
        Space complexity-O(1)
        """
        for i in range(1, len(triangle)):
            for j in range(i+1):
                if j==0:
                    triangle[i][j]=triangle[i][j]+triangle[i-1][j]
                elif j==i:
                    triangle[i][j]=triangle[i][j]+triangle[i-1][j-1]
                else:
                    triangle[i][j]=triangle[i][j]+min(triangle[i-1][j-1],triangle[i-1][j])
        mini=float('inf')
        for i in range(len(triangle)):
            mini=min(mini, triangle[len(triangle)-1][i])
        return mini
                            
                
        """Bottom Up DP Approach
        Time complexity-O(m*n)
        Space complexity-O(1)"""
        # n=len(triangle)
        # for i in range(n-2,-1,-1):
        #     for j in range(i+1):
        #         triangle[i][j]=triangle[i][j]+min(triangle[i+1][j], triangle[i+1][j+1])
        # return triangle[0][0]
        """DP Bottom Up Approach
        Time complexity-O(mn) where m is the length and n is the height of triangle
        Space complexity-O(m) as we are using array and not matrix"""
        # n=len(triangle)
        # dparr=[0 for i in range(n)]
        # for i in range(len(dparr)):
        #     dparr[i]=triangle[n-1][i]
        # for i in range(len(dparr)-2,-1,-1):
        #     for j in range(i+1):
        #         dparr[j]=triangle[i][j]+min(dparr[j], dparr[j+1])
        # return dparr[0]
                
            
        