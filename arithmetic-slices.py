'''

TC: O(n)
SC: O(n)

'''
class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        nlen = len(nums)
        if nlen < 3:
            return 0
        
        dp = [0 for i in nums]
        tot = 0 
        
        for i in range(nlen - 3, -1, -1):
            if nums[i + 1] - nums[i] == nums[i + 2] - nums[i + 1]:
                dp[i] = dp[i + 1] + 1
                tot += dp[i]
        
        return tot
        