class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [0 for i in range(n)]
        res = 0
        for i in range(n - 2, 0, -1):
            if (nums[i] - nums[i + 1]) == (nums[i - 1] - nums[i]):
                dp[i - 1] = dp[i] + 1
            res += dp[i - 1]
        return res
