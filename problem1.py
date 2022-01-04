#413 Arithmetic slices
# Time O(n)
# space O(1)
class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        
        result = 0
        count = 0
        
        for i in range(2, len(nums)):
            
            if(nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]):
                
                count += 1
                result += count
            
            else:
                count = 0
        
        return result
            
