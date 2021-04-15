# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using DP Approach


class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        if not nums or len(nums) < 3:
            return 0
        prev = 0
        count = 0
        for i in range(2, len(nums)):
            if nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]:
                prev = prev + 1
                count += prev
            else:
                prev = 0
        return count