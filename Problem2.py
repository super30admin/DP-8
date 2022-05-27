#Time Complexity : O(N*N)
#Space Complexity: O(N)
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        li = []
        for i in triangle[-1]:
            li.append(i)
        for i in range(len(triangle)-2,-1,-1):
            for j in range(0,i+1):
                li[j] = min(triangle[i][j] + li[j],triangle[i][j] + li[j+1])
                
        return li[0]
            