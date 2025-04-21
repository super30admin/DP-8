"""
Brute Force Approach (Two for-loops) --
TC - O(n^2)
SC - O(1)

Optimized Top Down/Bottom up approach -
TC - O(n)
SC - O(n)

Optimized Top Down approach (WITHOUT an extra array) -
TC - O(n)
SC - O(1)
"""


class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        if nums is None or len(nums) < 3: return 0

        n = len(nums)
        count = 0
        prev = 0

        dp = [0 for i in range(n)]

        # n-3, because we start from 3rd last elememt ==> bottom up approach
        for i in range(n - 3, -1, -1):
            if nums[i + 2] - nums[i + 1] == nums[i + 1] - nums[i]:
                dp[i] = dp[i + 1] + 1
                count = count + dp[i]

        # for i in range(2, n):
        #     if  nums[i] - nums[i-1] == nums[i-1] - nums[i-2]:
        #         prev = prev + 1
        #         count = count + prev
        #     else:
        #         prev = 0
        return count


