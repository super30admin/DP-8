"""
TC: O(n)
SP: O(n)
check if 3 consective values have same difference, if yes increment the count, if not reset count to 0
"""
class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        if len(nums)<3: return 0
        dp = [0]*len(nums)
        for i in range(2, len(nums)):
            if nums[i]-nums[i-1] == nums[i-1]-nums[i-2]:
                dp[i] = dp[i-1]+1
            else:
                dp[i] = 0
        return sum(dp)
            