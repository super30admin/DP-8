class Solution:
    def TopDownminimumTotal(self, triangle: List[List[int]]) -> int:
        '''
        Top Down 
        time:  (O(M+N))
        space: O(1)
        '''
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
    
    def BottomUpminimumTotal(self, triangle: List[List[int]]) -> int:
        """
        Bottom up approach 
        time:  (O(M+N))
        space: O(1)
        """ 
        if len(triangle) == 1: return triangle[0][0]
        for row in range(len(triangle)-1, 0, -1 ):
            for col in range(len(triangle[row])-1):
                triangle[row-1][col] += min(triangle[row][col],triangle[row][col+1])
        return triangle[0][0]
