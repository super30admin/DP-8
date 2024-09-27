// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach:
for the last row of the triangle,there are no dependents .so we store the last row elements in an array.
a)we start with n-2 row and for every value in n-2 row we check with the adjacent neigbours which are nearer and store the min value of that index value in the out array.
b)In this way we override the values of out array till we reach the first row.
c)The value of out[0] gives the min value from top to bottom.

# Time complexity --> o(n*n) n is the size of the traingle
# space complexity --> o(n)
class Solution(object):
    def minimumTotal(self, triangle):
        """
        :type triangle: List[List[int]]
        :rtype: int
        """
        if triangle==None or len(triangle)==0:
            return []
        out=triangle[len(triangle)-1]
        for i in range(len(triangle)-2,-1,-1):
            val=triangle[i]
            for j in range(len(val)):
            #checking with the neighbour values of the current index value.
                out[j]=min(val[j]+out[j],val[j]+out[j+1])
        return out[0]