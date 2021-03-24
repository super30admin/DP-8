"""
Time Complexity : O(n)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Explaination
we gor fron 2nd index to last index in the array
we check the difference between [i] - [i-1] and [i+1] - [i], if both of these are equal.
aupdate the dp with the dp[i-1]+1
and count by dp[i]
return last index of the dp array

"""

class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        if len(nums)<3: return 0
        count = 0
        prev, cur = 0,0
        for i in range(2, len(nums)):
            if nums[i] - nums[i-1] == nums[i-1] - nums[i-2]:
                cur = prev+1
                count += cur
                prev = cur
            else:
                prev = 0
        
        
#         dp = [0]*len(nums)
        
#         for i in range(2,len(nums)):
#             if nums[i]-nums[i-1] == nums[i-1] - nums[i-2]:
#                 dp[i] = dp[i-1] + 1
#                 count += dp[i]
        
        
        
        # for i in range(1, len(nums)-1):
        #     dif = nums[i] - nums[i-1]
        #     j = i+1
        #     while j<len(nums) and nums[j]-nums[j-1] == dif:
        #         count += 1
        #         j+=1
            
        return count
            
        