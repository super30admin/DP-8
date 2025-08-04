# Time Complexity: O(n)
# Space Complexity: O(n)
# class Solution:
#     def numberOfArithmeticSlices(self, nums: List[int]) -> int:
#         n = len(nums)
#         dp = [0] * n
#         ans = 0
#         for i in range(2, n):
#             if nums[i-1] - nums[i-2] == nums[i] - nums[i-1]:
#                 dp[i] = dp[i-1] + 1
#             ans += dp[i]
#         return ans

# Time Complexity: O(n)
# Space Complexity: O(1)
class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        n = len(nums)
        dp, dpPrev = 0, 0
        ans = 0
        for i in range(2, n):
            if nums[i-1] - nums[i-2] == nums[i] - nums[i-1]:
                dp = dpPrev + 1
            ans += dp
            dpPrev = dp
            dp = 0
        return ans