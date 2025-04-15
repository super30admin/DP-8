# https://leetcode.com/problems/arithmetic-slices/

class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        count = 0
        n = len(nums)
        dp = [0] * (n)

        for i in range(n-3,-1,-1):
            if nums[i+2] - nums[i+1] == nums[i+1] - nums[i]:
                dp[i] = dp[i+1] + 1
            else:
                dp[i] = 0

            count += dp[i]      

        return count

#TC: O(n)
# sc: O(n)

        