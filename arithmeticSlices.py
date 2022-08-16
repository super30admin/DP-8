#Time complexity: O(n)
#Space complexity: O(1)

class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        
        n = len(nums)
        
        prev, curr, res = 0, 0, 0
        
        for i in range(n-3, -1, -1):
            if nums[i+2]-nums[i+1] == nums[i+1]-nums[i]:
                curr = prev + 1
            else:
                curr = 0
            prev = curr
            res += curr
    
        return res
        
        
