# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# saving the number of previous ones and maintaining the number of total ones
class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        
        if nums == None or len(nums) <= 2:
            return 0
        
        n = len(nums)
        
        total = 0
        
        dp = [0]*n
        
        for i in range(n-3,-1,-1):
            if nums[i+2] - nums[i+1] == nums[i+1] - nums[i]:
                dp[i] = dp[i+1] + 1
                total += dp[i]
        
        return total
        