# TC:O(n)
# SC:O(n)
class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        if nums is None or len(nums) == 0:
            return 0

        n = len(nums)
        count = 0

        dp = [0] * n

        for i in range(n - 3, -1, -1):
            if nums[i + 1] - nums[i] == nums[i + 2] - nums[i + 1]:
                dp[i] = dp[i + 1] + 1
                count = count + dp[i]

        return count


# APPROACH 2:
# TC:O(n)
# SC:O(1)
class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        if nums is None or len(nums) == 0:
            return 0

        n = len(nums)
        count = 0

        prev = 0

        for i in range(n - 3, -1, -1):
            if nums[i + 1] - nums[i] == nums[i + 2] - nums[i + 1]:
                prev = prev + 1
                count = count + prev
            else:
                prev = 0

        return count
