# problem 1

#https://leetcode.com/problems/arithmetic-slices/

class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        count = 0 
        n = len(nums)
        c = 0
        for i in range(2,n):
            if nums[i] - nums[i-1] == nums[i-1] - nums[i-2]:
                c+=1
            else:
                c = 0
            count = count+c
        return count 