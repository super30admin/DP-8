# Time Complexity : O(mxn) 
# Space Complexity :O(mxn)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

# Method-1) in case you as a follow-up question need to print the path that gave the minimum sum.
# Tc = O(n^2) | Sc = O(1)
class Solution:
    def minimumTotal(self, triangle):
        if len(triangle) == 0:
            return 0 
        arr = []
        sum_ = triangle[0][0]
        arr.append(sum_)
        #    2 
        #   5 6
        #11 10 13
        #15 11 
        for i in range(1, len(triangle)):
            globalMin = float('inf')
            
            for j in range(len(triangle[i])):
                localMin = float('inf')
                
                if j-1 >= 0 and j-1 < len(triangle[i-1]):
                    localMin = min(localMin, triangle[i-1][j-1])
                
                if j >= 0 and j < len(triangle[i-1]):
                    localMin = min(localMin, triangle[i-1][j])
                
                globalMin = min(globalMin, triangle[i][j] + localMin)  #15
                triangle[i][j] = triangle[i][j] + localMin 
            
            arr.append(globalMin - sum_)
            sum_ = globalMin 
        
        # print(arr)
        # print(triangle)
        return sum_

# Method- 2) Using O(n) extra space.
# O(n^2) | Sc = O(n)
class Solution:
    def minimumTotal(self, triangle):
        if len(triangle) == 0:
            return 0 
        n = len(triangle)
        arr = [0 for _ in range(len(triangle)+1)]
        print(arr)
        for row in triangle[::-1]:
            for i in range(len(row)):
                arr[i] = row[i] + min(arr[i],arr[i+1])
        print(triangle)
        print(arr)
        return arr[0]
    
if __name__ == "__main__":
    s = Solution()
    res = s.minimumTotal([[2],[3,4],[6,5,7],[4,1,8,3]])
    assert res == 11