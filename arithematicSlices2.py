#Time: O(n)
#Space: O(n)
#Program ran on leetcode successfully

class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        if nums is None or len(nums) == 0:
            return 0
        
        dp = [0] * len(nums)
        res = 0
        
        for i in reversed(range(len(nums)-2)):
            if ((nums[i+2] - nums[i+1]) == (nums[i+1] - nums[i])):
                dp[i] = dp[i+1] + 1
                res += dp[i]
        
        return res
        