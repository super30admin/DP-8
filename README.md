# DP-8

## Problem1 Arithmetic Slices (https://leetcode.com/problems/arithmetic-slices/)

# Time Complexity=O(n)
# Space Complexity=O(1)

class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        c=0
        res=0
        for i in range(2,len(nums)):
            if nums[i]-nums[i-1]==nums[i-1]-nums[i-2]:
                c+=1
                res+=c
            else:
                c=0
        return res
        

## Problem 2 Triangle (https://leetcode.com/problems/triangle/)

# Time Complexity=O(n**2)
# Space Complexity=O(1)
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        for i in range(len(triangle)-2,-1,-1):
            for j in range(len(triangle[i])):
                triangle[i][j]+=min(triangle[i+1][j],triangle[i+1][j+1])
        return triangle[0][0]
                
        

