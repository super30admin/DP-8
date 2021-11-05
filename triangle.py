# // Time Complexity :O(m*n)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach


class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        
        curr=triangle[0][0]
        minn=0
        for i in range(1,len(triangle)):
            for j in range(i+1):
                if j==0:
                    triangle[i][j]+=triangle[i-1][j]
                elif j==i:
                    triangle[i][j]+=triangle[i-1][j-1]
                else:
                    triangle[i][j]+=min(triangle[i-1][j],triangle[i-1][j-1])
        return min(triangle[len(triangle)-1])
                