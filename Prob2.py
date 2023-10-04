class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        #Method 1 - Recursive - TLE - TC O(2^n) and SC - O(1)
        #Esentially, explore all possible paths and each elevel get min from below. And in the end get to the root and return the val at root.
        #2->3->6->4->0(l) and 0(r) so, at 4 it is min(0,0)+4=4.Then, go up to 6 and explore 6's right and so on.
        #You will observe repeats, ex-1 is reached from 6 and 5, 8 is reahced by 5 and 7 and many more such exmaples.-> DP
        # def dfs(triangle,r,c):
        #     #base
        #     if r==len(triangle): return 0
        #     #logic
        #     case1=dfs(triangle,r+1,c)
        #     case2=dfs(triangle,r+1,c+1)
        #     return min(case1,case2)+triangle[r][c]
        # return dfs(triangle,0,0)

        #Method 2 - 2D DP - Do the same thing, but with DP go level by level in a bottom up manner.
        #TC and SC-O(n^2) and 
        n=len(triangle)
        for i in range(n-2,-1,-1):
            for j in range(0,i+1):
                triangle[i][j]=triangle[i][j]+min(triangle[i+1][j],triangle[i+1][j+1])
        return triangle[0][0]

