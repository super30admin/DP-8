#Time: O(N)
#Space: O(n)
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        res = list(triangle[-1])
        for i in range(len(triangle)-2,-1,-1):
            for j in range(len(triangle[i])):
                res[j] = min(res[j],res[j+1])+triangle[i][j]
                #print(res)
        return res[0] 
