#120 triangle
# time - O(m*n)
# space - O(1)
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        
        for i in range(1, len(triangle)):
            
            for j in range(0, len(triangle[i])):
                
                if i - 1 == 0:
                    triangle[i][j] = triangle[i][j] + triangle[0][0]
                    continue
                    
                if (j == 0 or j == len(triangle[i])- 1):
                    
                    if j == 0:
                        
                        triangle[i][j] = triangle[i][j] + triangle[i - 1][0]
                    else:
                        
                        triangle[i][j] = triangle[i][j] + triangle[i - 1][len(triangle[i - 1]) - 1]
                else:
                    
                    triangle[i][j] = triangle[i][j] + min(triangle[i - 1][j - 1], triangle[i - 1][j])
                    
        
        return min(triangle[-1])
        
