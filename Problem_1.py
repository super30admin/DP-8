# Time Complexity: O(n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution(object):
    def numberOfArithmeticSlices(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        ans = 0
        dp = 0
        for i in range(2, len(nums)):
            if (nums[i] - nums[i - 1]) == (nums[i - 1] - nums[i - 2]):
                dp += 1
                ans += dp
            else:
                dp = 0
        return ans