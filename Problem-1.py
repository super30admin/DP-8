class Solution:
    # Approach 1: DP
    """
    TC: O(n)
    SC: O(n)
    """
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        n = len(nums)
        if n<3: return 0
        dp = [0] * n
        result = 0
        for i in range(n-3, -1, -1):
            if nums[i] - nums[i + 1] == nums[i + 1] - nums[i + 2]:
                dp[i] = dp[i+1] + 1
                result += dp[i]
        return result