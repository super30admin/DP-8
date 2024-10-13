# time: O(n)
# space: O(n)

class Solution(object):
    def numberOfArithmeticSlices(self, nums):
        dp = [0] * (len(nums) + 1)
        res = 0
        for i in range(len(nums) - 2):
            if nums[i+2] - nums[i+1] == nums[i+1] - nums[i]:
                dp[i+1] = dp[i] + 1
                res += dp[i+1]
        return res
                 