# Time Complexity: O(n)
# Space Compelxity: O(n)
from typing import List


class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [0] * n

        no_of_subarrays = 0

        for i in range(2, n):
            if nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]:
                dp[i] = dp[i - 1] + 1
                no_of_subarrays += dp[i]

        return no_of_subarrays
