# Time Complexity : O(n)
# Space Complexity :O(n)
# Passed on Leetcode: yes

class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        n = len(nums)

        if n < 3:
            return 0
        dp = [0 for _ in range(n)]
        res = 0
        for i in range(n-3, -1, -1):
            if nums[i] - nums[i+1] == nums[i+1] - nums[i+2]:
                dp[i] = 1 + dp[i+1]
            else:
                dp[i] = 0
            
            res += dp[i]

        return res
