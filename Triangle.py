-------------------------Minimum Total Top to Bottom------------------------------------------
# Time Complexity : O(MXN) as M is the number of rows and N is number of columns 
# Space Complexity : O(1)  No extra space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Here I am using top-down approach where I am iterating from Top from the second row and add the element from top and get the mini
# from the particular row, we will have a h=global min where we can add the min total up to this row to that element
# to get that element we will get the diff between min and global sums and add to the list.Once we iterate entire triangle will 
# return global min.

class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        if not triangle or len(triangle) == 0:
            return 0
        
        
        global_min = triangle[0][0]
        min_element = float('inf')
        path = [triangle[0][0]]
        for i in range(1,len(triangle)):
            for j in range(len(triangle[i])):
                if j == 0:
                    triangle[i][j] += triangle[i-1][j]
                elif j == len(triangle[i])-1:
                    triangle[i][j] += triangle[i-1][j-1]
                else:
                    triangle[i][j] += min(triangle[i-1][j-1], triangle[i-1][j])
                
                min_element = min(min_element, triangle[i][j])
            path.append(min_element-global_min)
            global_min =min_element
            min_element = float('inf')
        print(path)
        return global_min
        
-------------------------Minimum Total Bottom UP------------------------------------------
# Time Complexity : O(MXN) as M is the number of rows and N is number of columns 
# Space Complexity : O(1)  No extra space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Here I am using bottom up approach where I am iterating from bottom but one row and add the elements from the below row ro 
# the up row and get the minimum from that and add to the global min for each row. we will get the element from taking the
# difference of global min and local min elements. Return the global min once the iteration is completed.

        
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        if not triangle or len(triangle) == 0:
            return 0
        
        
        global_min = min(triangle[len(triangle)-1])
        min_element = float('inf')
        path = [global_min]
        for i in range(len(triangle)-2, -1, -1):
            for j in range(len(triangle[i])):
                triangle[i][j] += min(triangle[i+1][j], triangle[i+1][j+1])
                min_element = min(min_element, triangle[i][j])
            path.append(min_element-global_min)
            global_min =min_element
            min_element = float('inf')
        print(path)
        return global_min