
#Time Complexity: 0(n*m) 
#Space Complexity: 0(1) 

class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:

        for j in range(0,len(triangle[len(triangle)-1])):
            triangle[len(triangle)-1][j] = [None,triangle[len(triangle)-1][j]]

        for i in range(len(triangle)-2,-1,-1):
            for j in range(0,len(triangle[i])):
                pair = [0,0]
                if triangle[i+1][j][1] < triangle[i+1][j+1][1]:
                    pair[0] = j
                else:
                    pair[0] = j+1

                calSum = triangle[i][j] + triangle[i+1][pair[0]][1]
                pair[1] = calSum

                triangle[i][j] = pair
        
        return triangle[0][0][1]
