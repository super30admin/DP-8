# Time complexity : O(n^2)
# Space complexity : O(n)
# Works on leetcode : Yes
#Approach -  We use bottom-up approach here, starting from last second row in triangle and using last row as result. We
# iterate row-wise and set res[j] as minimum of current j and and prev j plus current element in triangle. 
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        res = list(triangle[-1])
        for i in range(len(triangle)-2,-1,-1):
            for j in range(len(triangle[i])):
                res[j] = min(res[j],res[j+1])+triangle[i][j]
                #print(res)
        return res[0]