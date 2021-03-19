# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        if not nums:
            return 0
        
        count = 0 
        dp = [0 for i in range(len(nums))]
        
        for i in range(2, len(nums)):
            if nums[i] - nums[i-1] == nums[i-1] - nums[i-2]:
                dp[i] = dp[i-1] + 1
                count += dp[i]
                
        return count