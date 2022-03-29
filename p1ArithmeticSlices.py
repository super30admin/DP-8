"""
  time:  (O(M+N))
  space: O(1)
""" 
    
class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        """
        1,2,3,4,6,8
        
        count = 1
        start idx 1, compar curr to prev if equal to curr and cur + 1, count +1
        
        """
        if len(nums) < 3:
            return 0
        ans = count = 0

        

        
        for i in range(2,len(nums)):
            if nums[i] - nums[i-1] == nums[i-1] - nums[i-2]:
                count += 1
            else:
                count = 0
            ans += count
        return ans