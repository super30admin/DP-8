# 413. Arithmetic Slices
# https://leetcode.com/problems/arithmetic-slices/

# Logic: We can have a dp variable that will have the count of 
# arithmetic slice at that point. We also have a running sum 
# variable that will give us the count of all the possible 
# arithmatic slices.

# Time Complexity: O(n)
# Space Complexity: O(1)

class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        if len(nums) < 3:
            return 0
        
        dp = 0
        count = 0
        
        for i in range(2, len(nums)):
            if nums[i] - nums[i-1] == nums[i-1] - nums[i-2]:
                dp = dp + 1
                count += dp
            else:
                dp = 0
        
        return count