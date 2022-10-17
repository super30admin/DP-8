class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        ############ Optimized DP O(n) time and O(1) space (can be donw with n sized DP array as well) #################
        if not nums or not len(nums):
            return 0
        
        n = len(nums)
        count = 0
        dp = 0
        
        for i in range(2,n):
            if nums[i]-nums[i-1] == nums[i-1]-nums[i-2]:
                curr = dp+1
                count += curr
                dp = curr
            else:
                dp = 0
                
        return count
        
        ########### Brute Force O(n^2) time and O(1) space #############
        
#         if not nums or not len(nums):
#             return 0
        
#         n = len(nums)
#         count = 0
#         for i in range(n-2):
#             diff = nums[i+1] - nums[i]
#             for j in range(i+1,n-1):
#                 if diff == nums[j+1]-nums[j]:
#                     count += 1
#                 else:
#                     break
        
#         return count
        