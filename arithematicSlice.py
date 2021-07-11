class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        if nums is None or len(nums) == 0:
            return 0
        count = 0
        prev = 0
        dp = [0] * len(nums)
        for i in range(2, len(dp)):
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]):
                dp[i] = dp[i - 1] + 1

        for idx in range(len(dp)):
            count += dp[idx]
        return count

    #Time
    Complexity: O(n)
    # Space
    Complexity: O(1)