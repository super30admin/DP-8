# Time: O(n)
# Space: O(1) 
# Did it run on Leetcode: yes

# either top-down start from 0th row or bottom-up start from last-but-one row.
# choose tje min at each level and add it to the current value and at the end choose the min value
class Solution(object):
    def minimumTotal(self, triangle):
        """
        :type triangle: List[List[int]]
        :rtype: int
        """
        # O(n) bottom-up with path
        # n=len(triangle)
        # path=[[0 for i in range(n-1)]for j in range(n-1)]
        # for i in range(n-2, -1,-1):
        #     for j in range(i+1):
        #         minel=min(triangle[i+1][j], triangle[i+1][j+1])
        #         if(triangle[i+1][j]<triangle[i+1][j+1]):
        #             path[i][j]=j
        #         else:
        #             path[i][j]=j+1
        #         triangle[i][j] = triangle[i][j]+minel
        # print(path)
        # return triangle[0][0]


        # top-down:O(n) 
        n=len(triangle)
        for i in range(1, n):
            for j in range(i+1):
                if(j==0):
                    triangle[i][j]=triangle[i][j]+ triangle[i-1][j]
                elif(j==i):
                    triangle[i][j]=triangle[i][j]+ triangle[i-1][j-1]
                else:
                    triangle[i][j]=triangle[i][j]+ min(triangle[i-1][j], triangle[i-1][j-1])
        ans=min(triangle[n-1])
        return ans
