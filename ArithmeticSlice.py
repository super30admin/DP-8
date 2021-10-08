"""
Time Complexity : O(n) + O(max element) 
Space Complexity : O(max element)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        if len(nums) == 0 or len(nums) < 3:
            return 0
        total = 0
        n = len(nums)
        dp = [0]*n
        # We traverse through the array from last thirst element and if we find 
        # same diff in range of 3 elements we simlly imcrement the value in our dp at
        # one more than current element plus 1. After that we increment total and 
        # return it
        for i in range(n-3, -1, -1):
            if nums[i] - nums[i + 1] == nums[i+1] - nums[i+2]:
                dp[i] = dp[i+1]+1
            total += dp[i]
        return total