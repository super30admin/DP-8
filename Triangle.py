#All TC passed on leetcode

class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:


         #Here both top-bottom or bottom-top appraoch is possible. In cur row and cur index we add min of nums from prev row (similar topascal's triangle).
        #Time complexity - O(m.n) where m is no. of rows and n is avg length of row
        #Space complexity - O(1)
        n = len(triangle)
        m = len(triangle[n-1])
        path = [[0]*m for i in range(n)]

        for i in range(1, n):
            for j in range(len(triangle[i])):
                if j==0:
                    triangle[i][j] = triangle[i][j] + triangle[i-1][j]
                    path[i][j] = j

                elif j==len(triangle[i])-1:
                    triangle[i][j] = triangle[i][j] + triangle[i-1][j-1]
                    path[i][j] = j-1

                else:
                    if triangle[i-1][j]<triangle[i-1][j-1]:
                        triangle[i][j] = triangle[i][j] + triangle[i-1][j]
                        path[i][j] = j
                    else:
                        triangle[i][j] = triangle[i][j] + triangle[i-1][j-1]
                        path[i][j] = j-1
        
        print(path)

        
        return min(triangle[n-1])

        