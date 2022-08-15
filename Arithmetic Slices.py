""""// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""

class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        if nums == None or len(nums) == 0:
            return 0
        count = 0
        n = len(nums)
        dp = [0] * n
        for i in range(2, n):
            if nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]:
                dp[i] = dp[i - 1] + 1
                count += dp[i]
        return count


""""// Time Complexity : O(n^2)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""
# class Solution:
#     def numberOfArithmeticSlices(self, nums: List[int]) -> int:
#         if nums==None or len(nums)==0:
#             return 0
#         count=0
#         n=len(nums)
#         for i in range(n-2):
#             diff=nums[i+1]-nums[i]
#             for j in range(i+1, n-1):
#                 if diff==nums[j+1]-nums[j]:
#                     count+=1
#                 else:
#                     break
#         return count
