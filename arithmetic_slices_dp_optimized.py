# Time Complexity : O(N) where N is length of the nums array
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        count = 0
        n = len(nums)
        dp = 0
        diff  = nums[n-1] - nums[n-2]
        for i in range(n-3, -1, -1):
            if  nums[i+1] - nums[i] == diff:
                dp = dp + 1
                count += dp
            else:
                dp = 0
                diff  = nums[i+1] - nums[i]
        return count