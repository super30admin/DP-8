#Time: O(2^n)
#Space: O(1)
#Program ran on leetcode successfully

class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        if nums is None or len(nums) == 0:
            return 0
        
        res = 0
        
        for i in range(len(nums) - 2):
            diff = nums[i+1] - nums[i]
            for j in range(i+2, len(nums)):
                if nums[j] - nums[j-1] == diff:
                    res += 1
                else:
                    break
        
        return res
        