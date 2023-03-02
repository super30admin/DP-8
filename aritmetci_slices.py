# Time Complexity: O(N)
# Space Complexity: O(1)

class Solution:
    out = 0

    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        if not nums:
            return 0
        add = 0
        dp = [0 for i in range(len(nums))]
        for i in range(2, len(nums)):
            if nums[i] - nums[i-1] == nums[i-1] - nums[i-2]:
                dp[i] = dp[i-1]+1
        return sum(dp)
#         if len(nums) < 3: return 0
#         for i in range(len(nums)-2):
#             diff = nums[i+1] - nums[i]
#             for j in range(i+2, len(nums)):
#                 if nums[j] - nums[j-1] == diff:
#                     self.out += 1
#                 else: break
#         return self.out
