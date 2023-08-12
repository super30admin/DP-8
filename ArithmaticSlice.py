from typing import List


class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        if len(nums) < 3:
            return 0
        
        count = 0
        dp = 0
        for i in range(len(nums)-2):
            if nums[i+2] - nums[i+1] == nums[i+1] - nums[i]:
                dp = dp + 1
                count += dp
            else:
                dp = 0
        return count