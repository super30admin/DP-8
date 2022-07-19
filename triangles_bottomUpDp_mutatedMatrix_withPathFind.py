'''Bottom-up dp'''
'''
Time Complexity: 0(n*m) 
Space Complexity: 0(1) --- mutate the matrix with list of [inx
Run on LeetCode: Yes

Other approaches:
1. Exhaustive: Choose Not Choose 
2. Top-down dp
'''
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        
        # start from 2nd last row and mutate the triangle
        # to get the path store in tuple pair (minimaIdx,calSum)
        
        # for last row update the cell in pair format
        for j in range(0,len(triangle[len(triangle)-1])):
            triangle[len(triangle)-1][j] = [None,triangle[len(triangle)-1][j]]
        
        # update the remaining matrix
        for i in range(len(triangle)-2,-1,-1):
            for j in range(0,len(triangle[i])):
                pair = [0,0]
                # get the minimaIdx i.e. i+1,j and i+1,j+1
                if triangle[i+1][j][1] < triangle[i+1][j+1][1]:
                    pair[0] = j
                else:
                    pair[0] = j+1
                
                # update the calSum
                calSum = triangle[i][j] + triangle[i+1][pair[0]][1]
                pair[1] = calSum
                
                # update the triangle
                triangle[i][j] = pair
            '''end of inner for loop'''
        '''end of outer for loop'''
        
        '''
        # print the mutated triangle
        for r in range(0,len(triangle)):
            print(triangle[r])
        print('\n')
        '''
        return triangle[0][0][1]
                