class Solution:
    '''
    Time: O(n^2)
    Space: O(1)
    '''
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        for i in range(1,len(triangle)):
            for j in range(0,len(triangle[i])):
                if(j<len(triangle[i-1]) and j>=1):
                    triangle[i][j] += min(triangle[i-1][j], triangle[i-1][j-1])
                elif(j>=len(triangle[i-1])):
                    triangle[i][j] += triangle[i-1][j-1]
                else:
                    triangle[i][j] += triangle[i-1][j]
        return min(triangle[-1])
