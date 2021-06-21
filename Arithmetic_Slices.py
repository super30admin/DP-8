class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        
        if not nums:
            return 0
        
        result, count = 0,0
        
        for i in range(2,len(nums)):
            
            if nums[i-1] - nums[i-2] == nums[i] - nums[i-1]:
                count +=1
                result +=count
            else:
                count = 0
        return result
                
