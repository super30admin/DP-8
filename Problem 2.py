# Time: O(number of elements)
# Space: O(1)
class Solution(object):
    def minimumTotal(self, triangle):
        """
        :type triangle: List[List[int]]
        :rtype: int
        """
        for i in range(1, len(triangle)):
            for j in range(len(triangle[i])):
                mn = 100000000007
                if j - 1 >= 0:
                    mn = min(triangle[i-1][j-1], mn)
                if j < i:
                    mn = min(triangle[i-1][j], mn)
                triangle[i][j] += mn
        ans = 100000000000007
        for i in triangle[len(triangle)-1]:
            ans = min(ans, i)
        return ans
        
