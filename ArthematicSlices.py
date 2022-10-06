
#TiemComplexity: O(N)
#spaceComplexity: O(1)

def numberOfArithmeticSlices(self, nums: List[int]) -> int:
    if not nums or len(nums) < 3:
        return 0
    dp = [0] * len(nums)
    count = 0
    for i in range(2, len(nums)):
        if nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]:
            dp[i] = dp[i - 1] + 1
            count += dp[i]

    return count