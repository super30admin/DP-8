#time O(N*N)
#space O(1)

class Solution(object):
    def minimumTotal(self, triangle):
        for i in range(len(triangle) -2, -1, -1):
            for j in range(len(triangle[i])):
                # print(len(triangle[i]))
                triangle[i][j] += min(triangle[i+1][j], triangle[i+1][j+1])
                print(triangle[i][j])
        return triangle[0][0]