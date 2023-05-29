# Time Complexity : O(n), where n is the length of the input list nums.
# Space Complexity : O(1)
from typing import List


class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        n = len(nums)
        if n < 3:
            return 0
        
        count = 0
        curr = 0
        
        for i in range(2, n):
            if nums[i] - nums[i-1] == nums[i-1] - nums[i-2]:
                curr += 1
                count += curr
            else:
                curr = 0
        
        return count