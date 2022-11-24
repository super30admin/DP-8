class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        if len(nums) == 0 or nums is None:
            return 0

        n = len(nums)
        dp = [0] * n
        count = 0
        for i in range(2, n):
            if nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]:
                dp[i] = dp[i - 1] + 1
                count += dp[i]

        return count

# Top Down Dynamic Programming
# Time Complexity: O(n)
# Space Complexity:O(n). Size of dp Array
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
